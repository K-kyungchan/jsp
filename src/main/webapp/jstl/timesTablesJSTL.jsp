<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
td {
	border: 1px double black;
}

table {
	width: 50%;
}
</style>
</head>
<body>
	표현식. 스크립틀을 EL, JSTL로 변경
	<br>
	<h3>일반 for문</h3>
	<hr>
	<table>
		<c:forEach begin="2" end="9" var="i" varStatus="loop">
			<tr>
				<c:forEach begin="1" end="9" var="j" varStatus="loop">
					<td>${i} * ${j} = ${i*j}</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	
	<h3>향상된 for문</h3>
	<%
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		rangers.add("sally");
		rangers.add("moon");
		rangers.add("james");
		request.setAttribute("rangers", rangers);
		
		/*
			for(String ranger : (List<String>request.getAttribute("rangers")) ){
				작업내용	
			}
			
			<c:forEach items="${rangers}" var="ranger">
			</c:forEach>
		*/
	%>
	
	<c:forEach items="${rangers}" var="ranger">
		${ranger }<br>
	</c:forEach>
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>