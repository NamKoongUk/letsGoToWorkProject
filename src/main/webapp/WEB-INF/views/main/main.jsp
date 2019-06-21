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
	<div class="row wrap">
		<section class="col-sm-12">
			
			<div class="container-fluid text-center">	  
		 		<div class="content" width="100%">
					<div class="text-left"> 
		      			<h1 align="center">Welcome</h1>
		      			<jsp:include page="loginMain.jsp"/>
		    		</div>
				</div>
		    </div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>