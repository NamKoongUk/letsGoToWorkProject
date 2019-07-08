<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LetsGoToWork</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
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
		width:10%;
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
		<c:set var = "deptList" value="${hmap.deptList }" />
		<c:set var = "jobList" value="${hmap.jobList }" />
		
		<section class="col-sm-10">
			<h1 class="title">사용자 추가</h1>
			<button type="button" class="btn btn-primary" onclick="location.href='showEmpOneRegister.em'">사용자 추가</button>
			<button type="button" class="btn btn-primary" onclick="location.href='showEmpClctvRegister.em'">사용자 일괄 추가</button>
			<button type="button" class="btn btn-primary" onclick="location.href='showUpdateEmpClctv.em'">사용자 일괄 수정</button>
			<hr>
			<div class="content">
				
				<form  action="insertOneEmpl.em" method="post" enctype="multipart/form-data">
					<div id="proflieArea">
						<img id="profileIcon" src="${contextPath }/resources/images/profile/users.png" width="150px;" height="200px;">
					</div>
					<div id="cancelBtn">
						<input type="button" class="img-button" id="deleteBtn" onclick="deleteImg();">
					</div>
						<div id="infoArea" style="margin-left:15%;">
							<table>
								<tr>
									<td>아이디</td>
									<td><input type="text" class="form-control" name="empId"></td>
								</tr>
								<tr>
									<td>비밀번호</td>
									<td><input type="password" class="form-control" name="empPwd"></td>
								</tr>
								<tr>
									<td width="250px;">이름</td>
									<td><input type="text" class="form-control" name="empName"></td>
								</tr>
								<tr>
									<td>소속</td>
									<td>
										<select name = "deptCode">
							        		<c:forEach var="item" items="${deptList }">
							        			<option value="${item.deptCode }"><c:out value="${item.deptName }"></c:out></option>
							        		</c:forEach>
					        	
					        			</select>
									</td>
								</tr>
								<tr>
									<td>직급</td>
									<td>
										<select name = "jobCode">
											<c:forEach var="item" items="${jobList }">
						        			<option value="${item.jobCode }"><c:out value="${item.jobName }"></c:out></option>
						        			</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<td>사내전화</td>
									<td><input type="text" class="form-control" name="officeTel"></td>
								</tr>
								<tr>
									<td>휴대전화</td>
									<td><input type="text" class="form-control" name="empPhone"></td>
								</tr>
								<tr>
									<td>이메일</td>
									<td><input type="text" class="form-control" name="email"></td>
								</tr>
								<tr>
									<td>입사일</td>
									<td><input type="text" class="form-control" name="enrollDate"></td>
								</tr>
								<tr>
									<td>성별</td>
									<td><input type="radio" name="gender" value="M">남자
										<input type="radio" name="gender" value="F">여자</td>
								</tr>
								<tr>
									<td>생년월일</td>
									<td><input type="text" class="form-control" name="empBirth"></td>
								</tr>
								<tr>
									<td>자택주소</td>
									<td><input type="text" id="sample6_postcode" placeholder="우편번호" name="zipCode"> <input type="button" onclick="setAddress();" value="우편번호"></td>
								</tr>
								<tr>
									<td></td>
									<td><input type="text" id="empAddress1" class="form-control" placeholder="주소" name="address1"><input type="text" id="empAddress2" class="form-control" placeholder="상세주소" name="address2"></td>
									
								</tr>
								<tr>
									<td>기타정보</td>
									<td>
										<textarea cols="30" rows="5" name="otherInfo">
										</textarea>
									</td>
								</tr>
								<tr>
									<td>개인정보 비공개</td>
									<td><input type="checkbox" checked name="personalInfoCheck" value="Y"></td>
								</tr>
							</table>
						</div>
						<div id="saveArea" style="margin-left:55%;">
							<button type="submit" class="btn btn-primary">저장</button>
						</div>
				<div id="fileArea">
					<input id="file" type="file" name="profile" onchange="loadImg(this,1)">
				</div>
				</form>
			</div>
		</section>
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
	
	function deleteImg(){
		$("#deleteBtn").click(function(){
			$("#profileIcon").attr("src","${contextPath }/resources/images/profile/users.png");
			
		});
		
	}
	
	 function setAddress() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var addr = ''; // 주소 변수
	                var extraAddr = ''; // 참고항목 변수

	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }

	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	                if(data.userSelectedType === 'R'){
	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있고, 공동주택일 경우 추가한다.
	                    if(data.buildingName !== '' && data.apartment === 'Y'){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                    if(extraAddr !== ''){
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                    // 조합된 참고항목을 해당 필드에 넣는다.
	                    $("#empAddress1").val(extraAddr)
	                
	                } else {
	                	 $("#empAddress1").val();
	                }

	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                 $("#sample6_postcode").val(data.zonecode);
	                
	                $("#empAddress1").val(addr);
	                // 커서를 상세주소 필드로 이동한다.
	                $("#empAddress2").focus();
	            }
	        }).open();
	    }
</script>



	
</body>
</html>