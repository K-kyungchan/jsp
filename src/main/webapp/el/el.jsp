<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// 컨트롤러에서 조회된 데이터를 request에 저장 했다라는 가정
	UserVo userVO = new UserVo();
	userVO.setUserid("brown");
	userVO.setUsernm("브라운");
	userVO.setAlias("곰");
		
	request.setAttribute("userVo", userVO);
	%>
	<%-- view  --%>
	<h3>표현식 - userVo</h3>
	userVo : <%=request.getAttribute("userVo") %><br>
	userVo.getUserid() : <%=((UserVo)request.getAttribute("userVo")).getUserid() %><br><br>
	
	<h3>el - userVo</h3>
	userVo : ${userVo}<br>
	userVo.getUserid() : ${userVo.userid} / ${userVo.getUserid()}<br><br>
	
	<%
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid","brown");
		map.put("usernm","브라운");
		map.put("alias","곰");
		map.put("number","5");
		
		request.setAttribute("map", map);
	%>
	<h3>map - expression</h3>	
	map : <%=map%><br>
	map.get("userid") : ${map.usernm}<br>
	
	
	<h3>산술 연산</h3>
	${map.number + 7}<br>
	${map.number * 7}<br>
	${map.number * 7 + "5" + '1'}<br>
	
	
</body>
</html>