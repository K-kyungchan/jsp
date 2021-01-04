package kr.or.ddit.servlet.scope;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(sumCalculation.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(req.getContextPath() + "/sumCalculationjsp.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num1 = req.getParameter("start");
		String num2 = req.getParameter("end");

		HttpSession session = req.getSession();
		int num11 = Integer.parseInt(num1);
		int num22 = Integer.parseInt(num2);
		int sum = 0;
		for (int i = num11; i <= num22; i++) {
			sum = sum + i;
		}
		session.setAttribute("sumResult", sum);
		
		req.getRequestDispatcher(req.getContextPath() + "/sumResult.jsp").forward(req, resp);
	}

}
