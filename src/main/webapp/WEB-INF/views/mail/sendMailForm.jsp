<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="${ contextPath }/resources/images/favicon.ico">
<script type="text/javascript" src="${ contextPath }/resources/ckeditor/ckeditor.js"></script>
<style>
	#mailTable{
		width: 93%;
		border-collapse : collapse;
		border-top: 2px solid black;
		border-bottom: 2px solid black;
	}   
	#mailTable tr{
		border-bottom : 1px solid #ddd;
	}
	#mailTable tr:nth-child(4){
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
	.title{
		font-weight : bold;
	}
	#addressModal .modal-title{
		padding: 5px 15px 3px;
		font-family: 'Do Hyeon', sans-serif;
		font-size : 1.5em;
	}
</style>
<title>LetsGoToWork</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/mail.jsp"/>
		
		<section class="col-sm-10"><br><br>
			<h3 class="title" align="center">메일작성</h3>
			<div class="content">
				<form id="mailForm" action="${ contextPath }/mail/send" method="post" enctype="multipart/form-data">
					<table id="mailTable" align="center">
						<tr>
							<th width="15%">받는사람</th>
							<td>
								<input type="email" name="reciveMail" class="form-control"/>
								<!-- <span class="plusEmail"> + </span> -->
							</td>
							<td width="50px" style="padding: 0; text-align:right">
								<button class="btn btn-md" data-toggle="modal" style="margin-right :15px;"
									data-target="#addressModal" onclick="return selectEmp();">주소록</button>
							</td>
						</tr>
						<tr>
							<th>보내는 사람</th>
							<td colspan="2">
								<input type="email" class="form-control" name="sendMail" value="${ loginEmp.email }" readOnly/>
							</td>
						</tr>
						<tr>
							<th>제목</th>
							<td colspan="2">
								<input type="text" class="form-control" name="mTitle"/>
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="2">
								<textarea name="mContent" id="ckeditor"></textarea>
							</td>
						</tr>
						<tr>	
							<th>첨부파일</th>
							<td colspan="2">
								<div><input type="file" name="mailAttachment" class="form-control"/> 
										<span class="fileSize"></span></div>
							</td>
						</tr>
					</table>
					
				</form>
				<div class="btnArea" align="center">
					<button class="btn btn-md" onclick="submit()">전송</button>
					<button class="btn btn-md">임시보관</button>
					<button class="btn btn-md">취소</button>
				</div>
			</div>
		</section>
	</div>
	
	<!-- 주소록 모달  -->
	<div id="addressModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content" style="width: 800px;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">받는 사람 </h4>
				</div>
				<div class="modal-body" style="height: 500px; width: 96%; margin-left: 2%">
					<!-- 부서명 나오는 곳  -->
					<div id="deptList" class="treeview col-sm-3"
						style="overflow: auto; height: 450px; border: 1px solid black;">
						<span id="all" onclick="underEmp(this, event);">전체보기</span>
					</div>
					<div class="col-sm-4 form-group">
						<select class="form-control" name="empList" size="10"
							style="overflow: auto; width: 100%; height: 450px;" multiple>
						</select>
					</div>
					<div class="col-sm-5">
						<div class="row">
							<div>
								<div class="col-sm-2" style="padding-top: 80px;">
									<button class="btn inout" name="setInputCircle" type="button">
										<b>></b>
									</button><br><br>
									<button class="btn inout" name="setOutputCircle" type="button"><b><</b>
									</button>
								</div>
								<div class="col-sm-10">
									<label class="col-sm-12">보내는 사람</label> 
									<select class="form-control list circleList" name="setEmpList"
										size="10" style="width: 100%; height: 190px;" id="setEmpList" multiple></select> <br>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
				<button type="button" onclick="insertEmailAddress();"
					class="btn btn-primary" data-dismiss="modal">확인</button>
			</div>
		</div>
	</div>
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
			// size = 1000000000000000000000000000000000;
			if(size > 1024 * 1024 * 10){
				alert("이미지 파일의 용량이 너무 큽니다. \n10MB이하의 파일만 첨부해주세요.");
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
		
		// 폼태그 제출 메소드
		function submit(){
			$("#mailForm").submit();
		}
		
		// 에디터 
		$(function(){
	        CKEDITOR.replace( 'ckeditor', { //해당 이름으로 된 textarea에 에디터를 적용
	            width:'100%',
	            height:'300px',
	            filebrowserImageUploadUrl: '${ contextPath }/reources/images', //여기 경로로 파일을 전달하여 업로드 시킨다.
	            defaultLanguage:'kor'
	        });
	         
	        CKEDITOR.on('dialogDefinition', function( ev ){
	            var dialogName = ev.data.name;
	            var dialogDefinition = ev.data.definition;
	          
	            switch (dialogName) {
	                case 'image': 
	                    dialogDefinition.removeContents('Link');
	                    dialogDefinition.removeContents('advanced');
	                    break;
	            }
	        });
	    });
		
		// 주소록 버튼 선택시 -> 최 상위 부서 출력
		function selectEmp(){
			console.log("selectEmp");
			$(".signArea").children("input[type='hidden']").remove();
			$(".lab").remove();
			
			$("#deptList").children().remove();
			$.ajax({
				url:"${contextPath}/approval/selectEmp",
				type:"get",
				success:function(data){
					console.log("성공");
					var $ul = $("<ul style='padding-left:3px;'>");
					
					for(var i = 0; i < data.deptList.length; i++) {
						if(data.deptList[i].topDept == null){
							var $li = $("<li style='list-style:none' class='dept'> <span onclick='underEmp(this, event);' id='" + data.deptList[i].deptCode + "'>" + data.deptList[i].deptName + "</span></li>");
							if(data.deptList[i].stat == 'Y') {
								var $img = $("<img id='" + data.deptList[i].deptCode + "' onclick='underDept(this);' style='width:14px; height:14px;' src='${contextPath}/resources/images/approval/plus.gif'>");					
								$li.prepend($img);
							}
							$ul.append($li);
						} 
					}
					$("#deptList").append($ul);
				}
			});
			return false;
		}
		
		$(".inout").click(function(){
	 		var selectEmp = $("select[name='empList']").val();
	 		console.log($("select[name='empList']").val());
	 		console.log($(this).text());
	 		
	 		var cnt = 0;
	 		if($(this).text() == '>') {
	 			$(this).parent().parent().parent().parent().find("select").find("option").each(function(){
	 				console.log($(this).val());
	 				for(var i = 0; i < selectEmp.length; i++) {
	 					if($(this).val() == selectEmp[i]) {
	 						cnt++;
	 					}
	 				}
	 			});
	 		}
	 		
	 		if(cnt <= 0) {
	 			if($(this).attr("name") == "setInputCircle"){
	 				var setEmpList = $(this).parent().parent().find("select[name='setEmpList']");
	 				console.log($(this).parent().parent().find("select[name='setEmpList']"));
	 				
	 				for(var i = 0; i < selectEmp.length; i++) {
	 					var emp = $("#" + selectEmp[i]).clone();
	 					setEmpList.append(emp);
	 				}
	 				
	 			}else if($(this).attr("name") == "setOutputCircle"){
	 				var deleteEmp = $("select[name='setEmpList']").val();
	 				for(var i = 0; i < deleteEmp.length; i++) {
	 					$("select[name='setEmpList']").find("option#" + deleteEmp[i]).remove();
	 				}
	 			}else if($(this).attr("name") == "readInputCircle"){
	 				var readEmpList = $(this).parent().parent().find("select[name='readEmpList']");
	 				console.log($(this).parent().parent().find("select[name='readEmpList']"));
	 				
	 				for(var i = 0; i < selectEmp.length; i++) {
	 					var emp = $("#" + selectEmp[i]).clone();
	 					readEmpList.append(emp);
	 				}
	 			}else if($(this).attr("name") == "readOutputCircle"){
	 				var deleteEmp = $(this).parent().parent().find("select[name='readEmpList']").val();
	 				for(var i = 0; i < deleteEmp.length; i++) {
	 					$("select[name='readEmpList']").find("option#" + deleteEmp[i]).remove();
	 				}
	 			}
	 		}else {
	 			alert("중복된 사용자는 추가할 수 없습니다.");
	 		}
	 	});
		
		// 하위부서 출력 함수
		function underDept(img){
			console.log("underDept");
			console.log(img.id);
			var deptCode = img.id;
			
			if($("#" + img.id).parent().children().length <= 2) {
				$("#" + img.id).attr("src", "${contextPath}/resources/images/approval/minus.gif");
				$.ajax({
					url:"${contextPath}/approval/selectUnderDept",
					data:{deptCode:deptCode},
					type:"get",
					success:function(data){		
						console.log(data);
						
						var $ul = $("<ul>");
						
						for(var i = 0; i < data.deptList.length; i++) {
							var $li = $("<li style='list-style:none' class='dept'><span onclick='underEmp(this, event);' id='" + data.deptList[i].deptCode + "'>" + data.deptList[i].deptName + "</span></li>");
							if(data.deptList[i].stat == 'Y') {
								var $img = $("<img id='" + data.deptList[i].deptCode + "' onclick='underDept(this);' style='width:12px; height:12px;' src='${contextPath}/resources/images/approval/plus.gif'>");					
								$li.prepend($img);
							}
							$ul.append($li);
						}
						console.log($("#" + img.id).parent());
						$("#" + img.id).parent().append($ul);
					}
				});
				
			}else {
				$("#" + img.id).attr("src", "${contextPath}/resources/images/approval/plus.gif");
				$("#" + img.id).parent().children("ul").remove();
			} 
		}
		
		// 사원 조회
		function underEmp(span, event){
			console.log("underEmp");
			console.log(span.id);
			var deptCode = span.id;
			if(deptCode != 'D') {
				$.ajax({
					url:"${contextPath}/approval/selectUnderDept",
					data:{deptCode:deptCode},
					type:"get",
					success:function(data){		
						console.log(data);
						$("select[name='empList']").children().remove();
						for(var i = 0; i < data.empList.length; i++) {
							if(${sessionScope.loginEmp.empNo} != data.empList[i].empNo){
								console.log(data.empList[i].empName);
								var $option = $("<option id='" + data.empList[i].empNo + "' value='" + data.empList[i].empNo + "'>");
								$option.append($("<label>" + data.empList[i].empName + "(" + data.empList[i].deptName + "/" + data.empList[i].email + ")" + "</label>"));
								
								$("select[name='empList']").append($option);
							}
						}
					}
				});
			}else {
				$.ajax({
					url:"${contextPath}/approval/selectEmp",
					type:"get",
					success:function(data){
						console.log("성공");
						
						for(var i = 0; i < data.empList.length; i++) {
							if(${sessionScope.loginEmp.empNo} != data.empList[i].empNo){
								console.log(data.empList[i].empName);
								var $option = $("<option id='" + data.empList[i].empNo + "' value='" + data.empList[i].empNo + "'>");
								$option.append($("<label>" + data.empList[i].empName + "(" + data.empList[i].deptName + "/" + data.empList[i].email + ")" + "</label>"));
								
								$("select[name='empList']").append($option);
							}
						} 
					}
				});
			}
		}
		
		// 확인버튼 클릭스 -> 주소록에 선택한 사원 추가
		function insertEmailAddress(){
			var inputEmpInfo = $("#setEmpList").children().children().text();
			
			console.log(inputEmpInfo);
			// console.log(inputEmpInfo.lastIndexOf("/"));
			// console.log(inputEmpInfo.lastIndexOf(")"));
			var email = inputEmpInfo.substring(inputEmpInfo.lastIndexOf("/") + 1, inputEmpInfo.lastIndexOf(")"));
			var empName = inputEmpInfo.substring(0, inputEmpInfo.indexOf("()"));
			console.log(empName);
			$("[name=reciveMail]").val(email);
		}
	</script>

	<jsp:include page="../common/footer.jsp" />
</body>
</html>