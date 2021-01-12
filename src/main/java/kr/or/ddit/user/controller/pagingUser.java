package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/pagingUser2")
public class pagingUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// left.jsp : /paginUser?page=1&pageSize=5
		// ===> /pagingUser
		
		// doGet 메소드에서 page,PageSize 파라미터가 request 객체에 존재하지 않을떄
		// page는 1로 pageSize 5로 생각을 코드를 작성
		// 파라미터가 존재하면 해당 파라미터를 이용
		// refactoring : 코드를(깔끔하게) 바꾸는데 기존 동작방식을 유지한채로 변경하는 기법
		String a = request.getParameter("page");
		String b = request.getParameter("pageSize");
		
		// request 객체에서 제공하는 파라미터 관련 메소드
		
		int page = a == null ? 1 : Integer.parseInt(request.getParameter("page"));
		int pageSize = b == null ? 5 : Integer.parseInt(request.getParameter("pageSize"));
		
		UserServiceI service = new UserService();
		PageVo page2 = new PageVo(page, pageSize);
		
		Map<String, Object> map = service.selectPagingUser(page2);
		
		List<UserVo> userList = (List<UserVo>)map.get("userList");
		int userCnt = (int) map.get("userCnt");
		int pagination = (int) Math.ceil((double) userCnt / pageSize);
		
		request.setAttribute("userlist", userList);
		request.setAttribute("pagination", pagination);
		
		request.getRequestDispatcher("pageUser/pageUser.jsp").forward(request, response);
	}
}