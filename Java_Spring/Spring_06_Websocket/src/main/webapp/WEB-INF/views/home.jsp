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
		*{box-sizing:border-box;}
		div{border: 1px solid black;}
		#chat-box{
			width:300px;
			height:300px;
			margin:auto;
		}
		#chat-box .chat-contents{
			height:80%;
			overflow:auto;
		}
		#chat-box .chat-input{
			height:20%;
		}
		#chat-box .chat-input div{
			float:left;
		}
		#chat-box .chat-input .input-message{
			width:80%;
			height:100%;
		}
		#chat-box .chat-input .input-button{
			width:20%;
			height:100%;
		}
		#message{
			width:100%;
			height:100%;
		}
		#send{
			width:100%;
			height:100%;
		}
		
	</style>
</head>
<body>

	<div id="chat-box">
		<div class="chat-contents">
		</div>
		<div class="chat-input">
			<div class="input-message">
				<textarea id="message"></textarea>
			</div>
			<div class="input-button">
				<button id="send">Send</button>
			</div>
		</div>
	</div>
	
	<script>
		let ws = new WebSocket("ws://192.168.75.66/chat"); // 엔드포인트 클래스 /chat한테 감
								// 웹소켓과 http url은 동일해야한다.
		
		ws.onmessage = function(e){
			let line = $("<div>");
			let msgObj = JSON.parse(e.data); // json파스하는 부분
			
			line.append(msgObj.ID + " : " + msgObj.message);
			$(".chat-contents").append(line);
		}
								
		$("#send").on("click", () => {
			let text = $("#message").val();
			$("#message").val("");
			ws.send(text);
		});
		
	</script>
</body>
</html>