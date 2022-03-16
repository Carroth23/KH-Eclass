<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<table border="1">
		<form action="/writeComplete.board" method="post" enctype="multipart/form-data">
		<tr>
			<td colspan="2" width="800" align="center"><b>자유게시판 글 작성하기</b>
		</tr>
		<tr>
			<td><input type="text" placeholder="글 제목을 입력하세요" size="60" name="title">
		</tr>
		<tr>
			<td colspan="2" height="400"><textarea
					placeholder="글 내용을 입력하세요." cols="112" rows="25" name="contents"></textarea><br>
					<input type="file" name="file">
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="button" value="목록으로" id="boardList">
				<input type="submit" value="작성완료">
		</tr>
		</form>
	</table>

	<script>
		$("#boardList").on("click",function(){
			location.href="/toboard.board";
		})
	</script>
</body>
</html>