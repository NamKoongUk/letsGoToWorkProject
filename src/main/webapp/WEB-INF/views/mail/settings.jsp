<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="${ contextPath }/resources/images/favicon.ico">
<title>LetsGoToWork</title>
<style>
#buttonArea{
	margin-top : 30px;
}
#buttonArea button{
	padding: 10px 20px;
	margin-right : 20px;
	width: 30%;
	border-radius : 5px;
	font-size : 1.05em;
}
#buttonArea button.seleted, 
#buttonArea button:hover {
	background : black;
	color : white;
	font-weight : bold;
}
#absenceForm{
	
	padding: 5% 10%;
}
.nav{
	padding-left: 5% !important;
}
.nav-tabs{
	align:center;
	text-align:center;
	border-bottom: 3px solid #aaa !important;
}
/* .nav-tabs .active  a{ */
.nav-tabs > li.active > a{
	top: -2px;
	border-top : 3px solid #aaa !important;
	border-left : 3px solid #aaa !important;
	border-right : 3px solid #aaa !important;
	font-weight : bold;
	font-size: 1.2em;
}
.nav-tabs > li.active{
	height : 2em !important;
	border-bottom: 3px solid white !important;
}
.nav-tabs > li{
	text-align:center;
	width: 30%;
}
#absenceTable th{
	font-size : 1em;
	padding: 10px;
}
#absenceTable td > *{
	width: 100%;
} 
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/mail.jsp"/>
		
		<section class="col-sm-10">
			<!-- <h1 class="title" align="center">환경설정</h1> -->
			<br><br>
			<div class="content" style="width:90%; margin: 0 auto" align="center" >
				<div class="navArea" width=" 80% !important">
					<ul class="nav nav-tabs">
						<li class="active"><a data-toggle="tab" href="#absence">부재중 설정</a></li>
						<li><a data-toggle="tab" href="#sign">서명 설정</a></li>
						<li><a data-toggle="tab" href="#officeMail">공용메일 설정</a></li>
					</ul>
				</div>

				<div class="tab-content">
					<div id="absence" class="tab-pane fade in active">
						<form id="absenceForm" action="${ contextPath }/mail/put/absence" method="post">
							<table id="absenceTable" width="90%">
								<tr>
									<th width="25%">부재중 기간</th>
									<td width="35%"><input class="form-control" type="date" name="startDate" /></td>
									<td width="5%" style="text-align:center"><span> ~ </span></td>
									<td width="35%"><input class="form-control" type="date" name="endDate"/></td>
								</tr>
								<tr>
									<th>종류</th>
									<td>
										<input list="absenceType" class="form-control"/>
										<datalist id="absenceType" name="aKind">
											<option value="연차" selected="selected">
											<option value="휴가">
											<option value="출장">
										</datalist>
									</td>
									<td></td><td></td>
								</tr>
								<tr>
									<th>내용</th>
									<td colspan="3"><textarea class="form-control" style="resize:none;" cols="20" rows="5" name="content">내용을 입력해주세요</textarea></td>
								</tr>
							</table>
							<br>
							<button class="btn" onclick="return addAbsence();">부재중 추가하기</button>
						</form><br>
						<div class="listArea" align="center">
							<table class="listTable">
								<tr>
									<th width="30%">부재중 기간</th>
									<th width="15%">종류</th>
									<th>내용</th>
								</tr>
								<tr>
									<td>2019/05/01 - 2019/05/10</td>
									<td>연차</td>
									<td>쉴거야 빼애액</td>
								</tr>
							</table>
						</div>
					</div> <!-- 부재중 설정 -->
					<br><br><br>
					<div id="sign" class="tab-pane fade" align="center">
						<form id="signFrom" action="updateSign.ap"  >
							<table id="signTable">
								<tr><td>
									<img src="${ contextPath }/resources/images/mail/readMailN.PNG" alt="서명이미지 입니다." width="80%" style="border: 1px solid black"/> 
									 </td>
								</tr>
								<tr>
									<td><input type="file"></td>
								</tr>
								<tr></tr>
							</table>
							<br><br><br>
							<button class="btn">서명 수정하기</button>
						</form>
						
					</div>
					<div id="officeMail" class="tab-pane fade">
						<h3>공용메일 설정</h3>
						<!-- 공용메일 설정 폼을 만들고 -->
						<!--  -->
					</div>
				</div>
			</div>
		</section>
	</div>
	<script>
		function addAbsence(){
			var startDate = new Date($("[name=startDate]").val());
			var endDate = new Date($("[name=endDate]").val());
			
			console.log(endDate - startDate);
			
			if((endDate - startDate) > 0){
				return true;
			}else{
				alert("만료날짜가 시작날짜보다 빠를 수 없습니다.");
				return false;
			}
		}
	</script>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>
