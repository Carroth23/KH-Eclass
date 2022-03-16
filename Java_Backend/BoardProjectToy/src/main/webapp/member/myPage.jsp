<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


<style>
div {
	border: 1px solid black;
	padding: 1px;
	font-size: 14px;
}

[class*=col] {
	padding: 0px;
}

.container {
	margin-top: 10px;
	width: 70%;
}

.header {
	text-align: center;
	font-size: 18px;
}

.nametag {
	text-align: right;
}

.footer {
	text-align: center;
}

.post {
	width: 100%;
}

button {
	border: 1px solid gray;
}

input {
	border: 1px solid gray;
	margin: 1px;
}

#pwo1 {
	float: left;
	border: 0;
}

#pwo {
	float: left;
}
</style>
</head>
<body>
	<div class="container">
		<form action="/modify.mem" method="post">
			<div class="row">
				<div class="col header">회원 가입 정보</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">아이디 :</div>
				<div class="col-10" name="id">
					${dto.id } <!-- input 속성에 disabled로 해도 됨 -->
				</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">패스워드 :</div>
				<div class="col-10">
					<input type="password" id="pw">
				</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">패스워드 확인:</div>
				<!-- 유효성 검사 -->
				<div class="col-10">
					<input type="password" id="pwo" name="pw">
					<div id="pwo1"></div>
				</div>

			</div>
			<div class="row">
				<div class="col-2 nametag">이름 :</div>
				<div class="col-10">
					<input type="text" id="name" name="name" value="${dto.name }">
				</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">전화번호 :</div>
				<div class="col-10">
					<input type="text" id="phone" name="phone" value="${dto.phone }">
					<button type="button">휴대폰 인증</button>
				</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">이메일 : </div>
				<div class="col-10">
					<input type="text" id="email" name="email" value="${dto.email }">
				</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">우편번호 :</div>
				<div class="col-10">
					<input type="text" id="postcode" name="postcode" value="${dto.zipcode }">
					<button id="postsearch" type="button">찾기</button>
				</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">도로명 주소 :</div>
				<div class="col-10">
					<input type="text" class="post" id="roadAddress" name="readAddress" value="${dto.address1 }">
				</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">상세 주소 :</div>
				<div class="col-10">
					<input type="text" class="post" id="jibunAddress"
						name="jibunAddress" value="${dto.address2 }">
				</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">가입일 : </div>
				<div class="col-10">
					${dto.signup_date }
				</div>
			</div>
			<div class="row">
				<div class="col footer">
					<button id="sign">정보 수정</button>
					<input type="reset" value="다시 입력">
				</div>
			</div>
		</form>
	</div>
	<script>
		let pw = document.getElementById("pw");
		let pwo = document.getElementById("pwo");
		let pwo1 = document.getElementById("pwo1");

		pwo.oninput = function() {
			if (pw.value != pwo.value) {
				pwo1.setAttribute("style", "color:pink;");
				pwo1.innerHTML = "패스워드 불일치";
			} else if (pw.value === pwo.value) {
				pwo1.setAttribute("style", "color:blue;");
				pwo1.innerHTML = "패스워드 일치";
			}
		}
	</script>

	<script>
		document.getElementById("postsearch").onclick = function() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							document.getElementById('postcode').value = data.zonecode;
							document.getElementById("roadAddress").value = data.roadAddress;
							document.getElementById("jibunAddress").value = data.jibunAddress;
						}
					}).open();
		}
	</script>

	<script>
		// 정규식의 공간
		document.getElementById('sign').addEventListener("click", clickEvent);
		function clickEvent() {
			let btns = document.getElementById('sign');
			let pwRegex = /^[a-zA-Z0-9].{3,18}$/;
			let nameRegex = /^[가-힣a-zA-Z]{2,8}$/;
			let phoneRegex = /^[0-9]{9,16}$/;
			let emailRegex = /^[a-zA-Z/d]+@[a-zA-Z/d.]+$/;
			if (!pwRegex.test(document.getElementById("pw").value)) {
				alert("비밀번호 확인");
			} else if (!nameRegex.test(document.getElementById("name").value)) {
				alert("이름 확인");
			} else if (!emailRegex.test(document.getElementById("email").value)) {
				alert("이메일 확인");
			}
		}
	</script>
</body>
</html>