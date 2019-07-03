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

</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>	
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/community.jsp"/>
		
		<section class="col-sm-10">
			<h1 class="title">게시판 만들기</h1>
			
			<div class="content"> 
				<form action="communityInsert.co" method="post"> 
					<table align="center" class="boardArea" >
						<tr> 
							<td>게시판 종류:</td>
							<td >
								&nbsp;<input type="radio" name="boardType" value="공지">공지
								<input type="radio" name="boardType" value="일반">일반
							</td>
						
						</tr>
						<tr height=50px;>
							<td>게시판 이름:</td> 
							<td><input type="text" name="boardName"   ></td>
						</tr>
						<tr>
							<td>게시판 기본 권한:</td>
							
							<td>
							&nbsp;<input type="radio" name="boardAuthority" value="R">읽기
								  <input type="radio" name="boardAuthority" value="W">읽기/쓰기
						 	</td>
						</tr>
						  
						<!-- <tr height=50px;>
							<td >게시판 기본 권한: </td> 
							<td >
								&nbsp;<input type="checkbox" name="authority" value="">읽기
								<input type="checkbox" name="authority" value="">읽기/쓰기
							</td>
							 
						</tr>  
						<tr height=50px; >
							<td>사용자 권한: </td>
							<td><input type="text" name=""  id="" ></td> 
							
							<td>&nbsp; <button id="btn" onclick="">추가</button> </td> 
							
						</tr> 
						
 -->						
					
					</table> 
					<div align="center">
						<button type="reset">작성취소 </button>
						<button type="submit" >작성</button>
					
					</div>
							
				
				</form>	
			
			
				
			</div>
		</section>
	</div> 

	
	
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>