<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<div class="col-sm-2 sidenav visible-sm visible-md visible-lg">
	<ul>
		<li class="mailSelect">
			<select class="form-control">
				<option value="email" selected="selected">letsGoToWork@office.com</option>
				<option value="email2">letsGoToWork2@office.com</option>		
				<option value="email3">letsGoToWork3@office.com</option>					
			</select>
		</li>
		<li><button onclick="location.href='${ contextPath }/mail/writeForm'" style="height : 100%;">메일작성하기</button></li><hr>
				<!-- ${ contextPah }/mail.ma?pageType=all -->
		<li><a href="${ contextPath }/mail.ma">전체보관함</a></li><hr>
		<li><a href="${ contextPath }/mail.ma">받은메일함</a></li><hr>
		<li><a href="${ contextPath }/mail.ma">보낸메일함</a></li><hr>
		<li><a href="${ contextPath }/mail.ma">임시보관함</a></li><hr><br>
		<li><button class="grayBtn" style="height : 100%;" onclick="location.href='${ contextPath }/mail.ma'">휴지통</button></li><br>
		<li><a href="setting.ma">환경설정</a></li>
		<!-- 환경설정에 공용메일 관리 추가하기  -->	
	</ul>
</div>