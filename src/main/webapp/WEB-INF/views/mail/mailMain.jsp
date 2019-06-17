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
		margin-left: 7%;
		margin-bottom : 20px;
	}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/mail.jsp"/>
		
		<section class="col-sm-10">
		<br><br><br><br>
			<!-- <h1 class="title"> 메인입니다.</h1> -->
			<div class="content" align="center">
				<div class="searchArea" align="left">
					<select>
						<option value="name">이름</option>
						<option value="writer">작성자</option>
						<option value="content">내용</option>
					</select> &nbsp;&nbsp;&nbsp;
					<input type="text" name="serarhValue"/>&nbsp;
					<button></button>
				</div>
				<div class="tableArea" align="center">
					<table class="listTable">
						<!-- 가져가서 여기 width로 설정하셔요 -->
						<tr>
							<th width="5%"><input type="checkbox"/></th>
							<th width="10%">읽음여부</th>
							<th width="18%">이름</th>
							<th width="12%">메일종류</th>
							<th>제목</th>
							<th width="15%">날짜</th>
						</tr>
						<tr>
							<td><input type="checkbox"/></td>
							<td><img src="${ contextPath }/resources/images/mail/readMailN.PNG" width="70px"></td>
							<td>김채연 사원</td>
							<td>보낸메일</td>
							<td>안녕하세요 임시자료에욧</td>
							<td>2019-01-01</td>
						</tr>
						<tr>
							<td><input type="checkbox"/></td>
							<td><img src="${ contextPath }/resources/images/mail/readMailY.PNG" width="70px"></td>
							<td>gora7@naver.com</td>
							<td>받은메일</td>
							<td>메일메일메일</td>
							<td>2019-02-03</td>
						</tr>
						<tr>
							<td><input type="checkbox"/></td>
							<td><img src="${ contextPath }/resources/images/mail/readMailN.PNG" width="70px"></td>
							<td>김채연 사원</td>
							<td>보낸메일</td>
							<td>안녕하세요 임시자료에욧</td>
							<td>2019-01-01</td>
						</tr>
						<tr>
							<td><input type="checkbox"/></td>
							<td><img src="${ contextPath }/resources/images/mail/readMailY.PNG" width="70px"></td>
							<td>gora7@naver.com</td>
							<td>받은메일</td>
							<td>메일메일메일</td>
							<td>2019-02-03</td>
						</tr>
						<tr>
							<td><input type="checkbox"/></td>
							<td><img src="${ contextPath }/resources/images/mail/readMailN.PNG" width="70px"></td>
							<td>김채연 사원</td>
							<td>보낸메일</td>
							<td>안녕하세요 임시자료에욧</td>
							<td>2019-01-01</td>
						</tr>
						<tr>
							<td><input type="checkbox"/></td>
							<td><img src="${ contextPath }/resources/images/mail/readMailY.PNG" width="70px"></td>
							<td>gora7@naver.com</td>
							<td>받은메일</td>
							<td>메일메일메일</td>
							<td>2019-02-03</td>
						</tr>
					</table>
					<br>
					<div class="bottomBtn" align="right"> 
						<button>읽음</button>
						<button>삭제</button>
					</div>
					<div class="paging">
						<ul class="pagination">
						  <li><a href="#">1</a></li>
						  <li><a href="#">2</a></li>
						  <li><a href="#">3</a></li>
						  <li><a href="#">4</a></li>
						  <li><a href="#">5</a></li>
						</ul>
					</div>
				</div>
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>