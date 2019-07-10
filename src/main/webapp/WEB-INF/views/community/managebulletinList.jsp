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
			        <th>게시판 유형</th>
			        <th>게시판 작성자</th>
			        <th>게시판 작성일자</th>
			        <th>게시글 게시글수</th>
			        <th>게시판 수정</th> 
			        <th>게시판 삭제</th>
			         
			      </tr>
			    </thead>
			    
			    	
			    <c:forEach  var="b" items="${requestScope.list }">
			    <tbody>
				      
				      <tr>
				        <td><input type="hidden" name="bno" value="${b.bno }" id="bnohidden"> ${b.boardName}</td>
				        <td>${b.boardType }</td>
				        <td>${b.createUserName }</td>
				        <td>${b.createDate }</td> 
				        <td>${b.postcount}</td>
				      	
				        
											      	
				        <td><button name="updateBtn" type="button" class="btn btn-info btn-lg" >수정</button></td>
				        <td><button type="button" class="btn btn-info btn-lg" name="deleteBtn">삭제</button></td>
				      </tr>
				       
				   	 </tbody>
				   	 
				   	 </c:forEach>
				 
				  </table>
				  
				  <!-- Modal -->
				    <!-- <div class="modal fade" id="myModal" role="dialog">
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
						          <button type="button" class="btn btn-default" data-dismiss="modal" name="deleteBtn">확인</button>
						           <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
								</div>
							</div>
													
						</div>
					</div> -->
							
				</div>
			 
			 </div> 
				
		</section> 
		
		
		<script> 
			$("button[name='updateBtn']").click(function(){
				var bno = $(this).parent().parent().children().eq(0).children().eq(0).val();
		
				console.log(bno);
				/* document.write( typeof bno ); */
				location.href = "communityUpdateForm.co?bno="+bno; 
				
				
				
			}); 
			
			$("button[name='deleteBtn']").click(function(){
				var bno = $(this).parent().parent().children().eq(0).children().eq(0).val();
				console.log(bno);
				
				if(window.confirm("게시판을 삭제 할까요 ?")){
					console.log("삭제할까요");
					location.href = "communityDelete.co?bno="+bno;
					
				}else {
					console.log("삭제하지마세여");
				}
				
				
			});
			
			
			
			
		
/* 			function revision() {
				
				
				var bno = $('input[name=bno]').val();
				alert("수정페이지 로 이동 하겠습니다." );
				
				
				console.log(bno);
			} */
			
		
		</script>
		
		
	
	
	
	</div> 
	
	
	
	
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>