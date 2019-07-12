<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="${ contextPath }/resources/images/favicon.ico">
<style>
#mailTable {
	width: 85%;
	border-collapse: collapse;
	border-top: 2px solid black;
	border-bottom: 2px solid black;
	font-size: 1.2em;
}

#mailTable tr {
	border-bottom: 1px solid #ddd;
}

#mailTable tr:nth-child(3) {
	min-height: 200px;
}

#mailTable td, #mailTable th {
	padding: 10px;
	text-align: left;
}

#mailTable th {
	min-width: 25%;
}

#mailTable td {
	min-width: 25%;
}

input[type=file] {
	display: inline-block !important;
	height: 40px !important;
	width: 350px !important;
	margin-bottom: 8px;
}

.fileSize {
	text-align: right;
}

.btnArea {
	margin-top: 30px;
	margin-bottom: 50px;
}

#detailInfoArea h3 {
	max-width: 80%;
	text-align: center;
	margin: 0 auto 20px;;
}

@media screen and (max-width: 1300px) and (min-width: 600px) {
	#mailTable {
		width: 85%;
		border-collapse: collapse;
		border-top: 2px solid black;
		border-bottom: 2px solid black;
		font-size: 1.2em;
	}
	#mailTable tr {
		border-bottom: 1px solid #ddd;
	}
	#mailTable tr:nth-child(3) {
		min-height: 200px;
	}
	#mailTable td{
		padding: 10px;
		text-align: left;
	}
	#mailTable th {
		min-width: 25%;
		padding-left: 10px;
	}
	#mailTable td {
		min-width: 25%;
	}
	input[type=file] {
		display: inline-block !important;
		height: 40px !important;
		width: 350px !important;
		margin-bottom: 8px;
	}
	.fileSize {
		text-align: right;
	}
	.btnArea {
		margin-top: 30px;
		margin-bottom: 50px;
	}
	#detailInfoArea h3 {
		max-width: 80%;
		text-align: center;
		margin: 0 auto 20px;;
	}
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
					<h3 align="center">
						<c:out value="${ mail.mTitle }"/>
						<input type="hidden" name="mailNo" value="${ mail.mailNo }"/>
					</h3>
					<table id="mailTable" align="center">
						<tr>
							<!-- 받은 메일이나 보낸 메일에 따라 다르다. -->
							<c:if test="${ mail.mailType eq '받은메일'}">
								<th width="25%">보낸사람</th>
								<td><c:out value="${ mail.sendMail }"/></td>
								<th>받은날짜</th>
								<td><c:out value="${ mail.sendDate }"/></td>
							</c:if>
							<c:if test="${ mail.mailType eq '보낸메일'}">
								<th>받는사람</th>
								<td><c:out value="${ mail.reciveMail }"/></td>
								<th>보낸날짜</th>
								<td><c:out value="${ mail.sendDate }"/></td>
							</c:if>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td colspan="3">
								첨부파일 이름이 나와야 하는데 아직은 알할거임....
								<span class="fileSize"></span>
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="3" id="contentArea">
								${ mail.mContent }
							</td>
						</tr>
					</table>
				</div>
				<div id="reserveArea">	
					<
				</div>
			</div>
		</section>
	</div>
	<script>
		// 시간남으면 뒤로가기 버튼 클릭시  리다이렉트 시키는 처리하기
	</script>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>