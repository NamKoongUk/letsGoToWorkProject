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
	.img-button{
		background:url(resources/images/employee/plus.png) no-repeat;
		border:none;
		width:20px;
		height:20px;
		cursor:pointer;
	}
	.aBtn{
		color:#00BFFF;
	}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/employee.jsp"/>
		
		<section class="col-sm-10">
			<h1 class="title">직급/부서장 관리</h1>
			<hr>
			<div class="content">
				<p>직급관리</p>
				<form>
					<table class="table">
						<tr>
							<td class="info">1등급</td>
							<td width="30%;">대표이사</td>
							<td><input type="text"><input type="button" class="img-button"></td>
						</tr>
						<tr>
							<td class="info">2등급</td>
							<td>이사</td>
							<td><input type="text"><input type="button" class="img-button"></td>
						</tr>
						<tr>
							<td class="info">3등급</td>
							<td>부장</td>
							<td><input type="text"><input type="button" class="img-button"></td>
						</tr>
						<tr>
							<td class="info">4등급</td>
							<td>차장</td>
							<td><input type="text"><input type="button" class="img-button"></td>
						</tr>
						<tr>
							<td class="info">5등급</td>
							<td>과장</td>
							<td><input type="text"><input type="button" class="img-button"></td>
						</tr>
						<tr>
							<td class="info">6등급</td>
							<td>대리</td>
							<td><input type="text"><input type="button" class="img-button"></td>
						</tr>
						<tr>
							<td class="info">7등급</td>
							<td>사원</td>
							<td><input type="text"><input type="button" class="img-button"></td>
						</tr>
					</table>
					<div id="saveArea">
						<button type="button" class="btn btn-primary" onclick="location.href=''">저장</button>
					</div>
				</form>
				<hr>
				<p>부서장 관리</p>
				<form>
					<table class="table">
						<tr>
							<th>부서</th>
							<td>부서장</td>
							<td>직급</td>
							<td>상태</td>
						</tr>
						<tr>
							<td>출근합시다</td>
							<td>김채연</td>
							<td>대표이사</td>
							<td>정상<a class="aBtn">(변경)</a></td>
						</tr>
						<tr>
							<td>개발1팀</td>
							<td>남궁욱</td>
							<td>과장</td>
							<td>정상<a class="aBtn">(변경)</a></td>
						</tr>
						<tr>
							<td>개발2팀</td>
							<td><input type="text" placeholder="공석(부서장을 입력하세요)"></td>
							<td></td>
							<td><button type="button" class="btn btn-primary" onclick="location.href=''">저장</button></td>
						</tr>
					</table>
				
				</form>
				
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>