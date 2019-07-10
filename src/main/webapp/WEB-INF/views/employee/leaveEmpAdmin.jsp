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
			<h1 class="title">휴직자 관리</h1>
			<hr>
			<div class="content">
				<div id="searchArea">
					<input id="searchInput" type="text" name="" placeholder="ID, 이름 검색">
					<button id="searchBtn">검색</button>
				</div>
				<br>
				<form action="insertEmpQuick.em" method="post">
				<table class="table">
				    <thead>
					      <tr class="info">
					      	<th><input type="checkbox" class="chk" name="checkAll" id="th_checkAll"></th>
					        <th>이름</th>
					        <th>ID</th>
					        <th>비밀번호</th>
					        <th>사내전화</th>
					        <th>휴대전화</th>
					        <th>소속</th>
					        <th>직급</th>
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
				      		<th>
					        	<select name = "deptCode">
					        		<c:forEach var="item" items="${deptList }">
					        			<option value="${item.deptCode }"><c:out value="${item.deptName }"></c:out></option>
					        		</c:forEach>
					        	
					        	</select>
					        </th>
					        <th>
					        	<select name = "jobCode">
					        		<c:forEach var="item" items="${jobList }">
					        			<option value="${item.jobCode }"><c:out value="${item.jobName }"></c:out></option>
					        		</c:forEach>
					        	
					        	</select>
					        </th>
				      		<td><button type="submit" class="btn btn-primary">저장</button></td>
				      	</tr>
				    </tbody>
			 	 </table>
			 	 </form>
			 	 <form action="deleteEmpList.em" method="post">
			 	 	<table class="table" id="empTable">
			 	 		<c:forEach var="item" items="${list }">
			 	 			<tr>
				 	 			<td><input type="checkbox" class="chk" name="empNo" value="${item.empNo }"></td>
				 	 			<td><c:out value="${item.empName }"/></td>
				 	 			<td><c:out value="${item.empId }"/></td>
				 	 			<td>********</td>
				 	 			<td><c:out value="${item.officeTel }"/></td>
				 	 			<td><c:out value="${item.empPhone }"/></td>
				 	 			<td><c:out value="${item.deptName }"/></td>
				 	 			<td><c:out value="${item.jobName }"/></td>
				 	 			<td>
				 	 				<c:choose>
				 	 					<c:when test="${item.status eq 'Y' }">
				 	 						정상
				 	 					</c:when>
				 	 					<c:when test="${item.status eq 'H' }">
				 	 						휴직
				 	 					</c:when>
				 	 				</c:choose>
				 	 			</td>
			 	 			</tr>
			 	 		</c:forEach>
			 	 	</table>
			 	 	<div style="margin-left:1%; margin-top:-1%;">
						<input type="submit" class="btn btn-primary" value="삭제">
					</div>
			 	 </form>
			 	 	<br>
			 	 	
			 	 	<!-- 페이징 -->
			 	 <%-- 	 <div id="pagingArea" align="center">
						<c:if test="${pi.currentPage<=1 }">
							[이전] 
						</c:if>
						<c:if test="${pi.currentPage>1 }">
							<c:url var="blistBack" value="/showEmployeeAdmin.em">
								<c:param name="currentPage" value="${pi.currentPage -1 }"/>
							</c:url>
							<a href="${blistBack }">[이전]</a> 
						</c:if>
						
						<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }">
							<c:if test="${p eq pi.currentPage }">
								<font color="red" size="4"><b>[${p }]</b></font>
							</c:if>
							<c:if test="${p ne pi.currentPage }">
								<c:url var="blistCheck" value="/showEmployeeAdmin.em">
									<c:param name="currentPage" value="${ p }"/>
								</c:url>
								<a href="${blistCheck }">${p }</a>
							</c:if>
						</c:forEach>
						
						<c:if test="${pi.currentPage == pi.maxPage }">
							 [다음]
						</c:if>
						<c:if test="${pi.currentPage < pi.maxPage }">
							<c:url var="blistEnd" value="/showEmployeeAdmin.em">
								<c:param name="currentPage" value="${pi.currentPage +1 }"/>
							</c:url>
							<a href="${blistEnd }">[다음]</a>
						</c:if>
					</div> --%>
				
				
				
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>