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
			
					<span><a>수정</a></span>
					<span><a>삭제</a></span> 
				<div>	
						<table class="table table-striped" border="" >	
								<thead>
									<tr>
										<th colspan="2"><h2>안전 교육일정</h2></th>
			
									</tr>
												  
							  		<tr>
										<td width="10%;">첨부파일: 2019-06-21 안전교육 일정안내서</td>
							  		
			
							  		</tr>
									 
									<tr>
						
										<td height="500px">
												<div style="margin-left:10px; ">
												교육일정: 2019-06-21 PM 12:00  <br>
												교육장소: kh 정보 교육원 </div>
										</td>
					 
				 					</tr> 
											
								</thead>
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
					 			<th></th> 	
					 		</tr>  
					 		
					 		
					 		<tr>
					 			<td width=10%>강형석</td>
					 			<td>확인 했습니다.</td>
					 			<td><a>작성</a></td>
					 			<td><a>취소</a></td>
					 		 
					 		</tr>
					 	</thead>
					 	
					 	</table>
					 
					 
					 </div>
					  	
					 
				
						
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp"/>


</body>
</html>