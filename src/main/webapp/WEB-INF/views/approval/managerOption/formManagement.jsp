<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LetsGoToWork</title>
<style>
	td{
		cursor:pointer;
	}
</style>
</head>
<body>
	<jsp:include page="../../common/menubar.jsp"/>
	
	<div class="row wrap">
		<jsp:include page="../../common/sideMenu/approval.jsp"/>
		
		<section class="col-sm-10">
			<h3 class="title">양식관리</h3>
			<hr>
			<div class="content">
				<a href="${ contextPath }/selectAppForm.ap">양식생성</a> &nbsp;&nbsp;
				<a href="#">제공양식</a><br><br>
				
				<a href="#" id="delete">삭제</a>&nbsp;&nbsp;
				<a href="#" class="update" id="Y">사용전환</a>&nbsp;&nbsp;
				<a href="#" class="update" id="N">미사용전환</a>
				<table class="table table-hover" id="afArea">
				    <thead>
				      <tr>
				        <th><input type="checkbox" id="checkAll"></th>
				        <th>사용여부</th>
				        <th>양식명</th>
				        <th>약칭</th>
				        <th>설명</th>
				      </tr>
				    </thead>
				    <tbody id="tbody">
				      <c:forEach var="af" items="${ list }"> 
				      	<tr>
				      		<th>
				     			<input type="hidden" value="${ af.afNo }">
				     			<input type="checkbox" name="check" value="${ af.afNo }">
				     		</th>
				      		<td>
				      			<c:if test="${ af.afStatus == 'N' }">
				      				<p>미사용</p>
				      			</c:if>
				      			<c:if test="${ af.afStatus == 'Y' }">
				      				<p>사용</p>
				      			</c:if>
				      		</td>
				      		<td>${ af.afName }</td>
				      		<td>${ af.afAlias }</td>
				      		<td>${ af.afComment }</td>
				      	</tr>
				      </c:forEach>
				    </tbody>
		  		</table>
		  		<div class="paging" align="center">
                  <ul class="pagination">
                     <c:if test="${ pi.startPage > 1 }">
                     	<c:url var="blistBack" value="${ cotextPage }/showFormManagement.ap">
							<c:param name="currentPage" value="${ pi.currentPage - 1 }"/>
						</c:url>
                        <li><a href="${ blistBack }"><<</a></li>
                     </c:if>
                     <c:if test="${ pi.startPage <= 1 }">
                        <li><a href="#"><<</a></li>
                     </c:if>
                     <c:if test="${ pi.startPage != pi.currentPage }">
                        <li><a href="${ contextPath }/showFormManagement.ap?currentPage=${ pi.currentPage - 1}"><</a></li>
                     </c:if>
                     <c:if test="${ pi.startPage == pi.currentPage }">
                        <li><a href="#"><</a></li>
                     </c:if>
                     <c:forEach var="pageNum" begin="${ pi.startPage }" end="${ pi.endPage }" step="1">
                        <c:if test="${ pageNum == pi.currentPage }">
                           <li class="active"><a>${ pageNum }</a></li>
                        </c:if>
                        <c:if test="${ pageNum != pi.currentPage }">
                           <li><a href="${ contextPath }/showFormManagement.ap?currentPage=${ pageNum }">${ pageNum }</a></li>
                        </c:if>
                     </c:forEach>
                     <c:if test="${ pi.endPage != currentPage }">
                        <li><a href="${ contextPath }/showFormManagement.ap?currentPage=${ pi.currentPage + 1 }">></a></li>
                     </c:if>
                     <c:if test="${ pi.endPage == currentPage }">
                        <li><a href="#">></a></li>
                     </c:if>
                     <c:if test="${ pi.endPage != pi.maxPage }">
                        <li><a href="${ contextPath }/showFormManagement.ap?currentPage=${ pi.endPage + 1 }">>></a></li>
                     </c:if>
                     <c:if test="${ pi.endPage == pi.maxPage }">
                        <li><a href="#">>></a></li>
                     </c:if>
                  </ul>
               </div>
				<%-- <div class="pagingArea" align="center">
					<ul class="pagination">
					<c:if test="${ pi.currentPage <= 1 }">
						<li><a href="#">이전</a></li>
					</c:if>
					<c:if test="${ pi.currentPage > 1 }">
						<c:url var="blistBack" value="${ cotextPage }/showFormManagement.ap">
							<c:param name="currentPage" value="${ pi.currentPage - 1 }"/>
						</c:url>
						<li><a href="${ blistBack }">이전</a></li>
					</c:if>
					
					<c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
						<c:if test="${ p eq pi.currentPage }">
							<li class="active"><a href="#">${ p }</a></li>
							
						</c:if>
						<c:if test="${ p ne pi.currentPage }">
							<c:url var="blistCheck" value="${ cotextPage }/showFormManagement.ap">
								<c:param name="currentPage" value="${ p }"/>
							</c:url>
							<li><a href="${ blistCheck }">${ p }</a></li>
						</c:if>
					</c:forEach>
					
					<c:if test="${ pi.currentPage >= pi.maxPage }">
						<li><a href="#">다음</a></li>
					</c:if>
					<c:if test="${ pi.currentPage < pi.maxPage }">
						<c:url var="blistEnd" value="${ cotextPage }/showFormManagement.ap">
							<c:param name="currentPage" value="${ pi.currentPage + 1 }"/>
						</c:url>
						<li><a href="${ blistEnd }">다음</a></li>
					</c:if>
					</ul>
				</div> --%>
			</div>
		</section>
	</div>
	<jsp:include page="../../common/footer.jsp" />
	
	
	<script>
		$(function(){
			$("#checkAll").click(function(){
				if($("#checkAll").prop("checked")) {				
					$("input[name='check']").prop("checked", true);
				}else {
					$("input[name='check']").prop("checked", false);
				}
				
			});
			
			$("#afArea").find("td").click(function(){
				var afNo = $(this).parents().children("th").eq(0).children().eq(0).val();
				console.log(afNo);
				location.href="${ contextPath }/selectOneAppFormDcm.ap?afNo=" + afNo;
			});
			if(${requestScope.result} > 0){
				alert("${ requestScope.msg }");
				location.href="${ contextPath }/showFormManagement.ap"
			}
			
			$("#delete").click(function(){
				if(confirm("정말 삭제하시겠습니까?")){
					var afNoArr = new Array();
					$("input[name='check']").each(function(){
						if($(this).is(":checked") == true) {
							afNoArr.push($(this).val());
						}
					});
					console.log(afNoArr);
					
					if(afNoArr.length > 0) {
						$.ajax({
							url:"${contextPath}/deleteAppForm.ap",
							type:"post",
							data:{afNoArr:afNoArr},
							traditional : true,
							success:function(data){
								alert(data);
								window.location.reload(true);
							}
						});
					}else {
						alert("삭제할 문서를 선택해주세요");
					}					
				}else{
					alert("취소되었습니다.");
				}
			});
			
			$(".update").click(function(){
				var choice = $(this).attr("id");
				console.log(choice);
				
				var afNoArr = new Array();
				$("input[name='check']").each(function(){
					if($(this).is(":checked") == true) {
						afNoArr.push($(this).val());
					}
				});
				
				var map = {
						"choice":choice,
						"afNoArr":afNoArr
				}
				
				$.ajax({
					url:"${contextPath}/statusUpdateAppForm.ap",
					data:JSON.stringify(map),
					contentType:"application/json;charset=UTF-8",
					type:"post",
					success:function(data){
						alert(data);
						window.location.reload(true);
					}
				});
				
			});
			
		});
		
	</script>
	
</body>
</html>















