<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

#container {
	width: 300px;
	height: 200px;
	margin: auto;
}

.header {
	text-align: center;
	font-size: 18px;
}

.idtag {
	float: left;
	width: 30%;
}

.pwtag {
	float: left;
	width: 30%;
}

input[type="text"] {
	width: 70%;
	height: 100%;
}

.btns {
	text-align: center;
}

.btns>* {
	margin: 1px;
	margin-top: 5px;
}
</style>
</head>
<body>
<body>

	<c:choose>
		<c:when test="${loginID != null }">
			<table border=1 align=center>
				<tr>
					<th colspan=5>${loginID }님안녕하세요.
				</tr>
				<tr>
					<td><button id="toboard">To board</button>
					<td><button id="mypage">MyPage</button>
					<td><button id="logout">logOut</button>
					<td><button id="leave">Leave</button>
					<td><button id="translate">Translate</button>
				</tr>


			</table>

			<script>
				$("#logout").on("click",function(){
					if(confirm("정말 로그아웃 하시겠습니까?")){
						location.href="/logout.mem"; // 자바스크립트에서 페이지 이동하는 방법
					}
				})
				
				$("#leave").on("click",function(){
					if(confirm("정말 탈퇴하시겠습니까? 모든 정보는 삭제됩니다.")){
						location.href="/leave.mem";
					}
				})
				
				$("#mypage").on("click",function(){
					location.href="/mypage.mem";
				})
				
				$("#toboard").on("click",function(){
					location.href="/toboard.board?cpage=1"; // 입장하면 당연히 1페이지를 보니까 1
				})
				
				$("#translate").on("click", function(){
					location.href="/toPage.trs";
				})
			</script>

		</c:when>

		<c:otherwise>

			<div id="container">
				<div class="header">회원 로그인</div>
				<form action="/loginCheck.mem" method="post">
					<div class="inputBoxs">
						<div class="idtag">아이디</div>
						<div class="idinput">
							<input type="text" name="id">
						</div>
						<div class="pwtag">비밀번호</div>
						<div class="pwinput">
							<input type="text" name="pw">
						</div>
					</div>
					<div class="btns">
						<input type="submit" value="로그인"><a href="signup.mem"><button
								type="button">회원가입</button></a>
					</div>
				</form>
			</div>
		</c:otherwise>
	</c:choose>

</body>


</html>