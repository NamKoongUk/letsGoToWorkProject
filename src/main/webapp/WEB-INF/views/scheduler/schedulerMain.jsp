<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="${ contextPath }/resources/images/favicon.ico">
<title>LetsGoToWork</title>
<link href='${ contextPath }/resources/schedulerPackages/core/main.css' rel='stylesheet' />
<link href='${ contextPath }/resources/schedulerPackages/daygrid/main.css' rel='stylesheet' />
<link href='${ contextPath }/resources/schedulerPackages/timegrid/main.css' rel='stylesheet' />
<link href='${ contextPath }/resources/schedulerPackages/list/main.css' rel='stylesheet' />
<script src='${ contextPath }/resources/schedulerPackages/core/main.js'></script>
<script src='${ contextPath }/resources/schedulerPackages/moment/main.min.js'></script>
<script src='${ contextPath }/resources/schedulerPackages/interaction/main.js'></script>
<script src='${ contextPath }/resources/schedulerPackages/daygrid/main.js'></script>
<script src='${ contextPath }/resources/schedulerPackages/timegrid/main.js'></script>
<script src='${ contextPath }/resources/schedulerPackages/list/main.js'></script>
<script src="${ contextPath }/resources/schedulerPackages/core/locales-all.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script>
  document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var initialLocaleCode = 'ko';
    
    calendar = new FullCalendar.Calendar(calendarEl, {
      plugins: [ 'interaction', 'dayGrid', 'timeGrid', 'list'],
      header: {
          left: 'prevYear,prev,next,nextYear today',
          center: 'title',
          right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
      },
      defaultDate: new Date,
      locale: initialLocaleCode,
      buttonIcons: false,
      navLinks: true,
      selectable: true,
      businessHours: true,
      editable: true,
      eventLimit: true,
      events: [],
      select: function(info) {
    	  var startDate = info.startStr;
    	  var endDate = new Date(info.endStr);
    	  console.log(endDate);
    	  
    	  endDate.setDate(endDate.getDate() - 1);
    	  
    	  $("#insertScheduleBtn").trigger('click');
    	  $("[name=startDate]").val(startDate);
    	  $("[name=endDate]").val(endDate.format("yyyy-MM-dd"));
      },
      eventClick: function(info) {
    	  console.log("ajax 들어옴!");
          var eventObj = info.event;
          console.log(info.event);
          $("#selectDetailSchedule").trigger('click');
          $.ajax({
        	 url:"selectScheduleDetail.sc",
        	 data:{
        		 scheduleNo:eventObj.id,
        		 schedulerType:eventObj.allow
        	 },
        	 type:"get",
        	 success:function(data){
        		 console.log("ajax 성공 진입!");
        		 console.log(data);
        		 
        		 var startDate = data.startDate.split(" ");
        		 console.log(startDate);
        		 
        		 var endDate = data.endDate.split(" ");
        		 console.log(endDate);
        		 
        		 console.log(data.scheduleNo);
        		 console.log(data.groupList[0]);
        		 if(data.schedulerList[0].schedulerType == "공용" && data.groupList[0].authority == "N"){
        			 $("#dtscBtnArea").hide();
        		 }else{
        			 $("#dtscBtnArea").show();
        		 }
        		 
        		 $("#selectDetailSchedule > input, #selectDetailSchedule > textarea").val("");
        		 $("#dtscNo").val(data.scheduleNo);
        		 $("#dtScrName").val(data.schedulerList[0].schedulerName);
        		 $("#dtScName").val(data.scheduleName);
        		 $("#dtscSD").val(startDate[0]);
        		 $("#dtscST").val(data.startTime);
        		 $("#dtscED").val(endDate[0]);
        		 $("#dtscET").val(data.endTime);
        		 $("#dtscContent").val(data.scheduleContent);
        	 }
          });
          
      },
      eventDrop: function(info) {
    	  /* console.log(info);
      	  console.log(info.event.id);
      	  console.log(info.event.start.toISOString());
      	  console.log(info.event.end.toISOString());
    	  console.log(info.event.end); */
      	  var id = info.event.id;
      	  var start = new Date(info.event.start.toISOString());
      	  var startD = start.format("yyyy-MM-dd");
      	  console.log(startD);
      	  
      	  if(info.event.allDay){
      	    var end = new Date(info.event.end.toISOString());
      	    end.setDate(end.getDate() - 1);
      	    var endD = end.format("yyyy-MM-dd");
      	  }else{
      		var end = new Date(info.event.end.toISOString());
        	var endD = end.format("yyyy-MM-dd");
      	  }
      	  
      	  console.log(endD);
      	  
          if (!confirm("정말로 변경 하시겠습니까?")) {
            info.revert();
          }else{
        	  location.href = '${contextPath}/updateSchedule.sc?scheduleNo=' + id + "&startDate=" + startD
        			  			+ "&endDate=" + endD;
          }
    	  
      },
      eventResize: function(info) {
    	  var id = info.event.id;
    	  var end = new Date(info.event.end.toISOString());
    	  end.setDate(end.getDate() - 1);
    	  var endD = end.format("yyyy-MM-dd");
    	  
    	 if (!confirm("정말로 변경 하시겠습니까?")) {
    	      info.revert();
    	 }else{
    		 location.href = '${contextPath}/updateSchedule.sc?scheduleNo=' + id + "&endDate=" + endD;
    	 }
      }
      
      
      
    });

    calendar.render();
  });
