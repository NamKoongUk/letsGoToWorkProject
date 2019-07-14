<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../common/tools.jsp"/>
<link rel="shortcut icon" href="${ contextPath }/resources/images/favicon.ico">
<link rel="stylesheet" href="${ contextPath }/resources/css/messenger/layout.css">
<link href="${ contextPath }/resources/css/datepicker/datepicker.min.css" rel="stylesheet" type="text/css">
<script src="${ contextPath }/resources/js/datepicker/datepicker.min.js"></script>
<script src="${ contextPath }/resources/js/datepicker/i18n/datepicker.en.js"></script>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<title>LetsGoToWork</title>
<style>

body {

    padding-right: 0px !important;

}

</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/messenger.jsp"/>
		
		<section class="col-sm-10 selectArea">
			<h1 class="title">받은 쪽지함</h1>	
			<div class="content">
				<div class="searchArea form-group" style="width:100%; padding:10px; margin-left:20px;">
					<table style="width:95%">
						<tr style="font-size:11px; font-weight:bold">
							<th>
								<label>
									카테고리
								</label>
							</th>
							<th>
								<label>
									검색내용
								</label>
							</th>
							<th>
								<label>
									조회시작일
								</label>
							</th>
							<th>
								<label>
									조회종료일
								</label>
							</th>
							<th>
							</th>
						</tr>
						<tr>
							<td width="10%">
								<select class="searhKind form-control" style="position:relative">
									<option value="none">전체</option>
									<option value="name">쪽지제목</option>
									<option value="writer">작성자</option>
									<option value="content">쪽지내용</option>
								</select>
							</td>
							<td width="35%">
								<input type="text" id="searchValue" name="serarhValue" class="form-control"/>
							</td>
							<td width="20%">
								<input type='text' class='datepicker-here firstDate pick form-control' data-language='en' data-date-format ='yyyy-mm-dd'/>
							</td>
							<td width="20%">
								<input type='text' class='datepicker-here lastDate pick form-control' data-language='en' data-date-format ='yyyy-mm-dd'/>
							</td>
							<td width="20%">
								<button class="searchBtn" style="width:100%">검색</button>
							</td>
						</tr>
					</table>	
				</div>
				<div class="tableArea" align="center">
					<table class="listTable">
						<!-- 가져가서 여기 width로 설정하셔요 -->
						<thead>
							<tr>
								<th width="5%"><input type="checkbox" class="totalCheck"/></th>
								<th width="10%">읽음여부</th>
								<th width="18%" class="sendType">작성자</th>
								<th width="12%">쪽지종류</th>
								<th>쪽지 제목</th>
								<th width="15%">날짜</th>
							</tr>
						</thead>
						<tbody id="messengerArea">
						</tbody>
					</table>
					<br>
					<div class="bottomBtn" align="right">
						<button class="reSendBtn">답장</button>
						<button class="removeBtn">삭제</button>
					</div>
					<div class="paging">
						<ul class="pagination">
							<li><a href="#"><</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">></a></li>
						</ul>
					</div>
				</div>
			</div>
		</section>
		
		<section class="col-sm-10 detailArea" style="display:none">
			<div class="content">
				<table style="width:100%">
						<tr>
							<td>
								<label>제목</label>
								<input class="messengerName" name="messengerName" type="text" style="width:100%; margin-bottom:10px; border:1px solid #cdcdcd"/>
							</td>
						</tr>
						<tr>
							<td>
								<label class="sendType">수신자</label>
								<div id="sendInput" style="width:100%; margin-bottom:10px; height:auto; overflow:auto; border:1px solid #cdcdcd; padding:2px;">
								</div>
							</td>
						</tr>
						<tr>
							<td><label>쪽지내용</label></td>
						</tr>
					</table>			
					<textarea class="messengerContent" name="messengerContent" style="width:100%; height:300px; resize:none"></textarea>
					<div style="text-align:center">
						<button type="button" class="submitBtn">삭제</button>
						<button type="button" class="stoSendBtn">전송</button>
						<button type="button" onclick="changeView('2')">취소</button>
					</div>
				</div>
		</section>
	</div>
	
	
	<jsp:include page="../common/footer.jsp" />
	
	<button type="button" class="btn btn-info btn-lg reSendModal" data-toggle="modal" data-target="#myModal" style="display:none">Open Modal</button>

	  <!-- Modal -->
	  <div class="modal fade" id="myModal" role="dialog">
	    <div class="modal-dialog">
	    
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	        
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">답장</h4>
	        </div>
	        <div class="modal-body">
	        	<table style="width:100%">
	        		<tr>
	        			<td>
	        				<label>수신자</label>
	        			</td>
	        		</tr>
	        		<tr>
	        			<td>
	        				<div class="sendEmp" style="height:30px; border:1px solid lightgray">
	        					수신자
	        				</div>
	        			</td>
	        		</tr>
	        		<tr>
	        			<td>
	        				<label>쪽지내용</label>
	        			</td>
	        		</tr>
	        		<tr>
	        			<td>
	        				<textarea class="sendContent" style="width:100%; height:200px; resize:none"></textarea>
	        			</td>
	        		</tr>
	        	</table>
	        </div>
	          <div class="modal-footer">
	          <button type="button" class="btn btn-default sendBtn" data-dismiss="modal">전송</button>
	          <button type="button" class="btn btn-default modalCancleBtn" data-dismiss="modal">취소</button>
	       	  </div>
	          
	        </div>
	        
	      </div>
	    </div>
	  
	
	<script>
	
	var startDate;
	var endDate;
	
	$(function(){
		setDate(90);

		startDate = $(".firstDate").val().split("-").join("");
		endDate = $(".lastDate").val().split("-").join("");
		resMessenger();
		
	});


	
	//Messenger ajax 호출
	function viewMessage(currentPage,status,startDate,endDate,content,searhCondition){
		startDate = $(".firstDate").val().split("-").join("");
		endDate = $(".lastDate").val().split("-").join("");
		
		if(status == 'res'){
			$(".title").text('받은 쪽지함').attr("id","res");
		}else if(status == 'req'){
			$(".title").text('보낸 쪽지함').attr("id","req");
		}else if(status == 'sto'){
			$(".title").text('임시 저장함').attr("id","sto");
		}else if(status == 'del'){
			$(".title").text('휴지통').attr("id","del");
		}
		
		if(content == "" || content == undefined){
			content = "empty";
		}

		$.ajax({
			url:"messenger/selectMessenger/" + currentPage + "/" + status + "/" 
			+ startDate + "/" + endDate + "/" + ${ sessionScope.loginEmp.empNo } + "/" + content + "/" + $(".searhKind").val(),
			type:"get",
			success: function(data) {
				console.log(data);
				createMessengerTable(data.list);
				createPaging(data.pi);
			},
			error: function(status) {
				console.log("오류");
			}
			
		});
	}
	
	
	
	//date 만듬
	 function createDate(time){
		var date;
		if(time > 0){
			date = new Date(time);
		}else{
			date = new Date();
		}
		
		var month;
		var day;
		if(date.getMonth() < 9){
			month = "0" + (date.getMonth()+1);
		}else{
			month = (date.getMonth()+1);
		}
		
		if(date.getDate() < 9){
			day = "0" + date.getDate();
		}else{
			day = date.getDate();
		}
		
		return date.getFullYear() + "-" + month + "-" + day;
	} 
	
	//Messenger Table 생성
	function createMessengerTable(messengerInfo){
		var $msgTable = $("#messengerArea");
		$msgTable.empty();
		var msgType = $(".title").prop("id");
		if(msgType == 'req'){
			$(".sendType").text('수신자');
		}else if(msgType == 'res'){
			$(".sendType").text('발신자');
		}else if(msgType == 'sto'){
			$(".sendType").text('수신자');
		}else{
			$(".sendType").text('발신자');
		}
		
		
		for(var i=0; i<messengerInfo.length; i++){
			var $msgTr;
			var $checkInput = $("<input type='checkbox'>");
			var $checkTd = $("<td>").append($checkInput);
			var src ='${contextPath}/resources/images/mail/';
			
	
			$msgTr = $("<tr>").attr("id",messengerInfo[i].msgNo);
			
			
			if($(".title").attr("id") == 'res' || $(".title").attr("id") == 'del'){
				$msgTr.attr("class",messengerInfo[i].sender);
			}else{
				$msgTr.attr("class",messengerInfo[i].recipient);
			}
			

			
			
			var $readImg = $("<img>").attr("src",messengerInfo[i].readStatus=='N'?src + 'readMailN.PNG':src + 'readMailY.PNG').css("width","70px");
			var $readTd = $("<td>").append($readImg);
			var $nameTd;
			if($(".title").attr("id") == 'sto'){
				$nameTd = $("<td>").text(messengerInfo[i].empName+" ("+messengerInfo[i].deptName+") "+"- " + messengerInfo[i].jobName + " 외 " + messengerInfo[i].gNum + "명");
			}else{
				$nameTd = $("<td>").text(messengerInfo[i].empName+" ("+messengerInfo[i].deptName+") "+"- " + messengerInfo[i].jobName);				
			}
			var $typeTd = $("<td>").text(msgType=='req'?'보낸쪽지':msgType=='res'?'받은쪽지':msgType=='sto'?'임시저장':'휴지통');
			var $titleTd = $("<td>").text(messengerInfo[i].msgTitle);
			var $sendDateTd = $("<td>").text(createDate(messengerInfo[i].sendDate));
			
			$msgTr.append($checkTd);
			$msgTr.append($readTd);
			$msgTr.append($nameTd);
			$msgTr.append($typeTd);
			$msgTr.append($titleTd);
			$msgTr.append($sendDateTd);
			$msgTable.append($msgTr);
			
			var ee = $msgTr.children().not(':first');
			
			if($(".title").attr("id") == 'res' || $(".title").attr("id") == 'del' || $(".title").attr("id") == 'req'){
				$msgTr.children().not(':first').attr("onclick","detailMessenger(" + messengerInfo[i].msgNo + ")");
			}else{
				$msgTr.children().not(':first').attr("onclick","getStoMsg(" + messengerInfo[i].msgNo + ")");
			}
			
			//$msgTr.children().not(':first').attr("onclick",'detailMessenger()');
		}
	}
	
	//페이징 버튼 생성
	function createPaging(pageInfo){
		
		var $pagination = $(".pagination");
		$pagination.empty();
		
		var currentPage = pageInfo.currentPage;
		var startPage = pageInfo.startPage;
		var endPage = pageInfo.endPage;
		var limit = pageInfo.limit;
		var maxPage = pageInfo.maxPage;
		var messageType = $(".title").prop("id");
		var searchCondition = $(".searhKind").val();
		var searchValue = $("#searchValue").val();
		
			$pagination.append($("<li>").append($("<a>").text("<<")).css("cursor","pointer").click(function(){	
				viewMessage(1,messageType,startDate,endDate,searchValue,searchCondition);
			}));
		   	   
			if(currentPage <= 1) { 
				$pagination.append($("<li>").append($("<a>").text("<")).attr("disabled",true).css("cursor","pointer"));
			}else{ 
				$pagination.append($("<li>").append($("<a>").text("<")).css("cursor","pointer").click(function(){
					viewMessage(currentPage - 1,messageType,startDate,endDate,searchValue,searchCondition);
				}));

			 } 
			 for(var p= startPage; p <= endPage; p++){
				if(p == currentPage){
				$pagination.append($("<li>").append($("<a>").text(p)).attr("disabled",true));
			 }else{ 
				$pagination.append($("<li>").append($("<a>").text(p)).css("cursor","pointer").click(function(){
					viewMessage($(this).children().text(),messageType,startDate,endDate,searchValue,searchCondition);
				}));
			 }
				
			 } 
			 if(currentPage >= maxPage){ 
				 $pagination.append($("<li>").append($("<a>").text(">")).attr("disabled",true).css("cursor","pointer"));					
			 }else {
				 $pagination.append($("<li>").append($("<a>").text(">")).css("cursor","pointer").click(function(){
					 viewMessage(currentPage + 1,messageType,startDate,endDate,searchValue,searchCondition);
				 }));
			 } 
			 	$pagination.append($("<li>").append($("<a>").text(">>")).css("cursor","pointer").click(function(){
			 		viewMessage(endPage,messageType,startDate,endDate,searchValue,searchCondition);
			 	}));
		
	}
	
	//datepicker 초기화
	function setDate(value){
		
		var date = new Date();
		 
		if(value == 7){
			date.setDate(date.getDate() - 7);					
		}else if(value == 30){
			date.setMonth(date.getMonth() - 1);
		}else if(value == 90){
			date.setMonth(date.getMonth() - 3);
		}else if(value == 180){
			date.setMonth(date.getMonth() - 6);
		}
	 
	 var month = getMonth(date.getMonth());
	 
	 $(".firstDate").val(date.getFullYear()+ "-" + month + "-" +  getDate(new Date().getDate()));
	 $(".lastDate").val(new Date().getFullYear()+ "-" + getMonth(new Date().getMonth()) + "-" + getDate(new Date().getDate()));
	}
	
	//월 리턴
	function getMonth(month){
 		 
		 if(month <= 9){
			   month = ('0' + (month+1));
			   
		   }else{
			   month = (month+1);				   
		   }
		 
		 
		 return month;
	 }
	//일 리턴
	function getDate(date){
		 
		if(date <= 9){
			   date = ('0' + (date));
			   
		   }else{
			   date = (date);				   
		   }
		 
		 
		 return date;
	}
	
	$(".searchBtn").click(function(){
		var msgType = $(".title").prop("id");
		var searchCondition = $(".searhKind").val();
		var searchValue = $("#searchValue").val();
		
		viewMessage(1,msgType,startDate,endDate,searchValue,searchCondition);
	});
	
	
	function detailMessenger(msgNo){
		var msgNo = msgNo;
		var messageType = $(".title").prop("id");
		
		$.ajax({
			url:"messenger/selectDetailMessenger/" + msgNo + "/" + messageType + "/" + '${sessionScope.loginEmp.empNo}',
			type:"get",
			success:function(data){
				console.log(data);
				detailView(data,messageType);
			},
			error:function(status){
				
			}
		});	
		
	}	

	function resMessenger(){
		$(".reSendBtn").css("display","inline");
		$(".reSendBtn").text("답장");
		$(".UpdateBtn").css("display","none");
		$(".removeBtn").text("삭제");
		viewMessage(1,'res',startDate,endDate);
		changeView('2');
	}
	function reqMessenger(){
		$(".reSendBtn").css("display","none");
		$(".removeBtn").text("삭제");
		$(".UpdateBtn").css("display","none");
		viewMessage(1,'req',startDate,endDate);	
		changeView('2');
	}
	function stoMessenger(){
		$(".reSendBtn").css("display","inline");
		$(".reSendBtn").css("display","none");
		$(".removeBtn").text("삭제");
		$(".UpdateBtn").css("display","inline");
		$(".stoSendBtn").css("display","inline");
		viewMessage(1,'sto',startDate,endDate);
		changeView('2');
	}
	function delMessenger(){
		$(".removeBtn").text("영구삭제");
		$(".reSendBtn").css("display","none");
		$(".UpdateBtn").css("display","none");
		viewMessage(1,'del',startDate,endDate);
		changeView('2');
	}
	
	function changeView(value){
		if(value=='1'){
			$(".selectArea").hide();
			$(".detailArea").show();
		}else{
			$(".selectArea").show();
			$(".detailArea").hide();
		}
	}
	
	function detailView(messageDetail,messageType){
		
		$("#sendInput").empty();
		
		if(messageType == 'res'){
			$(".sendType").text("발신자");
			$(".stoSendBtn").css("display","none");
		}else if(messageType == 'req'){
			$(".submitBtn").text("삭제").attr("onclick","");
			$(".stoSendBtn").css("display","none");
		}else if(messageType == 'del'){
			$(".submitBtn").text("삭제").attr("onclick","");
			$(".stoSendBtn").css("display","none");
		}else if(messageType == 'sto'){
			$(".submitBtn").text("수정").attr("onclick","");
			$(".stoSendBtn").css("display","inline");
		}
		
		
			$(".messengerName").val(messageDetail.msgTitle).attr("readonly","readonly");
			$("#sendInput").append($("<span>").text(messageDetail.empName+" ("+messageDetail.deptName+") "+"- " + messageDetail.jobName)
							.attr("id",messageDetail.sender).attr("class",messageDetail.msgNo));
			$(".messengerContent").val(messageDetail.msgContent).attr("readonly","readonly");
		
		
		
		if($(".title").prop("id") == 'res'){
			resMessenger();
		}
		
		changeView('1');
	}

	
	//답장 모달
	$(".reSendBtn").click(function(){
		var checked = $("input[type='checkbox']:checked").not(".totalCheck");
		$(".sendEmp").empty();
		
		if($(this).text() == '답장'){
			if(checked.length == 1){
				$(".reSendModal").click();
				$(".sendEmp").text(checked.parent().siblings("td:first").next().text());
				$(".sendEmp").append($("<input type='hidden'>").attr("class","reMsgNo").val(checked.parent().parent().prop("id")));
				$(".sendEmp").append($("<input type='hidden'>").attr("class","reMsgName").val(checked.parent().siblings("td:last").prev().text()));
			}else{
				alert("한 메세지만 선택하세요");
			}
			
		}else if($(this).text() == '전송'){
			
			if(checked.length > 1){
				
			}else{
				confirm("일괄 전송 하시겠습니까?");
			}
			
		}
		
		 
		
	});

	//답장 전송
	function reSendMsg(){
			var msgTitle = "[RE]:" + '${sessionScope.loginEmp.empName}' + '님의 ' + $(".reMsgName").val() + ' 글의 답장';
			var msgContent = $(".sendContent").val();
			var sender = ${sessionScope.loginEmp.empNo};
			var receiper = $("#"+$(".reMsgNo").val()).prop("class");
			var info = {
					'msgTitle':msgTitle,
					'msgContent':msgContent,
					'sender':sender,
					'receiper':receiper
					};
			
			$.ajax({
				url:"messenger/reSendMessenger",
				type:"post",
				contentType: 'application/json',
				data:JSON.stringify(info),
				success:function(data){
					if(data == 'success'){
						reqMessenger();
					}
				}
			});
				
		}
	
	$(".sendBtn").click(function(){
		reSendMsg();
	});
	
	function pageBack(){
		
		if($(".title").attr("id") == 'res'){
			resMessenger();
		}else if($(".title").attr("id") == 'req'){
			reqMessenger();
		}else if($(".title").attr("id") == 'sto'){
			stoMessenger();
		}else if($(".title").attr("id") == 'del'){
			
		}

	}
	
	$(".totalCheck").click(function(){
		if($(this).prop("checked")){
			$("input[type='checkbox']").not(".totalCheck").prop("checked",true);
		}else{
			$("input[type='checkbox']").not(".totalCheck").prop("checked",false);
		}
	});
	
	$(".removeBtn").click(function(){
		
		var msgNos = $("input[type='checkbox']:checked").not(".totalCheck").parent().parent();
		var msgNoList = new Array();
		
		for(var i=0; i<msgNos.length; i++){
			msgNoList.push(msgNos[i].id);
		}
		
		var JSONObject = {
						msgNoList:msgNoList,
						messageType:$(".title").attr("id")
						}
		
		$.ajax({
			url:"messenger/deleteMessenger",
			type:"put",
			contentType: 'application/json; charset=utf-8',
		    data: JSON.stringify(JSONObject),
		    dataType: 'json',
		    success:function(data){
		    	console.log(data);
		    		pageBack();
		    	
		    }
			
		});
		
	});
	
	$(".submitBtn").click(function(){
		if($(this).text() == '수정'){
			updateMessenger();
		}else if($(this).text() == '삭제'){
			var msgNo = $("#sendInput").children("span");
			console.log(msgNo);
			
			var msgNoArr = new Array();
			
			for(var i=0; i< msgNo.length; i++){
				msgNoArr.push(msgNo.eq(i).attr("class"));
			}
			
			
			 var MessengerInfo = {
					 			  msgNoArr:msgNo.eq(0).attr("class"),
					 			  messageType:$(".title").attr("id")
								 }
			 
			 $.ajax({
					url:"messenger/resDelMessenger",
					type:"put",
					contentType: 'application/json; charset=utf-8',
					data:JSON.stringify(MessengerInfo),
					dataType: 'json',
					success:function(data){
						pageBack();
					}
				});
		}
	});
	
	function updateMessenger(){
		
		console.log($("#sendInput").children("span"));
		
		var msgNo = $("#sendInput").children("span");
		var msgNoArr = new Array();
		
		for(var i=0; i<msgNo.length; i++){
			msgNoArr.push(msgNo.eq(i).prop("class"));
		}
		
		
		
		var updateMsgInfo = {
							
							messengerName:$(".messengerName").val(),
							messengerContent:$(".messengerContent").val(),
							msgNoArr:msgNoArr
							}
		
		 $.ajax({
			url:"messenger/updateMessenger",
			type:"put",
			contentType: 'application/json; charset=utf-8',
			data:JSON.stringify(updateMsgInfo),
			dataType: 'json',
			success:function(data){
				stoMessenger();
			}
		}); 
	}
	
	function getStoMsg(msgNo){
		//var checked = $("input[type='checkbox']:checked").not(".totalCheck");
		$(".sendEmp").empty();
			
			$.ajax({
				url:"messenger/getStoDetail/" + msgNo,
				type:"get",
				success:function(data){
					console.log(data);
					StoDetail(data);
					
				},
				error:function(data){
					
				}
				
			});

	}
	
	function StoDetail(stoMessenger){
		console.log(stoMessenger);
		
		$("#sendInput").empty();
		$(".submitBtn").text("수정");
		for(var i=0; i<stoMessenger.length; i++){
			
			$(".messengerName").val(stoMessenger[i].msgTitle).attr("readonly",false);
			$(".messengerContent").val(stoMessenger[i].msgContent).attr("readonly",false);
			
			var $span = $("<span>").mouseenter(function(){
				$(this).children().css("visibility","visible");
			}).mouseleave(function(){
				$(this).children().css("visibility","hidden");
			});
			
			var icon = $('<i class="fas fa-times-circle" style="visibility:hidden; cursor:pointer; color:gray;" onclick="deleteUSer(this)"></i>');
			$("#sendInput").append($span.text(stoMessenger[i].empName+" ("+stoMessenger[i].deptName+") "+"- " + stoMessenger[i].jobName)
					.attr("id",stoMessenger[i].sender).attr("class",stoMessenger[i].msgNo).append(icon));
		}
		changeView('1');
	}
	
	function deleteUSer(icon){
		$(icon).parent().remove();
	};
	
	$(".stoSendBtn").click(function(){
		
		var msgNo = $("#sendInput").children("span");
		var msgNoArr = new Array();
		
		for(var i=0; i<msgNo.length; i++){
			msgNoArr.push(msgNo.eq(i).prop("class"));
		}
		
		var stoSendInfo = {
				
				messengerName:$(".messengerName").val(),
				messengerContent:$(".messengerContent").val(),
				msgNoArr:msgNoArr
				}
		
		$.ajax({
			url:"messenger/stoSendMessenger",
			type:"put",
			contentType: 'application/json; charset=utf-8',
			data:JSON.stringify(stoSendInfo),
			dataType: 'json',
			success:function(data){
				pageBack();
			}
		});
		
	});

	
		
	</script>
</body>
</html>