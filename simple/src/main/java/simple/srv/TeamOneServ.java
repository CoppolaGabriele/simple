package simple.srv;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simple.dao.Team;
import simple.dao.TeamDao;

@WebServlet("/team/getOne")
public class TeamOneServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(CoderAllSrv.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String param = request.getParameter("id");
		TeamDao dao = new TeamDao();
		
		try {
			Optional<Team> teams = dao.get(Integer.parseInt(param));
			if(teams.isPresent()) {
				request.setAttribute("teams", teams);
				request.getRequestDispatcher("/team/getTeam.jsp").forward(request, response);
			}
		} catch (Exception e) {
			LOG.debug("Error! Exception: " + e);
			request.getRequestDispatcher("/team/GetOneTeam.html").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
