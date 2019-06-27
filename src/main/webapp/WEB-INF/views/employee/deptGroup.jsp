<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LetsGoToWork</title>
 	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {packages:["orgchart"]});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var result = new Array();
        
        <c:forEach items="${list}" var="dept">
        	var json = new Object();
        	json.deptCode="${dept.deptCode}";
        	json.deptName="${dept.deptName}";
        	json.topDept="${dept.topDept}";
        	result.push(json);
        </c:forEach>
    	  
        console.log(JSON.stringify(result));
        console.log(result.length);
        console.log(result[0].deptName);
    	  
    	  var data = new google.visualization.DataTable();
        data.addColumn('string', 'Name');
        data.addColumn('string', 'Manager');
		
        var deptList = new Array();
        
        for(var i=0; i<result.length; i++){
        	deptList[i]=[{v:result[i].deptCode,f:result[i].deptName},{v:result[i].topDept}];
    	}
        
        console.log(deptList[0]);
        
        
        // For each orgchart box, provide the name, manager, and tooltip to show.
        data.addRows([
        	[{v:result[0].deptCode,f:result[0].deptName},{v:result[0].topDept}],
        	[{v:result[1].deptCode,f:result[1].deptName},{v:result[1].topDept}],
        	[{v:result[2].deptCode,f:result[2].deptName},{v:result[2].topDept}],
        	[{v:result[3].deptCode,f:result[3].deptName},{v:result[3].topDept}],
        	[{v:result[4].deptCode,f:result[4].deptName},{v:result[4].topDept}],
        	[{v:result[5].deptCode,f:result[5].deptName},{v:result[5].topDept}],
        	[{v:result[6].deptCode,f:result[6].deptName},{v:result[6].topDept}],
        	
        ]);
        	/* [{v:'D', f:'출근<div style="color:red; font-style:italic">President</div>'},
           '', 'The President'],
          [{v:'Jim', f:'개발부<div style="color:red; font-style:italic">Vice President</div>'},
           'D', 'VP'],
          ['Alice', 'D', ''],
          ['Bob', 'Jim', 'Bob Sponge'],
          ['Carol', 'Bob', ''] */

        // Create the chart.
        var chart = new google.visualization.OrgChart(document.getElementById('chart_div'));
        // Draw the chart, setting the allowHtml option to true for the tooltips.
        chart.draw(data, {allowHtml:true});
      }
   </script>
<style>
	#chart_div div{
		width:30%;
		height:30%;
	}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/employee.jsp"/>
		<section class="col-sm-10">
			<h1 class="title">조직도</h1>
				 <div id="chart_div">
				    
				</div>
			<div class="content">
			</div>
		</section>
	</div>
	<jsp:include page="../common/footer.jsp" />
	
	
</body>
</html>