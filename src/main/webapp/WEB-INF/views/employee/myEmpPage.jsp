<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LetsGoToWork</title>
<style>
	td{
		font-size:2em;
	}
	tr{
		height:80px;
	}
	table{
		margin-left:5%;
	}
	#saveArea{
		margin-left:65%;
	}

</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/employee.jsp"/>
		<section class="col-sm-10">
			<h1 class="title">내 정보</h1>
			<hr>
			<div class="content">
				<form>
					<table>
						<tr>
							<td width="250px;">이름</td>
							<td>김규형</td>
						</tr>
						<tr>
							<td>소속</td>
							<td>개발1팀</td>
						</tr>
						<tr>
							<td>직급</td>
							<td>사원</td>
						</tr>
						<tr>
							<td>사내전화</td>
							<td><input type="text"></td>
						</tr>
						<tr>
							<td>휴대전화</td>
							<td><input type="text"></td>
						</tr>
						<tr>
							<td>이메일</td>
							<td><input type="text"></td>
						</tr>
						<tr>
							<td>사번</td>
							<td>kh0302</td>
						</tr>
						<tr>
							<td>입사일</td>
							<td>2019-03-02</td>
						</tr>
						<tr>
							<td>생년월일</td>
							<td>1991-03-02</td>
						</tr>
						<tr>
							<td>자택주소</td>
							<td><input type="text"> <button>우편번호</button></td>
						</tr>
						<tr>
							<td> </td>
							<td><input type="text"></td>
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
					<div id="saveArea">
						<button type="button" class="btn btn-primary" onclick="location.href=''">저장</button>
					</div>
				</form>
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>