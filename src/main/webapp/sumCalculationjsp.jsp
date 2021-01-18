<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/sumCalculation"
		method="post">
		<input name="start"  placeholder="start">
		<input name="end"  placeholder="end">
		<input type="submit">
	</form>
</body>
</html>