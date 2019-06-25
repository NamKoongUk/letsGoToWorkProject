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
          $("#selectDetailSchedule").trigger('click');
          $.ajax({
        	 url:"selectScheduleDetail.sc",
        	 data:{
        		 scheduleNo:eventObj.id
        	 },
        	 type:"get",
        	 success:function(data){
        		 console.log("ajax 성공 진입!");
        		 console.log(data);
        		 
        		 var startDate = data.startDate.split(" ");
        		 console.log(startDate);
        		 
        		 var endDate = data.endDate.split(" ");
        		 console.log(endDate);
        		 
        		 $("#selectDetailSchedule > input, #selectDetailSchedule > textarea").val("");
        		 $("#dtscNo").val(data.schedulerNo);
        		 $("#dtScrName").val(data.schedulerList[0].schedulerName);
        		 $("#dtScName").val(data.scheduleName);
        		 $("#dtscSD").val(startDate[0]);
        		 $("#dtscST").val(data.startTime);
        		 $("#dtscED").val(endDate[0]);
        		 $("#dtscET").val(data.endTime);
        		 $("#dtscContent").val(data.scheduleContent);
        	 }
          });
          
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
  #colorSp {
  	position: relative;
  	display : inline-block;
  	left: -5px;
  	bottom : 2px;
  	height : 10px !important;
  	width : 10px !important;
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
			  
			  <!-- 일정추가 모달 -->
			  <form action="${contextPath}/insertSchedule.sc" method="post">
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
								<input type="date" name="startDate"> &nbsp;&nbsp;
								<input type="time" name="startTime" id="startTime">
							</td>
							<td width="20%">
								<input type="checkbox" id="allDateBtn"> 종일
							</td>
							
						</tr>
						<tr>
							<td><b>종료</b></td>
							<td colspan="3">
								<input type="date" name="endDate"> &nbsp;&nbsp;
								<input type="time" name="endTime" id="endTime">
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
			          <button type="submit" class="btn">생성</button>
			          <button type="reset" class="btn" data-dismiss="modal">취소</button>
			        </div>
			        
			      </div>
			    </div>
			  </div>
			  </form>
			  
			  <!-- 일정 상세보기 모달 -->
			  <button style="display:none" id="selectDetailSchedule" data-toggle="modal" data-target="#detailScheduleModal"></button>
			  <form action="" method="post">
				<div class="modal fade" id="detailScheduleModal" role="dialog">
			    <div class="modal-dialog">
			    
			      <!-- Modal content-->
			      <div class="modal-content">
			        <div class="modal-header">
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			          <h4 class="modal-title" align="center"><b>일정 정보</b></h4>
			        </div>
			        
			        <div class="modal-body">
			          <table>
			          	<tr>
			          		<td width="20%"><b>캘린더</b></td>
			          		<td>
			          			<input type="hidden" name="schedulerNo" id="dtscNo">
			          			<input type="text" name="schedulerName" id="dtScrName" readonly>
			          		</td>
						</tr>
						<tr>
							<td><b>일정명</b></td>
							<td colspan="2"><input type="text" name="scheduleName" id="dtScName" readonly></td>
						</tr>
						<tr>
							<td><b>시작</b></td>
							<td>
								<input type="date" name="startDate" id="dtscSD" readonly> &nbsp;&nbsp;
								<input type="time" name="startTime" id="dtscST" readonly>
							</td>
						</tr>
						<tr>
							<td><b>종료</b></td>
							<td colspan="3">
								<input type="date" name="endDate" id="dtscED" readonly> &nbsp;&nbsp;
								<input type="time" name="endTime" id="dtscET" readonly>
							</td>
						</tr>
						<tr>
							<td colspan="3"><b>내용</b></td>
						</tr>
						<tr>
							<td colspan="3">
								<textarea cols="70%" rows="10" style="resize: none;" name="scheduleContent" id="dtscContent" readonly></textarea>
							</td>
						</tr>
			          </table>
			        </div>
			        
			        <div class="modal-footer">
			          <button type="submit" class="btn">수정</button>
			          <button type="reset" class="btn">삭제</button>
			        </div>
			        
			      </div>
			    </div>
			  </div>
			  </form>
			  
			  
			  <!-- 그룹캘린더 추가 모달 -->
				<!-- <form action="" method="get">
				<div class="modal fade" id="groupSchedulerModal" role="dialog">
			    <div class="modal-dialog">
			    
			      Modal content
			      <div class="modal-content">
			        <div class="modal-header">
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			          <h4 class="modal-title" align="center">공유 일정표 추가</h4>
			        </div>
			        <div class="modal-body">
			          <table>
			          	<tr>
			          		<td width="20%">일정표 이름</td>
			          		<td width="50%"><input type="text" name="schedulerName"></td>
						</tr>
						<tr>
							<td>색상</td>
							<td>
			          			<div>
									<button type="button" class="label on" name="cc"><span class="c1" ></span></button>
									<button type="button" class="label" name="cc"><span class="c2"></span></button>
									<button type="button" class="label" name="cc"><span class="c3"></span></button>
									<button type="button" class="label" name="cc"><span class="c4"></span></button>
									<button type="button" class="label" name="cc"><span class="c5"></span></button>
									<button type="button" class="label" name="cc"><span class="c6"></span></button>
									<button type="button" class="label" name="cc"><span class="c7"></span></button>
									<br>
								</div>
			          		</td>
						</tr>
						<tr>
							<td>공유대상</td>
						</tr>
						<tr>
							<td>
								
							</td>
						</tr>
			          </table>
			        </div>
			        <div class="modal-footer">
			          <button type="submit" class="btn" data-dismiss="modal">생성</button>
			          <button type="reset" class="btn" data-dismiss="modal">취소</button>
			        </div>
			      </div>
			      
			    </div>
			  </div>
			  </form> -->
			  
			  <!-- 일정 상세보기 추가 모달 -->
				<!-- <form action="" method="get">
				<div class="modal fade" id="groupSchedulerModal" role="dialog">
			    <div class="modal-dialog">
			    
			      Modal content
			      <div class="modal-content">
			        <div class="modal-header">
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			          <h4 class="modal-title" align="center">공유 일정표 추가</h4>
			        </div>
			        <div class="modal-body">
			          <table>
			          	<tr>
			          		<td width="20%">일정표 이름</td>
			          		<td width="50%"><input type="text" name="schedulerName"></td>
						</tr>
						<tr>
							<td>색상</td>
							<td>
			          			<div>
									<button type="button" class="label on" name="cc"><span class="c1" ></span></button>
									<button type="button" class="label" name="cc"><span class="c2"></span></button>
									<button type="button" class="label" name="cc"><span class="c3"></span></button>
									<button type="button" class="label" name="cc"><span class="c4"></span></button>
									<button type="button" class="label" name="cc"><span class="c5"></span></button>
									<button type="button" class="label" name="cc"><span class="c6"></span></button>
									<button type="button" class="label" name="cc"><span class="c7"></span></button>
									<br>
								</div>
			          		</td>
						</tr>
						<tr>
							<td>공유대상</td>
						</tr>
						<tr>
							<td>
								
							</td>
						</tr>
			          </table>
			        </div>
			        <div class="modal-footer">
			          <button type="submit" class="btn" data-dismiss="modal">생성</button>
			          <button type="reset" class="btn" data-dismiss="modal">취소</button>
			        </div>
			      </div>
			      
			    </div>
			  </div>
			  </form> -->
			  
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
			console.log($(this).attr("name"));
			console.log($(this).val());
		});
		
		function createEmpSC(){
      		var colorVal = $("[name=schedulerColor]").val();
      		var nameVal = $("[name=schedulerName]").val();
      		
      		console.log($("[name=schedulerName]").val());
      		
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
      	}
      	
      	$("#allDateBtn").click(function(){
			var check = $(this).is(":checked");
			if(check){
				$("#startTime").attr("disabled","disabled");
				$("#endTime").attr("disabled","disabled");
			}else{
				$("#startTime").removeAttr("disabled");
				$("#endTime").removeAttr("disabled");
			}
      	});
      	
      	$(function(){
      		console.log("온로드 펑션입니다.");
      		$.ajax({
      			url:"allSelectSchedule/sc",
      			type:"get",
      			success:function(data){
      				alert("성공");
      				console.log(data.empScList);
      				console.log(data.gpScList);
      				console.log(data.scList);
      				$("#empScheduler > tbody > tr").remove();
  					var $empScheduler = $("#empScheduler");
  					
  					$("#groupScheduler > tbody > tr").remove();
  					var $groupScheduler = $("#groupScheduler");
  					
      				for(var key in data.empScList){
      					var $empTr = $("<tr>");
      					var $colTd = $("<td colspan='2'>");
      					var $colBtn = $("<button style='width:5px; height:16px;'>");
      					var $colSp = $("<span style='background:" + data.empScList[key].schedulerColor + "' id='colorSp'>");
      					      					
      					var $nameSp = $("<span style='margin-left:5px;'>").text(data.empScList[key].schedulerName);
      					
      					var $settingTd = $("<td align='center'>");
      					var $settingIm = $("<img src='${contextPath}/resources/images/scheduler/settings.png' style='width:16px; height:16px;'>");
      					
      					$colBtn.append($colSp);
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
      					var $colBtn = $("<button style='width:5px; height:16px;'>");
      					var $colSp = $("<span style='background-color:" + data.gpScList[key].schedulerColor + "' id='colorSp'>");
      					      					
      					var $nameSp = $("<span style='margin-left:5px;'>").text(data.gpScList[key].schedulerName);
      					
      					var $settingTd = $("<td align='center'>");
      					var $settingIm = $("<img src='${contextPath}/resources/images/scheduler/settings.png' style='width:16px; height:16px;'>");
      					
      					$colBtn.append($colSp);
      					$colTd.append($colBtn);
      					$colTd.append($nameSp);
      					$gmTr.append($colTd);
      					
      					$settingTd.append($settingIm);
      					$gmTr.append($settingTd);
    					
      					$groupScheduler.append($gmTr);
      				}
      				
      				for(var key in data.scList){
      					var id = data.scList[key].scheduleNo;
      					var title = data.scList[key].scheduleName;
      					var startD = data.scList[key].startDate.split(" ");
      					var endD = data.scList[key].endDate.split(" ");
      					var color = data.scList[key].schedulerList[0].schedulerColor;
      					console.log(startD);
      					var startT = data.scList[key].startTime;
      					var endT = data.scList[key].endTime;
      					
      					var endDate = new Date(endD[0]);
      					endDate.setDate(endDate.getDate() + 1);
      					
      					var event = {
      							id:id,
      							title:title,
      							start:startD[0],
      							end:endDate.format("yyyy-MM-dd"),
      							color:color
      					}
      					console.log(event);
      					calendar.addEvent(event);
      				}
      			}
      		});
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
	</script>
	
	
</body>
</html>









































