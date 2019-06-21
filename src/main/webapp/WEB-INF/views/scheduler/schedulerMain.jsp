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
    
    var calendar = new FullCalendar.Calendar(calendarEl, {
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
      businessHours: true,
      editable: true,
      eventLimit: true,
      events: [ {
          title: 'Business Lunch',
          start: '2019-06-03',
          end: '2019-06-07'
        } ]
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
			          			<select name="schedulerName" id="ismSelect">
			          				
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
								<input type="time" name="startTime">
							</td>
							<td width="20%">
								<input type="checkbox" id="allDateBtn"> 종일
							</td>
							
						</tr>
						<tr>
							<td><b>종료</b></td>
							<td colspan="3">
								<input type="date" name="endDate"> &nbsp;&nbsp;
								<input type="time" name="endTime">
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
			          <button type="submit" class="btn" onclick="return createSchedule()">생성</button>
			          <button type="reset" class="btn" data-dismiss="modal">취소</button>
			        </div>
			      </div>
			    </div>
			  </div>
			  
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
      			success:function(data){
      				console.log(data);
      				var $selectArea = $("#ismSelect");
      				for(var key in data){
      					var $option = $("<option>").text(data[key]);
      					console.log(data[key]);
      					$selectArea.append($option);
      				}
      			}
      		});
      	}
      	
      	
		
		/* document.addEventListener('DOMContentLoaded', function() {  
		
		var calendar = new FullCalendar.Calendar(calendarEl, {

			  dateClick: function(info) {
			    alert('Date: ' + info.dateStr);
			    alert('Resource ID: ' + info.resource.id);
			  }

			});
		
		)}; */
	</script>
	
	
</body>
</html>









































