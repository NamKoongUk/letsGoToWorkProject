<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<style>
	
	#deptTable td{
		font-size:150%;
	}
	.profileArea {
    border-radius: 0;
    border: 0;
    display: inline-block;
	margin-right:3%;
	margin-bottom:1%;
    position: relative;
	}
	.image img {
    display: block;
	} */
	/* img{
		border-radius:100%;
	} */
	.profileTable td{
		font-size:130%;
	}
	.proTableArea{
		display: inline-block;
	}
	#searchTable{
		width:50%;
	}
	
	select {
		width: 200px;
		padding: .8em .5em;
		border: 1px solid #999;
		font-family: inherit;
		background: url('resources/images/arrow.jpg') no-repeat 95% 50%;
		border-radius: 0px;
		-webkit-appearance: none;
		-moz-appearance: none;
		appearance: none;
	}
	
</style>
<meta charset="UTF-8">
<title>LetsGoToWork</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/employee.jsp"/>
		
		<c:set var="deptList" value="${hmap.deptList }"/>
		<c:set var="jobList" value="${hmap.jobList }"/>
		
		<section class="col-sm-10">
			<h1 class="title">직원목록</h1>
			<hr>
			<div class="content">
				<div id="searchArea">
					<form action="searchEmpUser.em" method="post">
						<table class="table" id="searchTable">
							<tr>
								<td width="20%;">
									<select name="deptName">
										<option value="all">부서 전체</option>
										<c:forEach var="dept" items="${deptList }" varStatus="status">
											<option value="${dept.deptName }"><c:out value="${dept.deptName }"/></option>
										</c:forEach>
									</select>
								</td>
								<td>
									<select name="jobName">
										<option value="all">직급 전체</option>
										<c:forEach var="job" items="${jobList }">
											<option value="${job.jobName }"><c:out value="${job.jobName }"/></option>
										</c:forEach>
									</select>
								</td>
								<td>
									<input id="seach" name="empName" type="text" placeholder="이름을 입력하세요." style="height:43px;">
									
								</td>
								<td>
									<button type="submit" class="btn btn-primary">검색</button>
								</td>
								
							</tr>
						
						</table>
					</form>
				</div>
				<hr>
			
					  <div class="empProfile">
						  <c:forEach var="emp" items="${empList }">
						  	<div class="profileArea" data-toggle="modal" data-target="#myModal">
						  		<c:forEach var="attach" items="${attachList }">
									<c:if test="${emp.empNo eq attach.empNo }">
										<c:if test="${attach.originName eq 'users.jpg' }">
								  			<img src="${contextPath }/resources/images/profile/users.jpg" width="150px;" height="200px;">
										</c:if>
										<c:if test="${!attach.originName eq 'users.jpg'}">
											<img src="${contextPath }/resources/images/profile/${attach.changeName }.jpg">
										</c:if>
									</c:if>					  	
						  		</c:forEach>
						  		<div class="proTableArea">
							  		<table class="profileTable">
							  			<tr>
							  				<td><c:out value="${emp.empName }"/></td>
							  			</tr>
							  			<tr>
							  				<td><c:out value="${emp.deptName }"/></td>
							  			</tr>
							  			<tr>
							  				<td><c:out value="${emp.jobName }" /></td>
							  			</tr>
							  			<tr>
							  				<td><c:out value="${emp.enrollDate }" /></td>
							  			</tr>
							  		</table>
						  		</div>
						  	</div>
						  </c:forEach>
					  </div>
					  
					  	<div class="paging" align="center">
	                  <ul class="pagination">
	                     <c:if test="${ pi.startPage > 1 }">
	                        <li><a href="${ contextPath }/showWaitCirculationDcm.ap?currentPage=${ pi.startPage - pi.buttonCount }"><<</a></li>
	                     </c:if>
	                     <c:if test="${ pi.startPage <= 1 }">
	                        <li><a href="#"><<</a></li>
	                     </c:if>
	                     <c:if test="${ pi.startPage != pi.currentPage }">
	                        <li><a href="${ contextPath }/showWaitCirculationDcm.ap?currentPage=${ pi.currentPage - 1}"><</a></li>
	                     </c:if>
	                     <c:if test="${ pi.startPage == pi.currentPage }">
	                        <li><a href="#"><</a></li>
	                     </c:if>
	                     <c:forEach var="pageNum" begin="${ pi.startPage }" end="${ pi.endPage }" step="1">
	                        <c:if test="${ pageNum == pi.currentPage }">
	                           <li class="active"><a>${ pageNum }</a></li>
	                        </c:if>
	                        <c:if test="${ pageNum != pi.currentPage }">
	                           <li><a href="${ contextPath }/showWaitCirculationDcm.ap?currentPage=${ pageNum }">${ pageNum }</a></li>
	                        </c:if>
	                     </c:forEach>
	                     <c:if test="${ pi.endPage != pi.currentPage }">
	                        <li><a href="${ contextPath }/showWaitCirculationDcm.ap?currentPage=${ pi.currentPage + 1 }">></a></li>
	                     </c:if>
	                     <c:if test="${ pi.endPage == pi.currentPage }">
	                        <li><a href="#">></a></li>
	                     </c:if>
	                     <c:if test="${ pi.endPage != pi.maxPage }">
	                        <li><a href="${ contextPath }/showWaitCirculationDcm.ap?currentPage=${ pi.endPage + 1 }">>></a></li>
	                     </c:if>
	                     <c:if test="${ pi.endPage == pi.maxPage }">
	                        <li><a href="#">>></a></li>
	                     </c:if>
	                  </ul>
	               </div>
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
	
	<!-- 모달영역 -->
	<div class="modal fade" id="myModal" role="dialog">
	    <div class="modal-dialog">
	    
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">개인 정보</h4>
	        </div>
	        <div class="modal-body">
	          <p>Some text in the modal.</p>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        </div>
	      </div>
	    </div>
  </div>
	
</body>
</html>