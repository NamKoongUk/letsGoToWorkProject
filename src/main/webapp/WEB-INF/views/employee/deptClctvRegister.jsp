<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LetsGoToWork</title>
<style>
	p{
		font-size:110%;
	}
	#download {
		color:#00BFFF;
	}
	
	.filebox input[type="file"] { 
		position: absolute; 
		width: 1px; 
		height: 1px; 
		padding: 0; 
		margin: -1px; 
		overflow: hidden; 
		clip:rect(0,0,0,0); 
		border: 0; 
		
		}
	.filebox label { 
		display: inline-block; 
		padding: .5em .75em; 
		color: black; 
		font-size: inherit; 
		line-height: normal; 
		vertical-align: middle; 
		background-color: skyblue; 
		cursor: pointer; 
		border: 1px solid #ebebeb; 
		border-bottom-color: #e2e2e2; 
		border-radius: .25em; 
	}
	.filebox .upload-name { 
		display: inline-block; 
		padding: .5em .75em; /* label의 패딩값과 일치 */ 
		font-size: inherit; 
		font-family: inherit; 
		line-height: normal; 
		vertical-align: middle; 
		background-color: #f5f5f5; 
		border: 1px solid #ebebeb; 
		border-bottom-color: #e2e2e2; 
		border-radius: .25em; 
		-webkit-appearance: none; /* 네이티브 외형 감추기 */ 
		-moz-appearance: none; appearance: none; 
	}
	
		

</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/employee.jsp"/>
		
		<section class="col-sm-10">
			<h1 class="title">조직 일괄 등록</h1>
			<hr>
			<div class="content">
				<div style="line-height:2.3em">
					<p>
						파일을 통해 대량의 조직을 일괄 등록할 수 있습니다. <br>
			
						등록 양식을 다운로드 받아, 조직을 일괄 등록하세요. <a id="download">샘플 다운로드</a> <br>
							<br><br><br>
							
							
							조직등록 파일 작성방법<br>
							
							1. 조직명은 (공백이 없는 경우) 한글 17자, 영문 35자까지 입력할 수 있습니다. <br>
							
							2. 5레벨까지 조직을 생성할 수 있으며, 1레벨(회사명) 정보는 입력하지 않습니다.<br>
							
							3. 기존 조직과 중복되는 경우, 해당 행은 등록되지 않습니다.<br>
							
							4. 기존 조직은 그대로 보존되며, 중복되지 않은 조직정보만 업데이트됩니다.<br>
							
							5. 상위 조직이 있는 경우, 상위조직 정보도 모두 입력해야 합니다.<br>
						
					</p>
						<div class="filebox"> 
							<input class="upload-name" value="파일선택" disabled="disabled"> 
							<label for="ex_filename">업로드</label> 
							<input type="file" id="ex_filename" class="upload-hidden"> 
						</div>
				</div>
				
			</div>
		</section>
	</div>
	<jsp:include page="../common/footer.jsp" />
	
	<script>
	$(document).ready(function(){ 
		var fileTarget = $('.filebox .upload-hidden'); 
		
		fileTarget.on('change', function(){ // 값이 변경되면 
			if(window.FileReader){ // modern browser 
			 var filename = $(this)[0].files[0].name; 
		} else { // old IE 
			var filename = $(this).val().split('/').pop().split('\\').pop(); // 파일명만 추출 
		} // 추출한 파일명 삽입
			
	
		$(this).siblings('.upload-name').val(filename); 
			
		}); 
	}); 
	
	
	</script>
	
</body>
</html>