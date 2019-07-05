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
			<h3 class="title">진행중인 문서</h3>
			<hr>
			<div class="content">
				<select class="form-control" style="width:150px; display:inline-block;">
					<option var="all">전체보기</option>
					<c:forEach var="form" items="${ requestScope.formList }">
						<option value="${ form.afNo }">${ form.afName }</option>
					</c:forEach>
				</select>
				<button onclick="" style="float:right; margin-left:8px;" class="btn btn-primary">확인</button>
				<select class="form-control" style="width:150px;display:inline-block; float:right;">
					<option>선택</option>
					<option>확인</option>
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
				      </tr>
				    </thead>
				    <tbody>
				      <c:forEach var="ad" items="${ requestScope.list }">
				      	<tr>
				      		<td><input type="hidden" value="${ ad.adNo }">${ ad.adNo }</td>
				      		<td>${ ad.adTitle }</td>
				      		<td>${ ad.adWriterName }</td>
				      		<td>${ ad.adStartDate }</td>
				      		<td>${ ad.afName }</td>
				      		<td>${ ad.status }</td>
				      	</tr>
				      </c:forEach>
				    </tbody>
		  		</table>
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
	
	<jsp:include page="../../common/footer.jsp" />
	<script>
		$(".table").find("td").click(function(){
			var adNo = $(this).parents().children("td").eq(0).children().eq(0).val();
			console.log(adNo);
			location.href="${ contextPath }/showDetailDcm.ap?adNo=" + adNo;
		});
	</script>
	
</body>
</html>