<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/summernote/summernote-lite.js"></script>
<script src="/summernote/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="/summernote/summernote-lite.css">
<style>
        #container {
          width: 600px;
          height: 600px;
          margin: auto;
        }

        #title {
          width: 100%;
          height: 50px;
        }
        #seq{
        	display:none;
        }
        #replyBox{
          margin-top:50px;
          margin:auto;
          width:200px;
        }
        .reply{
          margin:auto;
          width:200px;
        }
        #replyBSeq{
          display:none;
        }
      </style>
    </head>

    <body>
      <div id="container">
        <form action="/board/modify" method="post">
          <div class="title">
            <input type="text" id="title" name="title" value="${dto.title }" readonly>
            <input type="text" id="seq" name="seq" value="${dto.seq }">
          </div>
          <div class="contents">
            <textarea id="contents" name="contents" readonly>${dto.contents }</textarea>
          </div>
          <c:if test="${dto.writer == loginID}">
          	<button type="button" id="delBtn">삭제하기</button>
          	<button type="button" id="modify">수정하기</button>
          	<button id="modifyOk" style="display:none;">수정완료</button>
          </c:if>
          <button type="button" id="back">목록으로</button>
        </form>
      </div>

      <c:forEach var="i" items="${reply }">
        <div class="reply">
          <div>작성자 : ${i.writer}</div>
          <textarea cols=50 rows=6 readonly>${i.contents}</textarea>
        </div>
      </c:forEach>

      <div id="replyBox">
        <form action="replyUp" method="post">
          <input type="text" id="replyBSeq" name="board_seq" value="${dto.seq }">
          <textarea rows=10 cols=50 name="contents"></textarea>
          <button>작성</button>
        </form>
      </div>
      
      <script>
        //$('#contents').summernote({
 	    	//placeholder: 'content',
	        //minHeight: 370,
	        //maxHeight: null,
          	//airMode: true,
	        //lang : 'ko-KR'
	      //}); 나중에 써야쥥

      	$("#back").on("click", () => {
      		location.href="/board/list";
      	})
      	
      	$("#delBtn").on("click", () => {
      		if(confirm("삭제할거?")){
      			location.href="/board/deleteProc?seq=" + ${dto.seq};
      		}
      	})
      	
      	$("#modify").on("click", () => {
      		$("#title").attr('readonly', false);
      		$("#contents").attr('readonly', false);
      		$("#modifyOk").show();
      		$("#modify").hide();
      	})
      
      </script>
</body>
</html>