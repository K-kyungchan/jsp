<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>한국어</h3>
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="LANG" />
		<br>
		<fmt:message key="GREETING">
			<fmt:param value="brown" />
		</fmt:message>
	</fmt:bundle>

	<br>

	<h3>English</h3>
	<!-- 로케일 설정 변경 -->
	<fmt:setLocale value="en" />
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="LANG" />
		<br>
		<fmt:message key="GREETING">
			<fmt:param value="brown" />
		</fmt:message>
	</fmt:bundle>

	<h3>日本語</h3>
	<!-- 로케일 설정 변경 -->
	<fmt:setLocale value="ja" />
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="LANG" />
		<br>
		<fmt:message key="GREETING">
			<fmt:param value="brown" />
		</fmt:message>
	</fmt:bundle>

	<h3>
		setBundle : 번들값을 속성에 저장<br> message태그를 사용 할 때 번들을 지정 ==> bundle
		태그 없이 사용 가능
	</h3>

	<fmt:setBundle basename="kr.or.ddit.msg.msg" var="msg" />
	<fmt:message key="LANG" bundle="${msg }" var="lang"/>${lang }<br>
	<fmt:message key="GREETING" bundle="${msg }"> <br>
		<fmt:param value="brown" />
	</fmt:message>
	
</body>
</html>