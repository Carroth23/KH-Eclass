<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<h1>세션값 : ${loginID }</h1>
	<table border=1 align=center>
		<tr>
			<th colspan=4>
			<img src="/images/Carroth23.png"> <!-- 이미지는 request를 발생시킴 -->
		</tr>
		<tr>
			<th colspan=4>Index
		</tr>
		<tr align=center>
			<td><a href="toInput">toInput</a>
			<td><a href="toOutput">toOutput</a>
			<td><a href="toSearch">toSearch</a>
			<td><a href="login">Login</a>
		</tr>
	</table>
</body>
</html>