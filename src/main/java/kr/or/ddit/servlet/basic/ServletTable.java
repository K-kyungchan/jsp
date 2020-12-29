package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTable extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("ServletTable.init()");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=utf-8");

		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("		<title>ServletTable</title>");
		pw.println("	<style>");
		pw.println("	td{");
		pw.println("	border: 1px double black;");
		pw.println("	}");
		pw.println("	table{");
		pw.println("	width: 100%;");
		pw.println("	}");
		pw.println("	table{");
		pw.println("	hight: 20px;");
		pw.println("	}");
		pw.println("	</style>");
		pw.println("	</head>");
		pw.println("	<body>");
		pw.println("		<table>");
		for (int j = 1; j <= 9; j++) {
			pw.println("<tr>");
			for (int i = 2; i < 10; i++) {
				pw.println("<td>" + i + " * " + j + " = " + i * j + "</td>");
			}
		}
		pw.println("		</table>");
		pw.println("	</body>");
		pw.println("</html>");
		pw.flush();
		pw.close();

	}

}
