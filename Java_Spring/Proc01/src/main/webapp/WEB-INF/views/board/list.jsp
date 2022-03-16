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
	<table border="1">
		<tr>
			<td align="center" colspan="5"><b>자유게시판</b>
		</tr>
		<tr align="center">
			<td width="50" style="background-color: hotpink;">
			<td width="450">제목
			<td width="100">작성자
			<td width="80">날짜
			<td>조회수
		</tr>
		<tr>
				<c:forEach var="post_List" items="${post_List }">
					<tr align="center">
						<td width="50">${post_List.seq }
						<td width="450" id = "title"><a href="/board/list?seq=${post_List.seq }">${post_List.title }</a>
						<td width="100">${post_List.writer }
						<td width="80">${post_List.write_date }
						<td>${post_List.view_count }
					</tr>
				</c:forEach>
		</tr>
		<tr>
			<td colspan="5" align="center">
				${navi } <!-- 네비게이션 바 -->
		</tr>
		<tr>
			<td colspan="2"><input type="text" id="searchInput" placeholder="Search"> <button type="button" id="searchBtn">검색</button>
			<td colspan="5" align="right"><input type="button" value="작성하기"
				id="write">
		</tr>
	</table>

	<script>
		$("#write").on("click", function() {
			location.href = "/board/Write";
		})
		$("#searchBtn").on("click", function(){
			let searchTitle = $("#searchInput").val();
			location.href = "/toboard.board?search="+searchTitle+"&cpage=1";
		})
	</script>
</body>
</html>