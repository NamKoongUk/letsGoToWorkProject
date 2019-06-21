<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LetsGoToWork</title>
<style>
	p{
		font-size:150%;
	    font-weight:bold;
	}

</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/employee.jsp"/>
		
		<section class="col-sm-10">
			<h1 class="title">근태현황</h1>
			<button type="button" class="btn btn-primary" onclick="location.href='showAttendStatus.em'">근태현황</button>
			<button type="button" class="btn btn-primary" onclick="location.href='showUpdateAttenStatus.em'">근태 수정 내역</button>
			<hr>
			<div class="content">
				<p>출/퇴근</p>
				<h1>달력자리</h1>
				<hr>
				<p>근태 통계</p>
				<table class="table">
					    <thead>
						      <tr class="info">
						        <th>이름</th>
						        <th>소속</th>
						        <th>무단 결근</th>
						        <th>무단 지각</th>
						        <th>미체크</th>
						      </tr>
					    </thead>
					    <tbody>
					      	<tr>
					      		<td>김규형</td>
					      		<td>개발1팀</td>
					      		<td>0회</td>
					      		<td>0회</td>
					      		<td>0회</td>
					      	</tr>
					    </tbody>
				 	 </table>
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>