<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	width: 100%;
}
</style>
</head>
<body>
	<table>
<!-- 		for (int j = 1; j <= 10; j++) { -->
<!-- 		<tr> -->
<!-- 			for (int i = 2; i <= 10; i++) { -->
<%-- 			<td><%=i%> * <%=j%> = <%=i * j%></td> } --%>
<!-- 		</tr> -->
<!-- 		} -->


		<%
	for (int j = 1; j <= 10; j++) {
		out.print("<tr>");
		for (int i = 2; i <= 10; i++) {
			out.print("<td>" + i * j + " = " + i * j + "</td>");
		}
		out.print("</tr>");
	}
	%>
	</table>
</body>
</html>