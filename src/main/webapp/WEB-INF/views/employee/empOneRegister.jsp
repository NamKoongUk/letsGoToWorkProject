<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LetsGoToWork</title>
<style>
	#proflieArea{
		float:left;
	}
	.img-button{
		background:url(resources/images/profile/unchecked.png) no-repeat;
		border:none;
		width:32px;
		height:32px;
		cursor:pointer;
	}
	tr{
		height:50px;
	}
	
	.form-control{
		width:20%;
	}
	table{
		font-weight:bold;
	}
	
</style>

</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/employee.jsp"/>
		
		<section class="col-sm-10">
			<h1 class="title">사용자 추가</h1>
			<button type="button" class="btn btn-primary" onclick="location.href='showEmpOneRegister.em'">사용자 추가</button>
			<button type="button" class="btn btn-primary" onclick="location.href='showEmpClctvRegister.em'">사용자 일괄 추가</button>
			<button type="button" class="btn btn-primary" onclick="location.href='showUpdateEmpClctv.em'">사용자 일괄 수정</button>
			<hr>
			<div class="content">
				
				<form>
				<div id="proflieArea">
					<img id="profileIcon" src="${contextPath }/resources/images/profile/users.png" width="150px;" height="150px;">
				</div>
				<div id="cancelBtn">
					<input type="button" class="img-button">
				</div>
					<div id="infoArea" style="margin-left:15%;">
						<table>
							<tr>
								<td width="250px;">이름</td>
								<td><input type="text" class="form-control"></td>
							</tr>
							<tr>
								<td>소속</td>
								<td><input type="text" class="form-control"></td>
							</tr>
							<tr>
								<td>직급</td>
								<td><input type="text" class="form-control"></td>
							</tr>
							<tr>
								<td>사내전화</td>
								<td><input type="text" class="form-control"></td>
							</tr>
							<tr>
								<td>휴대전화</td>
								<td><input type="text" class="form-control"></td>
							</tr>
							<tr>
								<td>이메일</td>
								<td><input type="text" class="form-control"></td>
							</tr>
							<tr>
								<td>사번</td>
								<td><input type="text" class="form-control"></td>
							</tr>
							<tr>
								<td>입사일</td>
								<td><input type="text" class="form-control"></td>
							</tr>
							<tr>
								<td>생년월일</td>
								<td><input type="text" class="form-control"></td>
							</tr>
							<tr>
								<td>자택주소</td>
								<td><input type="text"> <button>우편번호</button></td>
							</tr>
							<tr>
								<td> </td>
								<td><input type="text" class="form-control"></td>
							</tr>
							<tr>
								<td>기타정보</td>
								<td>
									<textarea cols="30" rows="5">
									</textarea>
								
								</td>
							</tr>
							<tr>
								<td>개인정보 공개</td>
								<td><input type="checkbox"></td>
							</tr>
						</table>
					</div>
					<div id="saveArea" style="margin-left:55%;">
						<button type="button" class="btn btn-primary" onclick="location.href=''">저장</button>
					</div>
				</form>
				
				
			</div>
		</section>
	</div>
	<div id="fileArea">
		<input id="file" type="file" name="profile" onchange="loadImg(this,1)">
	</div>
	
	<jsp:include page="../common/footer.jsp" />


<script>
	$(function(){
		$("#fileArea").hide();
			$("#proflieArea").click(function(){
				$("#file").click();
			});
	});
	
	function loadImg(value, num){
		var reader = new FileReader();
		reader.onload=function(e){
			$("#profileIcon").attr("src",e.target.result);
		}
		reader.readAsDataURL(value.files[0]);	
	}
</script>



	
</body>
</html>