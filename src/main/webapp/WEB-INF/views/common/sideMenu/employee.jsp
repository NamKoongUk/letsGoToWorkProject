<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">    

<div id="accordion" class="col-sm-2 sidenav visible-sm visible-md visible-lg">
	<ul>
		<hr>
		<li>
			<button onclick="myFunction('Demo1')" class="accordionBtn">
				인사정보
			</button>
			<div id="Demo1" class="w3-container w3-hide w3-animate-opacity contentSelectArea">
				<ul>
					<li><a href="employee.em">조직도</a></li>
					<li><a href="showEmployeeList.em">직원목록</a></li>
					<li><a href="showMyPage.em">내 정보 관리</a></li>
				</ul>
			</div>
			<button onclick="myFunction('Demo2')" class="accordionBtn">
				휴가/근태
			</button>
			<div id="Demo2" class="w3-container w3-hide w3-animate-opacity contentSelectArea">
				<ul>
					<li><a href="#">휴가 신청</a></li>
					<li><a href="showHolidayList.em">휴가 현황</a></li>
					<li><a href="showAttendStatus.em">근태 현황</a></li>
				</ul>
			</div>
			<button onclick="myFunction('Demo3')" class="accordionBtn">
				인사관리
			</button>
			<div id="Demo3" class="w3-container w3-hide w3-animate-opacity contentSelectArea">
				<ul>
					<li><a href="#">조직관리</a></li>
					<li><a href="#">사용자 관리</a></li>
					<li><a href="#">직무/부서장 관리</a></li>
					<li><a href="#">인사관리자</a></li>
				</ul>
			</div>
			<button onclick="myFunction('Demo4')" class="accordionBtn">
				휴가관리
			</button>
			<div id="Demo4" class="w3-container w3-hide w3-animate-opacity contentSelectArea">
				<ul>
					<li><a href="#">휴가 관리</a></li>
					<li><a href="#">직원 휴가 관리</a></li>
				</ul>
			</div>
			<button onclick="myFunction('Demo5')" class="accordionBtn">
				근태관리
			</button>
			<div id="Demo5" class="w3-container w3-hide w3-animate-opacity contentSelectArea">
				<ul>
					<li><a href="#">근태관리</a></li>
					<li><a href="#">휴직자 관리</a></li>
					<li><a href="#">근태 예외 설정</a></li>
					<li><a href="#">직원 근태 관리</a></li>
				</ul>
			</div>
		</li>
	</ul>
	<!-- <ul>
		<li>
			<a href="#">인사정보</a>
				<ul>
					<li><a href="employee.em">조직도</a></li>
					<li><a href="showEmployeeList.em">직원목록</a></li>
					<li><a href="showMyPage.em">내 정보 관리</a></li>
				</ul>
		</li>
		
		<li>
			<a href="#">휴가/근태</a>
			<ul>
				<li><a href="#">휴가 신청</a></li>
				<li><a href="#">휴가 현황</a></li>
				<li><a href="#">근태 현황</a></li>
			</ul>
		</li>
		<li>
			<a href="#">인사관리</a>
				<ul>
					<li><a href="#">조직관리</a></li>
					<li><a href="#">사용자 관리</a></li>
					<li><a href="#">직무/부서장 관리</a></li>
					<li><a href="#">인사관리자</a></li>
				</ul>	
			
		</li>
		<li>
			<a href="#">휴가관리</a>
				<ul>
					<li><a href="#">휴가 관리</a></li>
					<li><a href="#">직원 휴가 관리</a></li>
				</ul>
		</li>
		<li>
			<a href="#">근태관리</a>
				<ul>
					<li><a href="#">근태관리</a></li>
					<li><a href="#">휴직자 관리</a></li>
					<li><a href="#">근태 예외 설정</a></li>
					<li><a href="#">직원 근태 관리</a></li>
				</ul>
		</li>
	</ul> -->
</div>

<script>
	/* $(document).ready(function(){
		$('#accordion > ul > li > a').on('click', function(){
			var element = $(this).parent('li');
			
			//$(this).parent().css("margin-bottom", "50px");
			
			if(element.hasClass('open')){
				element.removeClass('opne');
				element.find('li').removeClass('open');
				element.find('ul').slideUp();
			}else{
				element.addClass('open');
				element.children('ul').slideDown();
				
				element.siblings('li').children('ul').slideUp();
				element.siblings('li').removeClass('open');
				element.siblings('li').find('li').removeClass('open');
				element.siblings('li').find('ul').slideUp();
				
			}
			
		});
		
		$('#accordion ul ul').hide();
		$('.open').children('ul').slideDown();
		
		
	}); */
	function myFunction(id) {
		  var x = document.getElementById(id);
		  if (x.className.indexOf("w3-show") == -1) {
		    x.className += " w3-show";
		  } else { 
		    x.className = x.className.replace(" w3-show", "");
		  }
		}
	
</script>