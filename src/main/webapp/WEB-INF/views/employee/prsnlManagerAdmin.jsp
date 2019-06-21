<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LetsGoToWork</title>
<style>
	#searchArea{
		height:35px;
		width: 250px;
		border:1px solid #1b5ac2;
		background:#ffffff;
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
	.delete{
		color:#00BFFF;
	}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/employee.jsp"/>
		
		<section class="col-sm-10">
			<h1 class="title">인사관리자</h1>
			<hr>
			<div class="content">
				<form>
					<div id="searchArea">
					<input id="searchInput" type="text" placeholder="이름을 입력하세요">
					<button id="searchBtn">저장</button>
				</div>
				</form>
				<form>
					<table class="table">
						<tr class="info">
							<th>소속</th>
							<th>이름</th>
							<th>직급</th>
							<th>상태</th>
						</tr>
						<tr>
							<td>인사팀장</td>
							<td>임나연</td>
							<td>과장</td>
							<td><a class="delete">삭제</a></td>
						</tr>
					</table>
				
				</form>
				
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>