<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LetsGoToWork</title>
<style>
	.head{
		background:#e8e8e8;
	}
	td{
		vertical-align:middle !important;
		font-size:7;
	}
	a{
		font-size:17px;
	}
	
</style>
</head>
<body>
	<jsp:include page="../../common/menubar.jsp"/>
	
	<div class="row wrap">
		<jsp:include page="../../common/sideMenu/approval.jsp"/>
		
		<section class="col-sm-10">
			<h2 class="title" align="center">${ requestScope.map.afName }</h2>
			
			<div class="content">
				<c:if test="${ sessionScope.loginEmp.empNo == requestScope.map.adWriter && requestScope.map.adRead == 'N' }">
					<a href="#" onclick="updateAd(${ requestScope.map.adNo });">수정하기</a> &nbsp; <a href="#" onclick="cancleAd(${ requestScope.map.adNo });">기안취소</a>
				</c:if>
				   
				<a href="#" class="pull-right" onclick="adCopy(${ requestScope.map.adNo });">기안복사</a>
					<table class="table table-bordered">
						<tr>
				        <td class="head">기안부서</td>
				        <td>
							<p>${ requestScope.map.deptName }</p>
						</td>
						<td class="head">기안자</td>
						<td>
							<p>${ requestScope.map.adWriterName }</p>
						</td>
				      </tr>
				       <tr>
				        <td class="head">문서번호</td>
				        <td>
							<p>${ requestScope.map.adNo }</p>
						</td>
						<td class="head">기안일자</td>
						<td>
							<p>${ requestScope.map.adStartDate }</p>
						</td>
				      </tr>
				      <tr>
				        <td class="head">보존기간</td>
				        <td>
							<p>${ requestScope.map.afDate }</p>
						</td>
						<td class="head">보안등급</td>
						<td>
							<p><c:out value="${ requestScope.map.securityCode }"/>등급</p>
						</td>
				      </tr>
					</table>
					<div id="signFormArea">
					
						<c:if test="${ requestScope.map.signCode == 'circle' }">
							<table class="table table-bordered">
								<tr>
									<td width="100px" style="background:#e8e8e8">회람</td>
									<td align="left" id="circleEmp">
										<c:forEach var="al" items="${ requestScope.map.appList }">
											<c:if test="${ sessionScope.loginEmp.empNo == al.alEmpNo && al.alStatus == '회람대기'}">
												<label>${ al.approvaler } <font color="yellowgreen" size="2px"><a href="#" onclick="updateConfirmDcm();">확인</a></font></label>&nbsp;&nbsp;
											</c:if>
											<c:if test="${ sessionScope.loginEmp.empNo == al.alEmpNo && al.alStatus == '결재'}">
												<label>${ al.approvaler } <font color="green" size="2px">완료</font></label>&nbsp;&nbsp;
											</c:if>
											<c:if test="${ sessionScope.loginEmp.empNo != al.alEmpNo && al.alStatus == '회람대기' }">
												<label>${ al.approvaler } <font color="red" size="2px">대기</font></label>&nbsp;&nbsp;
											</c:if>
											<c:if test="${ sessionScope.loginEmp.empNo != al.alEmpNo && al.alStatus == '결재' }">
												<label>${ al.approvaler } <font color="green" size="2px">완료</font></label>&nbsp;&nbsp;
											</c:if>
											
										</c:forEach>
									</td>
								</tr>
							</table>
						</c:if>
						
						<c:if test="${ requestScope.map.signCode == 'approvalSend' }">
							<table class="table table-bordered" style="text-align:center">
                                 <tr id="approvalJobName">
                                        <td rowspan="3" width="80px" style="background:#e8e8e8;">결재</td>
                                	 <c:forEach begin="0" end="7" step="1" varStatus="i">
                                    	<c:if test="${ fn:length(requestScope.appList.approval) > i.index }">
                                    		<td width="80px" height="20px">${ requestScope.appList.approval[i.index].jobName }</td>
                                    	</c:if>
                                    	<c:if test="${ fn:length(requestScope.appList.approval) <= i.index }">
                                    		<td width="80px" height="20px"></td>
                                    	</c:if>
                                    </c:forEach>
                                </tr>
                                <tr height="75px" id="approval">
                                     <c:forEach begin="0" end="7" step="1" varStatus="i">
                                    	<c:if test="${ fn:length(requestScope.appList.approval) > i.index }">
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.approval[i.index].alLevel && requestScope.appList.approval[i.index].alStatus == '대기'}">
                                    			<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal6">결재하기</button></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.approval[i.index].alLevel && requestScope.appList.approval[i.index].alStatus == '결재'}">
                                    			<td><font color="green">결재</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.approval[i.index].alLevel && requestScope.appList.approval[i.index].alStatus == '결재'}">
                                    		
                                    			<td><font color="green">결재</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.approval[i.index].alLevel && requestScope.appList.approval[i.index].alStatus != '결재'}">
                                    		
                                    			<td><font color="red">결재대기</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.approval[i.index].alLevel && requestScope.appList.approval[i.index].alStatus == '반려'}">
                                    			<td><font color="red">반려</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.approval[i.index].alLevel && requestScope.appList.approval[i.index].alStatus == '반려'}">
                                    		
                                    			<td><font color="red">반려</font></td>
                                    		</c:if>
                                    		<%-- <c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.approval[i.index].alLevel }">
                                    			<td><font color="red">결재대기</font></td>
                                    		</c:if> --%>
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo != sessionScope.loginEmp.empNo }">
	                                    		<c:if test="${ requestScope.appList.approval[i.index].alStatus == '대기' }">
	                                    			<td><font color="red">결재대기</font></td>
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.approval[i.index].alStatus == '결재' }">
	                                    			<td><font color="green">결재</font></td>
	                                    		</c:if>             
	                                    		<c:if test="${ requestScope.appList.approval[i.index].alStatus == '반려' }">
	                                    			<td><font color="red">반려</font></td>
	                                    		</c:if>                        			
                                    		</c:if>
                                    	</c:if>
                                    	<c:if test="${ fn:length(requestScope.appList.approval) <= i.index }">
                                    		<td width="80px" height="20px"></td>
                                    	</c:if>
                                    </c:forEach>
                                </tr>
                                <tr height="30px" id="approvalEmpName">
                                     <c:forEach begin="0" end="7" step="1" varStatus="i">
                                    	<c:if test="${ fn:length(requestScope.appList.approval) > i.index }">
                                    		<td width="80px" height="20px">${ requestScope.appList.approval[i.index].approvaler }</td>
                                    	</c:if>
                                    	<c:if test="${ fn:length(requestScope.appList.approval) <= i.index }">
                                    		<td width="80px" height="20px"></td>
                                    	</c:if>
                                    </c:forEach>
                                </tr>
                                <tr>
                                     <td style="background:#e8e8e8;">참조</td>
                                     <td style="text-align:left" colspan="8" id="refEmpName">
                                         <c:forEach begin="0" end="7" step="1" varStatus="i">
	                                    	<c:if test="${ fn:length(requestScope.appList.ref) > i.index }">
	                                    		<c:if test="${ requestScope.appList.ref[i.index].alEmpNo == sessionScope.loginEmp.empNo }">
	                                    			<c:out value="${ requestScope.appList.ref[i.index].approvaler }"/> &nbsp;
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.ref[i.index].alEmpNo != sessionScope.loginEmp.empNo }">
	                                    			<c:out value="${ requestScope.appList.ref[i.index].approvaler }"/> &nbsp;
	                                    		</c:if>
	                                    	</c:if>
	                                    	<%-- <c:if test="${ fn:length(requestScope.appList.ref) <= i.index }">
	                                    		<td width="80px" height="20px"></td>
	                                    	</c:if> --%>
                                    	</c:forEach>
                                     </td>
                                </tr>
                                <tr>
                                     <td style="background:#e8e8e8;">수신</td>
                                     <td style="text-align:left" colspan="8" id="sendEmpName">
                                         <c:forEach begin="0" end="7" step="1" varStatus="i">
                                    	<c:if test="${ fn:length(requestScope.appList.send) > i.index }">
                                    		<c:if test="${ requestScope.appList.send[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.send[i.index].alLevel && requestScope.appList.send[i.index].alStatus == '수신대기'}">
                                    			<label>${ requestScope.appList.send[i.index].approvaler } <font color="yellowgreen" size="2px"><a href="#" onclick="updateSendConfirmDcm();">확인</a></font></label>&nbsp;&nbsp;
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.send[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.send[i.index].alLevel && requestScope.appList.send[i.index].alStatus == '결재'}">
                                    			<label>${ requestScope.appList.send[i.index].approvaler } <font color="green" size="2px">완료</font></label>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.send[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.send[i.index].alLevel && requestScope.appList.send[i.index].alStatus == '결재'}">
                                    			<label>${ requestScope.appList.send[i.index].approvaler } <font color="green" size="2px">완료</font></label>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.send[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.send[i.index].alLevel && requestScope.appList.send[i.index].alStatus == '반려'}">
                                    			<td><font color="red">반려</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.send[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.send[i.index].alLevel && requestScope.appList.send[i.index].alStatus == '반려'}">
                                    		
                                    			<td><font color="red">반려</font></td>
                                    		</c:if>
                                    		<%-- <c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.approval[i.index].alLevel }">
                                    			<td><font color="red">결재대기</font></td>
                                    		</c:if> --%>
                                    		<c:if test="${ requestScope.appList.send[i.index].alEmpNo != sessionScope.loginEmp.empNo }">
	                                    		<c:if test="${ requestScope.appList.send[i.index].alStatus == '수신대기' }">
	                                    			<label>${ requestScope.appList.send[i.index].approvaler } <font color="red" size="2px">대기</font></label>
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.send[i.index].alStatus == '결재' }">
	                                    			<label>${ requestScope.appList.send[i.index].approvaler } <font color="green" size="2px">완료</font></label>
	                                    		</c:if>             
	                                    		<c:if test="${ requestScope.appList.send[i.index].alStatus == '반려' }">
	                                    			<label>${ requestScope.appList.send[i.index].approvaler } <font color="red" size="2px">반려</font></label>
	                                    		</c:if>                        			
                                    		</c:if>
                                    	</c:if>
                                    	<c:if test="${ fn:length(requestScope.appList.send) <= i.index }">
                                    		
                                    	</c:if>
                                    </c:forEach>
                                     </td>
                                </tr>
                        	</table>
						</c:if>
						
						<c:if test="${ requestScope.map.signCode == 'normalApproval' }">
							<table class="table table-bordered" style="text-align:center">
                                <tr id="approvalJobName">
                                        <td rowspan="3" width="80px" style="background:#e8e8e8;">결재</td>
                                	 <c:forEach begin="0" end="7" step="1" varStatus="i">
                                    	<c:if test="${ fn:length(requestScope.appList.approval) > i.index }">
                                    		<td width="80px" height="20px">${ requestScope.appList.approval[i.index].jobName }</td>
                                    	</c:if>
                                    	<c:if test="${ fn:length(requestScope.appList.approval) <= i.index }">
                                    		<td width="80px" height="20px"></td>
                                    	</c:if>
                                    </c:forEach>
                                </tr>
                                <tr height="75px" id="approval">
                                     <c:forEach begin="0" end="7" step="1" varStatus="i">
                                    	<c:if test="${ fn:length(requestScope.appList.approval) > i.index }">
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.approval[i.index].alLevel && requestScope.appList.approval[i.index].alStatus == '대기'}">
                                    			<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">결재하기</button></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.approval[i.index].alLevel && requestScope.appList.approval[i.index].alStatus == '결재'}">
                                    			<td><font color="green">결재</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.approval[i.index].alLevel && requestScope.appList.approval[i.index].alStatus == '결재'}">
                                    		
                                    			<td><font color="green">결재</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.approval[i.index].alLevel && requestScope.appList.approval[i.index].alStatus != '결재'}">
                                    		
                                    			<td><font color="red">결재대기</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.approval[i.index].alLevel && requestScope.appList.approval[i.index].alStatus == '반려'}">
                                    			<td><font color="red">반려</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.approval[i.index].alLevel && requestScope.appList.approval[i.index].alStatus == '반려'}">
                                    		
                                    			<td><font color="red">반려</font></td>
                                    		</c:if>
                                    		<%-- <c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.approval[i.index].alLevel }">
                                    			<td><font color="red">결재대기</font></td>
                                    		</c:if> --%>
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo != sessionScope.loginEmp.empNo }">
	                                    		<c:if test="${ requestScope.appList.approval[i.index].alStatus == '대기' }">
	                                    			<td><font color="red">결재대기</font></td>
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.approval[i.index].alStatus == '결재' }">
	                                    			<td><font color="green">결재</font></td>
	                                    		</c:if>             
	                                    		<c:if test="${ requestScope.appList.approval[i.index].alStatus == '반려' }">
	                                    			<td><font color="red">반려</font></td>
	                                    		</c:if>                        			
                                    		</c:if>
                                    	</c:if>
                                    	<c:if test="${ fn:length(requestScope.appList.approval) <= i.index }">
                                    		<td width="80px" height="20px"></td>
                                    	</c:if>
                                    </c:forEach>
                                </tr>
                                <tr height="30px" id="approvalEmpName">
                                     <c:forEach begin="0" end="7" step="1" varStatus="i">
                                    	<c:if test="${ fn:length(requestScope.appList.approval) > i.index }">
                                    		<td width="80px" height="20px">${ requestScope.appList.approval[i.index].approvaler }</td>
                                    	</c:if>
                                    	<c:if test="${ fn:length(requestScope.appList.approval) <= i.index }">
                                    		<td width="80px" height="20px"></td>
                                    	</c:if>
                                    </c:forEach>
                                </tr>
                                <tr id="agreeEmpList">
                                        <td style="background:#e8e8e8;">합의</td>
                                        <c:forEach begin="0" end="7" step="1" varStatus="i">
	                                    	<c:if test="${ fn:length(requestScope.appList.agree) > i.index }">
	                                    		<c:if test="${ requestScope.appList.agree[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adStatus == '합의대기' && requestScope.appList.agree[i.index].alStatus == '합의대기' }">
	                                    			<td width="80px" height="20px">
	                                    				<c:out value="${ requestScope.appList.agree[i.index].approvaler }"/>
	                                    				<a href="#" data-toggle="modal" data-target="#myModal2" ><font color="yellowgreen" size="2px"> 확인</font></a>
	                                    			</td>
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.agree[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adStatus != '합의대기' && requestScope.appList.agree[i.index].alStatus == '합의대기' }">
	                                    			<td width="80px" height="20px">
	                                    				<c:out value="${ requestScope.appList.agree[i.index].approvaler }"/>
	                                    				${ requestScope.appList.agree[i.index].approvaler } <font size="2px" color="red">대기</font>
	                                    			</td>
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.agree[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adStatus == '합의대기' && requestScope.appList.agree[i.index].alStatus == '결재' }">
	                                    			<td width="80px" height="20px">
		                                    				<c:out value="${ requestScope.appList.agree[i.index].approvaler }"/> <font size="2px" color="blue">결재</font>
	                                    			</td>
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.agree[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adStatus != '합의대기' && requestScope.appList.agree[i.index].alStatus == '결재' }">
	                                    			<td width="80px" height="20px">
		                                    				<c:out value="${ requestScope.appList.agree[i.index].approvaler }"/> <font size="2px" color="blue">결재</font>
	                                    			</td>
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.agree[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.agree[i.index].alLevel && requestScope.appList.agree[i.index].alStatus == '반려'}">
                                    				<td><c:out value="${ requestScope.appList.agree[i.index].approvaler }"/> <font size="2px" color="red">반려</font></td>
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.agree[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.agree[i.index].alLevel && requestScope.appList.agree[i.index].alStatus == '반려'}">
	                                    		
	                                    			<td><c:out value="${ requestScope.appList.agree[i.index].approvaler }"/> <font size="2px" color="red">반려</font></td>
	                                    		</c:if>
	                                    		<%-- <c:if test="${ requestScope.appList.agree[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adStatus == '반려' }">
	                                    			<td width="80px" height="20px">
		                                    				${ requestScope.appList.agree[i.index].approvaler } <font size="2px" color="red">반려</font>
	                                    			</td>
	                                    		</c:if> --%>
	                                    		<%-- <c:if test="${ requestScope.appList.agree[i.index].alEmpNo != sessionScope.loginEmp.empNo && requestScope.map.adStatus == '합의대기' }">
	                                    			<td width="80px" height="20px">
		                                    				${ requestScope.appList.agree[i.index].approvaler } <font size="2px" color="red">대기</font>
	                                    			</td>
	                                    		</c:if> --%>
	                                    		<c:if test="${ requestScope.appList.agree[i.index].alEmpNo != sessionScope.loginEmp.empNo }">
	                                    			<c:if test="${ requestScope.appList.agree[i.index].alStatus == '합의대기' }">
		                                    			<td width="80px" height="20px">
		                                    				${ requestScope.appList.agree[i.index].approvaler } <font size="2px" color="red">대기</font>
		                                    			</td>
	                                    			</c:if>
	                                    			<c:if test="${ requestScope.appList.agree[i.index].alStatus == '결재' }">
		                                    			<td width="80px" height="20px">
		                                    				${ requestScope.appList.agree[i.index].approvaler } 
		                                    				<font color="blue" size="2px"> 완료</font>
		                                    			</td>
	                                    			</c:if>
	                                    		</c:if>
	                                    		
	                                    	</c:if>
	                                    	<c:if test="${ fn:length(requestScope.appList.agree) <= i.index }">
	                                    		<td width="80px" height="20px"></td>
	                                    	</c:if>
                                    	</c:forEach>
                                </tr>
                                <tr>
                                     <td style="background:#e8e8e8;">참조</td>
                                     <td style="text-align:left" colspan="8" id="refEmpName">
                                         <c:forEach begin="0" end="7" step="1" varStatus="i">
	                                    	<c:if test="${ fn:length(requestScope.appList.ref) > i.index }">
	                                    		<c:if test="${ requestScope.appList.ref[i.index].alEmpNo == sessionScope.loginEmp.empNo }">
	                                    			<c:out value="${ requestScope.appList.ref[i.index].approvaler }"/> <font size="2px" color="yellowgreen"></font> &nbsp;
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.ref[i.index].alEmpNo != sessionScope.loginEmp.empNo }">
	                                    			<c:out value="${ requestScope.appList.ref[i.index].approvaler }"/> &nbsp;
	                                    		</c:if>
	                                    	</c:if>
	                                    	<%-- <c:if test="${ fn:length(requestScope.appList.ref) <= i.index }">
	                                    		<td width="80px" height="20px"></td>
	                                    	</c:if> --%>
                                    	</c:forEach>
                                     </td>
                                </tr>
                       		 </table>	
						</c:if>
						
						<c:if test="${ requestScope.map.signCode == 'agreementApproval' }">
							<table class="table table-bordered" style="text-align:center"> 
								<tr id="approvalJobName">
                                     <td rowspan="3" width="80px" style="background:#e8e8e8;">결재</td>
                                	 <c:forEach begin="0" end="7" step="1" varStatus="i">
                                    	<c:if test="${ fn:length(requestScope.appList.approval) > i.index }">
                                    		<td width="80px" height="20px">${ requestScope.appList.approval[i.index].jobName }</td>
                                    	</c:if>
                                    	<c:if test="${ fn:length(requestScope.appList.approval) <= i.index }">
                                    		<td width="80px" height="20px"></td>
                                    	</c:if>
                                    </c:forEach>
                                </tr>
                                <tr height="75px" id="approval">
                                     <c:forEach begin="0" end="7" step="1" varStatus="i">
                                    	<c:if test="${ fn:length(requestScope.appList.approval) > i.index }">
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.approval[i.index].alLevel && requestScope.appList.approval[i.index].alStatus == '대기'}">
                                    			<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">결재하기</button></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.approval[i.index].alLevel && requestScope.appList.approval[i.index].alStatus == '결재'}">
                                    			<td><font color="green">결재완료</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.approval[i.index].alLevel && requestScope.appList.approval[i.index].alStatus == '결재'}">
                                    		
                                    			<td><font color="green">결재완료</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.approval[i.index].alLevel && requestScope.appList.approval[i.index].alStatus != '결재'}">
                                    		
                                    			<td><font color="red">결재대기</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.approval[i.index].alLevel && requestScope.appList.approval[i.index].alStatus == '반려'}">
                                    			<td><font color="red">반려</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.approval[i.index].alLevel && requestScope.appList.approval[i.index].alStatus == '반려'}">
                                    		
                                    			<td><font color="red">반려</font></td>
                                    		</c:if>
                                    		<%-- <c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.approval[i.index].alLevel }">
                                    			<td><font color="red">결재대기</font></td>
                                    		</c:if> --%>
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo != sessionScope.loginEmp.empNo }">
	                                    		<c:if test="${ requestScope.appList.approval[i.index].alStatus == '대기' }">
	                                    			<td><font color="red">결재대기</font></td>
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.approval[i.index].alStatus == '결재' }">
	                                    			<td><font color="green">결재완료</font></td>
	                                    		</c:if>             
	                                    		<c:if test="${ requestScope.appList.approval[i.index].alStatus == '반려' }">
	                                    			<td><font color="red">반려</font></td>
	                                    		</c:if>                        			
                                    		</c:if>
                                    	</c:if>
                                    	<c:if test="${ fn:length(requestScope.appList.approval) <= i.index }">
                                    		<td width="80px" height="20px"></td>
                                    	</c:if>
                                    </c:forEach>
                                </tr>
                                <tr height="30px" id="approvalEmpName">
                                     <c:forEach begin="0" end="7" step="1" varStatus="i">
                                    	<c:if test="${ fn:length(requestScope.appList.approval) > i.index }">
                                    		<td width="80px" height="20px">${ requestScope.appList.approval[i.index].approvaler }</td>
                                    	</c:if>
                                    	<c:if test="${ fn:length(requestScope.appList.approval) <= i.index }">
                                    		<td width="80px" height="20px"></td>
                                    	</c:if>
                                    </c:forEach>
                                </tr> 
                                <tr id="payAgreeJobName"> 
                                	<td style="background:#e8e8e8;" rowspan="3">재무합의</td> 
                                	<c:forEach begin="0" end="7" step="1" varStatus="i">
                                    	<c:if test="${ fn:length(requestScope.appList.payAgree) > i.index }">
                                    		<td width="80px" height="20px">${ requestScope.appList.payAgree[i.index].jobName }</td>
                                    	</c:if>
                                    	<c:if test="${ fn:length(requestScope.appList.payAgree) <= i.index }">
                                    		<td width="80px" height="20px"></td>
                                    	</c:if>
                                    </c:forEach>
                                </tr>
                                <tr height="75px" id="payAgreeApproval">
	                                <c:forEach begin="0" end="7" step="1" varStatus="i">
                                    	<c:if test="${ fn:length(requestScope.appList.payAgree) > i.index }">
                                    		<c:if test="${ requestScope.appList.payAgree[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.payAgree[i.index].alLevel && requestScope.appList.payAgree[i.index].alStatus == '재무합의대기' }">
                                    			<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal3">결재하기</button></td>
                                    		</c:if>
                                    		<%-- <c:if test="${ requestScope.appList.payAgree[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.payAgree[i.index].alLevel && requestScope.appList.payAgree[i.index].alStatus != '결재' }">
                                    			<td><font color="red">결재대기</font></td>
                                    		</c:if> --%>
                                    		<c:if test="${ requestScope.appList.payAgree[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.payAgree[i.index].alLevel && requestScope.appList.payAgree[i.index].alStatus == '결재' }">
                                    			<td><font color="green">결재완료</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.payAgree[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.payAgree[i.index].alLevel && requestScope.appList.payAgree[i.index].alStatus == '결재' }">
                                    			<td><font color="green">결재완료</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.payAgree[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.payAgree[i.index].alLevel && requestScope.appList.payAgree[i.index].alStatus != '결재' }">
                                    			<td><font color="red">결재대기</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.payAgree[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.payAgree[i.index].alLevel && requestScope.appList.payAgree[i.index].alStatus == '반려'}">
                                    			<td><font color="red">반려</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.payAgree[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.payAgree[i.index].alLevel && requestScope.appList.payAgree[i.index].alStatus == '반려'}">
                                    		
                                    			<td><font color="red">반려</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.payAgree[i.index].alEmpNo != sessionScope.loginEmp.empNo }">
	                                    		<c:if test="${ requestScope.appList.payAgree[i.index].alStatus == '재무합의대기' }">
	                                    			<td><font color="red">결재대기</font></td>
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.payAgree[i.index].alStatus == '결재' }">
	                                    			<td><font color="green">결재완료</font></td>
	                                    		</c:if>                   
	                                    		<c:if test="${ requestScope.appList.payAgree[i.index].alStatus == '반려' }">
	                                    			<td><font color="red">반려</font></td>
	                                    		</c:if>                     			
                                    		</c:if>
                                    	</c:if>
                                    	<c:if test="${ fn:length(requestScope.appList.payAgree) <= i.index }">
                                    		<td width="80px" height="20px"></td>
                                    	</c:if>
                                    </c:forEach>
                                </tr>
                                <tr height="30px" id="payAgreeEmpName">
                                	<c:forEach begin="0" end="7" step="1" varStatus="i">
                                    	<c:if test="${ fn:length(requestScope.appList.payAgree) > i.index }">
                                    		<td width="80px" height="20px">${ requestScope.appList.payAgree[i.index].approvaler }</td>
                                    	</c:if>
                                    	<c:if test="${ fn:length(requestScope.appList.payAgree) <= i.index }">
                                    		<td width="80px" height="20px"></td>
                                    	</c:if>
                                    </c:forEach>
                                </tr>
                                <tr id="agreeEmpList">
                                	<td style="background:#e8e8e8;">합의</td>
                                	<c:forEach begin="0" end="7" step="1" varStatus="i">
	                                    	<c:if test="${ fn:length(requestScope.appList.agree) > i.index }">
	                                    		<c:if test="${ requestScope.appList.agree[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adStatus == '합의대기' && requestScope.appList.agree[i.index].alStatus == '합의대기' }">
	                                    			<td width="80px" height="20px">
	                                    				<c:out value="${ requestScope.appList.agree[i.index].approvaler }"/>
	                                    				<a href="#" data-toggle="modal" data-target="#myModal2" ><font color="yellowgreen" size="2px"> 확인</font></a>
	                                    			</td>
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.agree[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adStatus != '합의대기' && requestScope.appList.agree[i.index].alStatus == '합의대기' }">
	                                    			<td width="80px" height="20px">
	                                    				<c:out value="${ requestScope.appList.agree[i.index].approvaler }"/>
	                                    				${ requestScope.appList.agree[i.index].approvaler } <font size="2px" color="red">대기</font>
	                                    			</td>
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.agree[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adStatus == '합의대기' && requestScope.appList.agree[i.index].alStatus == '결재' }">
	                                    			<td width="80px" height="20px">
		                                    				<c:out value="${ requestScope.appList.agree[i.index].approvaler }"/> <font size="2px" color="blue">결재</font>
	                                    			</td>
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.agree[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adStatus != '합의대기' && requestScope.appList.agree[i.index].alStatus == '결재' }">
	                                    			<td width="80px" height="20px">
		                                    				<c:out value="${ requestScope.appList.agree[i.index].approvaler }"/> <font size="2px" color="blue">결재</font>
	                                    			</td>
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.agree[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adStatus == '합의대기' && requestScope.appList.agree[i.index].alStatus == '반려' }">
	                                    			<td width="80px" height="20px">
		                                    				<c:out value="${ requestScope.appList.agree[i.index].approvaler }"/> <font size="2px" color="red">반려</font>
	                                    			</td>
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.agree[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adStatus != '합의대기' && requestScope.appList.agree[i.index].alStatus == '반려' }">
	                                    			<td width="80px" height="20px">
		                                    				<c:out value="${ requestScope.appList.agree[i.index].approvaler }"/> <font size="2px" color="red">반려</font>
	                                    			</td>
	                                    		</c:if>
	                                    		
	                                    		<c:if test="${ requestScope.appList.agree[i.index].alEmpNo != sessionScope.loginEmp.empNo }">
	                                    			<c:if test="${ requestScope.appList.agree[i.index].alStatus == '합의대기' }">
		                                    			<td width="80px" height="20px">
		                                    				${ requestScope.appList.agree[i.index].approvaler } <font size="2px" color="red">대기</font>
		                                    			</td>
	                                    			</c:if>
	                                    			<c:if test="${ requestScope.appList.agree[i.index].alStatus == '결재' }">
		                                    			<td width="80px" height="20px">
		                                    				${ requestScope.appList.agree[i.index].approvaler } 
		                                    				<font color="blue" size="2px"> 완료</font>
		                                    			</td>
	                                    			</c:if>
	                                    		</c:if>
	                                    		
	                                    	</c:if>
	                                    	<c:if test="${ fn:length(requestScope.appList.agree) <= i.index }">
	                                    		<td width="80px" height="20px"></td>
	                                    	</c:if>
                                    	</c:forEach>
                                </tr> 
                                <tr>
                                	<td style="background:#e8e8e8;">참조</td>
                                     <td style="text-align:left" colspan="8" id="refEmpName">
                                         <c:forEach begin="0" end="7" step="1" varStatus="i">
	                                    	<c:if test="${ fn:length(requestScope.appList.ref) > i.index }">
	                                    		<c:if test="${ requestScope.appList.ref[i.index].alEmpNo == sessionScope.loginEmp.empNo }">
	                                    			<c:out value="${ requestScope.appList.ref[i.index].approvaler }"/> &nbsp;
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.ref[i.index].alEmpNo != sessionScope.loginEmp.empNo }">
	                                    			<c:out value="${ requestScope.appList.ref[i.index].approvaler }"/> &nbsp;
	                                    		</c:if>
	                                    	</c:if>
                                    	</c:forEach>
                                     </td>
                                </tr>
                             </table>
						</c:if>
						<c:if test="${ requestScope.map.signCode == 'applyDcm' }">
							<table class="table table-bordered" style="text-align:center">
                                <tr id="applyJobName">
                                        <td rowspan="3" width="80px" style="background:#e8e8e8;">신청</td>
                                     <c:forEach begin="0" end="7" step="1" varStatus="i">
                                    	<c:if test="${ fn:length(requestScope.appList.apply) > i.index }">
                                    		<td width="80px" height="20px">${ requestScope.appList.apply[i.index].jobName }</td>
                                    	</c:if>
                                    	<c:if test="${ fn:length(requestScope.appList.apply) <= i.index }">
                                    		<td width="80px" height="20px"></td>
                                    	</c:if>
                                    </c:forEach>                                    
                                </tr>
                                <tr height="75px" id="applyApproval">
                                        <c:forEach begin="0" end="7" step="1" varStatus="i">
                                    	<c:if test="${ fn:length(requestScope.appList.apply) > i.index }">
                                    		<c:if test="${ requestScope.appList.apply[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.apply[i.index].alLevel && requestScope.appList.apply[i.index].alStatus == '대기' }">
                                    			<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal4">결재하기</button></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.apply[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.apply[i.index].alLevel && requestScope.appList.apply[i.index].alStatus == '대기' }">
                                    			<td><font color="red">결재대기</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.apply[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.apply[i.index].alLevel && requestScope.appList.apply[i.index].alStatus == '반려'}">
                                    			<td><font color="red">반려</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.apply[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.apply[i.index].alLevel && requestScope.appList.apply[i.index].alStatus == '반려'}">
                                    		
                                    			<td><font color="red">반려</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.apply[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adStatus == '대기' && requestScope.appList.apply[i.index].alStatus == '결재' }">
	                                    			<td width="80px" height="20px">
		                                    			<font size="2px" color="green">결재완료</font>
	                                    			</td>
	                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.apply[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adStatus != '대기' && requestScope.appList.apply[i.index].alStatus == '결재' }">
                                    			<td width="80px" height="20px">
	                                    				<font size="2px" color="green">결재완료</font>
                                    			</td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.apply[i.index].alEmpNo != sessionScope.loginEmp.empNo }">
	                                    		<c:if test="${ requestScope.appList.payAgree[i.index].alStatus == '대기' }">
	                                    			<td><font color="red">결재대기</font></td>
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.apply[i.index].alStatus == '결재' }">
	                                    			<td><font color="green">결재</font></td>
	                                    		</c:if> 
	                                    		<c:if test="${ requestScope.appList.apply[i.index].alStatus == '반려' }">
	                                    			<td><font color="green">반려</font></td>
	                                    		</c:if>                                    			
                                    		</c:if>
                                    	</c:if>
                                    	<c:if test="${ fn:length(requestScope.appList.apply) <= i.index }">
                                    		<td width="80px" height="20px"></td>
                                    	</c:if>
                                    </c:forEach>
                                </tr>
                                <tr height="30px" id="applyEmpName">
                                     <c:forEach begin="0" end="7" step="1" varStatus="i">
                                    	<c:if test="${ fn:length(requestScope.appList.apply) > i.index }">
                                    		<td width="80px" height="20px">${ requestScope.appList.apply[i.index].approvaler }</td>
                                    	</c:if>
                                    	<c:if test="${ fn:length(requestScope.appList.apply) <= i.index }">
                                    		<td width="80px" height="20px"></td>
                                    	</c:if>
                                    </c:forEach>
                                </tr>
                                 <tr id="processJobName">
                                        <td rowspan="3" width="80px" style="background:#e8e8e8;">처리</td>
                                        <c:forEach begin="0" end="7" step="1" varStatus="i">
	                                    	<c:if test="${ fn:length(requestScope.appList.process) > i.index }">
	                                    		<td width="80px" height="20px">${ requestScope.appList.process[i.index].jobName }</td>
	                                    	</c:if>
	                                    	<c:if test="${ fn:length(requestScope.appList.process) <= i.index }">
	                                    		<td width="80px" height="20px"></td>
	                                    	</c:if>
                                   		</c:forEach>                                       
                                </tr>
                                <tr height="75px" id="processApproval">
                                     <c:forEach begin="0" end="7" step="1" varStatus="i">
                                    	<c:if test="${ fn:length(requestScope.appList.process) > i.index }">
                                    		<c:if test="${ requestScope.appList.process[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.process[i.index].alLevel && requestScope.appList.process[i.index].alStatus == '처리대기'}">
                                    			<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">결재하기</button></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.process[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.process[i.index].alLevel && requestScope.appList.process[i.index].alStatus == '결재'}">
                                    			<td><font color="green">결재완료</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.process[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.process[i.index].alLevel && requestScope.appList.process[i.index].alStatus == '결재'}">
                                    		
                                    			<td><font color="green">결재완료</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.process[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.process[i.index].alLevel && requestScope.appList.process[i.index].alStatus != '결재'}">
                                    		
                                    			<td><font color="red">결재대기</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.process[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.process[i.index].alLevel && requestScope.appList.process[i.index].alStatus == '반려'}">
                                    			<td><font color="red">반려</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.process[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.process[i.index].alLevel && requestScope.appList.process[i.index].alStatus == '반려'}">
                                    		
                                    			<td><font color="red">반려</font></td>
                                    		</c:if>
                                    		<%-- <c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.approval[i.index].alLevel }">
                                    			<td><font color="red">결재대기</font></td>
                                    		</c:if> --%>
                                    		<c:if test="${ requestScope.appList.process[i.index].alEmpNo != sessionScope.loginEmp.empNo }">
	                                    		<c:if test="${ requestScope.appList.process[i.index].alStatus == '처리대기' }">
	                                    			<td><font color="red">결재대기</font></td>
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.process[i.index].alStatus == '결재' }">
	                                    			<td><font color="green">결재완료</font></td>
	                                    		</c:if>             
	                                    		<c:if test="${ requestScope.appList.process[i.index].alStatus == '반려' }">
	                                    			<td><font color="red">반려</font></td>
	                                    		</c:if>                        			
                                    		</c:if>
                                    	</c:if>
                                    	<c:if test="${ fn:length(requestScope.appList.process) <= i.index }">
                                    		<td width="80px" height="20px"></td>
                                    	</c:if>
                                    </c:forEach>

                                </tr>
                                <tr height="30px" id="processEmpName">
                                     <c:forEach begin="0" end="7" step="1" varStatus="i">
                                    	<c:if test="${ fn:length(requestScope.appList.process) > i.index }">
                                    		<td width="80px" height="20px">${ requestScope.appList.process[i.index].approvaler }</td>
                                    	</c:if>
                                    	<c:if test="${ fn:length(requestScope.appList.process) <= i.index }">
                                    		<td width="80px" height="20px"></td>
                                    	</c:if>
                                    </c:forEach>

                                </tr>
                                <tr>
                                    <td style="background:#e8e8e8;">참조</td>
                                     <td style="text-align:left" colspan="8" id="refEmpName">
                                         <c:forEach begin="0" end="7" step="1" varStatus="i">
	                                    	<c:if test="${ fn:length(requestScope.appList.ref) > i.index }">
	                                    		<c:if test="${ requestScope.appList.ref[i.index].alEmpNo == sessionScope.loginEmp.empNo }">
	                                    			<c:out value="${ requestScope.appList.ref[i.index].approvaler }"/> &nbsp;
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.ref[i.index].alEmpNo != sessionScope.loginEmp.empNo }">
	                                    			<c:out value="${ requestScope.appList.ref[i.index].approvaler }"/> &nbsp;
	                                    		</c:if>
	                                    	</c:if>
                                    	</c:forEach>
                                     </td>
                                </tr>
                        </table>
                      </c:if>
					  <c:if test="${ requestScope.map.attachmentNo != null }">
					 	<table class="table table-bordered">
					 		<tr>
					 			<td class="head" style="width:100px;">첨부파일</td>
					 			<td>
						 			<label style="margin-right:10px;"><c:out value="${ requestScope.map.originName }"/></label>
						 			<button class="btn" onclick="location.href='${contextPath}/downloadFile.ap?adNo=${ requestScope.map.adNo }'">다운로드</button>
					 			</td>
					 		</tr>
					 	</table>					  
					  </c:if>	
						
					</div>
					
					
					<div id="area">
						<label>제목 : ${ requestScope.map.adTitle }</label>
					    <div>${ requestScope.map.adContent }</div>
		 				<br><br>
					</div>
					
			</div>
			<div id="commentArea" style="border:1px solid lightgray" class="row">
			    <div class="form-group" style="padding:20px;">
			      <label for="comment" style="display:block;">댓글작성 : </label>
			      <textarea class="form-control" rows="3" id="replyContent" style="resize:none;"></textarea>
			      <button class="btn pull-right" style="display:block; margin-top:10px; margin-bottom:10px;" onclick="writeReply();">작성하기</button>
			    </div>
			    <c:forEach var="reply" items="${ requestScope.appList.reply }">
			    	<div class="media" style="padding:30px; width:100%;">
					    <div class="media-body">
					      <input type="hidden" value="${ reply.arNo }">
					      <label class="media-heading"><c:out value="${ reply.empName }"/></label>  &nbsp;  <span style="color:gray"><c:out value="${ reply.arDate }"/></span>
					      <c:if test="${ reply.empNo == sessionScope.loginEmp.empNo }">
					      	<a href="#" class="pull-right deleteReply">댓글삭제</a><a href="#" class="pull-right updateReply" style="margin-right:10px;">댓글수정</a> 
					      </c:if>
					      <p><c:out value="${ reply.arContent }"/></p>
					    </div>
					     <hr>
			    	</div>
			    </c:forEach>
			</div>
			    <br><br><br><br><br><br><br>
		
		</section>
	</div>
	
	<!-- Modal -->
	<div id="myModal" class="modal fade" role="dialog">
	  <div class="modal-dialog">
	
	    <!-- Modal content-->
	    <div class="modal-content" style="width:300px;">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title">결재</h4>
	      </div>
	      <div class="modal-body" align="center">
	      	<h6>결재 또는 반려를 선택해주세요</h6>
	        <label class="radio-inline"><input type="radio" name="approve" value="결재" checked>결재</label>
	        <label class="radio-inline"><input type="radio" name="approve" value="반려">반려</label>
	      </div>
	      <div class="modal-footer">
	      	<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="updateApproval();">확인</button>
	        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
	      </div>
	    </div>
	
	  </div>
	</div>
	
	<!-- Modal -->
	<div id="myModal2" class="modal fade" role="dialog">
	  <div class="modal-dialog">
	
	    <!-- Modal content-->
	    <div class="modal-content" style="width:300px;">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title">결재</h4>
	      </div>
	      <div class="modal-body" align="center">
	      	<h6>결재 또는 반려를 선택해주세요</h6>
	        <label class="radio-inline"><input type="radio" name="agree" value="결재" checked>결재</label>
	        <label class="radio-inline"><input type="radio" name="agree" value="반려">반려</label>
	      </div>
	      <div class="modal-footer">
	      	<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="updateAgree();">확인</button>
	        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
	      </div>
	    </div>
	
	  </div>
	</div>
	
	<!-- Modal -->
	<div id="myModal3" class="modal fade" role="dialog">
	  <div class="modal-dialog">
	
	    <!-- Modal content-->
	    <div class="modal-content" style="width:300px;">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title">결재</h4>
	      </div>
	      <div class="modal-body" align="center">
	      	<h6>결재 또는 반려를 선택해주세요</h6>
	        <label class="radio-inline"><input type="radio" name="payAgree" value="결재" checked>결재</label>
	        <label class="radio-inline"><input type="radio" name="payAgree" value="반려">반려</label>
	      </div>
	      <div class="modal-footer">
	      	<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="updatePayAgree();">확인</button>
	        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
	      </div>
	    </div>
	
	  </div>
	</div>
	
	
	
	<!-- Modal -->
	<div id="myModal4" class="modal fade" role="dialog">
	  <div class="modal-dialog">
	
	    <!-- Modal content-->
	    <div class="modal-content" style="width:300px;">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title">결재</h4>
	      </div>
	      <div class="modal-body" align="center">
	      	<h6>결재 또는 반려를 선택해주세요</h6>
	        <label class="radio-inline"><input type="radio" name="apply" value="결재" checked>결재</label>
	        <label class="radio-inline"><input type="radio" name="apply" value="반려">반려</label>
	      </div>
	      <div class="modal-footer">
	      	<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="updateApply();">확인</button>
	        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
	      </div>
	    </div>
	
	  </div>
	</div>
	
	<!-- Modal -->
	<div id="myModal5" class="modal fade" role="dialog">
	  <div class="modal-dialog">
	
	    <!-- Modal content-->
	    <div class="modal-content" style="width:300px;">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title">결재</h4>
	      </div>
	      <div class="modal-body" align="center">
	      	<h6>결재 또는 반려를 선택해주세요</h6>
	        <label class="radio-inline"><input type="radio" name="process" value="결재" checked>결재</label>
	        <label class="radio-inline"><input type="radio" name="process" value="반려">반려</label>
	      </div>
	      <div class="modal-footer">
	      	<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="updateProcees();">확인</button>
	        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
	      </div>
	    </div>
	
	  </div>
	</div>
	
	<div id="myModal6" class="modal fade" role="dialog">
	  <div class="modal-dialog">
	
	    <!-- Modal content-->
	    <div class="modal-content" style="width:300px;">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title">결재</h4>
	      </div>
	      <div class="modal-body" align="center">
	      	<h6>결재 또는 반려를 선택해주세요</h6>
	        <label class="radio-inline"><input type="radio" name="approve" value="결재" checked>결재</label>
	        <label class="radio-inline"><input type="radio" name="approve" value="반려">반려</label>
	      </div>
	      <div class="modal-footer">
	      	<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="updateSendApproval();">확인</button>
	        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
	      </div>
	    </div>
	
	  </div>
	</div>
	
	<script>
		function adCopy(adNo){
			location.href="${contextPath}/copyAd.ap?adNo=" + adNo;
		}
		
		function updateAd(adNo){
			location.href="${contextPath}/updateAd.ap?adNo=" + adNo;
		}
		
		function cancleAd(adNo){			
			if(confirm("정말로 취소하시겠습니까?(취소한 기안문서는 임시저장함에 저장됩니다)")){
				location.href="${contextPath}/cancleAd.ap?adNo=" + adNo;				
			}
		}
	
		$(".deleteReply").click(function(){
			var arNo = $(this).parents().children().eq(0).val();
			
			console.log(arNo);
						
			var object = {
						arNo:arNo
			}

			$.ajax({
				url:"${contextPath}/approval/deleteReply",
				data: JSON.stringify(object),
				contentType: 'application/json; charset=utf-8',
				type:"post",
				success:function(data){
					
					if(data == '성공') {
						alert("정상적으로 삭제되었습니다.");
					}else {
						alert("삭제에 실패했습니다.");
					}
					location.reload();
					
				}
			});
			
		});
		
		$(".updateReply").click(function(){
			
			var $div = $("<div class='instant'>")
			var $textArea = $('<textarea class="form-control updateText" rows="3" style="resize:none;">');
			var $btn = $('<button class="btn pull-right update" style="display:inline-block; margin-top:10px;">수정하기</button>');
			var $cancleBtn = $('<button class="btn pull-right cancle" style="margin-right:10px; display:inline-block; margin-top:10px;" onclick="update();">취소</button>');
			
			var content = $(this).parent().find("p").text();
			$(this).parent().find("p").remove();
			$textArea.append(content);
			
			$div.append($textArea);
			$div.append($btn);
			$div.append($cancleBtn);
			
			$(this).parent().append($div);
			
			var offset = $(".updateText").offset();
			$('html, body').animate({scrollTop : offset.top}, 1);
			
			$(".updateText").focus();
			
			$(".cancle").click(function(){
				alert("취소되었습니다.");
				location.reload();
			});
			
			$(".update").click(function(){
				var arNo = $(this).parent().parent().children().eq(0).val();
				var text = $(this).parent().children().eq(0).val();
				
				console.log(text);
				
				var object = {
						text:text,
						arNo:arNo
				}

				$.ajax({
					url:"${contextPath}/approval/updateReply",
					data: JSON.stringify(object),
					contentType: 'application/json; charset=utf-8',
					type:"post",
					success:function(data){
						
						if(data == '성공') {
							alert("정상적으로 수정되었습니다.");
						}else {
							alert("수정이 실패했습니다.");
						}
						location.reload();
						
					}
				});
			});
		});
		
		
		
	
		function writeReply(){
			var content = $("#replyContent").val();
			var adNo = '${ requestScope.map.adNo }';
			
			var object = {
					content:content,
					adNo:adNo
			}
			
			$.ajax({
				url:"${contextPath}/approval/writeReply",
				data: JSON.stringify(object),
				contentType: 'application/json; charset=utf-8',
				type:"post",
				success:function(data){
					
					if(data == '성공') {
						alert("정상적으로 작성되었습니다.");
					}else {
						alert("작성이 실패했습니다.");
					}
					location.reload();
					
				}
			});
			
		}
	
	
		function updateSendApproval(){
			var empNo = "${sessionScope.loginEmp.empNo}";
			var adNo = "${requestScope.map.adNo}";
			var status = $("input[name='process']:checked").val();
			
			$.ajax({
				url:"${contextPath}/approval/updateSendApproval",
				type:"get",
				data:{empNo:empNo, adNo:adNo, status:status},
				success:function(data){
					console.log(data);
					if(data == '성공') {
						alert("성공적으로 " + status + "되었습니다");
						location.href="${contextPath}/showWaitDcm.ap"; 
					}
				}
			});
		}
	
		function updateProcees(){
			var empNo = "${sessionScope.loginEmp.empNo}";
			var adNo = "${requestScope.map.adNo}";
			var status = $("input[name='process']:checked").val();
			
			$.ajax({
				url:"${contextPath}/approval/updateProcees",
				type:"get",
				data:{empNo:empNo, adNo:adNo, status:status},
				success:function(data){
					console.log(data);
					if(data == '성공') {
						alert("성공적으로 " + status + "되었습니다");
						location.href="${contextPath}/showWaitDcm.ap"; 
					}
				}
			});
		}
		function updateApply(){
			var empNo = "${sessionScope.loginEmp.empNo}";
			var adNo = "${requestScope.map.adNo}";
			var status = $("input[name='apply']:checked").val();
			
			$.ajax({
				url:"${contextPath}/approval/updateApply",
				type:"get",
				data:{empNo:empNo, adNo:adNo, status:status},
				success:function(data){
					console.log(data);
					if(data == '성공') {
						alert("성공적으로 " + status + "되었습니다");
						location.href="${contextPath}/showWaitDcm.ap"; 
					}
				}
			});	
		}
		function updateApproval(){
			var empNo = "${sessionScope.loginEmp.empNo}";
			var adNo = "${requestScope.map.adNo}";
			var status = $("input[name='approve']:checked").val();
			
			$.ajax({
				url:"${contextPath}/approval/updateApproval",
				type:"get",
				data:{empNo:empNo, adNo:adNo, status:status},
				success:function(data){
					console.log(data);
					if(data == '성공') {
						alert("성공적으로 " + status + "되었습니다");
						location.href="${contextPath}/showWaitDcm.ap"; 
					}
				}
			});
		}
		function updateAgree(){
			var empNo = "${sessionScope.loginEmp.empNo}";
			var adNo = "${requestScope.map.adNo}";
			var status = $("input[name='agree']:checked").val();
			
			$.ajax({
				url:"${contextPath}/approval/updateAgree",
				type:"get",
				data:{empNo:empNo, adNo:adNo, status:status},
				success:function(data){
					console.log(data);
					if(data == '성공') {
						alert("성공적으로 " + status + "되었습니다");
						location.href="${contextPath}/showWaitDcm.ap"; 
					}
				}
			});
		}
		function updatePayAgree(){
			var empNo = "${sessionScope.loginEmp.empNo}";
			var adNo = "${requestScope.map.adNo}";
			var status = $("input[name='payAgree']:checked").val();
			
			$.ajax({
				url:"${contextPath}/approval/updatePayAgree",
				type:"get",
				data:{empNo:empNo, adNo:adNo, status:status},
				success:function(data){
					console.log(data);
					if(data == '성공') {
						alert("성공적으로 " + status + "되었습니다");
						location.href="${contextPath}/showWaitDcm.ap"; 
					}
				}
			});
		}
		function updateConfirmDcm(){
			var empNo = "${sessionScope.loginEmp.empNo}";
			var adNo = "${requestScope.map.adNo}";
			
			console.log(empNo);
			console.log(adNo);
			
			if(window.confirm("확인처리 하시겠습니까?")){
				$.ajax({
					url:"${contextPath}/approval/updateCircle",
					type:"get",
					data:{empNo:empNo, adNo:adNo},
					success:function(data){
						alert("확인처리가 완료되었습니다.");
						location.href="${contextPath}/showWaitDcm.ap";
					}
				});
			}else {
				alert("취소되었습니다");
			}
		}
		
		function updateSendConfirmDcm(){
			var empNo = "${sessionScope.loginEmp.empNo}";
			var adNo = "${requestScope.map.adNo}";
			
			console.log(empNo);
			console.log(adNo);
			
			if(window.confirm("확인처리 하시겠습니까?")){
				$.ajax({
					url:"${contextPath}/approval/updateSend",
					type:"get",
					data:{empNo:empNo, adNo:adNo},
					success:function(data){
						alert("확인처리가 완료되었습니다.");
						location.href="${contextPath}/showWaitDcm.ap";
					}
				});
			}else {
				alert("취소되었습니다");
			}
		}

	</script>
</body>
</html>



















