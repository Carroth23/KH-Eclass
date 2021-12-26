<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>보드연습1</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
  *{
    box-sizing: border-box;
    margin:0;
    padding:0;
  }

  #container{
    width:300px;
    height:200px;
    margin:auto;
    border:1px solid black;
    text-align: center;
  }
  .top{
    width:100%;
    height:50px;
    display:block;
    text-align:center;
    border-bottom: 1px solid black;
    line-height: 50px;
  }
  button{
    margin:10px;
  }

</style>

</head>
<body>
  <div id="container">
    <div class="top">
      회원가입 연습입니다.
    </div>
    <div class="bottom">
      <form action="/login.mem" method="post">
        ID : <input type="text" name="id" class="idBox"><br>
        PW : <input type="text" name="pw" class="pwBox"><br>
        <button>로그인</button><button type="button" id="signup">회원가입</button>
      </form>
    </div>
  </div>
  <div class="loginId">${loginId }님 안녕하세요</div>
  <button type="button" id="goBoard">게시판으로</button>
  <script>
    document.querySelector("#signup").addEventListener("click", () => {
      location.href="/signup.mem";
    })

    document.querySelector("#goBoard").addEventListener("click", () => {
      location.href="/boardList.board";
    })
  </script>
</body>
</html>