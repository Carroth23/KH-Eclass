<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
*{box-sizing: border-box;margin: 0;padding: 0;}
  #chatBox{
    width:400px;
    height:500px;
    margin:auto;
    margin-top:70px;
    background-color: aliceblue;
    box-shadow: 1px 1px 2px 2px rgb(214, 214, 214);
  }
  .chatCon{
    width:100%;
    height:85%;
    background-color: antiquewhite;
    overflow:auto;
    -ms-overflow-style: none;
  }
  .chatCon::-webkit-scrollbar{
    display:none;
  }
  .chatBottom{
    width:80%;
    height:15%;
    float:left;
  }
  .chatBottom2{
    width:20%;
    height:15%;
    float:left;
  }
  #chatInput{
    background-color: cadetblue;
    width:100%;
    height:100%;
    resize: none;
    color:aliceblue;
    padding: 5px;
    font-weight: bold;
  }
  #send{
    width:100%;
    height:100%;
    border: none;
    transition: all 0.2s;
  }
  #send:hover{
    background-color: aliceblue;
    cursor:pointer;
  }
  .msg{
    width:fit-content;
    margin:5px;
    border:1px solid rgb(114, 112, 248);
    display:block;
    padding:5px;
    border-radius: 5px;
  }
</style>
</head>
<body>

	<div id="chatBox">
    <div class="chatCon">

    </div>
    <div class="chatBottom">
      <textarea id="chatInput"></textarea>
    </div>
    <div class="chatBottom2">
      <button id="send">Send</button>
    </div>
  </div>

  <script>
    let ws = new WebSocket("ws://192.168.75.66/chat");
    ws.onmessage = function(e){
      let msg = $("<div class='msg'>");
      let msgObj = JSON.parse(e.data);
      msg.append(msgObj.ID + " : " + msgObj.message);
      $(".chatCon").append(msg);
      $('.chatCon').scrollTop($('.chatCon')[0].scrollHeight);
    }

    $("#send").on("click", () => {
      let msg = $("#chatInput").val();
      $("#chatInput").val("");
      ws.send(msg);
    })
  </script>

</body>
</html>