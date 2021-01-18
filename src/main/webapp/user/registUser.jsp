<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>user</title>

<!-- Bootstrap core CSS -->
<%@include file="/common/common_lib.jsp"%>
<link href="${pageContext.request.contextPath }/css/dashboard.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/blog.css" rel="stylesheet">
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	$(function() {
		// 주소검색 버튼이 클릭 되었을 때 다음 주소 api 팝업을 연다
		$("#addrBtn").on("click", function() {
			new daum.Postcode({
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
					// 예제를 참고하여 다양한 활용법을 확인해 보세요.
					console.log(data);

					$("#Addr1").val(data.roadAddress); // 도로주소
					$("#Zipcode").val(data.zonecode); // 우편번호

					// 사용자 편의성을 위해 상세주소 입력 input 태그로 focus설정
					$("#Addr2").focus();
				}
			}).open();
		})
	})
</script>
</head>
<body>
<body>
	<%@include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<!-- left -->
				<%@include file="/common/left.jsp"%>
			</div>
		</div>
	</div>
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

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				contextPaht el
				<form class="form-horizontal" role="form"
					action="${pageContext.request.contextPath}/registUser2" method="POST">
							 
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<%
							String userid = request.getParameter("userid");
							userid = userid == null ? "" : userid;
							%>
							<input id="userId" class="form-control" name="userid"
								placeholder="아이디" value="<%=userid%>">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<%
							String usernm = request.getParameter("usernm");
							usernm = usernm == null ? "" : usernm;
							%>
							<input id="userNm" class="form-control" name="usernm"
								placeholder="이름" value="<%=usernm%>">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 별명</label>
						<div class="col-sm-10">
							<%
							String alias = request.getParameter("alias");
							alias = alias == null ? "" : alias;
							%>
							<input id="Alias" class="form-control" name="alias"
								placeholder="별명" value="<%=alias%>">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">비밀번호</label>
						<div class="col-sm-10">
							<%
							String pass = request.getParameter("pass");
							pass = pass == null ? "" : pass;
							%>
							<input id="Pass" class="form-control" name="pass"
								placeholder="비밀번호" value="<%=pass%>">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">도로주소</label>
						<div class="col-sm-8">
							<%
							String addr1 = request.getParameter("addr1");
							addr1 = addr1 == null ? "" : addr1;
							%>
							<input id="Addr1" class="form-control" placeholder="도로주소"
								name="addr1" readonly value="<%=addr1%>">
						</div>
						<div class="col-sm-2">
							<button id="addrBtn" type="button" class="btn btn-default">주소검색</button>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<%
							String addr2 = request.getParameter("addr2");
							addr2 = addr2 == null ? "" : addr2;
							%>
							<input id="Addr2" class="form-control" name="addr2"
								placeholder="상세주소" value="<%=addr2%>">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<%
							String zipcode = request.getParameter("zipcode");
							zipcode = zipcode == null ? "" : zipcode;
							%>
							<input id="Zipcode" class="form-control" placeholder="우편번호"
								name="zipcode" readonly value="<%=zipcode%>">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">사용자 등록</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>