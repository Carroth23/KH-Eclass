<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
	img{
		width:200px;
		height:200px;
	}
</style>
</head>
<body>
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
	<script>
		document.querySelector("#joinBtn").addEventListener("click", () => {
			location.href="join";
		})
	</script>
</body>
</html>