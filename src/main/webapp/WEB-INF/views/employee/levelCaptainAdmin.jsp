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
	
	<c:set var="deptList" value="${hmap.deptList }"/>
	<c:set var="jobList" value="${hmap.jobList }"/>
	<c:set var="empList" value="${hmap.empList }"/>
	
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/employee.jsp"/>
		<c:set var="deptList" value="${hmap.deptList }"/>
		
		<section class="col-sm-10">
			<h1 class="title">부서장 관리</h1>
			<hr>
			<div class="content">
				<%-- <p>직급관리</p>
				<form>
					<table class="table">
						<c:forEach var="job" items="${jobList }" varStatus="status">
							<tr>
								<td class="info" width="30%;">${status.count }등급</td>
								<td width="30%;">${job.jobName }</td>
							</tr>
						</c:forEach>
					</table>
					<div id="saveArea">
						<button type="button" class="btn btn-primary" onclick="location.href=''">저장</button>
					</div>
				</form>
				<hr> --%>
				<p>부서장 관리</p>
				<form>
					<table class="table">
						<tr>
							<th>부서</th>
							<th>부서장</th>
							<th>직급</th>
							<th>상태</th>
						</tr>
						
						<c:forEach var="dept" items="${deptList }">
							<tr>
								<td><c:out value="${dept.deptName }"></c:out></td>
								<td>
									<c:if test="${dept.managerEmpNo ne 0 }">
										<c:forEach var="emp" items="${empList }">
											<c:if test="${dept.managerEmpNo eq emp.empNo }">
												<c:out value="${emp.empName }"></c:out>
											</c:if>
										</c:forEach>
									</c:if>
									<c:if test="${dept.managerEmpNo eq 0 }">
										공석   
									</c:if>
								</td>
								<td>2</td>
								<td>정상</td>
							</tr>
								
								
						</c:forEach>
					</table>
				
				</form>
				
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>