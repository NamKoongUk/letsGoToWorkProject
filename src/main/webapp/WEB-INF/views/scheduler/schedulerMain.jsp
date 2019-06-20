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
<%-- <script src="${ contextPath }/resources/schedulerPackages/core/locales/ko.js"></script> --%>
<script>
  document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      plugins: [ 'interaction', 'dayGrid', 'timeGrid', 'list'],
      header: {
          left: 'prevYear,prev,next,nextYear today',
          center: 'title',
          right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
      },
      defaultDate: new Date,
      /* lang: 'ko', */
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
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/scheduler.jsp"/>
		
		<section class="col-sm-10">
			<div class="content">
				<div id='calendar'></div>
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>