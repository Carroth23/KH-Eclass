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

	<form action="/upload.file" method="post" enctype="multipart/form-data"> <!-- 인코딩도 꼭 설정해줘야함. 안그러면 이상한숫자들로 감(저 인코딩은 String값이랑 파일이랑 분리해서 넘겨주는것) -->
		<input type="name" name="name"><br>
		<input type="file" name="file"><br> <!-- File이 포함되어 있다면 method를 GET로 보낼 수 없다. 무조건 POST -->
		<input type="submit">
	</form>
	
	<hr>
	<button id="fileList">파일 명단 보기</button>
	<br>
	<firldset>
		<legend>파일 목록</legend>
	</firldset>
	
	<script>
		$("#fileList").on("click", function(){ // ajax가 아니더라도 다운로드는 ajax로 작동함.
			$.ajax({
				url: "/list.file",
				dataType: "json"
			}).done(function(res){
				for (let i = 0; i < res.length; i++){
					let div = $("<div>");
					
					let anker = $("<a>");
					// 다운로드 구현방법 1. 파일에 링크 걸어버리는것. <- 얘는 통제가 안됨
					anker.attr("href","/download.file?sysName=" + res[i].sysName + "&oriName=" + res[i].oriName); // 서버에서 쓸 내용들을 보내줌
					anker.text(res[i].oriName);
					div.append(anker);
					$("legend").after(div);
					
					// 다운로드 구현방법 2. 서블릿 커쳐서 가는것
					// - 월욜에 배움
					
				}
				
			});
		})
	</script>

	
</body>
</html>