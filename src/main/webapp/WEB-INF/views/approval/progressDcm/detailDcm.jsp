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
</style>
</head>
<body>
	<jsp:include page="../../common/menubar.jsp"/>
	
	<div class="row wrap">
		<jsp:include page="../../common/sideMenu/approval.jsp"/>
		
		<section class="col-sm-10">
			<h2 class="title" align="center">${ requestScope.map.afName }</h2>
			
			<div class="content">
					<table class="table table-hover table-bordered">
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
											<c:if test="${ sessionScope.loginEmp.empNo == al.alEmpNo }">
												<label>${ al.approvaler } <font color="yellowgreen" size="2px"><a href="#" onclick="updateConfirmDcm();">확인</a></font></label>&nbsp;&nbsp;
											</c:if>
											<c:if test="${ sessionScope.loginEmp.empNo != al.alEmpNo }">
												<label>${ al.approvaler }</label>&nbsp;&nbsp;
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
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.approval[i.index].alLevel }">
                                    			<td><button onclick="updateApproval();">결재하기</button></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.approval[i.index].alLevel }">
                                    			<td><font color="red">결재대기</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo != sessionScope.loginEmp.empNo }">
	                                    		<c:if test="${ requestScope.appList.approval[i.index].alStatus == '대기' }">
	                                    			<td><font color="red">결재대기</font></td>
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.approval[i.index].alStatus == '결재' }">
	                                    			<td><font color="green">결재</font></td>
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
	                                    			<c:out value="${ requestScope.appList.ref[i.index].approvaler }"/> <font size="2px" color="yellowgreen"><a href="#">확인</a></font> &nbsp;
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
	                                    		<c:if test="${ requestScope.appList.send[i.index].alEmpNo == sessionScope.loginEmp.empNo }">
	                                    			<c:out value="${ requestScope.appList.ref[i.index].approvaler }"/> <font size="2px" color="yellowgreen"><a href="#" onclick="updateConfirmDcm();">확인</a></font> &nbsp;
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.send[i.index].alEmpNo != sessionScope.loginEmp.empNo }">
	                                    			<c:out value="${ requestScope.appList.send[i.index].approvaler }"/> &nbsp;
	                                    		</c:if>
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
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.approval[i.index].alLevel }">
                                    			<td><button onclick="updateApproval();">결재하기</button></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.approval[i.index].alLevel }">
                                    			<td><font color="red">결재대기</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo != sessionScope.loginEmp.empNo }">
	                                    		<c:if test="${ requestScope.appList.approval[i.index].alStatus == '대기' }">
	                                    			<td><font color="red">결재대기</font></td>
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.approval[i.index].alStatus == '결재' }">
	                                    			<td><font color="green">결재</font></td>
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
	                                    		<c:if test="${ requestScope.appList.agree[i.index].alEmpNo == sessionScope.loginEmp.empNo }">
	                                    			<td width="80px" height="20px">
	                                    				<c:out value="${ requestScope.appList.agree[i.index].approvaler }"/>
	                                    				<a href="#" onclick="updateAgree();"><font color="yellowgreen" size="2px"> 확인</font></a>
	                                    			</td>
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.agree[i.index].alEmpNo != sessionScope.loginEmp.empNo }">
	                                    			<c:if test="${ requestScope.appList.agree[i.index].alStatus == '대기' }">
		                                    			<td width="80px" height="20px">
		                                    				${ requestScope.appList.agree[i.index].approvaler } <font size="2px" color="red">대기</font>
		                                    			</td>
	                                    			</c:if>
	                                    			<c:if test="${ requestScope.appList.agree[i.index].alStatus == '확인' }">
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
	                                    			<c:out value="${ requestScope.appList.ref[i.index].approvaler }"/> <font size="2px" color="yellowgreen"><a href="#" onclick="updateConfirmDcm();">확인</a></font> &nbsp;
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
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.approval[i.index].alLevel }">
                                    			<td><button onclick="updateApproval();">결재하기</button></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.approval[i.index].alLevel }">
                                    			<td><font color="red">결재대기</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.approval[i.index].alEmpNo != sessionScope.loginEmp.empNo }">
	                                    		<c:if test="${ requestScope.appList.approval[i.index].alStatus == '대기' }">
	                                    			<td><font color="red">결재대기</font></td>
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.approval[i.index].alStatus == '결재' }">
	                                    			<td><font color="green">결재</font></td>
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
                                    		<c:if test="${ requestScope.appList.payAgree[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.payAgree[i.index].alLevel }">
                                    			<td><button onclick="updatePayAgree();">결재하기</button></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.payAgree[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.payAgree[i.index].alLevel }">
                                    			<td><font color="red">결재대기</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.payAgree[i.index].alEmpNo != sessionScope.loginEmp.empNo }">
	                                    		<c:if test="${ requestScope.appList.payAgree[i.index].alStatus == '대기' }">
	                                    			<td><font color="red">결재대기</font></td>
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.payAgree[i.index].alStatus == '결재' }">
	                                    			<td><font color="green">결재</font></td>
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
                                    		<c:if test="${ requestScope.appList.agree[i.index].alEmpNo == sessionScope.loginEmp.empNo }">
                                    			<td width="80px" height="20px">
                                    				<c:out value="${ requestScope.appList.agree[i.index].approvaler }"/>
                                    				<a href="#" onclick="updateAgree();"><font color="yellowgreen" size="2px"> 확인</font></a>
                                    			</td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.agree[i.index].alEmpNo != sessionScope.loginEmp.empNo }">
                                    			<c:if test="${ requestScope.appList.agree[i.index].alStatus == '대기' }">
	                                    			<td width="80px" height="20px">
	                                    				${ requestScope.appList.agree[i.index].approvaler } <font size="2px" color="red">대기</font>
	                                    			</td>
                                    			</c:if>
                                    			<c:if test="${ requestScope.appList.agree[i.index].alStatus == '확인' }">
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
	                                    			<c:out value="${ requestScope.appList.ref[i.index].approvaler }"/> <font size="2px" color="yellowgreen"><a href="#" onclick="updateConfirmDcm();">확인</a></font> &nbsp;
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
                                    		<c:if test="${ requestScope.appList.apply[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.apply[i.index].alLevel }">
                                    			<td><button onclick="updateApply();">결재하기</button></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.apply[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.apply[i.index].alLevel }">
                                    			<td><font color="red">결재대기</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.apply[i.index].alEmpNo != sessionScope.loginEmp.empNo }">
	                                    		<c:if test="${ requestScope.appList.payAgree[i.index].alStatus == '대기' }">
	                                    			<td><font color="red">결재대기</font></td>
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.apply[i.index].alStatus == '결재' }">
	                                    			<td><font color="green">결재</font></td>
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
                                    		<c:if test="${ requestScope.appList.process[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel == requestScope.appList.process[i.index].alLevel }">
                                    			<td><button onclick="updateProcees();">결재하기</button></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.process[i.index].alEmpNo == sessionScope.loginEmp.empNo && requestScope.map.adLevel != requestScope.appList.process[i.index].alLevel }">
                                    			<td><font color="red">결재대기</font></td>
                                    		</c:if>
                                    		<c:if test="${ requestScope.appList.process[i.index].alEmpNo != sessionScope.loginEmp.empNo }">
	                                    		<c:if test="${ requestScope.appList.payAgree[i.index].alStatus == '대기' }">
	                                    			<td><font color="red">결재대기</font></td>
	                                    		</c:if>
	                                    		<c:if test="${ requestScope.appList.process[i.index].alStatus == '결재' }">
	                                    			<td><font color="green">결재</font></td>
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
	                                    			<c:out value="${ requestScope.appList.ref[i.index].approvaler }"/> <font size="2px" color="yellowgreen"><a href="#" onclick="updateConfirmDcm();">확인</a></font> &nbsp;
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
						
					</div>
					
					<div id="area">
						<label>제목 : ${ requestScope.map.adTitle }</label>
					    <p>${ requestScope.map.adContent }</p>
		 		
					</div>
			</div>
		</section>
	</div>
	
	<jsp:include page="../../common/footer.jsp" />
	<input type="hidden" id="afNo" value="${ requestScope.map.afNo }">
	<script>	
		function updateProcees(){
			
		}
		function updateApply(){
					
		}
		function updateApproval(){
			
		}
		function updateAgree(){
			
		}
		function updatePayAgree(){
			
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
		function updateRef(){
			var empNo = "${sessionScope.loginEmp.empNo}";
			var adNo = "${requestScope.map.adNo}";
			
			console.log(empNo);
			console.log(adNo);
			
			if(window.confirm("읽음처리 하시겠습니까?")){
			/* 	$.ajax({
					url:"${contextPath}/approval/updateApproval",
					type:"get",
					data:{empNo:empNo, adNo:adNo},
					success:function(data){
						alert("성공");
					}
				}); */
			}else {
				alert("취소되었습니다");
			}
		}
			
		$(function(){
			$("#appFormUpdate").click(function(){
				var afNo = $("#afNo").val();
				location.href="${contextPath}/showUpdateAppForm.ap?afNo=" + afNo;
			});
			
			$("#appFormDelete").click(function(){
				var afNo = $("#afNo").val();
				var afNoArr = new Array();
				afNoArr.push(afNo);
				if(confirm("삭제하시겠습니까?")){
					$.ajax({
						url:"${contextPath}/deleteAppForm.ap",
						type:"post",
						data:{afNoArr:afNoArr},
						traditional : true,
						success:function(data){
							
							alert(data);
							location.href = "${contextPath}/showFormManagement.ap";
						}
					});				
				}else {
					alert("취소되었습니다.");
				}
				
			});
			
		});
	</script>
</body>
</html>



















