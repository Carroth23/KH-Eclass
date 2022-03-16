<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	
	<form action="/file/upload" method="post" enctype="multipart/form-data">
		<input type="text" name="title"><br>
		<input type="text" name="contents"><br>
		<input type="file" name="file" multiple><br> <!-- multiple은 여러개의 파일을 선택할 수 있게 해주는것 -->
		<button>작성완료</button>
	</form>
	
</body>
</html>