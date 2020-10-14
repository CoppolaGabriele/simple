package simple.srv;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import simple.dao.Team;
import simple.dao.TeamDao;

@WebServlet("/team/all")
public class TeamAllServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(CoderAllSrv.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TeamDao dao = new TeamDao();
		List<Team> teams = dao.getAll();
		LOG.debug("Team read: " + teams);
		request.setAttribute("teams", teams);

		request.getRequestDispatcher("/team/allTeams.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
