package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/registUser2")
public class RegistUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserServiceI userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String userid = request.getParameter("userid");
		String usernm = request.getParameter("usernm");
		String alias = request.getParameter("alias");
		String pass = request.getParameter("pass");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");

		UserVo userVo = new UserVo(userid, usernm, pass, new Date(), alias, addr1, addr2, zipcode);

		int insertUser = 0;
		try {
			insertUser = userService.registUser(userVo);
			response.sendRedirect(request.getContextPath() + "/pagingUser2");
		} catch (Exception e) {
			insertUser = 0;
			response.sendRedirect(request.getContextPath() + "user/registUser.jsp");
		}

//		if (insertUser == 1) {
//			response.sendRedirect(request.getContextPath() + "/pagingUser2");
//		} else {
//			// 사용자 수정이 비정상적으로 된 경우 ==> 해당 사용자의 정보 수정 페이지로 이동
//			doGet(request, response);
//		}

	}

}
