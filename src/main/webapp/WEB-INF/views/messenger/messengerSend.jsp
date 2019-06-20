<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="contextPath/resources/images/favicon.ico">
<title>LetsGoToWork</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/messenger.jsp"/>
		
		<section class="col-sm-10">
			<h1 class="title">쪽지보내기</h1>	
				
			<div class="content">
				<table style="width:100%">
					<tr>
						<td>
							<label>제목</label>
							<input type="text" style="width:100%; margin-bottom:10px;"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>수신자</label>
							<input type="text" style="width:100%; margin-bottom:10px;"/>
						</td>
					</tr>
					<tr>
						<td><label>쪽지내용</label></td>
					</tr>
				</table>			
				<textarea style="width:100%; height:300px;"></textarea>
				
				<div style="text-align:center">
					<button>전송</button>
					<button>임시저장</button>
					<button>취소</button>
				</div>
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>