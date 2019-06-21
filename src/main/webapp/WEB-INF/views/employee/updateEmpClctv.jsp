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
			<h1 class="title">사용자 일괄 수정</h1>
			<button type="button" class="btn btn-primary" onclick="location.href='showEmpOneRegister.em'">사용자 추가</button>
			<button type="button" class="btn btn-primary" onclick="location.href='showEmpClctvRegister.em'">사용자 일괄 추가</button>
			<button type="button" class="btn btn-primary" onclick="location.href='showUpdateEmpClctv.em'">사용자 일괄 수정</button>
			<hr>
			<div class="content">
					<div style="line-height:2.3em">
						<p>
							오피스에 이미 등록된 사용자 정보를 엑셀 파일(.csv)에서 수정하여 최대 100건까지 일괄 적용할 수 있습니다. <br>
							수정 양식을 다운로드 받아, 수정할 구성원 정보를 편집하세요.   <a id="download">샘플 다운로드</a> <br>
							<br><br><br>
							업로드한 파일과 동일하게 사용자 정보가 업데이트되므로, 변경 사항이 없는 정보 영역을 빈칸으로 남기지 마세요. <br>
							또한, 변경사항이 없는 구성원 행은 삭제하신 후 업로드 하실 것을 권장합니다. <br>
							아이디를 기준으로 사용자 정보가 수정되기 때문에 중복되거나 오피스에 없는 아이디가 포함되지 않았는지 확인 후 업로드하세요.
							
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