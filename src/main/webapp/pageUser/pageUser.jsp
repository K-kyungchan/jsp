<%@page import="kr.or.ddit.common.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@page import="kr.or.ddit.emp.vo.EmpVo"%>
<%@page import="java.util.List"%>
<html lang="UTF-8">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>
<%@ include file="/common/common_lib.jsp"%>
<link href="${pageContext.request.contextPath }/css/blog.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/dashboard.css"
	rel="stylesheet">
<!-- Bootstrap core CSS -->
<!-- Custom styles for this template -->

<script>
	// 문서 로딩이 완료되고 나서
	$(function() {
		$(".user").on("click", function() {
			// this 클릭이벤트가 발생한 element를 의미 
			// data-속성명 data-userid, 속성명은 대소문자 무시하고 소문자로 인식
			// data-userId ==> data-userid
			var userid = $(this).data("userid");
			$("#userid").val(userid);
			$("#frm").submit();
		});
	});
</script>
</head>

<body>
	<form id="frm" action="${pageContext.request.contextPath }/user">
		<input type="hidden" id="userid" name="userid" value="" />
	</form>
	
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">JSP/SPRING</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Dashboard</a></li>
					<li><a href="#">Settings</a></li>
					<li><a href="#">Profile</a></li>
					<li><a href="#">Help</a></li>
				</ul>
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Search...">
				</form>
			</div>
		</div>
	</nav>
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="#">Main <span class="sr-only">(current)</span></a></li>
					<li class="active"><a href="#">전체 사용자</a></li>
					<li class="active"><a href="#">직원</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">직원</h2>
						<div class="table-responsive">
						 
							<table class="table table-striped">
								<tr>
									<th>유저아이디</th>
									<th>유저이름</th>
									<th>별명</th>
								</tr>
								 
								<c:forEach items="${userlist}" var="user">
									<tr class="user" data-userid="${user.userid }">
										<td>${user.userid}</td>
										<td>${user.usernm}</td>
										<td>${user.alias}</td>
									</tr>
								</c:forEach>
							 
							</table>
						</div>

						<a class="btn btn-default pull-right" href="${pageContext.request.contextPath }user/registUser.jsp">사용자 등록</a>
						<div class="text-center">
							<ul class="pagination">
								<%-- pagination 값이 4이므로 1부터 4까지 4번 반복된다
								     전체 사용자수 : 16명
								     페이지 사이즈 : 5
								     전체 페이지 수 : 4페이지
								 --%>
								<li class="prev">
									<a href="${pageContext.request.contextPath }/pagingUser?page=1&pageSize=${PageVo.pageSize}">«</a>
								</li>
								<c:forEach begin="1" end="${pagination }" var="i" >
									<c:choose>
										<c:when test="${PageVo.page == i }">
											<li class="active"><span>${i }</span></li>
										</c:when>
										<c:otherwise>
											<li><a href="${pageContext.request.contextPath }/pagingUser?page=${i }&pageSize=${PageVo.pageSize}">${i }</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<li class="next">
									<a href="${pageContext.request.contextPath }/pagingUser?page=${pagination }&pageSize=${PageVo.pageSize}">»</a>
								</li>
							</ul>
						</div>

					</div>
				</div>
			</div>
		</div>


	</div>
</body>
</html>