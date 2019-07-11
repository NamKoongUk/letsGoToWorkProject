<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>LetsGoToWork</title>
<style>
	.boardArea {font-size:150%;}

</style>  
	<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>

</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>	
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/community.jsp"/>
		
		<section class="col-sm-10">
			<h1 class="title">게시판 수정</h1>
			
			<div class="content"> 
				<form action="${ contextPath }/communityUpdate.co" method="post" > 
						<input type="hidden" name="bno" value="${com.bno}">
						<table align="center" class="boardArea" >
					
						<tr> 
						<c:choose>
						  <c:when  test="${com.boardType eq '공지'}">               
							<td>게시판 종류:</td>
							 
							<td >
								&nbsp;<input type="radio" name="boardType" value="공지" checked="checked">공지
								<input type="radio" name="boardType" value="일반">일반
							</td>
						   </c:when> 
						   	
							<c:otherwise>
						   		<td>게시판 종류:</td>
							 
							<td >
								&nbsp;<input type="radio" name="boardType" value="공지">공지
								<input type="radio" name="boardType" value="일반" checked="checked" >일반
							</td>
							</c:otherwise>		   		
						   	
						  
						  
						  
						   </c:choose>                        
						   
						    
						   
							
						
						</tr>
						<tr height=50px;>
							<td>게시판 이름:</td> 
							<td><input type="text" name="boardName" value="${com.boardName}"></td>
						</tr>
						   
						   
							
						   <c:choose>
						   
						   <c:when test="${com.boardAuthority eq 'R'}">
						<tr>
						   <td>게시판 기본 권한:</td>
							
						
							<td>
							&nbsp;<input type="radio" name="boardAuthority" value="R" checked="checked">읽기
								  <input type="radio" name="boardAuthority" value="W">읽기/쓰기
						 	</td>
						</tr>
						 	</c:when>
						
							<c:otherwise>
							<tr>
						    <td>게시판 기본 권한:</td>
						    <td>
						   	&nbsp;<input type="radio" name="boardAuthority" value="R" >읽기
								  <input type="radio" name="boardAuthority" value="W" checked="checked">읽기/쓰기
						    <td>
							</tr> 
							</c:otherwise>
						   
						   
						   </c:choose>  
						  
						
						
					
					</table> 
					<div align="center">
						<button type="submit" id="modity_btn" >수정</button>
						<button type="button" id="delete_btn" onclick="location.href='communityUpdateCencel.co'">수정취소</button>
					
					</div> 
					
							
				
				</form>	
			
			
				
			</div>
		</section>
	</div> 

	
	
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>