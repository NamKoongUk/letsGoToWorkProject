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
		<!-- 진행중인문서-회람문서 -->
			<h3 class="title">회람문서</h3>
			<hr>
			<div class="content">
				<select class="form-control" style="width:150px; display:inline-block;">
					<option>전체</option>
					<option>품의서</option>
					<option>보고서</option>
					<option>휴가신청서</option>
				</select>
				<button onclick="" style="float:right; margin-left:8px;" class="btn btn-primary">확인</button>
				<select class="form-control" style="width:150px;display:inline-block; float:right;">
					<option>선택</option>
					<option>결재</option>
					<option>반려</option>
				</select>
				<table class="table table-hover">
				    <thead>
				      <tr>
				        <th>문서번호</th>
				        <th>제목</th>
				        <th>기안자</th>
				        <th>기안일</th>
				        <th>구분</th>
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