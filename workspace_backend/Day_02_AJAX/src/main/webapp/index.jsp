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

	<!-- AJAX : Asynchronous Javascript And XML -->
	<!-- Xml은 좀 옛날거고 지금은 JSON을 더 많이씀 -->
	<!-- "화면 전환 없는" 요청 및 응답을 처리하는 메서드 -->

	<fieldset>
		<legend>단순요청</legend>
		<button id="ajax01">Simple AJAX</button>
	</fieldset>
	<br>
	<fieldset>
		<legend>데이터를 담아서 요청</legend>
		<button id="ajax02">AJAX with data</button>
	</fieldset>
	<br>
	<fieldset>
		<legend>비동기 요청에 대한 응답 수신</legend>
		<button id="ajax03">AJAX with response</button>
	</fieldset>
	<br>
	<fieldset>
		<legend>비동기 요청에 대한 배열 데이터 응답</legend>
		<button id="ajax04">AJAX response with Array data</button>
	</fieldset>
	<br>
	<fieldset>
		<legend>비동기 요청에 대한 객체 데이터 응답</legend>
		<button id="ajax05">AJAX response with Object data</button>
	</fieldset>
	<br>
	<fieldset>
		<legend>비동기 요청에 대한 객체배열 데이터 응답</legend>
		<button id="ajax06">AJAX response with ObjectArray data</button>
	</fieldset>


	<script>
		// new Object();				: 자바 스크립트 기본 객체 (얜 거의 안씀)
		// function Constructor(){};	: 생성자 함수 방식
		// {}							: 객체 리터럴 방식(JavaScript Object Notation)
		// 객체 리터럴방식이 JSON표기법이라고 함

		document.getElementById("ajax01").addEventListener("click", function() {
			fetch("/exam01.ajax").then(function(res) { // promise 를 반환 promise상태는 3가지가 있음 pending, fullfilled, rejected (실행중, 성공, 실패)
				response.text().then(function(text){
					alert(text);
				})
			})
		})
		//$("#ajax01").on("click", function(){
		//$.ajax({ // 이 함수 자체가 request를 쏨
		//url: "/exam01.ajax" // 어디로 보낼것인지? (필수 키값)
		//});
		//})

		$("#ajax02").on("click", function() {
			$.ajax({
				url : "/exam02.ajax",
				type : "get", // 타입 지정도 가능 get post
				data : { // 데이터를 보낼땐 다시 객체형식으로 보냄
					key1 : "key1",
					appleKey : "Apple",
					orangeKey : "Orange"
				}
			});
		})

		
		$("#ajax03").on("click", function() {
			$.ajax({
				url : "/exam03.ajax"
			}).done(function(resp) { // ajax처리가 끝나면 실행하는 함수(서버가 보내주는 데이터를 resp에 담았다)
				console.log(resp);
			});
		})

		$("#ajax04").on("click", function() {
			$.ajax({
				url : "/exam04.ajax",
				dataType : "json" // 데이터타입을 명시하면 바로 parse되서 들어옴
			}).done(function(resp) {
				// let result = JSON.parse(resp); // 서버로부터 넘어온 문자열을 JS배열로 변환시킨것(parse는 객체처럼 오면 객체로 인식함)
				console.log(resp);
			})
		})

		$("#ajax05").on("click", function() {
			$.ajax({
				url : "/exam05.ajax"
			}).done(function(resp) {
				let result = JSON.parse(resp);
				console.log(result);
			})
		})

		$("#ajax06").on(
				"click",
				function() {
					$.ajax({
						url : "/exam06.ajax"
					}).done(
							function(resp) {
								let result = JSON.parse(resp);
								for (let i = 0; i < result.length; i++) {
									console.log(result[i].id + " : "
											+ result[i].name + " : "
											+ result[i].contact);
								}
								console.log(result[1].name);
							})
				})
	</script>

</body>
</html>