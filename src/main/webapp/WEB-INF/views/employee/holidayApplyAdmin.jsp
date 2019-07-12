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
<style>
	.setting_title{
		position: relative;
    	padding: 20px 25px 0 23px;
    	min-width: 733px;
    	height: 40px;
    	border-bottom: 1px solid #f2f4f3;	
	}
	
	.setting_title h3{
		color: #333;
    	font-size: 16px;
	}
	
	.contentArea{
		display: block;
		position: absolute;
    	left: 250px;
    	top: 0;
    	bottom: 0;
    	right: 0;
    	width: auto;
    	background: #fff;
    	z-index: 110;
	}
	
	

</style>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/employee.jsp"/>
		
		<section class="col-sm-10">
			
			<div class="setting_title">
				<h3>직원 휴가 관리</h3>
			</div>
			
			<div class="content">
				<div class="contentArea">
				
				
				</div>
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>