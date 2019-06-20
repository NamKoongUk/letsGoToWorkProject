<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LetsGoToWork</title>
<style>
	.holiP{
		font-size:180%;
	    font-weight:bold;
	}
	#havaHoli{
		font-size:130%;
		font-weight:bold;
	}
	#sel1{
		width:10%;
	}
	
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/employee.jsp"/>
		<section class="col-sm-10">
			<h1 class="title">휴가 현황</h1>
			<button type="button" class="btn btn-primary" onclick="location.href='showHolidayList.em'">내 휴가</button>
			<button type="button" class="btn btn-primary" onclick="location.href='showHoliCalender.em'">휴가 캘린더</button>
			<button type="button" class="btn btn-primary" onclick="location.href='showHolidayAdmin.em'">휴가 신청관리</button>
			<hr>
			<div class="content">
				<div id="holidayArea">
					<p class="holiP">휴가 생성 내역(2019.01.01~2019.12.31) 입사일 : 2019년 3월 2일</p>
					<table class="table">
					    <thead>
						      <tr class="info">
						        <th>생성일</th>
						        <th>휴가 시작일</th>
						        <th>휴가 종료일</th>
						        <th>내용</th>
						        <th>비고</th>
						      </tr>
					    </thead>
					    <tbody>
					      	<tr>
					      		<td>2019.06.20</td>
					      		<td>2019.07.01</td>
					      		<td>2019.07.17</td>
					      		<td>1차 정기 휴가</td>
					      		<td></td>
					      	</tr>
					    </tbody>
				 	 </table>
				  	<p id="havaHoli">올해 남은 휴가</p>
			  	</div>
			  	<hr>
			  	<div id="reqHoliArea">
			  		<p class="holiP">휴가 신청 내역</p>
			  		<form>
				      <select class="form-control" id="sel1">
				        <option>--휴가종류--</option>
				        <option>연차</option>
				        <option>병가</option>
				        <option>포상</option>
				        <option>교육</option>
				      </select>
				    </form>
				    <br>
			  		<table class="table">
					    <thead>
						      <tr class="info">
						        <th>신청번호</th>
						        <th>신청자</th>
						        <th>휴가 종류</th>
						        <th>일수</th>
						        <th>기간</th>
						        <td>상태</td>
						        <td>상세</td>
						      </tr>
					    </thead>
					    <tbody>
					      	<tr>
					      		<td>1</td>
					      		<td>김규형</td>
					      		<td>연차</td>
					      		<td>5일</td>
					      		<td>05.01~05.06</td>
					      		<td>결재</td>
					      		<td>연차휴가</td>
					      	</tr>
					    </tbody>
				 	 </table>
			  	</div>
			  
			  
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>