<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="${ contextPath }/resources/images/favicon.ico">
<style>
	#mailTable{
		width: 80%;
		border-collapse : collapse;
		border-top: 2px solid black;
		border-bottom: 2px solid black;
	}   
	#mailTable tr{
		border-bottom : 1px solid #ddd;
	}
	#mailTable tr:nth-child(3){
		height : 200px;
	}
	#mailTable td{
		padding: 15px;
		text-align: left;
	}
	#mailTable th{
		padding-left : 15px;
	}
	input[type=file]{
		display : inline-block !important;
		height : 40px !important;
		width : 350px !important;
		margin-bottom : 8px;
	}
	.fileSize{
		text-align:right;
	}
	.btnArea{
		margin-top : 30px;
		margin-bottom : 50px;
	}
</style>
<title>LetsGoToWork</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/mail.jsp"/>

		<section class="col-sm-10">
			<br>
			<br>
			<div class="content">
				<div class="btnArea" align="left">
					<button class="btn btn-md">답장</button>
					<button class="btn btn-md">전달</button>
					<button class="btn btn-md">삭제</button>
				</div>
				<div id="detailInfoArea">
					<h3 align="center">메일 제목이 들어가는 곳</h3>
					<table id="mailTable" align="center">
						<tr>
							<!-- 받은 메일이나 보낸 메일에 따라 다르다. -->
							<th>보낸사람 / 받는사람</th>
							<td>김채연 이사</td>
							<th>보낸 날짜 / 받은날짜</th>
							<td>2019-02-01</td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td colspan="3">
								파일 원본이름이름
								<span class="fileSize"></span>
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="3">내용내용</td>
						</tr>
					</table>
				</div>
			</div>
		</section>
	</div>
	<script>
		// 받는 사람 이메일을 추가하는 작업
		$("span.plusEmail").click(function(){
			$(this).parent().append('<br><input type="email" name="email"/><span class="plusEmail">+</span>');
			$(this).remove();
			return;
		});
		
		// 첨부파일 처리
		$("[name=mailAttachment]").change(function(){
			var size = $($(this)[0].files)[0].size;
			console.log("현재 파일의 사이즈는 " + size);
			if(size > 1024 * 1024 * 20){
				alert("이미지 파일의 용량이 너무 큽니다. \n20MB이하의 파일만 첨부해주세요.");
				$(this).val("");
				return;
			}else if(size > 1024 * 1024){
				size = Math.floor((size /(1024 * 1024) * 100)) / 100 + "MB";
				console.log("MB");
				console.log(size);
			}else{
				console.log("KB");
				size = Math.floor(size / (1024) * 100) / 100 + "KB";
				console.log(size);
			}
			$(this).parent().find("span.fileSize").text(size);
		});
	</script>

	<jsp:include page="../common/footer.jsp" />
</body>
</html>