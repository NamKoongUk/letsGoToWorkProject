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
	

</style>
<link rel="stylesheet" href="${ contextPath }/resources/treeview/css/jquery.treeview.css"/>
<link rel="stylesheet" href="${ contextPath }/resources/treeview/css/screen.css"/>
</head>
<body>
<script src="${ contextPath }/resources/treeview/lib/jquery.js" type="text/javascript"></script>
<script src="${ contextPath }/resources/treeview/lib/jquery.cookie.js" type="text/javascript"></script>
<script src="${ contextPath }/resources/treeview/lib/jquery.treeview.js" type="text/javascript"></script>
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
					      	<div id="deptList" class="treeview col-sm-4" style="height:450px; border:1px solid black">
					      			<ul id="browser" class="filetree"> 
					      				<li> <span class="folder">폴더</span> 
					      			<ul> 
					      				<li> <span class="file">폴더 - 파일</span> </li> 
					      			</ul> </li> 
					      				<li> <span class="file">파일</span> </li> 
					      			</ul>


					      	</div>
					      	<div class="col-sm-4 form-group">
					      		<!-- <div>
					      			<input type="checkbox" name="" id="checkbox1"/>
					      			<label for="checkbox1">사원이름</label>
					      			<input type="checkbox" name="" id="checkbox2"/>
					      			<label for="checkbox2">사원이름</label>
					      			<input type="checkbox" name="" id="checkbox3"/>
					      			<label for="checkbox3">사원이름</label>
					      			<input type="checkbox" name="" id="checkbox4"/>
					      			<label for="checkbox4">사원이름</label>
					      		</div>
					      		<script>
					      			$("[type=checkbox]").change(function(){
					      				
					      			})
					      		
					      		</script> -->
					      		<select class="form-control" name="empList" size="10" style="width:100%; height:450px;" multiple>
					      			
					      		</select>
					      	</div>
					      	<div class="col-sm-4">
					      		
					      	</div>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
	$(function() {
	    $("#tree").treeview({
	        collapsed: true,
	        animated: "medium",
	        control:"#sidetreecontrol",
	        persist: "location"
	    });
	});

	function selectEmp(){
		console.log("selectEmp 호출");
		
		$.ajax({
			url:"${contextPath}/approval/selectEmp",
			type:"get",
			success:function(data){
				console.log("성공");
				
				for(var i = 0; i < data.empList.length; i++) {
					console.log(data.empList[i].empName);
					var $option = $("<option value='" + data.empList[i].empNo + "'>");
					$option.append($("<label>" + data.empList[i].empName + "(" + data.empList[i].deptName + "/ " + data.empList[i].jobName + " )" + "</label>"));
					
					$("select[name='empList']").append($option);
				}
				
				for(var i = 0; i < data.deptList.length; i++) {
					
				}
				
			}
		});
	}
	
	
	var cnt = 0;
	$(function(){
		$("#dcmType").change(function(){
			var afNo = $(this).val();
			console.log(afNo);
			
			$.ajax({
				url:"${contextPath}/approval/selectWriteForm",
				data:{afNo:afNo},
				contentType:"application/json;charset=UTF-8",
				type:"get",
				success:function(data){
					/* $("#ckeditor").find("html").children("body").html(data.afContent); */
					CKEDITOR.instances.ckeditor.setData(data.afContent);
					/* $("#ckeditor").append(data.afContent); */
					$(".signArea").html(data.signContent);
					$("#date").val(data.afDate);
					$("#security").val(data.securityCode);
					/* $("#afNo").val(data.afNo); */
					$("#dcmType").val(data.afNo);
					$("#area").css("visibility", "visible");
					/* if($("#circle").attr("id") == "circle"){
						$("#circleText").attr("type", "text");
						$("#circle").append($("#circleText"));
					} */
					
					$("#circleEmp").autocomplete({	
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
				        $("#circleEmp").keydown(function(e){
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
				                 	$("#emp").append($label);
				                 	
				                 	$("#circleEmp").val("");

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