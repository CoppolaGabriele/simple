package simple.srv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simple.dao.Team;
import simple.dao.TeamDao;

@WebServlet("/team/new")
public class NewTeamServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(NewTeamServ.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		try {
			Team nTeam = new Team();
			TeamDao dao = new TeamDao();
			nTeam.setName(name);
			
			if(dao.create(nTeam)) {
				request.setAttribute("teams", true);
			} else {
				request.setAttribute("teams", false);
			}
		} catch (Exception e) {
			LOG.debug("Error! Exception: " + e);
		}
		
		request.getRequestDispatcher("/team/TeamCreated.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
