<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LetsGoToWork</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/employee.jsp"/>
		
		<section class="col-sm-10">
			<h1 class="title"></h1>
			<hr>
			<div class="content">
				
				<script type="text/javascript">
					var message = '${msg}';
					var returnUrl = '${url}'
					alert(message);
					document.location.href=returnUrl;
				</script>
				
				
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>