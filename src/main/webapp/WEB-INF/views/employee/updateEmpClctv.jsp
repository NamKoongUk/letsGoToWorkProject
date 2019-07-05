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
			<h1 class="title">사용자 일괄 수정</h1>
			<button type="button" class="btn btn-primary" onclick="location.href='showEmpOneRegister.em'">사용자 추가</button>
			<button type="button" class="btn btn-primary" onclick="location.href='showEmpClctvRegister.em'">사용자 일괄 추가</button>
			<button type="button" class="btn btn-primary" onclick="location.href='showUpdateEmpClctv.em'">사용자 일괄 수정</button>
			<hr>
			<div class="content">
					<div style="line-height:2.3em">
						<p>
							오피스에 이미 등록된 사용자 정보를 엑셀 파일에서 수정하여 최대 100건까지 일괄 적용할 수 있습니다. <br>
							수정 양식을 다운로드 받아, 수정할 구성원 정보를 편집하세요. <br>
							수정 사항이 없는 직원은 행을 삭제해 주세요. <a id="download" href="<c:url value='/dbEmpList.em' />">수정양식(직원데이터)</a> <br>
							 (※ 사번, 아이디는 수정할 수 없습니다.) 
							<br>
						</p>
					</div>
							<form  id="excelUploadForm" name="excelUploadForm" enctype="multipart/form-data"method="post" action= "empUpdateExcelUpload.em">
								<div class="filebox"> 
									<input class="upload-name" type="file" id="excelFile" name="excelFile"> 
								</div>
								<div>
									<button type="submit" id="addExcelImortBtn" class="btn" onclick="check();"><span>추가</span></button> 
								</div>
							</form>
				
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
	<script>
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
</body>
</html>














