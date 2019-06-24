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
			<h3 class="title">양식관리</h3>
			<hr>
			<div class="content">
				<a href="${ contextPath }/selectAppForm.ap">양식생성</a> &nbsp;&nbsp;
				<a href="#">제공양식</a><br><br>
				
				<a href="#" id="delete">삭제</a>&nbsp;&nbsp;
				<a href="#">사용전환</a>&nbsp;&nbsp;
				<a href="#">미사용전환</a>
				<table class="table table-hover" id="afArea">
				    <thead>
				      <tr>
				        <th><input type="checkbox" id="check"></th>
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
				<div class="pagingArea" align="center">
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
				</div>
			</div>
		</section>
	</div>
	<jsp:include page="../../common/footer.jsp" />
	
	
	<script>
		$(function(){
			$("#afArea").find("td").click(function(){
				var afNo = $(this).parents().children("td").eq(0).children().eq(0).val();
				console.log(afNo);
				location.href="${ contextPath }/selectOneAppFormDcm.ap?afNo=" + afNo;
			});
			if(${requestScope.result} > 0){
				alert("${ requestScope.msg }");
				location.href="${ contextPath }/showFormManagement.ap"
			}
			
			$("#delete").click(function(){
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
				}
			});
			
		});
	</script>
	
</body>
</html>















