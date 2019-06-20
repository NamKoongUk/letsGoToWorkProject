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
</head>
<body>
	<!-- 로그인시 -->
	<c:if test="true"> 
	<header>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="${ contextPath }">Logo 자리</a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav visible-lg visible-md">
						<li><a href="${contextPath}/approval.ap">결재관리</a></li>
						<li><a href="${contextPath}/employee.em">인사관리</a></li>
						<li><a href="${contextPath}/mail.ma">웹메일</a></li>
						<li><a href="${contextPath}/scheduler.sc">일정관리</a></li>
						<li><a href="${contextPath}/messenger.me">메신저</a></li>
						<li><a href="${contextPath}/community.co">커뮤니티</a></li>
					</ul>
					<ul class="nav navbar-nav visible-xs">
						<li>
							<div class="dropdown">
								<button class="btn btn-primary dropdown-toggle" type="button"
									data-toggle="dropdown">전자결재</button>
								<ul class="dropdown-menu" >
									<li><a href="#">HTML</a></li>
									<li><a href="#">CSS</a></li>
									<li><a href="#">JavaScript</a></li>
								</ul>
							</div>
						</li>
					</ul>
					<script>
						function approval(){
						}
						</script>
					<ul class="nav navbar-nav navbar-right">
						<li><span class=""><c:out value="${ loginUser.nickName }"/>님</span></li>
						<!-- <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
								Login</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li> -->
					</ul>
				</div>
			</div>
		</nav>
		
		<!-- 여기 이 navArea역할은? -->
	</header>
	</c:if>
	<%-- <c:if test="${ empty loginUser }">
		<jsp:include page="../main/loginMain.jsp"/>
		<jsp:forward page="../main/loginMain.jsp"/>
	</c:if> --%>

	
	<script>
		// textarea클릭시 안에 내용을 지워주는 코드 
		$(function(){
			$("textarea").click(function(){
				console.log("텍스트 area선택")
				$(this).text("");
			})
		})
	</script>
</body>
</html>