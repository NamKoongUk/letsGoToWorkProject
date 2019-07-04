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
			   	   
			   	     <option value="title">게시판 이름</option>
			   	     <option value="writer">게시판 작성자</option>
			   	     <option value="createDate">게시판 작성일자</option>
			   	
			   	
			   	</select> 
			   	
			   	<input id="searchValue" type="search"/>
			   	
			   	<button onclick="searchCommunity();"> 검색하기 </button> 
			   	
			  </div> 
			  
			  <script> 
			  	function searchCommunity() {
			  		var searchCondition = $("#searchCondition").val(); 
			  		var searchValue =$("#searchValue").val();
			  		
			  		location.href = "";
			  	} 
			  
			  
			  
			  </script>
						
				
				
			
				
				<div class="container">
		  <table id="communityList" class="table">
			    <thead>
			      <tr>
			        <th>게시판 번호</th>
			        <th>게시판 종류</th>
			        <th>게시판 이름</th>
			        <th>게시판 작성자</th>
			        <th>게시판 작성일자</th>
			      </tr>
			    </thead>
			    
			      <c:forEach var="b" items="${list }">  
			    <tbody>
				    <!--  <tr>
				        <td><a href="communityPostList.co">교육일정</a></td>
				        <td>강형석</td>
				        <td>2019-06-20</td>
				      </tr> --> 
				      <tr>
				        <td>${b.ord}</td> 
				        <td>${b.boardType }</td>
				        <td>${b.boardName}</td>
				        <td>${b.createUserName}</td>
				        <td>${b.createDate}</td>
				      </tr> 
				      <!-- <tr>
				        <td>회사내 모임  일정</td>
				        <td>강형석</td>
				        <td>2019-06-20</td>
				      </tr> 
				    -->
				   	 </tbody>  
				   	 </c:forEach>  
				 
				  </table>
					
				</div>
			 
			 </div> 
				
		</section>
		
		
	
	
	
	</div> 
	
	
	
	
	
	<jsp:include page="../common/footer.jsp" />
	<script>
		$(function(){
			$("#communityList").find("td").mouseenter(function(){
				$(this).parents("tr").css({"background":"lightblue", "color":"white" ,"cursor":"pointer"});	
			}).mouseout(function(){ 
				$(this).parents("tr").css({"background":"white","color":"black"});	
			}).click(function(){
				var bno =$(this).parents().children("td").eq(0).text();
				console.log(bno);
				location.href="communityPostList.co?bno="+bno;
			
			});	
		});
		
	
	</script>

</body>
</html>