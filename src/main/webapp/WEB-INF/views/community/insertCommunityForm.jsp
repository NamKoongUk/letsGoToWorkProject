<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LetsGoToWork</title>
	<style>
		.content{font-size:150%; }
	
	</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<script type="text/javascript" src="${ contextPath }/resources/ckeditor/ckeditor.js"></script>
	<jsp:include page="../common/menubar.jsp"/>	
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/community.jsp"/>
		
		<section class="col-sm-10">
			<h1 class="title">글작성</h1> 
		
			<div class="content">
					<form method="post" action=""  >
							
						
						<label>&nbsp;게시판 종류 :</label>
								
								<select >
								<c:forEach var="b" items="${ requestScope.list}">
					   	   
								   	     <option value="${b.bno}">${b.boardName}</option>
								   	     <%-- <option value="${}"></option>
								   	     <option value="${}"></option> --%>
								   	
					   	
					   			
					   			</c:forEach>
					   			</select> 

							<table class="table table-striped" >

								<tbody>
													
	
									<tr>
	
										<td colspan="2"><input type="text" class="form-control" placeholder="글 제목" name="bbsTitle" maxlength="50"/></td>
	
								  </tr> 
								  
								  <tr>
										<th width="10%;">첨부파일:</th>
								  		<td><input type="file" name="uploadfile"></td>
	  
								  </tr>
								   		
								  	
								</tbody>

							
							</table>
					<div id="signFormArea">
			
					</div>
		
					<div id="area">
						<label>&nbsp;상세 내용</label>
					    <div class="form-group">
					        <div class="form-group">
					            <div class="col-lg-12">
					                <textarea name="afContent" id="ckeditor"></textarea>
					            </div>
					        </div>
					        <div class="form-group">
					            <div class="col-lg-12" align="center">
					            	<button type="button" class="btn btn-md btn-default">임시저장</button>
					                <button type="submit" class="btn btn-md btn-primary">저장</button>
					            </div>
					        </div>
					    </div>
		 		
					</div>
			</form>




			
			
				
			</div>
		</section>
	</div>
	<script>
	$(function(){
		$("#dcmType").change(function(){
			console.log($(this).val());
			console.log($("#area").css("visibility"));
			$("#area").attr('style','visibility:visible');
		});
	});

    $(function(){
        CKEDITOR.replace( 'ckeditor', {//해당 이름으로 된 textarea에 에디터를 적용
            width:'100%',
            height:'400px',
            filebrowserImageUploadUrl: '${ contextPath }/reources/images', //여기 경로로 파일을 전달하여 업로드 시킨다.
            defaultLanguage:'kor'
        });
         
        CKEDITOR.on('dialogDefinition', function( ev ){
            var dialogName = ev.data.name;
            var dialogDefinition = ev.data.definition;
          
            switch (dialogName) {
                case 'image': //Image Properties dialog
                    //dialogDefinition.removeContents('info');
                    dialogDefinition.removeContents('Link');
                    dialogDefinition.removeContents('advanced');
                    break;
            }
        });
         
    });
		
	
	</script>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>