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
		margin-left:78%;
		
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
	.cancle{
		color:skyblue;
	}
	

</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/employee.jsp"/>
		
		<section class="col-sm-10">
			<h1 class="title">사용자 관리</h1>
			<button type="button" class="btn btn-primary" onclick="location.href='showEmpOneRegister.em'">사용자 추가</button>
			<button type="button" class="btn btn-primary" onclick="location.href='showEmpClctvRegister.em'">사용자 일괄 추가</button>
			<button type="button" class="btn btn-primary" onclick="location.href='showUpdateEmpClctv.em'">사용자 일괄 수정</button>
			<hr>
			<div class="content">
				<div id="searchArea">
					<input id="searchInput" type="text" placeholder="ID, 이름 검색">
					<button id="searchBtn">검색</button>
				</div>
				<div style="margin-left:1%;">
					<a class="cancle">삭제</a>
				</div>
				<form action="insertEmpQuick.em" method="post">
				<table class="table">
				    <thead>
					      <tr class="info">
					      	<th><input type="checkbox"></th>
					        <th>이름</th>
					        <th>ID</th>
					        <th>비밀번호</th>
					        <th>사내전화</th>
					        <th>휴대전화</th>
					        <th>소속조직</th>
					        <th>직위</th>
					        <th>상태</th>
					      </tr>
				    </thead>
				    <tbody>
				      	<tr>
				      		<td></td>
				      		<td><input type="text" size="10" name="empName"  placeholder="이름 입력"></td>
				      		<td><input type="text" size="10" name="empId"  placeholder="ID 입력"></td>
				      		<td><input type="password" size="10" name="empPwd"  placeholder="비밀번호 입력"></td>
				      		<td><input type="text" size="10" name="officeTel"  placeholder="사내전화 입력"></td>
				      		<td><input type="text" size="13" name="empPhone"  placeholder="휴대전화 입력"></td>
				      		<td><input type="text" size="10" placeholder="소속조직 입력"></td>
				      		<td><input type="text" size="5"  placeholder="직위 입력"></td>
				      		<td><button type="button" class="btn btn-primary" onclick="location.href=''">저장</button></td>
				      	</tr>
				    </tbody>
			 	 </table>
			 	 </form>
			 	 <form>
			 	 	<table class="table">
			 	 		<tr>
			 	 			<td><input type="checkbox"></td>
			 	 			<td>김규형</td>
			 	 			<td>kkhgud</td>
			 	 			<td>*******</td>
			 	 			<td>1302</td>
			 	 			<td>01022223333</td>
			 	 			<td>개발1팀</td>
			 	 			<td>사원</td>
			 	 			<td>정상</td>
			 	 		</tr>
			 	 	
			 	 	</table>
			 	 
			 	 </form>
				
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>