</script>
<style>
  #calendar {
    max-width: 90%;
    margin: 0 auto;
  }
  .fc-sun{
  	color:red;
  }
  .fc-sat{
  	color:blue;
  }
  .label{
  	margin-top : 5px;
  	width : 2.5em;
  	padding: 2px 1px;
  }
  .label span{
  position: relative;
  	left: -3px;
  	display : block;
  	height : 15px !important;
  	width : 15px !important;
  }
  .c1{
  	background:red;
  }
  .c2{
  	background:orange;
  }
  .c3{
  	background:yellow;
  }
  .c4{
  	background:green;
  }
  .c5{
  	background:blue;
  }
  .c6{
  	background:navy;
  }
  .c7{
  	background:purple;
  }
  .on{
  	border: 2px solid blue; 
  }
  .modal-footer{
  	text-align: center !important;
  } 
  .modal-footer button{
  	background:lightgray;
  	border:1px solid black;
  }
  .modal-body td{
  	padding-top:5px;
  }
  .colorSp {
  	position: relative;
  	/* display : inline-block; */
  	left: -5px;
  	bottom : 2px;
  	height : 10px !important;
  	width : 10px !important;
  } 
  .inout {
  	background:black;
  	color:white;
  	
  }
  
  
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/scheduler.jsp"/>
		
		<section class="col-sm-10">
			<div class="content">
				<div id='calendar'></div>
				
				<!-- 개인캘린더 추가 모달 -->
				<div class="modal fade" id="empSchedulerModal" role="dialog">
			    <div class="modal-dialog">
			    
			      <!-- Modal content-->
			      <div class="modal-content">
			        <div class="modal-header">
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			          <h4 class="modal-title" align="center">개인 캘린더 추가</h4>
			        </div>
			        <div class="modal-body">
			          <table>
			          	<tr>
			          		<td width="20%">캘린더 이름</td>
			          		<td width="50%"><input type="text" name="schedulerName"></td>
						</tr>
						<tr>
							<td>색상</td>
							<td>
			          			<div id="empScColor">
									<button type="button" class="label on" name="schedulerColor" value="red"><span class="c1"></span></button>
									<button type="button" class="label" name="cc" value="orange"><span class="c2"></span></button>
									<button type="button" class="label" name="cc" value="yellow"><span class="c3"></span></button>
									<button type="button" class="label" name="cc" value="green"><span class="c4"></span></button>
									<button type="button" class="label" name="cc" value="blue"><span class="c5"></span></button>
									<button type="button" class="label" name="cc" value="navy"><span class="c6"></span></button>
									<button type="button" class="label" name="cc" value="purple"><span class="c7"></span></button>
									<br>
								</div>
			          		</td>
						</tr>
			          </table>
			        </div>
			        
			        <div class="modal-footer">
			          <button type="submit" class="btn" onclick="return createEmpSC()">생성</button>
			          <button type="reset" class="btn" data-dismiss="modal">취소</button>
			        </div>
			      </div>
			    </div>
			  </div>
			  
			  
			  <!-- 개인캘린더 수정 모달 -->
			  <button style="display:none" id="updateScheduler" data-toggle="modal" data-target="#updateEmpScrModal"></button>
				<div class="modal fade" id="updateEmpScrModal" role="dialog">
			    <div class="modal-dialog">
			    
			      <!-- Modal content-->
			      <div class="modal-content">
			        <div class="modal-header">
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			          <h4 class="modal-title" align="center">캘린더 수정</h4>
			        </div>
			        <form action="" method="post" id="udEmpScrF">
				        <div class="modal-body">
				          <table>
				          	<tr>
				          		<td width="20%">캘린더 이름</td>
				          		<td width="50%">
				          			<input type="hidden" name="schedulerNo" id="udscrNo">
				          			<input type="text" name="schedulerName" id="udscrName">
				          		</td>
							</tr>
							<tr>
								<td>색상</td>
								<td>
				          			<div id="udscrColorArea">
										<button type="button" class="label on" name="schedulerColor" value="red" id="udscrColor"><span class="c1"></span></button>
										<button type="button" class="label" name="cc" value="orange"><span class="c2"></span></button>
										<button type="button" class="label" name="cc" value="yellow"><span class="c3"></span></button>
										<button type="button" class="label" name="cc" value="green"><span class="c4"></span></button>
										<button type="button" class="label" name="cc" value="blue"><span class="c5"></span></button>
										<button type="button" class="label" name="cc" value="navy"><span class="c6"></span></button>
										<button type="button" class="label" name="cc" value="purple"><span class="c7"></span></button>
										<br>
									</div>
				          		</td>
							</tr>
				          </table>
				        </div>
				      </form>
			        <div class="modal-footer">
			          <button type="button" class="btn" onclick="updateEmpScr()">수정</button>
			          <button type="button" class="btn" onclick="deleteEmpScr()">삭제</button>
			          <button type="reset" class="btn" data-dismiss="modal">취소</button>
			        </div>
			      </div>
			    </div>
			  </div>
			
			  
			  <!-- 일정추가 모달 -->
			  <form action="${contextPath}/insertSchedule.sc" method="post" id="insertSchedule">
				<div class="modal fade" id="insertScheduleModal" role="dialog">
			    <div class="modal-dialog">
			    
			      <!-- Modal content-->
			      <div class="modal-content">
			        <div class="modal-header">
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			          <h4 class="modal-title" align="center"><b>일정 추가</b></h4>
			        </div>
			        
			        <div class="modal-body">
			          <table>
			          	<tr>
			          		<td width="20%"><b>캘린더</b></td>
			          		<td colspan="2" width="70%">
			          			<select name="schedulerNo" id="ismSelect">
			          				
			          			</select>
			          		</td>
						</tr>
						<tr>
							<td><b>일정명</b></td>
							<td colspan="2"><input type="text" name="scheduleName"></td>
						</tr>
						<tr>
							<td><b>시작</b></td>
							<td>
								<input type="date" name="startDate" id="isSCstartDate"> &nbsp;&nbsp;
								<input type="time" name="startTime" id="isSCstartTime">
							</td>
							<td width="20%">
								<input type="checkbox" id="allDateBtn"> 종일
							</td>
							
						</tr>
						<tr>
							<td><b>종료</b></td>
							<td colspan="3">
								<input type="date" name="endDate" id="isSCendDate"> &nbsp;&nbsp;
								<input type="time" name="endTime" id="isSCendTime">
							</td>
						</tr>
						<tr>
							<td colspan="3"><b>내용</b></td>
						</tr>
						<tr>
							<td colspan="3">
								<textarea cols="70%" rows="10" style="resize: none;" name="scheduleContent"></textarea>
							</td>
						</tr>
			          </table>
			        </div>
			        
			        <div class="modal-footer">
			          <button type="button" class="btn" onclick="return insertSchedule()">생성</button>
			          <button type="reset" class="btn" data-dismiss="modal">취소</button>
			        </div>
			        
			      </div>
			    </div>
			  </div>
			  </form>
			  
			  <!-- 일정 상세보기 모달 -->
			  <button style="display:none" id="selectDetailSchedule" data-toggle="modal" data-target="#detailScheduleModal"></button>
			  <form action="${ contextPath }/deleteSchedule.sc" method="post" id="dtscForm">
				<div class="modal fade" id="detailScheduleModal" role="dialog">
			    <div class="modal-dialog">
			    
			      <!-- Modal content-->
			      <div class="modal-content">
			        <div class="modal-header">
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			          <h4 class="modal-title" align="center" id="dtscTitle"><b>일정 상세보기</b></h4>
			          <h4 class="modal-title" align="center" id="udscTitle" style="display:none"><b>일정 수정</b></h4>
			        </div>
			        
			        <div class="modal-body">
			          <table>
			          	<tr>
			          		<td width="20%"><b>캘린더</b></td>
			          		<td>
			          			<input type="hidden" name="scheduleNo" id="dtscNo">
			          			<input type="text" name="schedulerName" id="dtScrName" readonly>
			          		</td>
						</tr>
						<tr>
							<td><b>일정명</b></td>
							<td colspan="2"><input class="dtscIp" type="text" name="scheduleName" id="dtScName" readonly></td>
						</tr>
						<tr>
							<td><b>시작</b></td>
							<td>
								<input class="dtscIp" type="date" name="startDate" id="dtscSD" readonly> &nbsp;&nbsp;
								<input class="dtscIp" type="time" name="startTime" id="dtscST" readonly>
							</td>
						</tr>
						<tr>
							<td><b>종료</b></td>
							<td colspan="3">
								<input class="dtscIp" type="date" name="endDate" id="dtscED" readonly> &nbsp;&nbsp;
								<input class="dtscIp" type="time" name="endTime" id="dtscET" readonly>
							</td>
						</tr>
						<tr>
							<td colspan="3"><b>내용</b></td>
						</tr>
						<tr>
							<td colspan="3">
								<textarea class="dtscIp" cols="70%" rows="10" style="resize: none;" name="scheduleContent" id="dtscContent" readonly></textarea>
							</td>
						</tr>
			          </table>
			        </div>
			        
			        <div class="modal-footer" id="dtscBtnArea">
			          <button type="button" class="btn dtscBtn" onclick="updateSchedule()">수정</button>
			          <button type="submit" class="btn dtscBtn">삭제</button>
			          <button type="button" class="btn udscBtn" style="display:none" onclick="return complateUdSchedule()">완료</button>
			          <button type="reset" class="btn udscBtn" style="display:none" data-dismiss="modal" onclick="changeDtscF()">취소</button>
			        </div>
			        
			      </div>
			    </div>
			  </div>
			  </form>
			  
			  <!-- 그룹캘린더 추가 모달 -->
			  <form class="form-horizontal" role="form" id="editorForm" method="post" action="/">
					<div id="createGroupScr" class="modal fade" role="dialog">
					  <div class="modal-dialog">			
					    <!-- Modal content-->
					    <div class="modal-content" style="width:800px;">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal">&times;</button>
					        <h4 class="modal-title">그룹캘린더 생성</h4>
					      </div>
					      <div class="modal-body" style="height:580px; width:100%;">
					      <div>
				          <table>
				          	<tr>
				          		<td width="20%"><b>공유캘린더 이름</b></td>
				          		<td width="50%">
				          			<input type="hidden" name="schedulerNo" id="inGscrNo">
				          			<input type="text" name="schedulerName" id="inGscrName">
				          		</td>
							</tr>
							<tr>
								<td><b>색상</b></td>
								<td>
				          			<div id="inGscrColorArea">
										<button type="button" class="label on" name="schedulerColor" value="red" id="udscrColor"><span class="c1"></span></button>
										<button type="button" class="label" name="cc" value="orange"><span class="c2"></span></button>
										<button type="button" class="label" name="cc" value="yellow"><span class="c3"></span></button>
										<button type="button" class="label" name="cc" value="green"><span class="c4"></span></button>
										<button type="button" class="label" name="cc" value="blue"><span class="c5"></span></button>
										<button type="button" class="label" name="cc" value="navy"><span class="c6"></span></button>
										<button type="button" class="label" name="cc" value="purple"><span class="c7"></span></button>
										<br>
									</div>
				          		</td>
							</tr>
							<tr>
								<td><b>주소록</b></td>
							</tr>
				          </table>
				        </div>
					      	<div id="deptList" class="treeview col-sm-3" style="height:450px; border:1px solid black">		      
						      <span id="all" onclick="underEmp(this, event);">전체보기</span>			   
					      	</div>
					      	<div class="col-sm-4 form-group">
					      		<select class="form-control" name="empList" size="10" style="overflow: auto; width:100%; height:450px;" multiple>
					      			
					      		</select>
					      	</div>
					      	<div class="col-sm-5 signForm" id="circle">
					      		<div class="row">
						      		<div>
						      			<div class="col-sm-2" style="padding-top:80px;">
								      		<button class="btn inout" name="setInputCircle" type="button"><b>></b></button>
								      		<br><br>
								      		<button class="btn inout" name="setOutputCircle" type="button"><b><</b></button>
						      			</div>
						      			<div class="col-sm-10">
						      				<label class="col-sm-12">수정권한</label>
								      		<select class="form-control list circleList" name="setEmpList" size="10" style="width:100%; height:190px;" id="setEmpList" multiple>
								      			
								      		</select>
								      		<br>			      			
						      			</div>
						      		</div>
						      		
						      		<div>
						      			<div class="col-sm-2" style="padding-top:80px;">
								      		<button class="btn inout" name="readInputCircle" type="button"><b>></b></button>
								      		<br><br>
								      		<button class="btn inout" name="readOutputCircle" type="button"><b><</b></button>
						      			</div>
						      			<div class="col-sm-10">
								      		<label class="col-sm-12">읽기권한</label>
								      		<select class="form-control list circleList" name="readEmpList" size="10" style="width:100%; height:190px;" id="readEmpList" multiple>
								      			
								      		</select>				      			
						      			</div>
						      		</div>
						      	</div>
					      	</div>
					     </div>
					     <div class="modal-footer">
					     	<button type="button" onclick="insertGscr();" class="btn btn-primary" data-dismiss="modal">확인</button>
					        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					      </div>
					  </div>
				   </div>
				</div>
			  </form>
			  
			</div>
		</section>
	</div>
	
	
	
	<jsp:include page="../common/footer.jsp" />
	
	
	
	<script>
		$(".label").click(function(){
			$(".label").removeClass("on");
			$(this).addClass("on");
			$(this).siblings().attr("name", "cc");
			$(this).attr("name","schedulerColor");
			$(this).siblings().removeAttr("id");
			$(this).attr("id", "udscrColor");
			
			console.log($(this).attr("name"));
			console.log($(this).val());
		});
		
		function resetColorBtn(){
			$(".label").removeClass("on");
      		$(".label").removeAttr("id");
      		$(".label").attr("name", "cc");
      		
      		$(".label").eq(0).addClass("on");
      		$(".label").eq(0).attr("name", "schedulerColor");
      		$(".label").eq(0).attr("id", "udscrColor");
		};
		
		function createEmpSC(){
      		console.log($(".label").eq(0));
      		var colorVal = $("[name=schedulerColor]").val();
      		var nameVal = $("[name=schedulerName]").val();
      		
      		
      		console.log($("[name=schedulerName]").val());
      		console.log($("[name=schedulerColor]").val());
      		
      		if($("[name=schedulerName]").val() == ""){
      			alert("캘린더 이름을 입력해주세요!");
      			return false;
      		}else{
      			location.href="${ contextPath }/insertMemberScheduler.sc?schedulerName=" + nameVal 
					+ "&schedulerColor=" + colorVal;
      		}
      	};
      	
      	function selectSchedulerList(){
      		console.log("실행되는지");
      		$.ajax({
      		    url:"${contextPath}/selectSchedulerList.sc",
      		    type:"post",
      			success:function(data){
      				console.log("에이작스 성공까지 들어옴");
      				var $selectArea = $("#ismSelect");
      				$("#ismSelect > option").remove();
      				console.log(data);
      				console.log(data[0].schedulerNo);
      				for(var key in data){
      					var $option = $("<option id='tagOption' value='" + data[key].schedulerNo +  "' name='schedulerNo'>").text(data[key].schedulerName);
      					$selectArea.append($option);
      				}
      			}
      		});
      	};
      	
      	function insertSchedule(){
      		var startTime = $("#isSCstartTime").val();
      		var endTime = $("#isSCendTime").val();
      		var startDate = $("#isSCstartDate").val();
      		var endDate = $("#isSCendDate").val();
      		
      		if(startDate > endDate){
      			alert("날짜 설정이 잘못되었습니다.");
      			return false;
      		}
      		
      		if((startTime == "" && !(endTime == "")) || (startDate == endDate && endTime < startTime)){
      			alert("시간 설정이 잘못되었습니다.");
      			return false;
      		}
      		
      		$("#insertSchedule").submit();    	
      	}
      	
      	function updateSchedule(){
      		$("#dtscTitle").hide();
      		$("#udscTitle").show();
      		$(".dtscBtn").hide();
      		$(".udscBtn").show();
      		$(".dtscIp").removeAttr("readonly");
      		$("#dtscForm").attr("action","${ contextPath }/updateSchedule.sc");
      	};
      	
      	function changeDtscF(){
      		$("#dtscTitle").show();
      		$("#udscTitle").hide();
      		$(".dtscBtn").show();
      		$(".udscBtn").hide();
      		$(".dtscIp").prop("readonly",true);
      		$("#dtscForm").attr("action","${ contextPath }/deleteSchedule.sc");
      	};
      	
      	function complateUdSchedule(){
      		var startTime = $("#dtscST").val();
      		var endTime = $("#dtscET").val();
      		var startDate = $("#dtscSD").val();
      		var endDate = $("#dtscED").val();
      		
      		if(startDate > endDate){
      			alert("날짜 설정이 잘못되었습니다.");
      			return false;
      		}
      		
      		if((startTime == "" && !(endTime == "")) || (startDate == endDate && endTime < startTime)){
      			alert("시간 설정이 잘못되었습니다.");
      			return false;
      		}
      		
      		$("#dtscForm").submit(); 
      	}
      	
      	
      	$("#allDateBtn").click(function(){
			var check = $(this).is(":checked");
			if(check){
				$("#isSCstartTime").attr("disabled","disabled");
				$("#isSCendTime").attr("disabled","disabled");
			}else{
				$("#isSCstartTime").removeAttr("disabled");
				$("#isSCendTime").removeAttr("disabled");
			}
      	});
      	
      	
      	
      	$(function(){
      		console.log("온로드 펑션입니다.");
      		$.ajax({
      			url:"allSelectSchedule/sc",
      			type:"get",
      			success:function(data){
      				console.log(data.empScList);
      				console.log(data.gpScList);
      				console.log(data.scList);
      				$("#empScheduler > tbody > tr").remove();
  					var $empScheduler = $("#empScheduler");
  					
  					$("#groupScheduler > tbody > tr").remove();
  					var $groupScheduler = $("#groupScheduler");
  	
      				for(var key in data.empScList){
      					var $empTr = $("<tr id='empTr'>");
      					var $colTd = $("<td colspan='2'>");
      					var $hiddenNo = $("<input type='hidden' value='" + data.empScList[key].schedulerNo + "' class='hiddenNo'>");
      					var $colBtn = $("<button style='width:5px; height:16px;' class='colorBtn'>");
      					console.log(data.empScList[key].status == 'Y');
      					if(data.empScList[key].status == 'Y'){
      						var $colSp = $("<span style='background:" + data.empScList[key].schedulerColor + "; display:inline-block !important;' class='colorSp'>");
      					}else{
	      					var $colSp = $("<span style='background:" + data.empScList[key].schedulerColor + "; display:none !important;' class='colorSp'>");      						
      					}
      					      					
      					var $nameSp = $("<span style='margin-left:5px;' class='empScName'>").text(data.empScList[key].schedulerName);
      					
      					var $settingTd = $("<td align='center'>");
      					var $settingIm = $("<img src='${contextPath}/resources/images/scheduler/settings.png'" + 
      										"style='width:16px; height:16px;' class='empScSetting'>");
      					
      					$colBtn.append($colSp);
      					$colTd.append($hiddenNo);
      					$colTd.append($colBtn);
      					$colTd.append($nameSp);
      					$empTr.append($colTd);
      					
      					$settingTd.append($settingIm);
      					$empTr.append($settingTd);
    					
      					$empScheduler.append($empTr);
      				}
      				
      				for(var key in data.gpScList){
      					var $gmTr = $("<tr>");
      					var $colTd = $("<td colspan='2'>");
      					var $hiddenNo = $("<input type='hidden' value='" + data.gpScList[key].schedulerNo + "' class='hiddenNo'>");
      					var $colBtn = $("<button style='width:5px; height:16px;' class='gScrColorBtn'>");
      					console.log(data.gpScList[key].status == 'Y');
      					
      					console.log(data.gpScList[key].groupList[0].gmStatus);
      					if(data.gpScList[key].groupList[0].gmStatus == 'Y'){
      						var $colSp = $("<span style='background:" + data.gpScList[key].schedulerColor + "; display:inline-block !important;' class='colorSp'>");
      					}else{
	      					var $colSp = $("<span style='background:" + data.gpScList[key].schedulerColor + "; display:none !important;' class='colorSp'>");      						
      					}
      					      					
      					var $nameSp = $("<span style='margin-left:5px;' classs='gpScName'>").text(data.gpScList[key].schedulerName);
      					
      					$colBtn.append($colSp);
      					$colTd.append($hiddenNo);
      					$colTd.append($colBtn);
      					$colTd.append($nameSp);
      					$gmTr.append($colTd);
      					
      					if(data.gpScList[key].groupList[0].authority == 'Y'){
      						var $settingTd = $("<td align='center'>");
          					var $settingIm = $("<img src='${contextPath}/resources/images/scheduler/settings.png'" + 
          										"style='width:16px; height:16px;'>");
          					$settingTd.append($settingIm);
          					$gmTr.append($settingTd);
      					}
      					
      					$groupScheduler.append($gmTr);
      				}
      				
      				for(var key in data.scList){
      					var id = data.scList[key].scheduleNo;
      					console.log(data.scList[key].schedulerList[0].schedulerType);
      					if(data.scList[key].schedulerList[0].schedulerType == "개인"){
      						var title = data.scList[key].scheduleName;
      					}else{
      						var title = "[GS] " + data.scList[key].scheduleName;
      					}
      					var startD = data.scList[key].startDate.split(" ");
      					var endD = data.scList[key].endDate.split(" ");
      					var color = data.scList[key].schedulerList[0].schedulerColor;
      					console.log(startD);
      					var startT = data.scList[key].startTime;
      					var endT = data.scList[key].endTime;
      					var type = data.scList[key].schedulerList[0].schedulerType;
      					console.log(type);
      					var endDate = new Date(endD[0]);
      					
      					if(data.scList[key].schedulerList[0].schedulerType == "공용" && 
      							data.scList[key].groupList[0].gmStatus == "N"){
      						
      					}else{
      						if(startT == null){
	      						endDate.setDate(endDate.getDate() + 1);
	      						var event = {
	          							id:id,
	          							title:title,
	          							start:startD[0],
	          							end:endDate.format("yyyy-MM-dd"),
	          							color:color,
	          							allow:type
	          					}
	      					}else{
	      						endDate.setDate(endDate.getDate());
	      						var event = {
	          							id:id,
	          							title:title,
	          							start:startD[0] + "T" + startT,
	          							end:endDate.format("yyyy-MM-dd") + "T" + endT,
	          							color:color,
	          							allow:type
	          					}
	      					}
      						
      						console.log(event);
          					calendar.addEvent(event);
      					}
      					
      					
      				}
      				
      				
      			}
      		});
      	});
      	
      	$(document).on("click", ".empScSetting", function(){
      		console.log("버튼 클릭연동됨!");
      		var tableTr = $(this).parent().parent();
      		console.log(tableTr.find(".hiddenNo"));
      		var color = tableTr.find(".colorSp").css("background-color");
      		var no = tableTr.find(".hiddenNo").val();
      		var name = tableTr.find(".empScName").text();
      		
      		console.log(color);
      		console.log(no);
      		console.log(name);
      		
      		$("#udscrNo").val(no);
      		$("#udscrName").val(name);
      		console.log($("#udscrColorArea").find("span"));
      		$("#udscrColorArea").find("span").each(function(){
      			var bColor = $(this).css("background-color");
      			console.log(bColor);
      			if(color == bColor) {
      				$(this).parent().siblings().removeClass("on");
      				$(this).parent().addClass("on");
      				$(this).parent().siblings().attr("name", "cc");
      				$(this).parent().attr("name","schedulerColor");
      				$(this).parent().siblings().removeAttr("id");
      				$(this).parent().attr("id", "udscrColor");
      				
      			}
      			
      		});
      		
      		$("#updateScheduler").trigger("click");		
      	});
      	
      	
      	function updateEmpScr(){
      		var udscrNo = $("#udscrNo").val();
      		var udscrName = $("#udscrName").val();
      		var udscrColor = $("#udscrColor").val();
      		
      		console.log(udscrNo);
      		console.log(udscrName);
      		console.log(udscrColor);
      		
      		location.href = '${contextPath}/updateEmpScheduler.sc?schedulerNo=' + udscrNo
      				        + '&schedulerName=' + udscrName + "&schedulerColor=" + udscrColor;
      	};
      	
      	function deleteEmpScr(){
      		var udscrNo = $("#udscrNo").val();
      		
      		location.href = '${contextPath}/deleteEmpScheduler.sc?schedulerNo=' + udscrNo;
      	}

      	$(document).on('click', '.colorBtn', function(){
      		console.log($(this).parent().find(".hiddenNo").val());
      		
      		var schedulerNo = $(this).parent().find(".hiddenNo").val();
      		if($(this).find("span").is(":visible")){
      			$(this).find("span").css("display", "none"); 
      			location.href = '${contextPath}/changeStatusN.sc?schedulerNo=' + schedulerNo;
      		}else{
      			$(this).find("span").css("display", "inline-block");
      			location.href = '${contextPath}/changeStatusY.sc?schedulerNo=' + schedulerNo;
      		}
      	});
      	
      	$(document).on('click', '.gScrColorBtn', function(){
      		console.log($(this).parent().find(".hiddenNo").val());
      		
      		var schedulerNo = $(this).parent().find(".hiddenNo").val();
      		if($(this).find("span").is(":visible")){
      			$(this).find("span").css("display", "none"); 
      			location.href = '${contextPath}/changeGscrStatusN.sc?schedulerNo=' + schedulerNo;
      		}else{
      			$(this).find("span").css("display", "inline-block");
      			location.href = '${contextPath}/changeGscrStatusY.sc?schedulerNo=' + schedulerNo;
      		}
      	});
      	
      	
      	Date.prototype.format = function(f) {
      	    if (!this.valueOf()) return " ";
      	 
      	    var weekName = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];
      	    var d = this;
      	     
      	    return f.replace(/(yyyy|yy|MM|dd|E|hh|mm|ss|a\/p)/gi, function($1) {
      	        switch ($1) {
      	            case "yyyy": return d.getFullYear();
      	            case "yy": return (d.getFullYear() % 1000).zf(2);
      	            case "MM": return (d.getMonth() + 1).zf(2);
      	            case "dd": return d.getDate().zf(2);
      	            case "E": return weekName[d.getDay()];
      	            case "HH": return d.getHours().zf(2);
      	            case "hh": return ((h = d.getHours() % 12) ? h : 12).zf(2);
      	            case "mm": return d.getMinutes().zf(2);
      	            case "ss": return d.getSeconds().zf(2);
      	            case "a/p": return d.getHours() < 12 ? "오전" : "오후";
      	            default: return $1;
      	        }
      	    });
      	};
      	 
      	String.prototype.string = function(len){var s = '', i = 0; while (i++ < len) { s += this; } return s;};
      	String.prototype.zf = function(len){return "0".string(len - this.length) + this;};
      	Number.prototype.zf = function(len){return this.toString().zf(len);
     };
     
     
     /* 그룹캘린더 관련 이벤트 */
     function selectEmp(){
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
     
     
     function underEmp(span, event){
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
						console.log(data.empList[i].empName);
						var $option = $("<option id='" + data.empList[i].empNo + "' value='" + data.empList[i].empNo + "'>");
						$option.append($("<label>" + data.empList[i].empName + "(" + data.empList[i].deptName + "/ " + data.empList[i].jobName + " )" + "</label>"));
						
						$("select[name='empList']").append($option);
					}
				}
			});
		}else {
			$.ajax({
				url:"${contextPath}/approval/selectEmp",
				type:"get",
				success:function(data){
					console.log("성공");
					console.log($("select[name='empList']"));
					
					for(var i = 0; i < data.empList.length; i++) {
						console.log(data.empList[i].empName);
						var $option = $("<option id='" + data.empList[i].empNo + "' value='" + data.empList[i].empNo + "'>");
						$option.append($("<label>" + data.empList[i].empName + "(" + data.empList[i].deptName + "/ " + data.empList[i].jobName + " )" + "</label>"));
						
						$("select[name='empList']").append($option);
					} 
					
				}
			});
		}

	}
     
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
 		
 		
 		console.log(cnt);
 		
 		if(cnt <= 0) {
 			if($(this).attr("name") == "setInputCircle"){
 				var setEmpList = $(this).parent().parent().find("select[name='setEmpList']");
 				console.log($(this).parent().parent().find("select[name='setEmpList']"));
 				
 				for(var i = 0; i < selectEmp.length; i++) {
 					
 					var emp = $("#" + selectEmp[i]).clone();
 					
 					console.log("들어는 오냐??");
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
 					
 					console.log("들어는 오냐??");
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
     
     
     function insertGscr(){
    	 var inGscrName = $("#inGscrName").val();
    	 console.log(inGscrName);
    	 var inGscrColor = $("#inGscrColorArea > #udscrColor").val();
    	 console.log(inGscrColor);
    	 var setEmpList = new Array();
    	 
    	 $("#setEmpList").children().each(function(){
    		setEmpList.push($(this).val()); 
    	 });
    	 console.log(setEmpList);
    	 
    	 var readEmpList = new Array();
    	 
    	 $("#readEmpList").children().each(function(){
    		readEmpList.push($(this).val());
    	 });
    	 console.log(readEmpList);
    	 
    	 location.href = "${contextPath}/insertGscr.sc?schedulerName=" + inGscrName + "&schedulerColor=" + inGscrColor + "&setEmpList=" + setEmpList + "&readEmpList=" + readEmpList;
    	 
     }
     
     
	</script>
	
	
</body>
</html>









































