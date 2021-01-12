package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.emp.dao.EmpDao;
import kr.or.ddit.emp.dao.EmpDaoI;
import kr.or.ddit.emp.vo.EmpVo;

@WebServlet("/EmpAllUser")
public class EmpAllUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request.setcharacterencoding("utf-8");

		EmpDaoI service = new EmpDao();
		
		List<EmpVo> userlist = service.selectAllUser();
		request.setAttribute("userlist", userlist);
		request.getRequestDispatcher("empjsp/empUser.jsp").forward(request, response);

	}

}
