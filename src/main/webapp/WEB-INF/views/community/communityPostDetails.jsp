<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LetsGoToWork</title>
	<style>
		.content{font-size:150%; }
	
	</style>


</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>	
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/community.jsp"/>
		
		<section class="col-sm-10">
			<h1 class="title"></h1>
			
			<div class="content">
			
					<button type="button" class="btn btn-info btn-lg" onclick="revision();">수정</button>
					<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">삭제</button>
				<div>	
						<table class="table table-striped" border="" >	
								
								<c:forEach var="c" items="${list }">  
								<thead>
									<tr>
										<th colspan="2"><h2>${c.btitle}</h2></th>
			
									</tr>
												  
							  		<tr>
										<td width="10%;">첨부파일: 2019-06-21 안전교육 일정안내서</td>
							  		
			
							  		</tr>
									 
									<tr>
						
										<td height="500px">
												<div style="margin-left:10px; ">
												      ${c.bcontent}
												      
												      </div>
										</td>
					 
				 					</tr> 
											
								</thead>
								</c:forEach>
							 </table>
							
									
							
					 </div>
					 
					 <br>
					 <div >
					 	
					 	<table class="table table-striped"  >
					 	 <thead>
					 		<tr> 
					 			<th>작성자</th>
					 			<th>댓글 내용</th>
					 			<th></th>
					 			<!-- <th></th>  -->	
					 		</tr>  
					 		
					 		
					 		<tr>
					 			<td width=10%>강형석</td>
					 			<td>확인 했습니다.</td>
					 			<td><button type="button" class="btn btn-info btn-lg">확인</button>
					 				<button type="button" class="btn btn-info btn-lg">취소</button>
					 		   </td>
					 			
					 		 
					 	  </tr>
					 </thead>	
				</table>
			  </div>
			  <div class="modal fade" id="myModal" role="dialog">
				   		<div class="modal-dialog">
				    		<div class="modal-content">
						        <div class="modal-header">
						          <button type="button" class="close" data-dismiss="modal">&times;</button>
						          <h4 class="modal-title">게시판 삭제</h4>
						        </div>
						        <div class="modal-body">
						          <p>게시글을 삭제 할까요 ?</p>
						        </div>
						        <div class="modal-footer">
						          <button type="button" class="btn btn-default" data-dismiss="modal">확인</button>
						           <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
								</div>
							</div>
													
						</div>
					</div>
			  	
			  
			   
		   </div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp"/>
	<script> 
			function revision() {
				
				alert("게시글 이 수정 되었습니다.");
			}
			
		
		</script>


</body>
</html>