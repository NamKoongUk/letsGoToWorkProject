<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="contextPath/resources/images/favicon.ico">
<title>LetsGoToWork</title>
</head>
<style>
	tbody{
		display:table-row-group;
		vertical-align:middle; 
		border-color:inherit;
	}
	.holidayTable{
		width:100%;
		border-top:1px solid #cdcdcd;
		border-collapse:collapse;
	}
	.holidayTable td{
		padding:12px 0 12px 14px;
		border-bottom:1px solid #dedede;
	}
	colgroup{
		display:table-column-group;
	}
	table{
		border-collapse:collapse;
	}
	.holidayTable th{
		padding:14px 14px;
		border-bottom:1px solid #dedede;
		background:#f9f9f9;
		color:#333;
		font-weight:400;
	}
	body, button, input, select, td, textarea, th{
		font-size:14px;
	}
	.mgr{
		margin-right:20px;
	}
	.mgl{
		margin-left:20px;
	}
	.pdb{
		padding-bottom:30px;
	}
	.vc_new{
		position:relative;
	}
	.vc_new .btn.prev{
		left:0; 
		top:35px; 
		display:inline-block; 
		width:24px; 
		height:24px; 
		background:url(${contextPath}/resources/images/employee/insa_icon.png) -297px -38px no-repeat;
	}
	.vc_new .btn.next{
		right:0;
		top:35px;
		display:inline-block;
		width:24px;
		height:24px;
		background:url(${contextPath}/resources/images/employee/insa_icon.png) -324px -38px no-repeat;
	}
	.vc_new .btn{
		position:absolute;
	}
	
	a{
		color:#676767;
		text-decoration:none;
	}
	
	.vc_new .cal_area{
		padding:0 40px;
	}
	
	.day_choice{
		border-top:2px solid #666;
		border-bottom:1px solid #cdcdcd;
		max-width:850px;
	}
	
	.day_choice th{
		border-right:1px solid #dedede;
		padding:4px;
		font-size:12px;
	}
	
	.day_choice td{
		height:72px;
		padding:0;
		text-align:center;
		cursor:pointer;
		font-size:12px;
	}
	.Clearfix{
		zoom:1;
	}
	
	.blue_color{
		color:#2985db!important;
	}
	.Fl{
		float:left !important;
	}
	
	.Fr{
		float:right !important;
	}
	
	.pdb{
		padding-bottom:10px !important;
	}
	
	.pdt{
		padding-top:10px !important;
	}
	.setting_field select{
		border:1px solid #a5acb2;
		height:23px;
	}
	.detail_select{
		float:left;
		padding-right:26px;
		position:relative;
		color:#2985db;
		font-size:16px;
	}
	.content_title .detail_select>a{
		color:#2985db;
	}
	.holidayTable th{
		text-align:center;
	}
	
	tr{
		display: table-row;
		vertical-align: inherit;
        border-color: inherit;
	}
	
	thead {
    display: table-header-group;
    vertical-align: middle;
    border-color: inherit;
	}
	
	.day_choice td.holiday{
		cursor:default;
	}
	.day_choice td .all_absence{
		padding: 0;
   		height: 72px;
    	line-height: 72px;
    	background: #8cbbee;
    	color: #fff;
	}
	.day_choice td .am_absence, .day_choice td .pm_absence{
		padding: 0;
    	height: 36px;
    	line-height: 36px;
    	background: #8cbbee;
    	color: #fff;
	}
	.day_choice td.pm{
		vertical-align: bottom;
	}
	.day_choice td.am{
		vertical-align: top;
	}

