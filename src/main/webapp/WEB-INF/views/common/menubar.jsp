<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${ pageContext.servletContext.contextPath }" scope="application" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LetsGoToWork</title>
<!-- bootstrap CDN -->
<jsp:include page="../common/tools.jsp"></jsp:include>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
	.loginEmpInfo button{
		width: 40px;
		height : 30px;
	}
	.loginEmpInfo{
		float : right;
		margin : 10px ;
		padding-top : 10px;
		font-weight : bold;
	}
	.empIcon{
		cursor : pointer;
		width: 30px;
		margin-right: 5px;
		margin-bottom : 5px;
		color : white;
	}
	.empInfo{
		cursor : pointer;
	}
	
</style>
</head>
<body>
	<!-- 로그인시 -->
	<c:if test="true"> 
	<header>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid navbar-inline" >
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar">
						</span>
					</button>
					<a class="navbar-brand" href="${ contextPath }">
						<%-- <img src="${ contextPath }/resources/images/logo1.PNG" width="85px" style="position: relative; top: -15px"/> --%>
						<img src="${ contextPath }/resources/images/logo3.png" width="85px" style="position: relative; top: -10px; left: 15px;"/>
					</a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav visible-lg visible-md">
						<li><a href="${contextPath}/showWaitDcm.ap">결재관리</a></li>
						<li><a href="${contextPath}/employee.em">인사관리</a></li>
						<li><a href="${contextPath}/mail.ma">웹메일</a></li>
						<li><a href="${contextPath}/scheduler.sc">일정관리</a></li>
						<li><a href="${contextPath}/messenger">메신저</a></li>
						<li><a href="${contextPath}/community.co">커뮤니티</a></li>
					</ul>
					<c:if test="${ empty loginEmp }"></c:if>
					<c:if test="${ !empty loginEmp }">
						<div class="loginEmpInfo">
							<img src="${ contextPath }/resources/images/user.png" class="empIcon">
							<span class="empInfo">${ loginEmp.empName }님<%-- ${ loginEmp.empNo } --%></span>
						</div>
					</c:if>
				</div>
			</div>
		</nav>
		
	</header>
	</c:if>
	<script>
		// textarea클릭시 안에 내용을 지워주는 코드 
		$(function(){
			$("textarea").click(function(){
				console.log("텍스트 area선택")
				$(this).text("");
			})
		})
		
		// 로그아웃
		$(".empInfo").click(function(){
			location.href="${ contextPath }/logout.em";
		});
	</script>
</body>
</html>