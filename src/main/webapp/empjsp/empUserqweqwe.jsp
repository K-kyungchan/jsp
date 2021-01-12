<%@page import="kr.or.ddit.emp.vo.EmpVo"%>
<%@page import="java.util.List"%>
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
	List<EmpVo> userlist = (List<EmpVo>) request.getAttribute("userlist");
	%>
	<table>
		<%
		for (int i = 0; i < userlist.size(); i++) {
			EmpVo vo = userlist.get(i);
		%>
		<tr>
			<td><%=vo.getEmpno()%></td>
			<td><%=vo.getEmpnm()%></td>
			<td><%=vo.getJob()%></td>
			<td><%=vo.getDeptno()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>