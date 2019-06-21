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
				        <th>게시글 이름</th>
				        <th>게시글 작성자</th>
				        <th>게시글 작성일자</th>
				      </tr>
				    </thead>
				    <tbody>
				     
				      
				      <tr>
				        <td><a href="communityPostDetails.co">안전교육 일정</a></td>
				        <td>강형석</td>
				        <td>2019-06-20</td>
				      </tr>
				      
				      <tr>
				        <td>직무 향상 교육</td>
				        <td>강형석</td>
				        <td>2019-06-20</td>
				      </tr>
				   
				   	 </tbody> 
				 
				  </table>
				
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>