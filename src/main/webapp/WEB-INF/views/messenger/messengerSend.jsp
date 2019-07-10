<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="contextPath/resources/images/favicon.ico">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<title>LetsGoToWork</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/messenger.jsp"/>
		
		<section class="col-sm-10">
			<h1 class="title">쪽지보내기</h1>	
			<form id="messengerSendForm" method="post">	
				<div class="content">
					<table style="width:100%">
						<tr>
							<td>
								<label>제목</label>
								<input name="messengerName" type="text" style="width:100%; margin-bottom:10px; border:1px solid #cdcdcd"/>
							</td>
						</tr>
						<tr>
							<td>
								<label>수신자</label>
								<div id="sendInput" style="width:100%; margin-bottom:10px; height:auto; overflow:auto; border:1px solid #cdcdcd; padding:2px;">
									<i class="fas fa-plus plusBtn" style="float:right; margin-top:3px;" onclick="showModal()"></i>
								</div>
							</td>
						</tr>
						<tr>
							<td><label>쪽지내용</label></td>
						</tr>
					</table>			
					<textarea name="messengerContent" style="width:100%; height:300px;"></textarea>
					<input type="hidden" class="sendType" name="sendType">
					<div style="text-align:center">
						<button type="button" onclick="sendMessenger('send')">전송</button>
						<button type="button" onclick="sendMessenger('save')">임시저장</button>
						<button type="button">취소</button>
					</div>
				</div>
				<input type="hidden" name="sender" value="${sessionScope.loginEmp.empNo}">
			</form>	
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
	
	<!-- 모달영역 -->
		  <button type="button" class="btn btn-info btn-lg modalBtn" data-toggle="modal" data-target="#myModal" onclick="selectEmp();" style="display:none">Open Modal</button>
				
			
		        
					<div id="myModal" class="modal fade" role="dialog">
					  <div class="modal-dialog">			
					    <!-- Modal content-->
					    <div class="modal-content" style="width:800px;">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal">&times;</button>
					        <h4 class="modal-title">결재선 설정</h4>
					      </div>
					      <div class="modal-body" style="height:500px; width:100%;">
					      	<div id="deptList" class="treeview col-sm-3" style="overflow:auto; height:450px; border:1px solid black">		      
						      <span id="all" onclick="underEmp(this, event);">전체보기</span>			   
					      	</div>
					      	<div class="col-sm-4 form-group">
					      		<select class="form-control" name="empList" size="10" style="overflow: auto; width:100%; height:450px;" multiple>
					      			
					      		</select>
					      	</div>
					
					      	<!-- 수신자 -->
					      	<div class="col-sm-5 signForm" id="circle">
					      		<div class="row">
						      		<div>
						      			<div class="col-sm-2">
								      		<button class="btn inout" name="inputCircle" type="button">></button>
								      		<button class="btn inout" name="outputCircle" type="button"><</button>
						      			</div>
						      			<div class="col-sm-10">
						      				<label class="col-sm-12">수신자</label>
								      		<select class="form-control list circleList" name="circleList" size="10" style="width:100%; height:420px;" multiple>
								      			
								      		</select>					      			
						      			</div>		      		
						      		</div>						      	
						      	</div>
					      	</div>
					     </div>
						     <div class="modal-footer">
						     	<button type="button" class="btn btn-default addSendUsers" data-dismiss="modal">추가하기</button>
			          			<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
			          			
			       			 </div>
					  </div>
					      	
		        </div>
		        
		      </div>
		      
		
	<!-- 모달 영역 종단 -->	  
	
	<script>
		
	
		//사원조회
		function selectEmp(){
			$(".signArea").children("input[type='hidden']").remove();
			$(".lab").remove();
			
		    /* $(".signForm").find("select").children().remove(); */
			$("#deptList").children().remove();
			$.ajax({
				url:"${contextPath}/approval/selectEmp",
				type:"get",
				success:function(data){
					console.log("성공");
					var $ul = $("<ul style='padding-left:5px;'>");
					
					for(var i = 0; i < data.deptList.length; i++) {
						if(data.deptList[i].topDept == null){
							var $li = $("<li style='list-style:none' class='dept'><span onclick='underEmp(this, event);' id='" + data.deptList[i].deptCode + "'>" + data.deptList[i].deptName + "</span></li>");
							if(data.deptList[i].stat == 'Y') {
								var $img = $("<img id='" + data.deptList[i].deptCode + "' onclick='underDept(this);' style='width:12px; height:12px;' src='${contextPath}/resources/images/approval/plus.gif'>");					
								$li.prepend($img);
							}
							$ul.append($li);
						} 
					}
					$("#deptList").append($ul);
				}
			});
		}
		
		//팀별 조회
		function underDept(img){
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
		
		//팀내 사원 조회
		function underEmp(span, event){
			/* event.stopPropagation(); */
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
							if('${sessionScope.loginEmp.empNo}' != data.empList[i].empNo){
								console.log(data.empList[i].empName);
								var $option = $("<option id='" + data.empList[i].empNo + "' value='" + data.empList[i].empNo + "'>");
								$option.append($("<label>" + data.empList[i].empName + "(" + data.empList[i].deptName + "/ " + data.empList[i].jobName + " )" + "</label>"));
								
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
							if('${sessionScope.loginEmp.empNo}' != data.empList[i].empNo){
								console.log(data.empList[i].empName);
								var $option = $("<option id='" + data.empList[i].empNo + "' value='" + data.empList[i].empNo + "'>");
								$option.append($("<label>" + data.empList[i].empName + "(" + data.empList[i].deptName + "/ " + data.empList[i].jobName + " )" + "</label>"));
								
								$("select[name='empList']").append($option);
								
							}
						} 
						
					}
				});
			}
	
		}
		
		//수신자 영역 추가
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
				if($(this).attr("name") == "inputCircle"){
					var circleList = $(this).parent().parent().find("select[name='circleList']");
					console.log($(this).parent().parent().find("select[name='circleList']"));
					
					for(var i = 0; i < selectEmp.length; i++) {
						
						var emp = $("#" + selectEmp[i]).clone();
						
						console.log("들어는 오냐??");
						circleList.append(emp);
					}
					
				}else if($(this).attr("name") == "outputCircle"){
					var deleteEmp = $("select[name='circleList']").val();
					for(var i = 0; i < deleteEmp.length; i++) {
						$("select[name='circleList']").find("option#" + deleteEmp[i]).remove();
					}
				}
			}else {
				alert("중복된 사용자는 추가할 수 없습니다.");
			}
			
			
			
		});
		
		//수신자 추가
		$(".addSendUsers").click(function(){

			var circleList = $(".circleList").children();
			var checkList = $("#sendInput").children("span");
		
		
			for(var i=0; i<circleList.length; i++){      //들어가려는 사원
				var count = 0; 
				
				for(var j=0; j<checkList.length; j++){   //확인할 사원
					
					if(checkList[j].id == circleList.eq(i).val()){
						count++;
					}
				}
				
				if(count == 0){
					var $span = $("<span>").text(circleList.children().eq(i).text()
							.split("(")[0]).css({"opacity":"0.9","border-radius":"8px","margin-top":"4px"})
							.attr('id',circleList.eq(i).val()).mouseenter(function(){
								$(this).children().css("visibility","visible");
							}).mouseleave(function(){
								$(this).children().css("visibility","hidden");
							});

					var icon = $('<i class="fas fa-times-circle" style="visibility:hidden; cursor:pointer; color:gray;" onclick="deleteUSer(this)"></i>');
					$span.append(icon);
					$span.append($("<input type='hidden' name='sendEmp'>").val(circleList.eq(i).val()));
					$("#sendInput").append($span);
				}		
			}

			
		});	
		
		function showModal(){
			$(".modalBtn").click();
		}
		
		function deleteUSer(icon){
			$(icon).parent().remove();
		};
		
		function sendMessenger(value){
			var $form = $("#messengerSendForm"); 
			$(".sendType").val(value);							
			
			$form.attr("action","${contextPath}/messenger/sendMessenger");
			$form.submit();
		}
		
		
	
	</script>
</body>
</html>