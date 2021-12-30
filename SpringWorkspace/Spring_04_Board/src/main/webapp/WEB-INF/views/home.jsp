<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>

	<c:choose>
		<c:when test="${loginID != null}">
			${loginID } 님 환영합니당
			<button type="button" id="toboard">게시판</button>
			<button type="button" id="mypageBtn">마이페이지</button>
			<button type="button" id="logoutBtn">로그아웃</button>
			<button type="button" id="leaveBtn">회원탈퇴</button>
		</c:when>
		<c:otherwise>
			<form action="/member/login" method="post">
				<table border=1 align=center>
					<tr>
						<th>Login
					</tr>
					<tr>
						<th><img src="/images/Carroth23.png">
					</tr>
					<tr>
						<td><input type="text" name="id" placeholder="id">
					</tr>
					<tr>
						<td><input type="password" name="pw" placeholder="pw">
					</tr>
					<tr>
						<td align=center>
							<button>Login</button>
							<button type="button" id="joinBtn">Join</button>
					</tr>
				</table>
			</form>
		</c:otherwise>
	</c:choose>
	<script>
		$("#joinBtn").on("click", () => {
			location.href="/member/join";
		})
		$("#logoutBtn").on("click", () => {
			location.href="/member/logout";
		})
		$("#leaveBtn").on("click", () => {
			if(confirm("정말 탈퇴하시겠수?")){
				location.href="/member/leave";
			}
		})
		$("#mypageBtn").on("click", () => {
			location.href="/member/mypage";
		})
		$("#toboard").on("click", () => {
			location.href="/board/list";
		})
	</script>
</body>
</html>