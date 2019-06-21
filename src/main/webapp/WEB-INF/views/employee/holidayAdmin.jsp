<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LetsGoToWork</title>
<style>
	#sel1{
		width:15%;
		height:10%;
		font-size:150%;
	}
	#sel2{
		width:10%;
	}
	.cancle {
		color:#00BFFF;
	}

</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/employee.jsp"/>
		
		<section class="col-sm-10">
			<h1 class="title">휴가 신청관리</h1>
			<button type="button" class="btn btn-primary" onclick="location.href='showHolidayList.em'">내 휴가</button>
			<button type="button" class="btn btn-primary" onclick="location.href='showHoliCalender.em'">휴가 캘린더</button>
			<button type="button" class="btn btn-primary" onclick="location.href='showHolidayAdmin.em'">휴가 신청관리</button>
			<hr>
			<div class="content">
				<select class="form-control" id="sel1">
				        <option>2019.01</option>
				        <option>2019.02</option>
				        <option>2019.03</option>
				        <option>2019.04</option>
				        <option>2019.05</option>
				        <option>2019.06</option>
				        <option>2019.07</option>
				        <option>2019.08</option>
				        <option>2019.09</option>
				        <option>2019.10</option>
				        <option>2019.11</option>
				        <option>2019.12</option>
				</select>
				<br>
					<select class="form-control" id="sel2">
					        <option>--휴가종류--</option>
					        <option>연차</option>
					        <option>병가</option>
					        <option>포상</option>
					        <option>교육</option>
					</select>
				<br>
				<table class="table">
					    <thead>
						      <tr class="info">
						        <th>신청자</th>
						        <th>소속</th>
						        <th>휴가 종류</th>
						        <th>신청일</th>
						        <th>일수</th>
						        <th>기간</th>
						        <td>상태</td>
						        <td>상세</td>
						        <td>휴가신청취소</td>
						      </tr>
					    </thead>
					    <tbody>
					      	<tr>
					      		<td>김규형</td>
					      		<td>개발1팀</td>
					      		<td>연차</td>
					      		<td>04.06</td>
					      		<td>5일</td>
					      		<td>05.01~05.06</td>
					      		<td>결재</td>
					      		<td>연차휴가</td>
					      		<td><a class="cancle">취소</a></td>
					      	</tr>
					    </tbody>
				 	 </table>
				
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>