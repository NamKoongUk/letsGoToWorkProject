<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LetsGoToWork</title>
<style type="text/css">
	.cancle {
		color:#00BFFF;
	}
	#sel1{
		width:15%;
	}
	#selectArea{
		margin-bottom:1%;
	}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/employee.jsp"/>
		
		<section class="col-sm-10">
			<h1 class="title">근태 수정 내역</h1>
			<button type="button" class="btn btn-primary" onclick="location.href='showAttendStatus.em'">근태현황</button>
			<button type="button" class="btn btn-primary" onclick="location.href='showUpdateAttenStatus.em'">근태 수정 내역</button>
			<hr>
			<div class="content">
				<div id="selectArea">
					<select class="form-control" id="sel1">
						        <option>--모든 진행 상태--</option>
						        <option>대기</option>
						        <option>완료</option>
						        <option>반려</option>
						        <option>취소</option>
					</select>
				</div>
					<table class="table">
						    <thead>
							      <tr class="info">
							        <th>요청날짜</th>
							        <th>내용</th>
							        <th>기존 시간</th>
							        <th>요청 시간</th>
							        <th>사유</th>
							        <th>결과</th>
							        <td>상세</td>
							      </tr>
						    </thead>
						    <tbody>
						      	<tr>
						      		<td>2019.05.05</td>
						      		<td>휴일체크 오류</td>
						      		<td>미체크</td>
						      		<td>19:00</td>
						      		<td>시스템 오류</td>
						      		<td>결재완료</td>
						      		<td><a class="cancle">상세</a></td>
						      	</tr>
						    </tbody>
					 	 </table>
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>