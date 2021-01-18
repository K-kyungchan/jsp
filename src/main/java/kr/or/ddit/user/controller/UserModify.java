package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/userModify")
public class UserModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceI userService = new UserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		UserVo user = userService.selectUser(userid);
		request.setAttribute("user", user);

		request.getRequestDispatcher("/user/userModify.jsp").forward(request, response);
	}

	// 사용자 정보 수정 요청 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파라미터를 읽기 전에 실행
		// servlet의 dopost 메소드 마다 실행 필요 ==> Filter
		req.setCharacterEncoding("utf-8");
		
		String userid = req.getParameter("userid");
		String usernm = req.getParameter("usernm");
		String alias = req.getParameter("alias");
		String pass = req.getParameter("pass");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Date reg_dt = null;
		try {
			reg_dt = sdf.parse(req.getParameter("regdt"));
		} catch (ParseException e) {
		}
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String zipcode = req.getParameter("zipcode");

		UserVo userVo = new UserVo(userid, usernm, pass, reg_dt, alias, addr1, addr2, zipcode);

		int userUpdate = userService.modifyUser(userVo);

		if (userUpdate == 1) {
			resp.sendRedirect(req.getContextPath() + "/user?userid=" + userid);
		} else {
			//사용자 수정이 비정상적으로 된 경우 ==> 해당 사용자의 정보 수정 페이지로 이동
			doGet(req, resp);
		}

	}

}
