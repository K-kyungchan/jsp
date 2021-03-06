package kr.or.ddit.servlet.scope;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/scope")
public class Scope extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(req.getContextPath() + "/scope.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String scopeParameter = req.getParameter("scope");

		req.setAttribute("request", scopeParameter + "_reqeust");

		HttpSession session = req.getSession();
		session.setAttribute("session", scopeParameter + "_session");

		ServletContext application = getServletContext();
		application.setAttribute("application", scopeParameter + "_application");

		req.getRequestDispatcher(req.getContextPath() + "/scopeResult.jsp").forward(req, resp);
	}

}
