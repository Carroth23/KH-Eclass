<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div id="container">
		로그인에 성공했습니다.<br>
		${dto.name} 님의 정보는 : ${dto.id } , ${dto.phone } , ${dto.email }입니다.
	</div>
</body>
</html>