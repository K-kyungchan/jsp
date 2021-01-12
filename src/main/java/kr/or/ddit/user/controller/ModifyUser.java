package kr.or.ddit.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/userModify")
public class ModifyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceI userService = new UserService();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String userid = request.getParameter("userid");
		 UserVo user = userService.selectUser(userid);
		 request.setAttribute("user", user);
		 
		 request.getRequestDispatcher("/user/userModify.jsp").forward(request, response);
	}


}
