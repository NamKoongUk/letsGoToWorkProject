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
			<h1 class="title">게시판  관리</h1> 
			<hr>
			
			<div class="content" >
			
				<!-- <div id="searcArea" align="center">
			   	<label>검색조건</label>
			   	<select id="searchCondition" name="searchCondition">
			   	   
			   	     <option value="writer">게시판 이름</option>
			   	     <option value="title">게시판 작성자</option>
			   	     <option value="content">게시판 작성일자</option>
			   	
			   	
			   	</select> 
			   	
			   	<input id="searchValue" type="search"/>
			   	
			   	<button onclick=""> 검색하기 </button> 
			   	
			  </div> -->
						
				
				
			
				
				<div class="container">
		  <table class="table">
			    <thead>
			      <tr>
			        <th>게시판 이름</th>
			        <th>게시판 작성자</th>
			        <th>게시판 작성일자</th>
			        <th>게시글 게시글수</th>
			        <th>게시글 수정</th> 
			        <th>게시글 삭제</th>
			         
			      </tr>
			    </thead>
			    <tbody>
				     <tr>
				        <td>교육일정</td>
				        <td>강형석</td>
				        <td>2019-06-20</td> 
				        <td>""/10</td>
				        <td><button type="button" class="btn btn-info btn-lg" onclick="revision();">수정</button></td>
				        <td><button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">삭제</button></td>
				      </tr>
				      <tr>
				        <td>공지 사항</td>
				        <td>강형석</td>
				        <td>2019-06-20</td>
				        <td>""/10</td>
				        <td><button type="button" class="btn btn-info btn-lg" onclick="revision();">수정</button></td>
				        <td><button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">삭제</button></td>
				      </tr>
				      <tr>
				        <td>회사내 모임  일정</td>
				        <td>강형석</td>
				        <td>2019-06-20</td>
				        <td>""/10</td>
				      	<td><button type="button" class="btn btn-info btn-lg" onclick="revision();">수정</button></td>
				        <td><button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">삭제</button></td>
				      </tr> 
				   
				   	 </tbody> 
				 
				  </table>
				  
				  <!-- Modal -->
				    <div class="modal fade" id="myModal" role="dialog">
				   		<div class="modal-dialog">
				    		<div class="modal-content">
						        <div class="modal-header">
						          <button type="button" class="close" data-dismiss="modal">&times;</button>
						          <h4 class="modal-title">게시판 삭제</h4>
						        </div>
						        <div class="modal-body">
						          <p>게시판을 삭제 할까요 ?</p>
						        </div>
						        <div class="modal-footer">
						          <button type="button" class="btn btn-default" data-dismiss="modal">확인</button>
						           <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
								</div>
							</div>
													
						</div>
					</div>
							
				</div>
			 
			 </div> 
				
		</section> 
		
		
		<script> 
			function revision() {
				
				alert("수정페이지 로 이동 하겠습니다.");
			}
			
		
		</script>
		
		
	
	
	
	</div> 
	
	
	
	
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>