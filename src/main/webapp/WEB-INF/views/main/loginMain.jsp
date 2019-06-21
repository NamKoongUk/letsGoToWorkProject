<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LetsGoToWork</title>
</head>
<body>
	<section>
		<c:if test="${ empty loginEmp }">
			<h1 class="title">로그인페이지 입니다.</h1>
			<form id="loginForm" action="login.em" method="post">
				<table id="loginTable">
					<tr>
						<td><input type="text" name="empId" placeholder="아이디를 입력하주세요" class="form-control"/></td>
					</tr>			
					<tr>
						<td><input type="password" name="empPwd" placeholder="비밀번호를 입력해주세요" class="form-control"/></td>
					</tr>
					<tr>
						<td><button class="btn" type="submit">로그인</button></td>
					</tr>
				</table>
			</form>
		</c:if>
		<c:if test="${ !empty loginEmp }">
			<h1 align="center">${ loginEmp.empName }님이 로그인한 상태</h1>
			<!-- 로그인 적용할때 이거 주석 풀고 main에 include제거하기 -->
			<%-- <jsp:forward page="index.jsp"/> --%> 
		</c:if>		
	</section>
	
</body>
</html>