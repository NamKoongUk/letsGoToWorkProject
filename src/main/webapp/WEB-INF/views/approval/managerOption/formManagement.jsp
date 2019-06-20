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
	<jsp:include page="../../common/menubar.jsp"/>
	
	<div class="row wrap">
		<jsp:include page="../../common/sideMenu/approval.jsp"/>
		
		<section class="col-sm-10">
			<h3 class="title">양식관리</h3>
			<hr>
			<div class="content">
				<a href="insertAppForm.ap">양식생성</a> &nbsp;&nbsp;
				<a href="#">제공양식</a><br><br>
				
				<a href="#">삭제</a>&nbsp;&nbsp;
				<a href="#">사용전환</a>&nbsp;&nbsp;
				<a href="#">미사용전환</a>
				<table class="table table-hover">
				    <thead>
				      <tr>
				        <th><input type="checkbox" id="check"></th>
				        <th>사용여부</th>
				        <th>양식명</th>
				        <th>약칭</th>
				        <th>설명</th>
				      </tr>
				    </thead>
				    <tbody>
				      <!-- 조회해온 값 넣기 -->
				    </tbody>
		  		</table>
			</div>
		</section>
	</div>
	
	<jsp:include page="../../common/footer.jsp" />
</body>
</html>