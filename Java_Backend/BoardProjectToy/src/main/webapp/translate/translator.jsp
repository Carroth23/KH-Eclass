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
	
	<fieldset>
		<legend>From</legend>
		<textarea rows="8" cols="50" placeholder="input text" id="from"></textarea>
	</fieldset>
	
	<button id="translate">번역</button>
	
	<fieldset>
		<legend>To</legend>
		<textarea rows="8" cols="50" id="to"></textarea>
	</fieldset>
	
	<script>
		$("#translate").on("click", function(){
			$.ajax({
				url: "/translate.trs",
				dataType: "json",
				data: {src: $("#from").val()}
			}).done(function(resp){
				$("#to").val(resp.message.result.translatedText);
			})
		})
	</script>
	
</body>
</html>