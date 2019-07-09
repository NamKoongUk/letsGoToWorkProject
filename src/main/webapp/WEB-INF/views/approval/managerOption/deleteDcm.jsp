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
			<h3 class="title">삭제문서</h3>
			<hr>
			<div class="content">
				<select class="form-control" style="width:150px; display:inline-block;">
					<option var="all">전체보기</option>
					<c:forEach var="form" items="${ requestScope.formList }">
						<option value="${ form.afNo }">${ form.afName }</option>
					</c:forEach>
				</select>
				<button onclick="recoveryDcm();" style="float:right; margin-left:8px;" class="btn btn-default">선택복구</button>
				<button onclick="deleteDcm();" style="float:right; margin-left:8px;" class="btn btn-default">선택삭제</button>
				<table class="table table-hover">
				    <thead>
				      <tr>
				      	<th><input type="checkbox" id="checkAll"></th>
				        <th>문서번호</th>
				        <th>제목</th>
				        <th>기안자</th>
				        <th>기안일</th>
				        <th>구분</th>
				        <th>역할</th>
				      </tr>
				    </thead>
				    <tbody>
				      <c:forEach var="ad" items="${ requestScope.list }">
				      	<tr>
				      		<th><input type="checkbox" name="check" value="${ ad.adNo }"></th>
				      		<td>${ ad.adNo }</td>
				      		<td>${ ad.adTitle }</td>
				      		<td>${ ad.adWriterName }</td>
				      		<td>${ ad.adStartDate }</td>
				      		<td>${ ad.afName }</td>
				      		<td>${ ad.alRoll }</td>
				      	</tr>
				      </c:forEach>
				    </tbody>
		  		</table>
				<div class="paging" align="center">
	                  <ul class="pagination">
	                     <c:if test="${ pi.startPage > 1 }">
	                        <li><a href="${contextPath}/showAllDcm.ap?currentPage=${ pi.startPage - pi.buttonCount }"><<</a></li>
	                     </c:if>
	                     <c:if test="${ pi.startPage <= 1 }">
	                        <li><a href="#"><<</a></li>
	                     </c:if>
	                     <c:if test="${ pi.startPage != pi.currentPage }">
	                        <li><a href="${contextPath}/showAllDcm.ap?currentPage=${ pi.currentPage - 1}"><</a></li>
	                     </c:if>
	                     <c:if test="${ pi.startPage == pi.currentPage }">
	                        <li><a href="#"><</a></li>
	                     </c:if>
	                     <c:forEach var="pageNum" begin="${ pi.startPage }" end="${ pi.endPage }" step="1">
	                        <c:if test="${ pageNum == pi.currentPage }">
	                           <li class="active"><a>${ pageNum }</a></li>
	                        </c:if>
	                        <c:if test="${ pageNum != pi.currentPage }">
	                           <li><a href="${contextPath}/showAllDcm.ap?currentPage=${ pageNum }">${ pageNum }</a></li>
	                        </c:if>
	                     </c:forEach>
	                     <c:if test="${ pi.endPage != pi.currentPage }">
	                        <li><a href="${contextPath}/showAllDcm.ap?currentPage=${ pi.currentPage + 1 }">></a></li>
	                     </c:if>
	                     <c:if test="${ pi.endPage == pi.currentPage }">
	                        <li><a href="#">></a></li>
	                     </c:if>
	                     <c:if test="${ pi.endPage != pi.maxPage }">
	                        <li><a href="${contextPath}/showAllDcm.ap?currentPage=${ pi.endPage }">>></a></li>
	                     </c:if>
	                     <c:if test="${ pi.endPage == pi.maxPage }">
	                        <li><a href="#">>></a></li>
	                     </c:if>
	                  </ul>
	               </div>
			</div>
		</section>
	</div>
	
	<jsp:include page="../../common/footer.jsp" />
	<script>
		function recoveryDcm(){
			if(confirm("복구하시겠습니까?")) {
				var adNoArr = new Array();
				$("input[name='check']").each(function(){
					if($(this).is(":checked") == true) {
						adNoArr.push($(this).val());
					}
				});
				
				if(adNoArr.length > 0) {
					$.ajax({
						url:"${contextPath}/recoveryDcm.ap",
						type:"post",
						data:{adNoArr:adNoArr},
						traditional : true,
						success:function(data){
							alert(data + "개의 문서가 복구되었습니다.");
							window.location.reload();
						},
						error:function(data){
							alert("뭐지");
						}
					});
				}else {
					alert("삭제할 문서를 선택해주세요");
				}					
			}else{
				alert("취소되었습니다.");
			}
			
		}
	
		function deleteDcm(){
			if(confirm("복구가 불가능합니다 정말로 삭제하시겠습니까?")){
				var adNoArr = new Array();
				$("input[name='check']").each(function(){
					if($(this).is(":checked") == true) {
						adNoArr.push($(this).val());
					}
				});
				console.log(adNoArr);
				
				if(adNoArr.length > 0) {
					$.ajax({
						url:"${contextPath}/permanentlyDeleteDcm.ap",
						type:"post",
						data:{adNoArr:adNoArr},
						traditional : true,
						success:function(data){
							alert(data + "개의 문서가 삭제되었습니다.");
							window.location.reload();
						},
						error:function(data){
							alert("뭐지");
						}
					});
				}else {
					alert("삭제할 문서를 선택해주세요");
				}					
			}else{
				alert("취소되었습니다.");
			}
		}
	
		$("#checkAll").click(function(){
			if($("#checkAll").prop("checked")) {				
				$("input[name='check']").prop("checked", true);
			}else {
				$("input[name='check']").prop("checked", false);
			}
			
		});
		
		$(".table").find("td").click(function(){
			var adNo = $(this).parents().children("th").eq(0).children().eq(0).val();
			console.log(adNo);
			location.href="${ contextPath }/showDetailDcm.ap?adNo=" + adNo;
		});
	</script>
	
</body>
</html>