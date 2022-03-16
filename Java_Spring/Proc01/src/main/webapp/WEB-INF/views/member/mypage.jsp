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
		<form action="/member/modifyMyInfo" method="post">
			<div>내 정보</div>
			<div>
				아이디 : <input type="text" name=id id=id value="${dto.id }" readonly><span id="signup_date">${dto.signup_date }</span>
			</div>
			<div>
				패스워드 : <input type="text" name=pw>
			</div>
			<div>
				이름 :<input type="text" name=name value="${dto.name }">
			</div>
			<div>
				전화번호 : <input type="text" name=phone value="${dto.phone }">
				<!-- 전화번호 나눌라면 input hidden하나 만들고 걔한테 name줘서 스크립트에서 val조립시켜서 보내면됨 -->
			</div>
			<div>
				이메일 : <input type="text" name=email value="${dto.phone}">
			</div>
			<div>
				우편번호 : <input type="text" name=zipcode value="${dto.zipcode }">
			</div>
			<div>
				도로명 주소 : <input type="text" name=address1 value="${dto.address1 }">
			</div>
			<div>
				상세 주소 : <input type="text" name=address2 value="${dto.address2 }">
			</div>
			<div>
				<button>정보수정</button>
				<button type="button" id="back">돌아가기</button>
			</div>
		</form>
	</div>
	
	<script>
	$("#back").on("click", () => {
		history.back();
	})
	
	</script>
</body>
</html>