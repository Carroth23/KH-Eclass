<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판 글 하나</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/summernote/summernote-lite.js"></script>
<script src="/summernote/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="/summernote/summernote-lite.css">
<style>
  *{
      box-sizing: border-box;
      padding:0;
      margin:0;
  }
  #writeBox{
    margin:auto;
    width:600px;
    height:600px;
    margin-top:50px;
    border:1px solid black;
  }
  .title{
    width:70%;
    height:30px;
    margin:auto;
  }
  .content{
    width:100%;
    height:80%;
  }
  button{
    margin:10px;
  }
</style>
</head>
<body>
<div id="writeBox">
  <div class="titleBox">
    <input type="text" placeholder="제목입력" class="title" value="${dto.title}">
  </div>
  <div class="contentBox">
    <div class="content">${dto.contents}</div>
  </div>
  <button id="listBack">목록으로</button>
</div>

<script>
  document.querySelector("#listBack").addEventListener("click", () => {
    location.href="/boardList.board";
  })
</script>
</body>
</html>