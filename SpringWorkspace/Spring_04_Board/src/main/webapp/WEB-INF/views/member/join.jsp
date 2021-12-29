<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
div {
	border: 1px solid black;
	padding: 1px;
	font-size: 14px;
}

.container {
	margin-top: 50px;
	width: 300px;
	margin: auto;
}

input {
	border: 1px solid gray;
	margin: 1px;
}
</style>
</head>

<body>
	<div class="container">
		<form action="/member/signUp" method="post">
			<div>회원 가입 정보 입력</div>
			<div>
				아이디 : <input type="text" name=id id=id><span id="checkResult"></span>
			</div>
			<div>
				패스워드 : <input type="text" name=pw>
			</div>
			<div>
				이름 :<input type="text" name=name>
			</div>
			<div>
				전화번호 : <input type="text" name=phone>
				<!-- 전화번호 나눌라면 input hidden하나 만들고 걔한테 name줘서 스크립트에서 val조립시켜서 보내면됨 -->
			</div>
			<div>
				이메일 : <input type="text" name=email>
			</div>
			<div>
				우편번호 : <input type="text" name=zipcode>
			</div>
			<div>
				도로명 주소 : <input type="text" name=address1>
			</div>
			<div>
				상세 주소 : <input type="text" name=address2>
			</div>
			<div>
				<button>회원가입</button>
				<button type="reset">다시 입력</button>
			</div>
		</form>
	</div>
	
	<script>
		$("#id").on("blur", () => {
			$.ajax({
				url:"/member/idDuplCheck",
				data:{id:$("#id").val()}
			}).done(function(res){
				if(res == '1'){
					$("#checkResult").css("color", "hotpink");
					$("#checkResult").text($("#id").val() + "는 이미 사용중인 아이디입니다.");
					$("#id").val("");
					$("#id").focus();
				} else {
					$("#checkResult").css("color", "blue");
					$("#checkResult").text("사용가능한 아이디입니다.");
				}
			})
		})
	
	</script>
</body>
</html>