</style>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/employee.jsp"/>
		
		<section class="col-sm-10">
		<br>
			<form id="holidayApply" style="margin-left:15px;">
				<fieldset style="border:0 none">
					<span class="detail_select">
                		<a href="javascript:void(0)" onclick="formSubmit()">기안하기</a>
           		 	</span>
				</fieldset>
			</form>
			
			<div class="content">
				<div style="max-width:1000px; min-height:400px; min-width:500px; width:100%">
					<div style="padding-bottom:20px !important">
						<table class="holidayTable">
							<colgroup>
								<col width="12%">
								<col>
								<col width="12%">
								<col>
							</colgroup>
								<tbody>
									<tr>
										<th scope="row">현황</th>
										<td colspan="3">
											생성 : <span></span>일
											<span class="mgr mgl">/</span>
											사용 : <span></span>일
											<span class="mgr mgl">/</span>
											잔여 : <span></span>일

										</td>
									</tr>
									<tr>
										<th scope="row">작성자</th>
										<td colspan="3">
											<label>
												<c:out value="${sessionScope.loginEmp.empName}"></c:out>
											</label>
										</td>
									</tr>
									<tr>
										<th scope="row">신청</th>
										<td>
											<span>강형석</span>
										</td>
									</tr>
									<tr>
										<th scope="row">휴가기간</th>
										<td>
											<p class="pdb">셀을 클릭하면, [일차 >> 오전반차 >> 오후반차 >> 해제] 순으로 바뀝니다.</p>
											<div class="vc_new">
												<a href="javascript:void(0)" class="btn prev" onclick="showCalendar('L')"></a>
												<a href="javascript:void(0)" class="btn next" onclick="showCalendar('R')"></a>
												<div class="cal_area">
													<table class="holidayTable day_choice">
														<thead>
															<tr id="thead_year_month"></tr>
															<tr id="thead_day"></tr>
															<tr id="thead_day_name"></tr>
														</thead>
														<tbody>
															<tr id="tbody_selector">
																
															</tr>
														</tbody>
													</table>
													<div class="Clearfix">
														<p class="Fl pdt pdb">
															선택일수 : <span id="choice_day_count"></span> 일 </p>
														<p class="Fr pdt pdb">
															<a href="javascript:void(0)" class="blue_color" onclick="delChooseDate()">선택해제</a>
														</p>
														<p></p>
													</div>
												</div>
											</div>
										</td>
									</tr>
									<tr>
										<th scope="row">종류</th>
										<td colspan="3">
											<label>
												<select title="선택" id="vacation_type">
													<option value="">휴가 종류 선택</option>
													<option value="10">연차</option>
													<option value="21">훈련</option>
													<option value="22">교육</option>
													<option value="23">경조사</option>
													<option value="24">병가</option>
													<option value="25">출산</option>
													<option value="26">무급</option>
												</select>
											</label>
										</td>
									</tr>
									<tr>
										<th scope="row">사유</th>
										<td colspan="3">
											<textarea name="" id="vacation_content" cols="30" rows="10" style="height:27px;width:calc(100% - 14px);"></textarea>
										</td>
									</tr>
								</tbody>
						</table>
					</div>
				</div>
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
	
	<script>
		var dateNum = 0;
		var nDate;
		$(function(){
			//var nDate = new Date();
			
			nDate = new Date();
			showCalendar();
			
			//console.log();
			//nDate.setDate(0);
			//nDate.setDate(nDate.getDate() - 15);
			
			/* var year = nDate.getFullYear();
			var month = nDate.getMonth() + 1;
			var date = nDate.getDate();
			var day = nDate.getDay(); */
			
			
			//console.log(year + month + day);
			/* $("#thead_year_month").append($("<th colspan='15'>").text(year+"."+(month)));
			
			for(var i=0; i<15; i++){
				if(day == new Date().getDate()){
					$("#thead_day").append($("<th style='background-color: rgba(41, 133, 219, 0.1); border-right: 1px solid rgb(222, 222, 222); display: table-cell;'>").text(Number(day++)));
				}else{
					$("#thead_day").append($("<th style='background-color: #fff; border-right: 1px solid rgb(222, 222, 222); display: table-cell;'>").text(Number(date++)));
				}
				
				$("#thead_day_name").append($("<th style='background-color: #F9F9F9; border-right: 1px solid rgb(222, 222, 222); display: table-cell;'>")
						.text(MakeDay(nDate.getDay())));
			} */
			
			
		});
		
		function showCalendar(move){
			var fullDay;
			var num = 0;
			if(move == 'L'){
				fullDay = $("#thead_day").children(":first").prop("id");
				
			}else if(move == 'R'){
				fullDay = $("#thead_day").children(":last").prop("id");
			}
			
			$("#thead_year_month").empty();
			$("#thead_day").empty();
			$("#thead_day_name").empty();
			$("#tbody_selector").children().css({"display":"none"});
			$("#thead_year_month").append($("<th colspan='15' style='border-left:1px solid rgb(222, 222, 222);'>").text(nDate.getFullYear() + "." + (nDate.getMonth() + 1)));
			
			var selector = $("#tbody_selector").children("td");
			
			for(var i=0; i<15; i++){
				
				if(move == 'L'){
					if(i == 0){
						nDate = new Date(Number(fullDay));
					}
					nDate.setDate(nDate.getDate() - 1);
					}else if(move == 'R'){
						if(i == 0){
							nDate = new Date(Number(fullDay));
						}
						nDate.setDate(nDate.getDate() + 1); 
					}else{
						if(i > 0){
							nDate.setDate(nDate.getDate() + 1);
						}
					}
				
				
				if(move == 'L'){
					if(nDate.getFullYear() + "" + nDate.getMonth() + "" + nDate.getDate() ==
						new Date().getFullYear() + "" +new Date().getMonth()+ "" + new Date().getDate()){
					$("#thead_day").prepend($("<th style='background-color: rgba(41, 133, 219, 0.1); border: 1px solid rgb(222, 222, 222); display: table-cell;'>")
							.text(nDate.getDate()).attr("id",nDate.getTime()));
					}else{
						$("#thead_day").prepend($("<th style='background-color: #fff; border: 1px solid rgb(222, 222, 222); display: table-cell;'>")
								.text(nDate.getDate()).attr("id",nDate.getTime()));
					}
				
					if(MakeDay(nDate.getDay()) == '토'){
						$("#thead_day_name").prepend($("<th style='background-color: #F9F9F9; border: 1px solid rgb(222, 222, 222); display: table-cell; color:#2985DB'>")
									.text(MakeDay(nDate.getDay())));
					}else if(MakeDay(nDate.getDay()) == '일'){
						$("#thead_day_name").prepend($("<th style='background-color: #F9F9F9; border: 1px solid rgb(222, 222, 222); display: table-cell; color:#D91A1A'>")
									.text(MakeDay(nDate.getDay())));
					}else{
						$("#thead_day_name").prepend($("<th style='background-color: #F9F9F9; border: 1px solid rgb(222, 222, 222); display: table-cell;'>")
									.text(MakeDay(nDate.getDay())));
					}
				}else{
					if(nDate.getFullYear() + "" + nDate.getMonth() + "" + nDate.getDate() ==
						new Date().getFullYear() + "" +new Date().getMonth()+ "" + new Date().getDate()){
					$("#thead_day").append($("<th style='background-color: rgba(41, 133, 219, 0.1); border: 1px solid rgb(222, 222, 222); display: table-cell;'>")
							.text(nDate.getDate()).attr("id",nDate.getTime()));
					}else{
						$("#thead_day").append($("<th style='background-color: #fff; border: 1px solid rgb(222, 222, 222); display: table-cell;'>")
								.text(nDate.getDate()).attr("id",nDate.getTime()));
					}
					
					if(MakeDay(nDate.getDay()) == '토'){
						$("#thead_day_name").append($("<th style='background-color: #F9F9F9; border: 1px solid rgb(222, 222, 222); display: table-cell; color:#2985DB'>")
								.text(MakeDay(nDate.getDay())));
					}else if(MakeDay(nDate.getDay()) == '일'){
						$("#thead_day_name").append($("<th style='background-color: #F9F9F9; border: 1px solid rgb(222, 222, 222); display: table-cell; color:#D91A1A'>")
								.text(MakeDay(nDate.getDay())));
					}else{
						$("#thead_day_name").append($("<th style='background-color: #F9F9F9; border: 1px solid rgb(222, 222, 222); display: table-cell;'>")
								.text(MakeDay(nDate.getDay())));
					}
				}
				

				
				 for(var j=0; j <selector.length; j++){
					if(nDate.getFullYear() + "" + nDate.getMonth() + "" + nDate.getDate() == selector.eq(j).data("type")){
						selector.eq(j).css("display","table-cell");
						num++;
					}
				}   
				
				if(selector.length == 0 || num == 0){
					if(move == 'L'){
						if(MakeDay(nDate.getDay()) == '토' || MakeDay(nDate.getDay()) == '일'){
							$("#tbody_selector").prepend($("<td style='border: 1px solid rgb(222, 222, 222);'>")
												.attr({"class":"holiday","data-type":nDate.getFullYear() + "" + nDate.getMonth() + "" + nDate.getDate()}));
						}else{
							$("#tbody_selector").prepend($("<td style='border: 1px solid rgb(222, 222, 222);'>")
									.attr({"onclick":"selectDate(this)","data-type":nDate.getFullYear() + "" + nDate.getMonth() + "" + nDate.getDate()}));
						}
					}else{
						if(MakeDay(nDate.getDay()) == '토' || MakeDay(nDate.getDay()) == '일'){
							$("#tbody_selector").append($("<td style='border: 1px solid rgb(222, 222, 222);'>")
												.attr({"class":"holiday","data-type":nDate.getFullYear() + "" + nDate.getMonth() + "" + nDate.getDate()}));
						}else{
							$("#tbody_selector").append($("<td style='border: 1px solid rgb(222, 222, 222);'>")
									.attr({"onclick":"selectDate(this)","data-type":nDate.getFullYear() + "" + nDate.getMonth() + "" + nDate.getDate()}));
						}
					}
				}
				
			}		
		}
		
		
		
		function MakeDay(value){
			var day;
			switch(value){
			case 0 : day = '일'; break;
			case 1 : day = '월'; break;
			case 2 : day = '화'; break;
			case 3 : day = '수'; break;
			case 4 : day = '목'; break;
			case 5 : day = '금'; break;
			case 6 : day = '토'; break;
			} 
			return day;
		}
	
		function selectDate(td){
			var $div = $("<div class='all_absence'>");
			var status = $(td).children().attr("class");
			
			//$(td).empty();
			
			if(status == 'all_absence'){
				$(td).attr("class","choose_day am")
				$(td).children().attr("class","am_absence").text("전");
			}else if(status == 'am_absence'){
				$(td).attr("class","choose_day pm")
				$(td).children().attr("class","pm_absence").text("후");
			}else if(status == 'pm_absence'){
				$(td).attr("class","")
				$(td).children().remove();
			}else{
				$(td).attr("class","choose_day");
				$(td).append($div.text("일"));
			}
			dayCount();
		}
		
		function dayCount(){
			var chooseDay = $(".choose_day");
			var chooseCount = 0;
			for(var i=0; i<chooseDay.length; i++){
				var amPm = chooseDay.eq(i).children().prop("class");
				if(amPm == 'am_absence' || amPm == 'pm_absence'){
					chooseCount+= 0.5;
				}else if(amPm == 'all_absence'){
					chooseCount+= 1;
				}
			}
			
			$("#choice_day_count").text(chooseCount);
			
		}
		
		function delChooseDate(){
			var chooseDay = $(".choose_day");
			for(var i=0; i<chooseDay.length; i++){
				chooseDay.eq(i).children().remove();
			}
			$("#choice_day_count").text(0);
		}
		
		
		
		
		function formSubmit(){
			$("#tbody_selector").children().children();
			
			console.log($("#tbody_selector").children().children());
			
			$("#holidayApply").append();
			
			
		}
	
	</script>
</body>
</html>