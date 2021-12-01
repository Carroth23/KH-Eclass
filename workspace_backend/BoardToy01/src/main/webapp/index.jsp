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
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

#container {
	border: 1px solid black;
	display: flex;
	width: 400px;
	height: 200px;
	margin: auto;
	flex-wrap: wrap;
	border-radius: 10px;
}

header {
	text-align: center;
	width: 100%;
	height: 50px;
	background-color: aliceblue;
	margin-top: 20px;
}

section {
	width: 100%;
	height: 150px;
	text-align: center;
}

.idpw {
	display: inline-block;
	width: 40px;
}

.btns {
	margin-top: 10px;
}

.btns>button {
	width: 60px;
	height: 25px;
	transition: all 0.5s;
}

.btns>button:hover {
	background-color: #008080;
	border: none;
	cursor: pointer;
	color: white;
	border-radius: 5px;
}

table {
	width: 250px;
	height: 80px;
	margin: auto;
	margin-top: 10px;
	border: none;
	text-align: center;
}

table button {
	width: 100%;
	height: 100%;
	transition: all 0.5s;
	background-color: seashell;
	border: none;
	border-radius: 10px;
}

table button:hover {
	background-color: #008080;
	color: white;
	cursor: pointer;
}
</style>
</head>

<body>

	<c:choose>
		<c:when test="${loginId != null }">
			<table>
				<tr>
					<th colspan=4>${loginId }님안녕하세요.
				</tr>
				<tr>
					<td><button id="toboard" type="button">To board</button>
					<td><button id="mypage" type="button">MyPage</button>
					<td><button id="logout" type="button">logOut</button>
					<td><button id="leave" type="button">Leave</button>
				</tr>
			</table>

			<script>
				let logout = document.getElementById("logout");
				logout.addEventListener("click", function() {
					if (confirm("정말 로그아웃 하시겠습니까?")) {
						location.href = "/logout.mem";
					}
				});
				let leave = document.getElementById("leave");
				leave.addEventListener("click", function() {
					if (confirm("정말 탈퇴하시겠습니까?")) {
						location.href = "/leave.mem";
					}
				});
			</script>

		</c:when>
		<c:otherwise>
			<form action="/loginCheck.mem" method="post">
				<div id="container">
					<header> 로그인 프로젝트 ver2.4 </header>
					<section>
						<article>
							<span class="idpw">ID : </span><input type="text" name="id">
						</article>
						<article>
							<span class="idpw">PW : </span><input type="text" name="pw">
						</article>
						<article class="btns">
							<button>로그인</button>
							<button type="button" id="beforeSignup">회원가입</button>
						</article>
					</section>
				</div>
			</form>
		</c:otherwise>

	</c:choose>

	<script>
		let login = document.getElementById("beforeSignup");
		login.addEventListener("click", function() {
			location.href = "/beforeSignup.mem";
		});
	</script>

</body>

</html>