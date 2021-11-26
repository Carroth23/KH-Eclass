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
		<tr>
			<td align="center" colspan="5"><b>자유게시판</b>
		</tr>
		<tr align="center">
			<td width="50">
			<td width="450">제목 
			<td width="100">작성자
			<td width="80">날짜
			<td>조회
		</tr>
		<tr>
			<td colspan="5" height="340" align="center">표시할 내용이 없습니다.
		</tr>
		<tr>
			<td colspan="5" align="center">1 2 3 4 5 6 7 8 9 10
		</tr>
		<tr>
			<td colspan="5" align="right"><input type="button" value="작성하기" id="write">
		</tr>
	</table>
	
	<script>
		$("#write").on("click",function(){
			console.log("클릭감지");
			location.href="/boardWrite.board";
		})
	
	</script>
</body>
</html>