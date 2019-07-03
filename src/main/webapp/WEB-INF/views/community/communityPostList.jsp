<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LetsGoToWork</title>
<style > 
	.table{font-size:150%; }


</style>

</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>	
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/community.jsp"/>
		
		<section class="col-sm-10">
			<h1 class="title">게시글</h1> 
			 	
			<div class="content">
			
			
			<table class="table">
				    <thead>
				      <tr>
				        <th>게시글 번호</th>
				        <th>게시글 제목</th>
				        <th>게시글 작성자</th>
				        <th>게시글 작성일자</th>
				      </tr>
				    </thead>
				    
				    <c:forEach var="c" items="${list }">  
				    <tbody>
				     
				      
				      <tr>
				        <td>${c.ord}</td>
				        <td>${c.btitle}</td>
				        <td>${c.createUserName}</td>
						<td>${c.createDate}</td>				        
				      </tr>
				      
				     <!--  <tr>
				        <td>직무 향상 교육</td>
				        <td>강형석</td>
				        <td>2019-06-20</td>
				      </tr> -->
				   
				   	 </tbody>
				   	 </c:forEach> 
				 
				  </table>
				
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
	
	<script>
		$(function(){
			$(".table").find("td").mouseenter(function(){
				$(this).parents("tr").css({"background":"lightblue", "color":"white" ,"cursor":"pointer"});	
			}).mouseout(function(){ 
				$(this).parents("tr").css({"background":"white","color":"black"});	
			}).click(function(){
				var contentNO =$(this).parents().children("td").eq(0).text();
				location.href="communityPostDetails.co?contentNO="+contentNO;
			
			});	
		});
		
	
	</script>
	
</body>
</html>