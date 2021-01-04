<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	var test  = <%=application.getAttribute("application")%> 
	var test  = "sally_application"
	
	
 	<%--클라이언트에서는 서버 사이드 변수 값을 활용할 수 있으나
 	서버 사이드 변수에 클라이언트 사이드 변수 값을 대입할 수는없다--%>
	
</script>

</head>
<body>
	request = <%=request.getAttribute("request")%> <br><br>
	session = <%=session.getAttribute("session")%> <br><br>
	application = <%=application.getAttribute("application")%><br><br>
</body>
</html>