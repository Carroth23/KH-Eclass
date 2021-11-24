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
<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
	$(function(){
		$("#idCheck").on("click",function(){
			window.open("/idCheck.mem?id="+$("#id").val(),"","width=300px,height=200px,top=200px,left=200px"); // 팝업창 띄우는 명령어. 인자값 3개중 두번째는 안써도 됨.
		}); // /를 붙이면 절대경로 프로젝트의 제일 꼭대기에서 찾겠다. (나중에 전부 절대경로로 씀)
			// ../ 는 바로 상위폴더를 찾는것
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
		<form action="?" method="post">
			<div class="row">
				<div class="col header">회원 가입 정보 입력</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">아이디 :</div>
				<div class="col-10">
					<input type="text" id="id">
					<button type="button" id="idCheck">중복확인</button>
				</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">패스워드 :</div>
				<div class="col-10">
					<input type="text" id="pw">
				</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">패스워드 확인:</div>
				<!-- 유효성 검사 -->
				<div class="col-10">
					<input type="text" id="pwo">
					<div id="pwo1"></div>
				</div>

			</div>
			<div class="row">
				<div class="col-2 nametag">이름 :</div>
				<div class="col-10">
					<input type="text">
				</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">전화번호 :</div>
				<div class="col-10">
					<select>
						<option>02</option>
						<option>031</option>
						<option>032</option>
						<option>010</option>
						<option>011</option>
						<option>017</option>
						<option>018</option>
					</select> - <input type="text"> - <input type="text">
					<button type="button">휴대폰 인증</button>
				</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">이메일 :</div>
				<div class="col-10">
					<input type="text">
				</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">우편번호 :</div>
				<div class="col-10">
					<input type="text" id="postcode">
					<button id="postsearch" type="button">찾기</button>
				</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">도로명 주소 :</div>
				<div class="col-10">
					<input type="text" class="post" id="roadAddress">
				</div>
			</div>
			<div class="row">
				<div class="col-2 nametag">상세 주소 :</div>
				<div class="col-10">
					<input type="text" class="post" id="jibunAddress">
				</div>
			</div>
			<div class="row">
				<div class="col footer">
					<button>회원가입</button>
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
</body>
</html>