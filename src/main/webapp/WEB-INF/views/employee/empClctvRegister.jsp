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
	.filebox{
		float:left;	
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
						신규 등록할 사용자 정보를 엑셀파일로 업로드 하여, 최대 100건까지 일괄 등록할 수 있습니다. <br>
			
						등록 양식 샘플을 다운로드 받아, 신규 구성원 정보를 등록하세요. <a id="download" href="<c:url value='/empSample.em' />">샘플다운로드</a> <br>
						
						관리자가 설정한 비밀번호는 임시비밀번호이며, 사용자가 직접 1회 비밀번호를 변경한 후 오피스를 사용할 수 있습니다.
						
					</p>
					<form  id="excelUploadForm" name="excelUploadForm" enctype="multipart/form-data"
   						 method="post" action= "empExcelUpload.em">
						<div class="filebox"> 
							<input class="upload-name" type="file" id="excelFile" name="excelFile"> 
						</div>
						<div>
							<button type="submit" id="addExcelImortBtn" class="btn" onclick="check();"><span>추가</span></button> 
						</div>
					</form>
				</div>
				
			</div>
		</section>
	</div>
	<script>
	function checkFileType(filePath) {
	    var fileFormat = filePath.split(".");

	    if (fileFormat.indexOf("xls") > -1 || fileFormat.indexOf("xlsx") > -1) {
	      return true;
	      } else {
	      return false;
	    }
	  }
	
	function check() {

	    var file = $("#excelFile").val();

	    if (file == "" || file == null) {
	    alert("파일을 선택해주세요.");
	    return false;
	    
	    } else if (!checkFileType(file)) {
	    alert("엑셀 파일만 업로드 가능합니다.");

	    return false;
	    }
	
	    
	    
	  }
	</script>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>