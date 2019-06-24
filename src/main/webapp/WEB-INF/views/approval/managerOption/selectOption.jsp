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
			<h3 class="title">관리자 옵션</h3>
			<br>
			<label>등급설정</label>
				<table class="table">
					<tr style="background:">
						<th>등급</th>
						<th>권한</th>
					</tr>
					<c:forEach var="se" items="${ requestScope.list }">
						<tr>
							<td>${ se.securityGrade }</td>
							<c:if test="${ se.securityCode == 's' }">
								<td>기안자와 관련자만 열람 가능</td>
							</c:if>
							<c:if test="${ se.securityCode == 'c' }">
								<td>모든 사원 열람가능</td>
							</c:if>
							<c:if test="${ se.securityCode != 'c' && se.securityCode != 's' }">							
								<td>
									결재 완료시
									<select id="${ se.securityCode }">
										<option>선택</option>
										<c:forEach var="job" items="${ requestScope.jobList }">
											<c:if test="${ job.jobCode == se.jobCode }">
												<option value="${ job.jobCode }" selected="selected">${ job.jobName }</option>
											</c:if>
											<c:if test="${ job.jobCode != se.jobCode }">
												<option value="${ job.jobCode }">${ job.jobName }</option>
											</c:if>
 											</c:forEach>
									</select>
									직급 이상 열람가능
								</td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
				<div class="buttonArea">
					<button style="float:right" class="btn btn-default" onclick="optionSave();">저장</button>
				</div>
			<div class="content">
				
			</div>
		</section>
	</div>
	
	<jsp:include page="../../common/footer.jsp" />
	<script>	
		function optionSave(){
			var aGrade = $("#a option:selected").val();
			var bGrade = $("#b option:selected").val();
			
			var grade = {
					"aGrade":aGrade,
					"bGrade":bGrade
			}
			
			$.ajax({
				url:"${contextPath}/updateOption.ap",
				data:JSON.stringify(grade),
				contentType:"application/json;charset=UTF-8",
				type:"post",
				success:function(data){
					alert(data);
					window.location.reload(true);
				}
			});
		}
	</script>
	
</body>
</html>













