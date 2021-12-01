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
		<form action="/signupComplete.mem" method="post">
			<div class="row">
				<div class="col header">회원 가입 정보 입력</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">아이디 :</div>
				<div class="col-10">
					<input type="text" id="id" name="id">
					<button type="button" id="idCheck">중복확인</button>
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
					<input type="text" id="name" name="name">
				</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">전화번호 :</div>
				<div class="col-10">
					<select id="phone1" name="phone1">
						<option value="02">02</option>
						<!-- 옵션에 밸류값주면 서브밋할때 같이 감 -->
						<option>031</option>
						<option>032</option>
						<option>010</option>
						<option>011</option>
						<option>017</option>
						<option>018</option>
					</select> - <input type="text" id="phone2" name="phone2"> - <input
						type="text" id="phone3" name="phone3">
				</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">이메일 :</div>
				<div class="col-10">
					<input type="text" id="email" name="email">
				</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">우편번호 :</div>
				<div class="col-10">
					<input type="text" id="zipcode" name="zipcode">
					<button type="button">찾기</button>
				</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">도로명 주소 :</div>
				<div class="col-10">
					<input type="text" class="post" id="address1" name="address1">
				</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">상세 주소 :</div>
				<div class="col-10">
					<input type="text" class="post" id="address2" name="address2">
				</div>
			</div>
			<div class="row">
				<div class="col footer">
					<button id="sign">회원가입</button>
					<input type="reset" value="다시 입력">
				</div>
			</div>
		</form>
	</div>
	<script>
		'use strict'
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
		};
		
		let idCheck = document.getElementById("idCheck");
		idCheck.addEventListener("click",function(){
			let idval = document.getElementById("id").value;
			location.href="/idCheck.mem?idval=" + idval;
			//
			// 아이디 체크 해결해야됨 중복확인버튼 누르면 얼럿으로 띄울거
			//
			//
			
		});
	</script>
</body>
</html>