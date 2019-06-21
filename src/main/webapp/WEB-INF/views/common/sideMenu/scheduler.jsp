<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    


<div class="col-sm-2 sidenav visible-sm visible-md visible-lg">
	<ul>
		<li><button data-toggle="modal" data-target="#insertScheduleModal">일정추가</button></li>			
	</ul>
	<hr>
	<div style="height:200px; margin-top:10px;">
		<table id="empScheduler">
			<thead>
				<tr>
					<th colspan="2" style="text-align:center"><b>개인일정</b></th>
					<th><button onclick="selectSchedulerList()" data-toggle="modal" data-target="#empSchedulerModal"
					             >+</button></th>
				</tr>
			</thead>
			<tbody>
			
			</tbody>
		</table>
	</div>
	
	<hr>
	
	<div style="height:200px; margin-top:10px;">
		<table id="groupScheduler">
			<thead>
				<tr>
					<th colspan="2" style="text-align:center"><b>공유일정</b></th>
					<th><button data-toggle="modal" data-target="#groupSchedulerModal">+</button></th>
				</tr>
			</thead>
			<tbody>
			
			</tbody>
		</table>
	</div>
	
</div>

<script>
	
</script>

