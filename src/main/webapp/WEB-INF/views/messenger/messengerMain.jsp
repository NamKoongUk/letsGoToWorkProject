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
<title>LetsGoToWork</title>
<style>
	
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/messenger.jsp"/>
		
		<section class="col-sm-10">
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
								<th width="5%"><input type="checkbox"/></th>
								<th width="10%">읽음여부</th>
								<th width="18%">작성자</th>
								<th width="12%">쪽지종류</th>
								<th>쪽지 제목</th>
								<th width="15%">날짜</th>
							</tr>
						</thead>
						<tbody id="messengerArea">
							<tr>
								<td><input type="checkbox"/></td>
								<td><img src="${ contextPath }/resources/images/mail/readMailN.PNG" width="70px"></td>
								<td>김채연 사원</td>
								<td>보낸메일</td>
								<td>안녕하세요 임시자료에욧</td>
								<td>2019-01-01</td>
							</tr>
						</tbody>
					</table>
					<br>
					<div class="bottomBtn" align="right"> 
						<button>삭제</button>
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
	</div>
	
	
	<jsp:include page="../common/footer.jsp" />
	
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
			
			if(status == 'res'){
				$(".title").text('받은 쪽지함').attr("id","res");
			}else if(status == 'req'){
				$(".title").text('보낸 쪽지함').attr("id","req");
			}
			
			if(content == ""){
				content = "empty";
			}
	
			$.ajax({
				url:"messenger/selectMessenger/" + currentPage + "/" + status + "/" 
				+ startDate + "/" + endDate + "/" + '${sessionScope.loginEmp.empNo}' + "/" + content + "/" + $(".searhKind").val(),
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
			
			for(var i=0; i<messengerInfo.length; i++){
				var $msgTr;
				var $checkInput = $("<input type='checkbox'>");
				var $checkTd = $("<td>").append($checkInput);
				var src = '${ contextPath }/resources/images/mail/';
				
				if($(".title").prop("id") == 'res'){
					$msgTr = $("<tr>").attr("class",messengerInfo[i].msgGroup);

				}else{
					$msgTr = $("<tr>").attr("class",messengerInfo[i].msgNo);
				}
				
				var $readImg = $("<img>").attr("src",messengerInfo[i].readStatus=='N'?src + 'readMailN.PNG':src + 'readMailY.PNG').css("width","70px");
				var $readTd = $("<td>").append($readImg);
				var $nameTd = $("<td>").text(messengerInfo[i].empName+" ("+messengerInfo[i].deptName+") "+"- " + messengerInfo[i].jobName);
				var $typeTd = $("<td>").text($(".title").prop("id")=='req'?'보낸쪽지':'받은쪽지');
				var $titleTd = $("<td>").text(messengerInfo[i].msgTitle);
				var $sendDateTd = $("<td>").text(createDate(messengerInfo[i].sendDate));
				
				$msgTr.append($checkTd);
				$msgTr.append($readImg);
				$msgTr.append($nameTd);
				$msgTr.append($typeTd);
				$msgTr.append($titleTd);
				$msgTr.append($sendDateTd);
				$msgTable.append($msgTr);
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
						viewMessage(p,messageType,startDate,endDate,searchValue,searchCondition);
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
	 		 
			 if(month < 9){
				   month = ('0' + (month+1));
				   
			   }else{
				   month = (month+1);				   
			   }
			 
			 
			 return month;
		 }
		//일 리턴
		function getDate(date){
			 
			if(date < 9){
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
		

		function resMessenger(){
			viewMessage(1,'res',startDate,endDate);
		}
		function reqMessenger(){
			viewMessage(1,'req',startDate,endDate);		
		}
		function stoMessenger(){
			viewMessage(1,'sto',startDate,endDate);
		}
		function delMessenger(){
			viewMessage(1,'del',startDate,endDate);
		}
		
		
	</script>
</body>
</html>