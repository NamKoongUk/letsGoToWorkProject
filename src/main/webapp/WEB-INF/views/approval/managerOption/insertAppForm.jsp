<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
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
	<script type="text/javascript" src="${ contextPath }/resources/ckeditor/ckeditor.js"></script>
	<jsp:include page="../../common/menubar.jsp"/>
	
	<div class="row wrap">
		<jsp:include page="../../common/sideMenu/approval.jsp"/>
		
		<section class="col-sm-10">
			<h3 class="title"> 양식생성</h3>
			<hr>
			<div class="content">
				<form class="form-horizontal" role="form" id="editorForm" method="post" action="${ contextPath }/insertAppForm.ap">
					<table class="table table-hover table-bordered">
						<tr>
				        <td class="head">양식명</td>
				        <td>
							<input type="text" name="afName" class="form-control">
						</td>
						<td class="head">약칭</td>
						<td>
							<input type="text" name="afAlias" class="form-control">
						</td>
				      </tr>
				       <tr>
				        <td class="head">설명</td>
				        <td>
							<input type="text" name="afComment" class="form-control">
						</td>
						<td class="head">결재양식</td>
						<td>
							<button class="btn btn-primary" type="button" data-toggle="modal" data-target="#myModal">선택</button>
							<input type="hidden" name="signCode"/>
							 <!-- Modal -->
							  <div class="modal fade" id="myModal" role="dialog" style="left: -180px;">
							    <div class="modal-dialog">
							    
							      <!-- Modal content-->
							      <div class="modal-content" style="width:800px; align:center">
							        <div class="modal-header">
							          <button type="button" class="close" data-dismiss="modal">&times;</button>
							          <h4 class="modal-title">결재 양식선택</h4>
							        </div>
							        <div class="modal-body" >
							          <div class="form-group">
							          	<div class="row">
							          		<div class="col-sm-1"></div>
								          	<div class="col-sm-4">
								          		<label><input type="radio" name="signForm" value="normalApproval">결재
								          		<br>
								          		<img src="${ contextPath }/resources/images/approval/normal.PNG" width="300px" height="100px">
								          		</label>
								          	</div>
								          	<div class="col-sm-1"></div>
								          	<div class="col-sm-4">
								          		<label><input type="radio" name="signForm" value="agreementApproval">재무포함 결재
								          		<br>
								          		<img src="${ contextPath }/resources/images/approval/agree.PNG" width="300px" height="100px">
								          		</label>
								          	</div>
								  
							          	</div>
							          	<div class="row">
							          		<div class="col-sm-1"></div>
								          	<div class="col-sm-4">
								          		<label><input type="radio" name="signForm" value="applyDcm">신청
								          		<br>
								          		<img src="${ contextPath }/resources/images/approval/apply.PNG" width="300px" height="100px">
								          		</label>
								          	</div>
								          	<div class="col-sm-1"></div>
								          	<div class="col-sm-4">
								          		<label><input type="radio" name="signForm" value="approvalSend">결재후송신
								          		<br>
								          		<img src="${ contextPath }/resources/images/approval/send.PNG" width="300px" height="100px">
								          		</label>
								          	</div>
							          	</div>
							          	<div class="row">
								          	<div class="col-sm-1"></div>
								          	<div class="col-sm-4">
								          		<label><input type="radio" name="signForm" value="circle">회람
								          		<br>
								          		<img src="${ contextPath }/resources/images/approval/circle.PNG" width="300px" height="100px">
								          		</label>
								          	</div>
							          	</div>
							          </div>
							        </div>
							        <div class="modal-footer">
							          <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="selectSignForm();">확인</button>
							          <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
							        </div>
							      </div>
							      
							    </div>
							  </div>
						</td>
				      </tr>
				      <tr>
				        <td class="head">보존기간</td>
				        <td>
							<select class="form-control" name="afDate">
								<option>선택</option>
								<option value="1years">1년</option>
								<option value="3years">3년</option>
								<option value="5years">5년</option>
								<option value="10years">10년</option>
							</select>
						</td>
						<td class="head">보안등급</td>
						<td>
							<select class="form-control" name="securityCode">
								<option>선택</option>
								<option value="s">S등급</option>
								<option value="a">A등급</option>
								<option value="b">B등급</option>
								<option value="c">C등급</option>
							</select>
						</td>
				      </tr>
					</table>
					<div id="signFormArea">
						
					</div>
					
					<div id="area">
						<label>상세 내용</label>
					    <div class="form-group">
					        <div class="form-group">
					            <div class="col-lg-12">
					                <textarea name="afContent" id="ckeditor"></textarea>
					            </div>
					        </div>
					        <div class="form-group">
					            <div class="col-lg-12" align="right">
					            	<button type="button" class="btn btn-md btn-default">취소</button>
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
	function selectSignForm(){
		var signCode = $("input[name='signForm']:checked").val();
		alert(signCode);
		
		$.ajax({
			url:"selectSignForm.ap",
			type:"post",
			contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
			data:{signCode:signCode},
			success:function(data){
				alert(data);
				console.log(data);
				var appForm = data;
				$("#signFormArea").html(appForm);
				$("input[name='signCode']").val(signCode);
				console.log($("input[name='signCode']").val());
			}
		});
	}
	
	function replaceAll(str, searchStr, replaceStr) {
		console.log("searcnStr : " + searchStr);
		console.log("replaceStr : " + replaceStr);
	  return str.split(searchStr).join(replaceStr);
	}
	
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
	<jsp:include page="../../common/footer.jsp" />
</body>
</html>