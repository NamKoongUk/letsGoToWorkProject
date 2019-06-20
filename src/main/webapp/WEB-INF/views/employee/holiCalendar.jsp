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
	<jsp:include page="../common/menubar.jsp"/>
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/employee.jsp"/>
		<section class="col-sm-10">
			<h1 class="title">휴가 달력</h1>
			<button type="button" class="btn btn-primary" onclick="location.href='showHolidayList.em'">내 휴가</button>
			<button type="button" class="btn btn-primary" onclick="location.href='showHoliCalender.em'">휴가 캘린더</button>
			<button type="button" class="btn btn-primary" onclick="location.href='showHolidayAdmin.em'">휴가 신청관리</button>
			<hr>
			<div class="content">
				
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>