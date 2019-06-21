<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<style>
	.accordionBtn{
		background:blue !important;
	}
	.accordionBtn:hover{
		background:white !important;
	}
	.list{
		font-size:15px !important;
		cursor:pointer;
	}
</style>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">    
<div class="col-sm-2 sidenav visible-sm visible-md visible-lg">
	<ul>
		<li><button onclick="location.href='${ contextPath }/showWriteForm.ap'">글쓰기</button></li>
		<hr>
		<li>
			<button onclick="myFunction('prograssDcm')" class="accordionBtn">진행중인 문서</button>
				<div id="prograssDcm" class="w3-container w3-hide w3-animate-opacity contentSelectArea">
					<ul>
						<li onclick="location.href='${ contextPath }/showAllPrograssDcm.ap'" class="list">전체문서</li>
						<li onclick="location.href='${ contextPath }/showWaitDcm.ap'" class="list">처리대기</li>
						<li onclick="location.href='${ contextPath }/showIntendedDcm.ap'" class="list">처리예정</li>
						<li onclick="location.href='${ contextPath }/showProgressgDcm.ap'" class="list">처리 중</li>
						<li onclick="location.href='${ contextPath }/showFinishDcm.ap'" class="list">완료문서</li>
						<li onclick="location.href='${ contextPath }/showWaitReceptionDcm.ap'" class="list">수신대기문서</li>
						<li onclick="location.href='${ contextPath }/showWaitCirculationDcm.ap'" class="list">회람대기문서</li>
					</ul>
				</div>
			<button style="margin-top:8px;" onclick="myFunction('finDcm')" class="accordionBtn">완료 문서</button>
				<div id="finDcm" class="w3-container w3-hide w3-animate-opacity contentSelectArea">
					<ul>
						<li onclick="location.href='${ contextPath }/showAllFinishDcm.ap'" class="list">전체문서</li>
						<li onclick="location.href='${ contextPath }/showWriteDcm.ap'" class="list">기안한문서</li>
						<li onclick="location.href='${ contextPath }/showFinApprovaldDcm.ap'" class="list">걸재문서</li>
						<li onclick="location.href='${ contextPath }/showReceptionDcm.ap'" class="list">수신문서</li>
						<li onclick="location.href='${ contextPath }/showCirculationDcm.ap'" class="list">회람/참조 문서</li>
						<li onclick="location.href='${ contextPath }/showRefuseDcm.ap'" class="list">반려문서</li>
						<li onclick="location.href='${ contextPath }/showSaveDcm.ap'" class="list">임시저장문서</li>
					</ul>
				</div>
			<c:if test="${ sessionScope.loginEmp != null && sessionScope.loginEmp.empId.equals('admin')}">
				<button style="margin-top:8px;" onclick="myFunction('option')" class="accordionBtn">관리자설정</button>
					<div id="option" class="w3-container w3-hide w3-animate-opacity contentSelectArea">
						<ul>
							<li onclick="" class="list">결재관리자</li>
							<li onclick="" class="list">기본설정</li>
							<li onclick="location.href='${ contextPath }/showFormManagement.ap'" class="list">양식관리</li>
							<li onclick="" class="list">전체문서</li>
							<li onclick="" class="list">삭제문서</li>
						</ul>
					</div>
			</c:if>
		</li>
	</ul>
</div>
<script>
	function myFunction(id) {
	  var x = document.getElementById(id);
	  if (x.className.indexOf("w3-show") == -1) {
	    x.className += " w3-show";
	  } else { 
	    x.className = x.className.replace(" w3-show", "");
	  }
	}
</script>