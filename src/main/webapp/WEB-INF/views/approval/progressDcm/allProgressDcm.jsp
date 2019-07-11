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
			<h3 class="title">전체문서</h3>
			<hr>
			<div class="content">
				<select class="form-control" id="category" style="width:150px; display:inline-block;">
					<option value="all">전체보기</option>
					<c:forEach var="form" items="${ requestScope.formList }">
						<option value="${ form.afNo }">${ form.afName }</option>
					</c:forEach>
				</select>
				<button onclick="searchDcm();" style="float:right; margin-left:8px;" class="btn btn-primary">검색</button>
				<input type="text" class="form-control" id="searchText" style="float:right; width:200px; margin-left:10px;">
				<select class="form-control" id="type" style="width:100px;display:inline-block; float:right;">
					<option value="">선택</option>
					<option value="emp">기안자</option>
					<option value="title">문서제목</option>
					<option value="dept">기안부서</option>
				</select>
				<table class="table table-hover">
				    <thead>
				      <tr>
				        <th>문서번호</th>
				        <th>제목</th>
				        <th>기안자</th>
				        <th>기안일</th>
				        <th>구분</th>
				  		<th>상태</th>
				  		<th>역할</th>
				      </tr>
				    </thead>
				    <tbody>
				      <c:forEach var="ad" items="${ requestScope.list }">
				      	<tr>
				      		<td><input type="hidden" value="${ ad.adNo }">${ ad.adNo }</td>
				      		<td>${ ad.adTitle }</td>
				      		<td>${ ad.empName }</td>
				      		<td>${ ad.adStartDate }</td>
				      		<td>${ ad.afName }</td>
				      		<td>${ ad.adStatus }</td>
				      		<c:if test="${ ad.alRoll == null }">
				      			<td>기안자</td>
				      		</c:if>
				      		<c:if test="${ ad.alRoll != null }">
					      		<td>${ ad.alRoll }</td>				      		
				      		</c:if>
				      	</tr>
				      </c:forEach>
				    </tbody>
		  		</table>
				<div class="paging" align="center">
	                  <ul class="pagination">
	                     <c:if test="${ pi.startPage > 1 }">
	                        <li><a href="${ contextPath }/showAllPrograssDcm.ap?currentPage=${ pi.startPage - pi.buttonCount }"><<</a></li>
	                     </c:if>
	                     <c:if test="${ pi.startPage <= 1 }">
	                        <li><a href="#"><<</a></li>
	                     </c:if>
	                     <c:if test="${ pi.startPage != pi.currentPage }">
	                        <li><a onclick="movePage(${ pi.currentPage - 1 });" href="#"><</a></li>
	                     </c:if>
	                     <c:if test="${ pi.startPage == pi.currentPage }">
	                        <li><a href="#"><</a></li>
	                     </c:if>
	                     <c:forEach var="pageNum" begin="${ pi.startPage }" end="${ pi.endPage }" step="1">
	                        <c:if test="${ pageNum == pi.currentPage }">
	                           <li class="active"><a>${ pageNum }</a></li>
	                        </c:if>
	                        <c:if test="${ pageNum != pi.currentPage }">
	                           <li><a href="${ contextPath }/showAllPrograssDcm.ap?currentPage=${ pageNum }">${ pageNum }</a></li>
	                        </c:if>
	                     </c:forEach>
	                     <c:if test="${ pi.endPage != pi.currentPage }">
	                        <li><a onclick="movePage(${ pi.currentPage + 1 });" href="#">></a></li>
	                     </c:if>
	                     <c:if test="${ pi.endPage == pi.currentPage }">
	                        <li><a href="#">></a></li>
	                     </c:if>
	                     <c:if test="${ pi.endPage != pi.maxPage }">
	                        <li><a href="${ contextPath }/showAllPrograssDcm.ap?currentPage=${ pi.endPage }">>></a></li>
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
		function searchDcm(){
			var text = $("#searchText").val();
			var type = $("#type").val();
			var category = $("#category").val();
			
			location.href="${contextPath}/showAllPrograssDcm.ap?category=" + category + "&text=" + text + "&type=" + type;
			
		}
		
		function movePage(currentPage){
			var text = $("#searchText").val();
			var type = $("#type").val();
			var category = $("#category").val();
			
			console.log(currentPage);
			
			location.href="${contextPath}/showAllPrograssDcm.ap?category=" + category + "&text=" + text + "&type=" + type + "&currentPage=" + currentPage;
		}
	
		$(function(){		
			var afNo = '${requestScope.pi.filterInfo}';
			console.log(afNo);
			var type = '${requestScope.map.type}';
			$("option").each(function(){
				if($(this).val() == afNo) {
					$(this).attr("selected", "selected");
				}
				if($(this).val() == type) {
					$(this).attr("selected", "selected");
				}
			});
			
			
			var text = '${requestScope.map.text}';
			
			$("#searchText").val(text);
			
			
		});
	
		$("#checkAll").click(function(){
			if($("#checkAll").prop("checked")) {				
				$("input[name='check']").prop("checked", true);
			}else {
				$("input[name='check']").prop("checked", false);
			}
			
		});
		
		$(".table").find("td").click(function(){
			var adNo = $(this).parents().children("td").eq(0).children().eq(0).val();
			console.log(adNo);
			location.href="${ contextPath }/showDetailDcm.ap?adNo=" + adNo;
		});
		
		$("#category").change(function(){
			var category = $(this).val();
			
			location.href="${contextPath}/showAllPrograssDcm.ap?category=" + category;
			
		});
		
	</script>
	
</body>
</html>



















