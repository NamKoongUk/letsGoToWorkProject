<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>  
<head>                   
<meta charset="UTF-8">
<link rel="shortcut icon" href="${ contextPath }/resources/images/favicon.ico">
<title>LetsGoToWork</title>
<style>
	.listTable [type="checkbox"]{
		width: 20px;
		height : 20px;
	}
	.bottomBtn{
		margin-right: 7%;
	}
	.bottomBtn button{
		padding: 5px 17px;
		margin-left: 15px;
		border: 3px solid rgba(191, 191, 191, 1.0);
		background : rgba(191, 191, 191, 1.0);
		color: white;
		font-weight: bold;
		border-radius: 5px;
	}
	.bottomBtn button:hover{
		background : white;
		color: black;
	}
	.searchArea{
		height : 50px;
		margin-left: 3%;
		margin-bottom : 20px;
	}
	.searchArea *{
		height : 35px !important;;
		margin-right : 10px;
		width : 15% !important;
	}
	.searchArea .serarhValue{
		width: 30% !important;
	}
	.searchArea .searchBtn{
		border: 3px solid lightgray ;
		background : lightgray;
		font-weight : bold;
	}
	.searchBtn:hover{
		background : white;
		font-weight : bold;
		color : black;
	}
	.form-control{
		display: inline-block;
		float : left;
	}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/mail.jsp"/>
		
		<section class="col-sm-10">
		<br>
			<div class="content" align="center">
				<form class="searchArea form-group" align="left" action="mail/search.ma">
					<select class="searhType form-control">
						<option value="name">이름</option>
						<option value="writer">작성자</option>
						<option value="content">내용</option>
					</select> &nbsp;&nbsp;&nbsp;
					<input type="text" name="serarhValue" class="form-control serarhValue"/>&nbsp;
					<input type="submit" value="검색하기" class="form-control searchBtn"/>
				</form>
				<div class="tableArea" align="center">
					<table class="listTable">
						<tr>
							<th><input type="checkbox" id="wholeCheck"/></th>
							<th width="5%">읽음여부</th>
							<th width="16%">이름</th>
							<th width="14%">메일종류</th>
							<th>제목</th>
							<th width="18%">날짜</th>
						</tr>
						<c:forEach items="${ list }" var="mail">
							<tr>
								<td><input type="checkbox" name="check"/>
									<input type="hidden" name="mailNo" value="${ mail.mailNo }"/>
								</td>
								<td>
									<c:if test="${ mail.rStatus == 'Y' }">
										<img src="${ contextPath }/resources/images/mail/readMailY.PNG" width="50px">
									</c:if>
									<c:if test="${ mail.rStatus == 'N' }">
										<img src="${ contextPath }/resources/images/mail/readMailN.PNG" width="70px">
									</c:if>
								</td>
								<td>${ mail.sendMail }</td>
								<td>${ mail.mailType }</td>
								<td>${ mail.mTitle }</td>
								<td>${ mail.sendDate }</td>							
							</tr>
						</c:forEach>
					</table>
					<br>
					<div class="bottomBtn" align="right"> 
						<button onclick="changeStatus('read');">읽음</button>
						<button onclick="changeStatus('delete');">삭제</button>
					</div>
					<div class="paging">
						<ul class="pagination">
							<c:if test="${ pi.startPage > 1 }">
								<li><a href="${ contextPath }/allList.ma?currentPate=${ pi.startPage - pi.buttonCount }"><<</a></li>
							</c:if>
							<c:if test="${ pi.startPage <= 1 }">
								<li><a href="#"><<</a></li>
							</c:if>
							<c:if test="${ pi.startPage != pi.currentPage }">
								<li><a href="${ contextPath }/allList.ma?currentPate=${ pi.currentPage - 1}"><</a></li>
							</c:if>
							<c:if test="${ pi.startPage == pi.currentPage }">
								<li><a href="#"><</a></li>
							</c:if>
							<c:forEach var="pageNum" begin="${ pi.startPage }" end="${ pi.endPage }" step="1">
								<c:if test="${ pageNum == pi.currentPage }">
									<li class="active"><a>${ pageNum }</a></li>
								</c:if>
								<c:if test="${ pageNum != pi.currentPage }">
									<li><a href="${ contextPath }/allList.ma?currentPage=${ pageNum }">${ pageNum }</a></li>
								</c:if>
							</c:forEach>
							<c:if test="${ pi.endPage != currentPage }">
								<li><a href="${ contextPath }/allList.ma?currentPage=${ pi.currentPage + 1 }">></a></li>
							</c:if>
							<c:if test="${ pi.endPage == currentPage }">
								<li><a href="#">></a></li>
							</c:if>
							<c:if test="${ pi.endPage != pi.maxPage }">
								<li><a href="${ contextPath }/allList.ma?currentPage=${ pi.endPage + 1 }">>></a></li>
							</c:if>
							<c:if test="${ pi.endPage == pi.maxPage }">
								<li><a href="#">>></a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</section>
	</div>
	<script>
		// 메일 상세 페이지 이동
		$(".listTable").find("tr:not(:nth-child(1)) td:not(:nth-child(1))").click(function(){
			var mailNo = $(this).parent().find("td:nth-child(1) > [name=mailNo]").val();
			location.href='${ contextPath }/mail/detail.ma?mailNo=' + mailNo;
		});
		
		// 체크박스 전체 선택 및 해제 
		$("#wholeCheck").click(function(){
			if($(this).prop("checked")){
				$("[name=check]").prop("checked", true);
			}else{
				$("[name=check]").prop("checked", false);
			}
		});
		
		// 체크박스 값 변경 
		function changeStatus(type){
			console.log(type);
			
			checkList = [];
			
			$("input[name=check]:checked").each(function(){
				checkList.push($(this).siblings("[name=mailNo]").val());
				console.log(checkList);
				console.log(typeof checkList);
			});
			
			var data = {checkList: checkList, type:type};
			console.log(JSON.stringify(data));
			
			console.log("checkList : " + checkList);
			$.ajax({
				url : "${ contextPath }/mail/updateStatus",
				data :  JSON.stringify(data), 
				contentType : "application/json; charset=utf-8",
				type:"post",
				success:function(data){
					console.log("성공 : " + data);
				}
			});
		}
	</script>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>