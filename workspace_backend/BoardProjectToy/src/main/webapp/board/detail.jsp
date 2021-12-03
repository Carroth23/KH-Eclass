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
		<form action="/modify.board" method="post" id="frmDetail">
			<tr>
				${post_One.seq} ${post_One.writer}
				<td colspan="2" width="800" align="center"><input type="hidden"
					value="${post_One.seq}" name="seq"> <!-- 눈에 보이지 않지만 제출되는 hidden -->
					<input type="text" id="title" name="title" style="width: 70%"
					readonly value="${post_One.title}">
			</tr>
			<tr>
				<td colspan="2" height="400"><textarea
						placeholder="글 내용을 입력하세요." cols="112" rows="25" id="contents"
						name="contents" disabled>${post_One.contents}</textarea><br>
						<button type="button" id="fileListBtn">파일 목록 갱신</button><br>
						<fieldset>
							<legend>
								파일 목록
							</legend>

						</fieldset>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="button" value="목록으로"
					id="boardList"> <c:if test="${post_One.writer == loginID }">
						<!-- 내가 쓴 글일때만 삭제하기 띄우기 -->
						<button type="button" id="mod">수정하기</button>
						<button type="button" id="del">삭제하기</button>
						<button type="button" id="modOk" style="display: none">수정완료</button>
						<button type="button" id="modCancel" style="display: none">취소</button>
					</c:if>
			</tr>
		</form>
	</table>

	<script>
		$("#boardList").on("click", function() { // 목록으로
			history.back(); // 뒤로가기 기능?
		})

		$("#del").on("click", function() { // 삭제 확인
			if (confirm("정말 삭제하시겠습니까?")) {
				location.href = "/delete.board?seq=${post_One.seq}";
			}
		})

		let bkTitle = ""; // 수정취소 눌렀을때 원래글 저장
		let bkContents = "";

		$("#mod").on("click", function() { // 수정하기 클릭

			bkTitle = $("#title").val(); // 현재의 제목을 저장
			bkContents = $("#contents").val();

			$("#title").removeAttr("readonly"); // 수정불가옵션 빼기
			$("#contents").removeAttr("disabled");

			$("#del").css("display", "none");
			$("#mod").css("display", "none");
			$("#modOk").css("display", "inline");
			$("#modCancel").css("display", "inline");
		})

		$("#modCancel").on("click", function() { // 수정취소하기
			if (confirm("정말 취소하시겠습니까?")) {
				$("#title").val(bkTitle); // 취소 누르면 원래대로 돌아가게 하기
				$("#contents").val(bkContents);
				$("#title").attr("readonly", "");
				$("#contents").attr("disabled", "");
				$("#del").css("display", "inline");
				$("#mod").css("display", "inline");
				$("#modOk").css("display", "none");
				$("#modCancel").css("display", "none");
			}
		})

		$("#modOk").on("click", function() { // JS로도 서브밋 시킬수있다
			if (confirm("이대로 수정하시겠습니까?")) {
				$("#frmDetail").submit();
			}
		})

		$("#fileListBtn").on("click", function(){
			$.ajax({
				url: "/fileList.file",
				dataType: "json"
			}).done(function(res){
				for(let i = 0; i < res.length; i++){
					let div = $("<div>");
					let anker = $("<a>");
						console.log("콘솔실행");
					anker.attr("href","/files/" + res[i].sysName);
					anker.text(res[i].oriName);
					div.append(anker);
					$("legend").after(div);
				}
			});
		})
	</script>
</body>
</html>