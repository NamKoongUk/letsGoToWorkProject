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
	.badge{
		background-color:#a1a1a1!important;
	}
</style>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">    
<div class="col-sm-2 sidenav visible-sm visible-md visible-lg">
	<ul>
		<li><button onclick="location.href='${ contextPath }/showWriteForm.ap'">글쓰기</button></li>
		<hr>
		<li>
			<button onclick="myFunction('prograssDcm')" class="accordionBtn">진행중인 문서</button>
				<div id="prograssDcm" class="w3-hide w3-animate-opacity contentSelectArea">
					<ul>
						<li onclick="location.href='${ contextPath }/showAllPrograssDcm.ap'" class="list" id="all">전체문서</li>
						<li onclick="location.href='${ contextPath }/myWriteDcm.ap'" class="list" id="write">기안한 문서</li>
						<li onclick="location.href='${ contextPath }/showWaitDcm.ap'" class="list" id="wait">처리대기</li>
						<li onclick="location.href='${ contextPath }/showIntendedDcm.ap'" class="list" id="intended">처리예정</li>
						<li onclick="location.href='${ contextPath }/showProgressgDcm.ap'" class="list" id="progress">처리 중</li>
						<li onclick="location.href='${ contextPath }/showWaitReceptionDcm.ap'" class="list" id="reception">수신대기문서</li>
						<li onclick="location.href='${ contextPath }/showWaitCirculationDcm.ap'" class="list" id="circle">회람대기문서</li>
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
							<li onclick="location.href='${contextPath}/showApprovalManager.ap'" class="list">결재관리자</li>
							<li onclick="location.href='${contextPath}/showOption.ap'" class="list">기본설정</li>
							<li onclick="location.href='${ contextPath }/showFormManagement.ap'" class="list">양식관리</li>
							<li onclick="location.href='${contextPath}/showAllDcm.ap'" class="list">전체문서</li>
							<li onclick="location.href='${contextPath}/showDeleteDcm.ap'" class="list">삭제문서</li>
						</ul>
					</div>
			</c:if>
			<c:if test="${ sessionScope.loginEmp != null && sessionScope.loginEmp.managerType.equals('결재관리자')}">
				<button style="margin-top:8px;" onclick="myFunction('option')" class="accordionBtn">관리자설정</button>
					<div id="option" class="w3-container w3-hide w3-animate-opacity contentSelectArea">
						<ul>
							<li onclick="location.href='${contextPath}/showApprovalManager.ap'" class="list">결재관리자</li>
							<li onclick="location.href='${contextPath}/showOption.ap'" class="list">기본설정</li>
							<li onclick="location.href='${ contextPath }/showFormManagement.ap'" class="list">양식관리</li>
							<li onclick="location.href='${contextPath}/showAllDcm.ap'" class="list">전체문서</li>
							<li onclick="location.href='${contextPath}/showDeleteDcm.ap'" class="list">삭제문서</li>
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
	
	$(function(){
		var empNo = ${sessionScope.loginEmp.empNo};
		$.ajax({
			url:"${contextPath}/approval/selectDcmCount",
			type:"get",
			data:{empNo:empNo},
			success:function(data){
				
				if(data.all != 0) {
					var $span = $("<span class='badge pull-right badge-pill' style='width:30px; margin-left:-28px; margin-top:17px;'>").append(data.all);
					$("#all").append($span);					
				}
				if(data.wait != 0){
					var $span2 = $("<span class='badge pull-right badge-pill' style='width:30px; margin-left:-28px; margin-top:17px;'>").append(data.wait);
					$("#wait").append($span2);
				}
				if(data.write != 0){
					var $span3 = $("<span class='badge pull-right badge-pill' style='width:30px; margin-left:-28px; margin-top:17px;'>").append(data.write);
					$("#write").append($span3);
				}
				if(data.progress != 0){
					var $span4 = $("<span class='badge pull-right badge-pill' style='width:30px; margin-left:-28px; margin-top:17px;'>").append(data.progress);
					$("#progress").append($span4);
				}
				if(data.intended != 0){
					var $span5 = $("<span class='badge pull-right badge-pill' style='width:30px; margin-left:-28px; margin-top:17px;'>").append(data.intended);
					$("#intended").append($span5);
				}
				if(data.circle != 0){
					var $span6 = $("<span class='badge pull-right badge-pill' style='width:30px; margin-left:-28px; margin-top:17px;'>").append(data.circle);
					$("#circle").append($span6);
				}
				if(data.reception != 0){
					var $span7 = $("<span class='badge pull-right badge-pill' style='width:30px; margin-left:-28px; margin-top:17px;'>").append(data.reception);
					$("#reception").append($span7);
				}

				
			}
		});
	});
	
</script>