<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LetsGoToWork</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
   
   
   
   <style>
      .content{font-size:150%; }
   
   </style>


</head>
<body>
   <jsp:include page="../common/menubar.jsp"/>   
   <div class="row wrap">
      <jsp:include page="../common/sideMenu/community.jsp"/>
      
      <section class="col-sm-10">
         <h1 class="title"></h1>
         
         <div class="content">
            
                <c:forEach var="c" items="${list }">
               <%-- <c:if test="${c.status eq 'N'}">  --%>
               <button type="button" class="btn btn-info btn-lg" name="updateBtn" >수정</button>
               <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">삭제</button>
               <%-- </c:if> --%>
                </c:forEach>
            <div>   
                  <table class="table table-striped" border="" >   
                              
                     <c:forEach var="c" items="${list }">  
                             <input id="bnohidden" type="hidden" name="bno" value="${c.bno }">     
                             <input id="contentNOHidden" type="hidden" name="bno" value="${c.contentNO }">  
                      <thead>
                           <tr>
                              <th colspan="2"><h2>${c.btitle}</h2></th>
         
                           </tr>
                                      
                             <tr>
                              <td width="10%;">첨부파일: 2019-06-21 안전교육 일정안내서</td>
                             
         
                             </tr>
                            
                           <tr>
                  
                              <td height="500px">
                                    <div style="margin-left:10px; ">
                                          ${c.bcontent}
                                    </div>
                              </td>
                
                            </tr> 
                                 
                        </thead>
                        
                        
                        </c:forEach>
                      </table>
                     
                     
                     
                     
                     
                     
                                                
                     
                    </div>
               
                
                <br>
                <div >
                <c:forEach var="c" items="${list }">  
                   <c:if test="${c.status eq 'N'}"> 
                   <table class="table table-striped"  >
                    <thead>
                      <tr> 
                         <th>작성자</th>
                         <th>댓글 내용</th>
                         <th></th>
                         <!-- <th></th>  -->   
                      </tr> 
                      <%-- <c:forEach var="cc" items="${commentlist }"> --%>
                      <tr> 
                      <c:if test="${!empty sessionScope.loginEmp.empNo}">
               
                      
                         <td>${sessionScope.loginEmp.empName}</td>
                         <td><!-- <input type="text" id="ccontent"> --><textarea id="ccontent" style="width:100%; height:auto; "></textarea></td>
                         <td><button type="button" class="btn btn-info btn-lg" id="addReply">생성</button></td>
                      
                      </c:if>
                      </tr>
                      <%-- </c:forEach> --%>
                   
                      
                      
                      <tr><th>댓글</th></tr>
                      <tr>  
                      <c:forEach var="cc" items="${commentlist }">
                      <c:if test="${empty sessionScope.loginEmp || !empty sessionScope.loginEmp.empNo}"> 
                         <tr>  
                         <td width=10%><input type="hidden" value="${cc.cwriter }">${cc.empname}</td>
                               
           
                         <td  id="replyList" >${cc.ccontent}</td>
                         
         
                         <td  id="updateReply" style="display:none"><input type="text" value="${cc.ccontent}"> </td>
                        
                          
                         <c:if test="${sessionScope.loginEmp.empNo eq cc.cwriter}">
                         <td><input type="hidden" value="${cc.cno}">
                            <button type="button" class="btn btn-info btn-lg" onclick="updateBtn(this)" id="updateBtn">수정</button>
                            <button type="button" class="btn btn-info btn-lg" name="deleteReply" onclick="sendAndDelete(this)">삭제</button> 
                            <!-- <button type="button" class="btn btn-info btn-lg" style="display:none" onclick="">취소</button> --> 
                            
                         </td>
                         </c:if>
                         
                         </tr>
                      
                      </c:if>
                         
                        
                        <%--  <c:if test="${sessionScope.loginEmp.empNo eq cc.cwriter }"> 
                         <tr><th>댓글 수정</th></tr>
                         <tr>
                         <td>${sessionScope.loginEmp.empName}</td> 
                         <td><input type="text" value="${cc.ccontent}"></td> 
                         
                         <td>
                            <input type="hidden" value="${cc.cno}">
                            <button type="button" class="btn btn-info btn-lg" name="updateReply">수정</button>
                            <button type="button" class="btn btn-info btn-lg" name="deleteReply">삭제</button>
                         </td>
                         </tr>
                         </c:if> 
                          --%>
                       
                       </c:forEach>
                       </tr>   
                        
                </thead>   
            </table>
            </c:if>
            </c:forEach>
           </div>
           <div class="modal fade" id="myModal" role="dialog">
                     <div class="modal-dialog">
                      <div class="modal-content">
                          <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">게시판 삭제</h4>
                          </div>
                          <div class="modal-body">
                            <p>게시글을 삭제 할까요 ?</p>
                          </div>
                          <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal" name="deleteBtn">확인</button>
                             <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
                        </div>
                     </div>
                                       
                  </div>
               </div>
              
           
            
         </div>
      </section>
   </div>
   
   <jsp:include page="../common/footer.jsp"/>
   <script> 
         $("button[name='updateBtn']").click(function(){
            var contentno = $("#contentNOHidden").val();
            
            console.log(contentno);
            
             location.href= "communityPostUpdateForm.co?contentno="+contentno;  
         }); 
         
         $("button[name='deleteBtn']").click(function(){
            var contentno = $("#contentNOHidden").val();
            var bno = $("#bnohidden").val();
            console.log(contentno);
            
            location.href ="communityPostDelete.co?contentno="+contentno+"&bno="+bno;
         });
         
         
         $(function(){
           $("#addReply").click(function(){
              var writer = ${sessionScope.loginEmp.empNo}; 
              var contentno = $("#contentNOHidden").val(); 
               /*  console.log(contentno); */
               /*  console.log(writer); */ 
                var ccontent  = $("#ccontent").val();
                
               /* console.log(ccontent); */ 
               
               $.ajax({
                  url:"insertComment.co" ,  
                   data:{writer:writer,contentno:contentno ,ccontent:ccontent},
                   type:"post",
                   success:function(date){
                      if(date == "ok"){
                         alert("댓글 작성이 완료 되었습니다.");
                         location.href='communityPostDetails.co?contentNO='+contentno;
                      }else{
                         console.log("FAIL");
                      }
                   }
               
               })
               
               
               
           })   
            
            
         }) ;
         $("button[name='updateReply']").click(function(){
            var cno = $(this).parent().children().eq(0).val();
             var ccontent = $(this).parents().prev().children().val();
             var contentno = $("#contentNOHidden").val();
             
            /* console.log(cno); */
            console.log(ccontent);
            
               $.ajax({
                  url:"updateComment.co", 
                  data:{cno:cno,ccontent:ccontent ,contentno:contentno} , 
                  type:"post",
                  success:function(date){
                     if(date="ok"){
                        alert("댓글 수정 완료 되었습니다"); 
                        location.href='communityPostDetails.co?contentNO='+contentno; 
                     }
                     
                  }
                     
               })
            
         });
         
           
            
            
         
         function updateBtn(updateBtn){
        	console.log();
        	var inputArea = $(updateBtn).parent().siblings("#replyList");
        	
        	 if($(updateBtn).text() == '수정'){ 
        		 inputArea.text(""); 
        		 inputArea.append($("<textarea>").css({"width":"100%","height":"auto","resize":"none"}).val(inputArea.next().children().val()));
        		 $(updateBtn).text("취소");
        		 $(updateBtn).next().text("전송");
        	} else{
        		inputArea.empty();
        		inputArea.text(inputArea.next().children().val());
        		$(updateBtn).text("수정");
        		$(updateBtn).next().text("삭제");
        	}
        	 
         };
         
         function sendAndDelete(sendAndDelete){
        	 
        	 if($(sendAndDelete).text() == '전송'){
        	  var cno =$(sendAndDelete).parent().children("input").val(); 
        	  var writer = $(sendAndDelete).parents("tr").children("td").eq(0).children("input").val();
        	  var ccontent = $(sendAndDelete).parent().siblings("#replyList").children().val();
        	  var contentno = $("#contentNOHidden").val();
        	  /* console.log(writer); */
        	  	/* console.log(contentno); */ 
        	  
        	  	 $.ajax({
                    url:"updateComment.co", 
                    data:{cno:cno,ccontent:ccontent,contentno:contentno} , 
                    type:"post",
                    success:function(date){
                       if(date="ok"){
                          alert("댓글 수정 완료 되었습니다"); 
                			 location.href='communityPostDetails.co?contentNO='+contentno;  
                       }
                       
                    }
                       
                 });
               
           
           
  			 	
 
        	  
        		 
        	 }else{
        		 delReply();
        	 }
        	 
         }
      	function delReply(){
      		 var cno = $("button[name='deleteReply']").parent().children().eq(0).val(); 
             var contentno = $("#contentNOHidden").val();
             
             
             /* console.log(cno); */
             /*  console.log(contentno); */ 
             
             $.ajax({
                url:"deleteReply.co",
                data:{cno:cno,contentno:contentno} ,
                type:"post",
                success:function(data){
                   if(data="ok"){
                      alert("댓글 삭제 완료 되었습니다"); 
                         location.href='communityPostDetails.co?contentNO='+contentno; 
                   }
                }
                
                
             })
      	}
         
      
         
         
         
         
      </script>


</body>
</html>