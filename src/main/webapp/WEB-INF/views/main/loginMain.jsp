<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LetsGoToWork</title>

<style>
	.page{
	  width: 300px
	  display: flex;
	  justify-content: center;
	  margin-left:80%;
	}
	/* add default color for animation start  */
	/* toggle this class */
	.color-bg-start {
	  background-color: salmon;
	}
	
	/* toggle class bg-animate-color */
	
	.bg-animate-color {
	  animation: random-bg .5s linear infinite;
	}
	
	
	/* add animation to bg color  */
	
	@keyframes random-bg {
	  from {
	    filter: hue-rotate(0);
	  }
	  to {
	    filter: hue-rotate(360deg);
	  }
	}
	
	.fun-btn {
	  /* change bg color to get different hues    */
	  background-color: salmon;
	  color: white;
	  padding: 2em 3em;
	  border: none;
	  transition: all .3s ease;
	  border-radius: 5px;
	  letter-spacing: 2px;
	  text-transform: uppercase;
	  outline: none;
	  align-self: center;
	  cursor: pointer;
	  font-weight: bold;
	}
	
	.fun-btn:hover {
	  animation: random-bg .5s linear infinite, grow 1300ms ease infinite;
	}
	
	.start-fun {
	  background-color: #fff !important;
	  /* change color of button text when fun is started   */
	  color: salmon !important;
	}
	
		/* pulsating effect on button */
		@keyframes grow {
		  0% {
		    transform: scale(1);
		  }
		  14% {
		    transform: scale(1.3);
		  }
		  28% {
		    transform: scale(1);
		  }
		  42% {
		    transform: scale(1.3);
		  }
		  70% {
		    transform: scale(1);
		  }
		}
		
		#loginInfoArea{
			float:left;
		}
</style>
</head>
<body>
	<section>
		<c:if test="${ empty loginEmp }">
			<h1 class="title">로그인페이지 입니다.</h1>
			<form id="loginForm" action="login.em" method="post">
				<table id="loginTable">
					<tr>
						<td><input type="text" name="empId" placeholder="아이디를 입력하주세요" class="form-control" value="admin"/></td>
					</tr>			
					<tr>
						<td><input type="password" name="empPwd" placeholder="비밀번호를 입력해주세요" class="form-control" value="admin"/></td>
					</tr>
					<tr>
						<td><button id="loginBtn" class="btn" type="submit">로그인</button></td>
					</tr>
				</table>
			</form>
			
			
			
			<!-- <script>
				$(function(){
					$("#loginBtn").click();
				});
			</script> -->
		</c:if>
		<c:if test="${ !empty loginEmp }">
			<div id="loginInfoArea">
				<h1 align="center">${ loginEmp.empName }님이 로그인한 상태</h1>
			</div>
			<!-- 로그인 적용할때 이거 주석 풀고 main에 include제거하기 -->
			<%-- <jsp:forward page="index.jsp"/> --%> 
			<div class="page">
				<button id="gotoWork" class="btn btn-primary btn-lg" onclick="goToWork();">출근합시다</button>
			  	<button id="dontWork" class="fun-btn">퇴근합시다</button>
			</div>
			
		</c:if>		
	</section>
	
	<script>
		$('.fun-btn').on('click', function(event) {
		  $(this).toggleClass('start-fun');
		  var $page = $('.page');
		  $page.toggleClass('color-bg-start')
		    .toggleClass('bg-animate-color');

		  //change text when when button is clicked

		  $(this).hasClass('start-fun') ?
		    $(this).text('stop the fun') :
		    $(this).text('start the fun');

		});
		
		var xmlHttp;
	     
		function srvTime(){
	         if (window.XMLHttpRequest) {
	          xmlHttp = new XMLHttpRequest();
	          xmlHttp.open('HEAD',window.location.href.toString(),false);
	          xmlHttp.setRequestHeader("Content-Type", "text/html");
	          xmlHttp.send('');
	          return xmlHttp.getResponseHeader("Date");
	    
	         }else if (window.ActiveXObject) {
	         xmlHttp = new ActiveXObject('Msxml2.XMLHTTP');
	         xmlHttp.open('HEAD', window.location.href.toString(), false);
	         xmlHttp.setRequestHeader("Content-Type", "text/html");
	         xmlHttp.send('');
	         return xmlHttp.getResponseHeader("Date");
	        
	         }
	      }
	      
	      var st = srvTime();
	      var date = new Date(st);
		
	      function goToWork(){
	    	  var empNo = ${loginEmp.empNo};
	    	  var hours = date.getHours();
	    	  var minutes = date.getMinutes();
	    	  var time=date.getTime();
	    	  console.log(time);
	    	  console.log(date);
	    	  console.log(hours);
	    	  console.log(minutes);
	    	  console.log("사번"+empNo);
	    	  console.log(hours+":"+minutes);
	    	  
	    	  var workTime = hours+":"+minutes;
	    	  
	    	  var workArr = new Array();
	    	  
	    	  workArr.push(empNo);
	    	  workArr.push(workTime);
	    	  workArr.push(date);
	    	  
	    	  var object = {
	    			  workArr:workArr
				}
	    	  
	    	  $.ajax({
	    		  url:"${contextPath}/employee/goToWork",
	    		  type:"post",
	    		  contentType: 'application/json; charset=utf-8',
	    		  data:JSON.stringify(object),
	    		  succes:function(data){
	    			  console.log("성공");
	    			  window.location.reload();
	    		  },
	    		  error:function(data){
	    			  arlert("실패");
	    		  }
	    	  });
	    	  
	    	  if(hours>=9 && minutes>=0){
	    		  console.log('출근시간 지났으~');
	    		  alert('지각!');
	    	  }else{
				  alert('출근하셨습니다.');	    		  
	    	  }
	      }
	      
	</script>
	
</body>
</html>