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
			<h1 class="title">사용자 일괄추가</h1>
			<button type="button" class="btn btn-primary" onclick="location.href='showEmpOneRegister.em'">사용자 추가</button>
			<button type="button" class="btn btn-primary" onclick="location.href='showEmpClctvRegister.em'">사용자 일괄 추가</button>
			<button type="button" class="btn btn-primary" onclick="location.href='showUpdateEmpClctv.em'">사용자 일괄 수정</button>
			<hr>
			<div class="content">
				<div style="line-height:2.3em">
					<p>
						신규 등록할 사용자 정보를 엑셀파일(CSV)로 업로드 하여, 최대 100건까지 일괄 등록할 수 있습니다. <br>
			
						등록 양식 샘플을 다운로드 받아, 신규 구성원 정보를 등록하세요. <a id="download">샘플 다운로드</a> <br>
						
						관리자가 설정한 비밀번호는 임시비밀번호이며, 사용자가 직접 1회 비밀번호를 변경한 후 오피스를 사용할 수 있습니다.
						
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
</body>
</html>