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
		font-size:12px;
	}
	
	span{
		cursor:pointer;
	}

</style>
</head>
<body>
<script type="text/javascript" src="${ contextPath }/resources/ckeditor/ckeditor.js"></script>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="row wrap">
		<jsp:include page="../common/sideMenu/approval.jsp"/>
			<!-- 프로그래밍 언어: <input id='my-language' type='text'> -->
		<section class="col-sm-10">
			<h3 class="title">문서 작성</h3>
			<hr>
			<table class="table table-bordered">
			    <tbody>
			      <tr>
			        <td class="head">문서종류</td>
			        <td>
						<select class="form-control" id="dcmType">
							<option value="">선택</option>
							<c:forEach var="af" items="${ requestScope.list }">
								<option value="${ af.afNo }">${ af.afName }</option>
							</c:forEach>
						</select>
					</td>
					<td class="head">작성자</td>
					<td>이지현</td>
			      </tr>
			      <tr>
			        <td class="head">보존기간</td>
			        <td>
						<select class="form-control" id="date" disabled>
							<option>선택</option>
							<option value="1years">1년</option>
							<option value="3years">3년</option>
							<option value="5years">5년</option>
							<option value="10years">10년</option>
						</select>
					</td>
					<td class="head">보안등급</td>
					<td>
						<select class="form-control" id="security" disabled>
							<option>선택</option>
							<option value="s">S등급</option>
							<option value="a">A등급</option>
							<option value="b">B등급</option>
							<option value="c">C등급</option>
						</select>
					</td>
			      </tr>
			    <tbody>
	  		</table>
			
			
			
			<div id="area" class="content" style="visibility:hidden;">
				<form class="form-horizontal" role="form" id="editorForm" method="post" action="/">
					<a href="#" data-toggle="modal" data-target="#myModal" onclick="selectEmp();">결재선설정</a><br>
					<div id="myModal" class="modal fade" role="dialog">
					  <div class="modal-dialog">			
					    <!-- Modal content-->
					    <div class="modal-content" style="width:700px;">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal">&times;</button>
					        <h4 class="modal-title">결재선 설정</h4>
					      </div>
					      <div class="modal-body" style="height:500px;">
					      	<div id="deptList" class="treeview col-sm-3" style="height:450px; border:1px solid black">		      
						      <span id="all" onclick="underEmp(this, event);">전체보기</span>			   
					      	</div>
					      	<div class="col-sm-4 form-group">
					      		<select class="form-control" name="empList" size="10" style="overflow: auto; width:100%; height:450px;" multiple>
					      			
					      		</select>
					      	</div>
					      <!-- 	<div class="col-sm-1">
					      		
					      		<button class="middle" type="button">></button>
					      		<button class="middle" type="button"><</button>
					      		
					      	</div> -->
					      	<div class="col-sm-4 signForm" id="circle" style="display:none;">
					      		<div class="row">
						      		<div>
						      			<div class="col-sm-2">
								      		<button class="btn" name="inputCircle" type="button">></button>
								      		<button class="btn" name="outputCircle" type="button"><</button>
						      			</div>
						      			<div class="col-sm-10">
						      				<label class="col-sm-12">회람</label>
								      		<select class="form-control circleList" name="circleList" size="10" style="width:100%; height:420px;" multiple>
								      			
								      		</select>					      			
						      			</div>
						      		
						      		</div>
						      	
						      	</div>
					      	</div>
					      	<div class="col-sm-5 signForm" id="normalApproval" style="display:none;">	
						      	<div class="row">
						      		<div>
						      			<div class="col-sm-2">
								      		<button class="top" type="button">></button>
								      		<button class="top" type="button"><</button>
						      			</div>
						      			<div class="col-sm-10">
						      				<label class="col-sm-12">결재</label>
								      		<select class="form-control" name="circleList" size="10" style="width:100%; height:110px;" multiple>
								      			
								      		</select>					      			
						      			</div>
						      		
						      		</div>
						      	
						      	</div>
					      		<div class="row">
						      		<div>
						      			<div class="col-sm-2">
								      		<button class="top" type="button">></button>
								      		<button class="top" type="button"><</button>
						      			</div>
						      			<div class="col-sm-10">	
						      				<label class="col-sm-12">합의</label>
								      		<select class="form-control" name="circleList" size="10" style="width:100%; height:110px;" multiple>
								      			
								      		</select>					      			
						      			</div>
						      		
						      		</div>
						      	
						      	</div>
					      		<div class="row">
						      		<div>
						      			<div class="col-sm-2" style="display:table-cell; vertical-align:center; top:50%;">
								      		<button class="top" type="button">></button>
								      		<button class="top" type="button"><</button>
						      			</div>
						      			<div class="col-sm-10">
						      				<label class="col-sm-12">참조</label>
								      		<select class="form-control" name="circleList" size="10" style="width:100%; height:110px;" multiple>
								      			
								      		</select>					      			
						      			</div>
						      		
						      		</div>
						      	
						      	</div>

					      	</div>
					      	<div class="col-sm-4 signForm" id="agreementApproval" style="display:none;">
					      		<label>결재</label>
					      		<select class="form-control" name="circleList" size="10" style="width:100%; height:80px;" multiple>
					      			
					      		</select>
					      		<label>재무합의</label>
					      		<select class="form-control" name="circleList" size="10" style="width:100%; height:80px;" multiple>
					      			
					      		</select>
					      		<label>합의</label>
					      		<select class="form-control" name="circleList" size="10" style="width:100%; height:80px;" multiple>
					      			
					      		</select>
					      		<label>참조자</label>
					      		<select class="form-control" name="circleList" size="10" style="width:100%; height:80px;" multiple>
					      			
					      		</select>
						      	<div class="btnArea">
						      		<button type="button">회람추가</button>
						      	</div>
					      	</div>
					      	<div class="col-sm-4 signForm" id="applyDcm" style="display:none;">
					      		<label>신청자</label>
					      		<select class="form-control" name="circleList" size="10" style="width:100%; height:110px;" multiple>
					      			
					      		</select>
					      		<label>처리자</label>
					      		<select class="form-control" name="circleList" size="10" style="width:100%; height:110px;" multiple>
					      			
					      		</select>
					      		<label>참조</label>
					      		<select class="form-control" name="circleList" size="10" style="width:100%; height:110px;" multiple>
					      			
					      		</select>
						      	<div class="btnArea">
						      		<button type="button">회람추가</button>
						      	</div>
					      	</div>
					      	<div class="col-sm-4 signForm" id="approvalSend" style="display:none;">
					      		<label>결재</label>
					      		<select class="form-control" name="circleList" size="10" style="width:100%; height:110px;" multiple>
					      			
					      		</select>
					      		<label>참조</label>
					      		<select class="form-control" name="circleList" size="10" style="width:100%; height:110px;" multiple>
					      			
					      		</select>
					      		<label>수신</label>
					      		<select class="form-control" name="circleList" size="10" style="width:100%; height:110px;" multiple>
					      			
					      		</select>
						      	<div class="btnArea">
						      		<button type="button">회람추가</button>
						      	</div>
					      	</div>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					        <button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
					      </div>
					    </div>				
					  </div>
					</div>
					<div class="signArea">
					<input type="text" id="circleText" value="circle">
					</div>
					
					<label>제목 </label>
					<input type="text" id="title" class="form-control">
					<br><br>
					<label>상세내용</label>
				    <div class="form-group">
				        <div class="form-group">
				            <div class="col-lg-12">
				                <textarea name="ckeditor" id="ckeditor"></textarea>
				            </div>
				        </div>
				        <div class="form-group">
				            <div class="col-lg-12" align="right">
				            	<button type="button" class="btn btn-md btn-default">취소</button>
				                <button type="button" class="btn btn-md btn-primary">저장</button>
				            </div>
				        </div>
				    </div>
				</form>
	 	
			</div>
		</section>
	</div>
	
	<jsp:include page="../common/footer.jsp" />
