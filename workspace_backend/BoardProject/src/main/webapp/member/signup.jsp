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

<script>
//html 실행 한 뒤 마지막에 실행하는 스크립트.
	$(function() {
		$("#idCheck").on(
				"click",
				function() {
					let idC = /^[a-z0-9]{4,12}$/;
					let id = $("#id").val();
					if (id == "") {
						alert("아이디를 입력하세요.");
						return;
					}
					window.open("/idCheck.mem?id=" + $("#id").val(), "",
							"width=300px,height=200px,top=200px,left=200px"); // 팝업창 띄우는 명령어. 인자값 3개중 두번째는 안써도 됨.
				}); // /를 붙이면 절대경로 프로젝트의 제일 꼭대기에서 찾겠다. (나중에 전부 절대경로로 씀)
		// ../ 는 바로 상위폴더를 찾는것
		// 상대경로 : 내 위치를 기준으로 상대를 부른것.
		// 절대경로 : /하나를 붙이면 프로젝트의 (webapp부터긴 한데)제일 꼭대기부터 찾음. 음.. 걍 처음부터 끝까지 경로 다쓰는것?
		// 근데 절대경로를 쓰면 프로젝트 명이 빠져서 나옴
		// 그래서 프로젝트명을 안쓰는 설정을 해야함. server.xml가서 path:지워버림 그럼 프로젝트명 없이 접속가능(짱편함)
		// 포트번호도 server.xml <Connector 여기서 80으로 바꿨음 그럼 포트번호 안써도 됨 (이클립스에서 사용하는 서버의 포트를 바꾼것)
		// 리다이렉트는 클라이언트한테 주소 다시지정해주는거임 ㅎㅎ
	})
</script>
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
		<form action="/sign.mem" method="post">
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
						<option value="02">02</option> <!-- 옵션에 밸류값주면 서브밋할때 같이 감 -->
						<option>031</option>
						<option>032</option>
						<option>010</option>
						<option>011</option>
						<option>017</option>
						<option>018</option>
					</select> - <input type="text" id="phone2" name="phone2"> - <input
						type="text" id="phone3" name="phone3">
					<button type="button">휴대폰 인증</button>
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
					<input type="text" id="postcode" name="postcode">
					<button id="postsearch" type="button">찾기</button>
				</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">도로명 주소 :</div>
				<div class="col-10">
					<input type="text" class="post" id="roadAddress" name="readAddress">
				</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">상세 주소 :</div>
				<div class="col-10">
					<input type="text" class="post" id="jibunAddress"
						name="jibunAddress">
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
			let idRegex = /^[a-zA-Z][a-zA-Z0-9]{3,12}$/;
			let pwRegex = /^[a-zA-Z].{7,18}$/;
			let nameRegex = /^[가-힣]{2,8}$/;
			let phoneRegex = /^[0-9]{9,16}$/;
			let emailRegex = /^[a-zA-Z/d]+@[a-zA-Z/d]+$/;
			if (!idRegex.test(document.getElementById("id").value)) {
				alert("아이디 확인");
				// btns.setAttribute("type","button");
				// 버튼 속성 이건 좀아닌거같은데 일단 냅둠
			} else if (!pwRegex.test(document.getElementById("pw").value)) {
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