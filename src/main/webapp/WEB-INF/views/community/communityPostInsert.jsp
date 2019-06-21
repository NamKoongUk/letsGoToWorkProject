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
			<h1 class="title">글작성</h1> 
		
			<div class="content">
					<form method="post" action="">
							
						
						<label>&nbsp;게시판 종류 :</label>
								<select >
					   	   
								   	     <option value="">교육 일정</option>
								   	     <option value="">공지 사항</option>
								   	     <option value="">회사 동호회 일정</option>
								   	
					   	
					   			</select>

							<table class="table table-striped" >

								<tbody>
													
	
									<tr>
	
										<td colspan="2"><input type="text" class="form-control" placeholder="글 제목" name="bbsTitle" maxlength="50"/></td>
	
								  </tr> 
								  
								  <tr>
										<th width="10%;">첨부파일:</th>
								  		<td><input type="file" ></td>
	  
								  </tr>
								   		
								  	
								  
	
								   <tr>
			
										<td colspan="2"><textarea class="form-control" placeholder="글 내용" name="bbsContent" maxlength="2048" style="height: 350px;"></textarea></td>
			
								  </tr>
	
								</tbody>

							
							</table>	

							<div align="center">
								<button type="reset">작성취소 </button>
								<button type="submit">작성</button>
							
							</div>

			</form>




			
			
				
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>