<script>
	$(".btn").click(function(){
		
		var selectEmp = $("select[name='empList']").val();
		
		console.log($("select[name='empList']").val());
		
		if($(this).attr("name") == "inputCircle"){
			var circleList = $(this).parent().parent().find("select[name='circleList']");
			console.log($(this).parent().parent().find("select[name='circleList']"));
			
			for(var i = 0; i < selectEmp.length; i++) {
				console.log("들어는 오냐??");
				console.log($("#" + selectEmp[i]));
				circleList.append($("#" + selectEmp[i]).parent());
			}
			
		}
	});
	
	function selectEmp(){
		console.log("selectEmp 호출");
		$("#deptList").children().remove();
		$.ajax({
			url:"${contextPath}/approval/selectEmp",
			type:"get",
			success:function(data){
				console.log("성공");
				var $ul = $("<ul>");
				
				for(var i = 0; i < data.deptList.length; i++) {
					if(data.deptList[i].topDept == null){
						var $li = $("<li style='list-style:none' class='dept'><span onclick='underEmp(this, event);' id='" + data.deptList[i].deptCode + "'>" + data.deptList[i].deptName + "</span></li>");
						if(data.deptList[i].stat == 'Y') {
							var $img = $("<img id='" + data.deptList[i].deptCode + "' onclick='underDept(this);' style='width:12px; height:12px;' src='${contextPath}/resources/images/approval/plus.gif'>");					
							$li.prepend($img);
						}
						$ul.append($li);
					} 
				}
				$("#deptList").append($ul);
			}
		});
	}
	
	function underDept(img){
		console.log(img.id);
		
		var deptCode = img.id;
		
		if($("#" + img.id).parent().children().length <= 2) {
			$("#" + img.id).attr("src", "${contextPath}/resources/images/approval/minus.gif");
			$.ajax({
				url:"${contextPath}/approval/selectUnderDept",
				data:{deptCode:deptCode},
				type:"get",
				success:function(data){		
					console.log(data);
					
					var $ul = $("<ul>");
					
					for(var i = 0; i < data.deptList.length; i++) {
						var $li = $("<li style='list-style:none' class='dept'><span onclick='underEmp(this, event);' id='" + data.deptList[i].deptCode + "'>" + data.deptList[i].deptName + "</span></li>");
						if(data.deptList[i].stat == 'Y') {
							var $img = $("<img id='" + data.deptList[i].deptCode + "' onclick='underDept(this);' style='width:12px; height:12px;' src='${contextPath}/resources/images/approval/plus.gif'>");					
							$li.prepend($img);
						}
						$ul.append($li);
					}
					console.log($("#" + img.id).parent());
					$("#" + img.id).parent().append($ul);
				}
			});
			
		}else {
			$("#" + img.id).attr("src", "${contextPath}/resources/images/approval/plus.gif");
			$("#" + img.id).parent().children("ul").remove();
	
		} 
	
		
		
	}
	
	
	function underEmp(span, event){
		event.stopPropagation();
		console.log(span.id);
		var deptCode = span.id;
		if(deptCode != 'all') {
			$.ajax({
				url:"${contextPath}/approval/selectUnderDept",
				data:{deptCode:deptCode},
				type:"get",
				success:function(data){		
					console.log(data);
					
					$("select[name='empList']").children().remove();
					
					for(var i = 0; i < data.empList.length; i++) {
						console.log(data.empList[i].empName);
						var $option = $("<option value='" + data.empList[i].empNo + "'>");
						$option.append($("<label id='" + data.empList[i].empNo + "'>" + data.empList[i].empName + "(" + data.empList[i].deptName + "/ " + data.empList[i].jobName + " )" + "</label>"));
						
						$("select[name='empList']").append($option);
					}
				}
			});
		}else {
			$.ajax({
				url:"${contextPath}/approval/selectEmp",
				type:"get",
				success:function(data){
					console.log("성공");
					
					for(var i = 0; i < data.empList.length; i++) {
						console.log(data.empList[i].empName);
						var $option = $("<option value='" + data.empList[i].empNo + "'>");
						$option.append($("<label id='" + data.empList[i].empNo + "'>" + data.empList[i].empName + "(" + data.empList[i].deptName + "/ " + data.empList[i].jobName + " )" + "</label>"));
						
						$("select[name='empList']").append($option);
					} 
					
				}
			});
		}

	}
	
	var cnt = 0;
	$(function(){
		$("#dcmType").change(function(){
			var afNo = $(this).val();
			console.log(afNo);
			
			$(".signForm").each(function(){
				$(this).css("display", "none");
			});
			
			$.ajax({
				url:"${contextPath}/approval/selectWriteForm",
				data:{afNo:afNo},
				type:"get",
				success:function(data){
					CKEDITOR.instances.ckeditor.setData(data.afContent);
					$(".signArea").html(data.signContent);
					$("#date").val(data.afDate);
					$("#security").val(data.securityCode);
					$("#dcmType").val(data.afNo);
					$("#area").css("visibility", "visible");
					
					console.log($(".signForm"));
					
					$(".signForm").each(function(){
						console.log($(this).attr("id"));
						console.log(data.signCode);
						if(data.signCode == $(this).attr("id")) {
							$(this).css("display", "block");
						}
					});

					
					$("#autoSelectEmp").autocomplete({	
						source : function( request, response ) {
							console.log("작동!!");
				             $.ajax({
				                    type: 'post',
				                    url: "${contextPath}/approval/autocompleteCircle",
				                    contentType:"application/json;charset=UTF-8",
				                    type:"get",
				                    //request.term = $("#autocomplete").val()
				                    data: { value : request.term },
				                    success: function(data) {
				                        //서버에서 json 데이터 response 후 목록에 뿌려주기 위함
				                        response(
				                            $.map(data, function(item) {
				                            	console.log("item : " + item);
				                                return {
				                                    label: item.empName + "(" + item.empId + ")",
				                                    value: item.empName + "(" + item.empId + ")",
				                                    empNo: item.empNo
				                                }
				                            })
				                        );
				                    }
				               });
				            },
				        //조회를 위한 최소글자수
					    minLength: 1,
					    delay:100,
				        select: function ( event, ui ) {
				        	console.log(ui);
				        	console.log("선택!!!");
				            // 만약 검색리스트에서 선택하였을때 선택한 데이터에 의한 이벤트발생
							var flag = true;
				        $("#autoSelectEmp").keydown(function(e){
				        	//엔터키를 통해 등록 script를 실행(선택시의 enter와는 별개로 작동한다.)
				        	
			                if(e.keyCode == 13 && flag){
			                	var $label = $("<label style='margin-left:5px; margin-right:5px;'>");
								console.log("엔터");
								console.log(ui.item.value);
								console.log(ui.item.empNo);
								
								var check = 0;
								
								$("input[type=hidden]").each(function(){
									if($(this).val() == ui.item.empNo){
										check = 1;
									}
								});
								
								
								if(check > 0){
									alert("중복된 사용자는 추가할 수 없습니다.");
								}else {
				                 	$label.append(ui.item.value);
				                 	$label.append($("<input type='hidden' value='" + ui.item.empNo + "'>"));
				                 	$label.append($("<a href='#' onclick='deleteTag(this);' style='color:red;'>x</a>"))
				                 	
				                 	console.log($("#" + (cnt-1)).val());
				                 	$(this).parent().append($label);
				                 	
				                 	$("#autoSelectEmp").val("");

				                 	$label = "";
				                 	ui.item = "";
									
								}
	
			                 	flag = false;
			                }
				        })
				            
					},focus:function(event, ui){return false;} //한글입력시 포커스이동하면 서제스트가 삭제되므로 focus처리
				});
			}
				
		});
		
	});
	});
	
	function deleteTag(a){
		console.log(a);
		console.log($(a).parent());
		$(a).parent().remove();
	}
			
	


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
</body>
</html>