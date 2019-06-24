<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LetsGoToWork</title>
<style>
	.updateBtn {
		color:#00BFFF;
	}
	#searchArea{
		height:35px;
		width: 250px;
		border:1px solid #1b5ac2;
		background:#ffffff;
		margin-left:78%;
		margin-bottom:1%;
		
	}
	#searchInput{
		font-size:14px;
		width:190px;
		padding:5px;
		border:0px;
		outline:none;
		float:left;
	}
	#searchBtn{
		width:50px;
		height:100%;
		border:0px;
		background: #1b5ac2;
		outline:none;
		float:right;
		color:#ffffff;
	}
</style>

</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/employee.jsp"/>
		
		<section class="col-sm-10">
			<h1 class="title">휴가관리</h1>
			<hr>
			<div class="content">
				<div id="searchArea">
					<input id="searchInput" type="text" placeholder="ID, 이름 검색">
					<button id="searchBtn">검색</button>
				</div>
				<table	class="table">
					<tr>
						<th>사번</th>
						<th>이름</th>
						<th>소속</th>
						<th>입사일</th>
						<th>정기휴가(잔여/총 일)</th>
						<th>포상휴가(잔여/총 일)</th>
						<th>수정</th>
					</tr>
					<tr>
						<td>ks0302</td>
						<td>김규형</td>
						<td>개발1팀</td>
						<td>2019.03.02</td>
						<td>15/15</td>
						<td>5/5</td>
						<td class="updateBtn"><a>수정</a></td>
					</tr>
				</table>
				
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>