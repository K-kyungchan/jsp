<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- page scope에 속성이름 price, 값은 10000 추가 --%>
	<%
	// 		pageContext.setAttribute("price", 100000);
	%>

	<c:set var="price" value="100000" />
	<%-- 100000(숫자) ==> 100,000(문자) --%>
	
	<c:set var="priceStr" value="100,000" />
	<%-- 100000(문자) ==> 100,000(숫자) --%>
	

	price : ${price }<br>
	price fmt : <fmt:formatNumber value="${price }"/>	<br>
	price fmt number : <fmt:formatNumber value="${price }" type="number"/>	<br>
	price fmt currency : <fmt:formatNumber value="${price }" type="currency"/>	<br>
	price fmt percent : <fmt:formatNumber value="${price }" type="percent"/>	<br>
	price fmt pattern : <fmt:formatNumber value="${price }" pattern="0000000000.00"/>	<br>
	priceStr pares : <fmt:parseNumber value="${priceStr }"/> <br>
	<br>
	
	<h3>de-germany</h3>
	<fmt:setLocale value="DE"/>
	price : ${price }<br>
	price fmt : <fmt:formatNumber value="${price }"/>	<br>
	price fmt : <fmt:formatNumber value="${price }" type="number"/>	<br>
	price fmt : <fmt:formatNumber value="${price }" type="currency"/>	<br>
	price fmt : <fmt:formatNumber value="${price }" type="percent"/>	<br>
	price fmt : <fmt:formatNumber value="${price }" pattern="0000000000.00"/>	<br>
</body>
</html>