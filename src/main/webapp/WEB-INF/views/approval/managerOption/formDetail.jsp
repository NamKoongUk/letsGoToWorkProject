<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LetsGoToWork</title>
<style>
	.head{
		background:#e8e8e8;
	}
	td{
		vertical-align:middle !important;
		font-size:7;
	}
</style>
</head>
<body>
	<jsp:include page="../../common/menubar.jsp"/>
	
	<div class="row wrap">
		<jsp:include page="../../common/sideMenu/approval.jsp"/>
		
		<section class="col-sm-10">
			<h3 class="title">상세보기</h3>
			<hr>
			<div class="content">
				<a>양식수정</a> &nbsp;&nbsp; <a>양식삭제</a>
				<br><br>
					<table class="table table-hover table-bordered">
						<tr>
				        <td class="head">양식명</td>
				        <td>
							<p>${ requestScope.form.afName }</p>
						</td>
						<td class="head">약칭</td>
						<td>
							<p>${ requestScope.form.afAlias }</p>
						</td>
				      </tr>
				       <tr>
				        <td class="head">설명</td>
				        <td>
							<p>${ requestScope.form.afComment }</p>
						</td>
						<td class="head">결재양식</td>
						<td>
							<p>${ requestScope.form.signName }</p>
						</td>
				      </tr>
				      <tr>
				        <td class="head">보존기간</td>
				        <td>
							<p>${ requestScope.form.afDate }</p>
						</td>
						<td class="head">보안등급</td>
						<td>
							<p>${ requestScope.form.securityCode }등급</p>
						</td>
				      </tr>
					</table>
					<div id="signFormArea">
						${ requestScope.form.signContent }
					</div>
					
					<div id="area">
						<label>상세 내용</label>
					    <p>${ requestScope.form.afContent }</p>
		 		
					</div>
			</div>
		</section>
	</div>

	<jsp:include page="../../common/footer.jsp" />
</body>
</html>