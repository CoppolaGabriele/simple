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

import simple.dao.Coder;
import simple.dao.CoderDao;

@WebServlet("/team/join")
public class CodersJoinTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(CodersJoinTeam.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		CoderDao dao = new CoderDao();
		List<Coder> coders = dao.getAll();
		LOG.debug("Coders read: " + coders);
		request.setAttribute("coders", coders);

		request.getRequestDispatcher("/coder/allCodersJoin.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
