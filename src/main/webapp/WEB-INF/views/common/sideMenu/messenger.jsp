<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">    
<div class="col-sm-2 sidenav visible-sm visible-md visible-lg">
<!-- <script src="http://localhost:3000/socket.io/socket.io.js"></script> -->
	<ul>
		<li onclick="MessengerSend()"><button>글쓰기</button></li>
		<hr>
		<li>
		<button onclick="myFunction('Demo1')" class="accordionBtn">
		쪽지
		</button>
			<div id="Demo1" class="w3-container w3-hide w3-animate-opacity contentSelectArea">
				<ul>
					<li onclick="resMessenger()">받은쪽지함</li>
					<li onclick="reqMessenger()">보낸쪽지함</li>
					<li onclick="stoMessenger()">임시저장</li>
					<li onclick="delMessenger()">휴지통</li>
				</ul>
			</div>
			<button style="margin-top:8px;" onclick="callMessenger()">메신저</button>
		</li>
	</ul>
	<form id="chatForm">
		<input type="hidden" name="hidden1" value="${loginEmp.empId}" />
		<input type="hidden" name="hidden2" value="${loginEmp.empName}" />
	</form>
	
</div>

<script>
	function myFunction(id) {
	  var x = document.getElementById(id);
	  if (x.className.indexOf("w3-show") == -1) {
	    x.className += " w3-show";
	  } else { 
	    x.className = x.className.replace(" w3-show", "");
	  }
	}
	
	function MessengerSend(){
		location.href="${contextPath}/messenger/showMessenger";
	}
	function callMessenger(){
		var chatForm = document.getElementById("chatForm");
		window.open("about:blank", "chatRoom", "width=400, height=500, toolbar=no, menubar=no, scrollbars=no, resizable=yes" );  
		chatForm.action="http://localhost:3000";
		chatForm.target="chatRoom";
		chatForm.method="post";
		chatForm.submit();
		
	}
</script>