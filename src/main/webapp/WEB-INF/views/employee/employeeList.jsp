<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<style>
	/* .grid-container {
	  display: grid;
	  grid-template-columns: 300px 1fr;
	  grid-template-rows: 1fr;
	  grid-template-areas: "deptList empProfile";
	}
	
	.deptList { 
		grid-area: deptList; 
		}
	
	.empProfile { grid-area: empProfile; } */
	
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
	
</style>
<meta charset="UTF-8">
<title>LetsGoToWork</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/employee.jsp"/>
		<section class="col-sm-10">
			<h1 class="title">직원목록</h1>
			<hr>
			<div class="content">
					  <div class="empProfile">
					  <c:forEach var="emp" items="${empList }">
					  	<div class="profileArea">
					  		<c:forEach var="attach" items="${attachList }">
								<c:if test="${emp.empNo eq attach.empNo }">
									<c:if test="${attach.originName eq 'users.jpg' }">
							  			<img src="${contextPath }/resources/images/profile/users.jpg">
									</c:if>
										<img src="${contextPath }/resources/images/profile/${attach.changeName }.jpg">
								</c:if>					  	
					  		</c:forEach>
					  		<div class="proTableArea">
						  		<table class="profileTable">
						  			<tr>
						  				<td><c:out value="${emp.empName }"></c:out></td>
						  			</tr>
						  		</table>
					  		</div>
					  	</div>
					  </c:forEach>
					  
					  <%-- 	<div class="profileArea">
					  		<img src="${contextPath }/resources/images/profile/chae.jpg">
					  		<div class="proTableArea">
					  			<table class="profileTable">
					  				<tr>
					  					<td>김채연</td>
					  				</tr>
					  				<tr>
					  					<td>사장</td>
					  				</tr>
					  			</table>
					  		</div>	
					  	</div>
					  	<div class="profileArea">
					  		<img src="${contextPath }/resources/images/profile/jihyeon.jpg">
					  		<div class="proTableArea">
					  			<table class="profileTable">
					  				<tr>
					  					<td>이지현</td>
					  				</tr>
					  				<tr>
					  					<td>부사장</td>
					  				</tr>
					  			</table>
					  		</div>	
					  	</div>
					  	<div class="profileArea">
					  		<img src="${contextPath }/resources/images/profile/dodo.jpg">
					  		<div class="proTableArea">
					  			<table class="profileTable">
					  				<tr>
					  					<td>조도연</td>
					  				</tr>
					  				<tr>
					  					<td>개발부</td>
					  				</tr>
					  				<tr>
					  					<td>과장</td>
					  				</tr>
					  			</table>
					  		</div>	
					  	</div>
					  	<div class="profileArea">
					  		<img src="${contextPath }/resources/images/profile/hyeongseo.jpg">
					  		<div class="proTableArea">
					  			<table class="profileTable">
					  				<tr>
					  					<td>강형석</td>
					  				</tr>
					  				<tr>
					  					<td>영업팀</td>
					  				</tr>
					  				<tr>
					  					<td>부장</td>
					  				</tr>
					  			</table>
					  		</div>	
					  	</div>
					  	<div class="profileArea">
					  		<img src="${contextPath }/resources/images/profile/ukuk.jpg">
					  		<div class="proTableArea">
					  			<table class="profileTable">
					  				<tr>
					  					<td>남궁욱</td>
					  				</tr>
					  				<tr>
					  					<td>개발1팀</td>
					  				</tr>
					  				<tr>
					  					<td>팀장</td>
					  				</tr>
					  			</table>
					  		</div>	
					  	</div>
					  	<div class="profileArea">
					  		<img src="${contextPath }/resources/images/profile/kyu.jpg">
					  		<div class="proTableArea">
					  			<table class="profileTable">
					  				<tr>
					  					<td>김규형</td>
					  				</tr>
					  				<tr>
					  					<td>개발1팀</td>
					  				</tr>
					  				<tr>
					  					<td>사원</td>
					  				</tr>
					  			</table>
					  		</div>	
					  	</div>
					  	<div class="profileArea">
					  		<img src="${contextPath }/resources/images/profile/momo.jpg">
					  		<div class="proTableArea">
					  			<table class="profileTable">
					  				<tr>
					  					<td>양상모</td>
					  				</tr>
					  				<tr>
					  					<td>이사</td>
					  				</tr>
					  			</table>
					  		</div>	
					  	</div> --%>
					  </div>
						
				
			</div>
		</section>
	</div>
	<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
	<script src="/SRC2/simpletree/jquery.treemenu.js"></script>
	<script>
	$(function(){
	        $(".tree").treemenu({delay:300}).openActive();
	    });
	</script>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>