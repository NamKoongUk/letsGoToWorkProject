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
	.setting_title{
		position: relative;
    	padding: 20px 25px 0 23px;
    	min-width: 733px;
    	height: 60px;
    	border-bottom: 1px solid #f2f4f3;	
	}
	
	.setting_title h3{
		color: #333;
    	font-size: 16px;
	}
	
	.content_inbox{
		position: absolute;
	    top: 61px;
	    bottom: 0;
	    left: 0;
	    right: 0;
	    overflow: auto;
	}
	
	.cont_box{
		min-height: 400px;
	    min-width: 500px;
	    width: 100%;
	}
	
	.setting_field{
		padding: 30px 25px 0;
	}
	
	.tabType1{
		width: 100%;
	    overflow: hidden;
	    background: #f3f3f3;
	}
	
	.tabType1 li.on{
		background:#fff;
	}
	.tabType1 li.on a{
		font-weight:700;
	}
	.tabType-tax li a, .tabType1 li a{
		color:#333;
	}
	a{
		text-decoration:none;
	}
	ul, li{
		list-style:none;
	}
	
	div{
		display:block;
	}
	.tabType1 li{
		float: left;
	    margin: 5px 8px 0;
	    padding: 4px 12px;
	    text-align: center;
	}
	
	h3{
		display: block;
	    font-size: 1.17em;
	    margin-block-start: 1em;
	    margin-block-end: 1em;
	    margin-inline-start: 0px;
	    margin-inline-end: 0px;
	    font-weight: bold;
	}
	
	.red_color{
		color:red;
	}
	.blue_color{
		color:#2985db!important;
	}
	
	.line24{
		line-height: 24px;
	}
	
	.pdb_30{
		padding-bottom: 30px!important;
	}
	.tableType02 th{
		padding: 14px 14px;
	    border-bottom: 1px solid #dedede;
	    background: #f9f9f9;
	    color: #333;
	    font-weight: 400;
	}
	
	col{
		display: table-column;
	}
	
	table.sub_table1>tbody>tr:first-child>td{
		border-top:none;
	}
	
	tr {
	    display: table-row;
	    vertical-align: inherit;
	    border-color: inherit;
	}
	
	table.sub_table1 {
	    width: 100%;
	    table-layout: Fixed;
	}
	
	.tableType02 td{
		padding: 12px 0 12px 14px;
    	border-bottom: 1px solid #dedede;
	}
	
	.tableType02{
		width: 100%;
    	border-top: 1px solid #cdcdcd;
	}
	
	.bt_left{
		width: 100%;
	    padding: 20px 0 50px;
	    text-align: left;
	}
	
	.bt_left button{
		border: 1px solid #c8c8c8;
	    display: inline-block;
	    width: 80px;
	    padding: 4px 0 6px;
	    background: #fff;
	    color: #2c86dc;
	}
	
	
	

	
	
	
	

</style>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/employee.jsp"/>
		
		<section class="col-sm-10 sectionArea">
			<div class="setting_title">
				<h3>휴가 생성</h3>
			</div>
		
			<div class="content">
				
				<div class="content_inbox">
					<div class="cont_box">
						<div class="setting_field">
							<ul class="tabType1">
								<li class="on"><a href="javascript:void(0)">연차 휴가 생성</a></li>
							</ul>
							<ul class="line24 pdb_30" style="padding-top:30px;">
								<li>연차는 [휴가관리 - 기본 설정] 페이지에서 설정한 휴가 생성 조건에 따라 생성됩니다.</li>
								<li>오피스 생성 후 근태/휴가를 처음 사용하거나 수동 설정이 필요한 경우, 아래 확인 사항을 확인하시고 [지금 생성] 버튼을 클릭하여 연차를 수동 생성하세요.</li>
								<li class="red_color">* 연차 휴가는 휴가 생성 조건에서 설정한 생성 일자에 매년 1회 자동 생성되므로, 특별한 경우를 제외하고는 수동 생성할 필요가 없습니다.</li>	
							</ul>
							
							<table class="tableType02 date">
                        		<colgroup>
                            		<col width="100"><col>
                        		</colgroup>
		                        <tbody>
		                        	<tr>
		                           		<th scope="row">휴가 일수</th>
		                            	<td style="padding:0;">
											<table class="sub_table1">
												<tbody>
													<tr>
														<td class="center">N(입사연도)</td>
														<td class="center">N+1</td>
														<td class="center">N+2</td>
														<td class="center">N+3</td>
														<td class="center">N+4</td>
														<td class="center">N+5</td>
														<td class="center">N+6</td>
														<td class="center">N+7</td>
														<td class="center">N+8</td>
														<td class="center">N+9</td>
														<td class="center">N+10</td>
														<td class="center">N+11</td>
														<td class="center">N+12↑</td>
													</tr>
											<tr>
												<td class="center hol_date">0 일</td>
												<td class="center hol_date">16 일</td>
												<td class="center hol_date">17 일</td>
												<td class="center hol_date">18 일</td>
												<td class="center hol_date">19 일</td>
												<td class="center hol_date">20 일</td>
												<td class="center hol_date">20 일</td>
												<td class="center hol_date">20 일</td>
												<td class="center hol_date">20 일</td>
												<td class="center hol_date">20 일</td>
												<td class="center hol_date">20 일</td>
												<td class="center hol_date">20 일</td>
												<td class="center hol_date">20 일</td>
											</tr>
											</tbody>
										</table>
									</td>
		                        </tr>
		                        <tr>
		                            <th scope="row">확인 사항</th>
		                            <td>
		                                <p>아래 내용을 확인 후 체크해주세요.</p>
		                                <p class="gr_depth1 pdt_10">
		                                	<label>
			                                	<input type="checkbox" name="gnAbs1" id="regular_check_point1"> 
			                                   	 위 조건으로 전 직원의 연차 휴가를 생성(재설정)합니다.
		                                   	 </label>
		                                </p>
		                                <p class="gr_depth1 pdt_10">
			                                <label>
			                                	<input type="checkbox" name="gnAbs1" id="regular_check_point2"> 
			                                                                                  조직에 속하지 않거나 입사일이 입력되지 않은 사용자는 휴가가 생성되지 않습니다.
			                                </label>
		                                </p>
		                            </td>
		                        </tr>
		                    </tbody>
                    	</table>
                    	
                    	<div class="bt_left">
                        	<button type="button" onclick="holidayInsert()">지금 생성</button>
                    	</div>
						</div>
					</div>
				</div>
				
				
				
				
				
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
		
	<script>
		function holidayInsert(){
			
			if($("#regular_check_point1").prop('checked') == true && $("#regular_check_point2").prop('checked') == true){
				
			
			$.ajax({
				url:"holidayInsert.em",
				type:"post",
				success:function(data){
					console.log(data);
					if(data > 0){
						alert(data + "명의 휴가를 생성하였습니다.");
					}else if(data == 0){
						alert("휴가 생성 대상자가 없습니다.");
					}
				},
				error:function(status){
					
				}
			});
			
			}
		}
		
		
		
		
	</script>
</body>
</html>