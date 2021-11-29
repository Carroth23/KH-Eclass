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
      ${post_One.seq}
			<td colspan="2" width="800" align="center"><b>${post_One.title}</b>
		</tr>
		<tr>
			<td colspan="2" height="400"><textarea
					placeholder="글 내용을 입력하세요." cols="112" rows="25" name="contents" disabled>${post_One.contents}</textarea>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="button" value="목록으로" id="boardList">
			<c:if test="${post_One.writer == loginID }"> <!-- 내가 쓴 글일때만 삭제하기 띄우기 -->
				<a href="/delete.board?seq=${post_One.seq}"><button type="button">삭제하기</button></a>
			</c:if>
		</tr>

	</table>

	<script>
		$("#boardList").on("click",function(){
			location.href="/toboard.board";
		})
	</script>
</body>
</html>