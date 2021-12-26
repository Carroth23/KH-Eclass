<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<style>
    *{
        box-sizing: border-box;
        padding:0;
        margin:0;
    }
    #writeBox{
      margin:auto;
      width: 1000px;
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
      resize: none;
    }
    button{
      margin:10px;
    }
</style>
</head>
<body>
  <form id="writeBox" action="/writeCom.board" method="post">
    <div class="titleBox">
      <input type="text" placeholder="제목입력" class="title" name="title">
    </div>
    <div class="contentBox">
      <textarea rows=30 cols=50 class="content" name="content"></textarea>
    </div>
    <button>작성완료</button><button type="reset">초기화</button>
  </form>

</body>
</html>