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
	<c:choose>
		<c:when test="${result }">
			<table border=1 align=center>
				<tr>
					<th>아이디 확인 여부
				</tr>
				<tr>
					<td>이미 사용중인 ID 입니다. <br> 다른 ID를 사용해주세요.
				</tr>
				<tr>
					<td align=center><button id="close">닫기</button> <script>
						$("#close").on("click", function() {
							opener.document.getElementById("id").value = ""; // 팝업창을 열어준 오프너의 id칸을 비움
							opener.document.getElementById("id").focus();
							window.close();
							// 열어준 브라우저는 opener
							// 열린 브라우저는 openee (여기에 해당)
						})
					</script>
				</tr>
			</table>
		</c:when>
		<c:otherwise>
			<div>
				<table border=1 align=center>
					<tr>
						<th colspan=2>아이디 확인 여부
					</tr>
					<tr>
						<td colspan=2>사용 가능한 ID 입니다.<br> 이 ID를 GET 하시겠습니까?
					</tr>
					<tr>
						<td align=center><button id="use">사용</button>
						<td align=center><button id="cancel">취소</button> <script>
							$("#use").on("click", function() {
								window.close();
							})
							$("#cancel")
									.on(
											"click",
											function() {
												opener.document
														.getElementById("id").value = "";
												opener.document.getElementById(
														"id").focus();
												window.close();
											})
						</script>
					</tr>
				</table>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>