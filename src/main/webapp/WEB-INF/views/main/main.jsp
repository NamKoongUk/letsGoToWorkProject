<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LetsGoToWork</title>
<link rel="shortcut icon" href="${ contextPath }/resources/images/favicon.ico">
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />
	<!-- sideBar추가자리 -->
	<div class="row wrap">
		<div class="col-sm-2 sidenav visible-sm visible-md visible-lg">
			<ul>
				<li><button>글쓰기</button></li>
				<hr>
				<li><a href="#">Link</a></li>
				<li><a href="#">Link</a></li>
				<li><a href="#">Link</a></li>
				<li><a href="#">Link</a></li>
				<li><a href="#">Link</a></li>
				<li><a href="#">Link</a></li>			
			</ul>
   		</div>
		<section class="col-sm-10">
			<h2 class="title">제목영역입니다.</h2>	
			
			<div class="container-fluid text-center">	  
		 		<div class="content">
					<div class="text-left"> 
		      			<h1 align="center">Welcome</h1>
		    		</div>
				</div>
		    </div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>