<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>회원가입</title>
      <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
      <style>
        * {
          box-sizing: border-box;
          padding: 0;
          margin: 0;
          text-align: center;
        }

        #container {
          width: 800px;
          height: 1000px;
          border: 1px solid black;
          margin: auto;
        }

        div {
          border-bottom: 1px solid black;
          margin-top:10px;
        }
        button{
          margin:10px;
        }
      </style>
    </head>

    <body>
      <div id="container">
        <form action="/signupC.mem" method="post">
          <div class="idBox">
            아이디 입력: <input type="text" name="id">
          </div>
          <div class="pwBox">
            비밀번호 입력: <input type="text" name="pw"><br>
            비밀번호 확인: <input type="text">
          </div>
          <div class="name">
            이름 입력: <input type="text" name="name">
          </div>
          <button>가입 ㄱ</button><button type="reset">리셋</button>
        </form>

      </div>
    </body>

    </html>