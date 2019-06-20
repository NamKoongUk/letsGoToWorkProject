<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LetsGoToWork</title> 
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
  
  <style>
  	.table{font-size:150%; }
  
  	#searcArea{font-size:150%;}
  </style>
  

</head>
<body>
	
	<jsp:include page="../common/menubar.jsp"/>	
	<div class="row wrap">
		
		<jsp:include page="../common/sideMenu/community.jsp"/>
		
		<section class="col-sm-10">
			<h1 class="title">게시판 </h1> 
			
			<div class="content" >
			
				<div id="searcArea" align="center">
			   	<label>검색조건</label>
			   	<select id="searchCondition" name="searchCondition">
			   	   
			   	     <option value="writer">게시판 이름</option>
			   	     <option value="title">게시판 작성자</option>
			   	     <option value="content">게시판 작성일자</option>
			   	
			   	
			   	</select> 
			   	
			   	<input id="searchValue" type="search"/>
			   	
			   	<button onclick=""> 검색하기 </button> 
			   	
			  </div>
						
				
				
			
				
				<div class="container">
		  <table class="table">
			    <thead>
			      <tr>
			        <th>게시판 이름</th>
			        <th>게시판 작성자</th>
			        <th>게시판 작성일자</th>
			      </tr>
			    </thead>
			    <tbody>
				     <tr>
				        <td>교육일정</td>
				        <td>강형석</td>
				        <td>2019-06-20</td>
				      </tr>
				      <tr>
				        <td>공지 사항</td>
				        <td>강형석</td>
				        <td>2019-06-20</td>
				      </tr>
				      <tr>
				        <td>회사내 모임  일정</td>
				        <td>강형석</td>
				        <td>2019-06-20</td>
				      </tr>
				   
				   	 </tbody> 
				 
				  </table>
					
				</div>
			 
			 </div> 
				
		</section>
		
		
	
	
	
	</div> 
	
	
	
	
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>