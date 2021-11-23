<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1 align=center>
		<tr>
			<th colspan=3>Contacts
		</tr>
		<tr>
			<th>
			<th>Name
			<th>Contact
		</tr>
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.seq }
				<td>${dto.name }
				<td>${dto.contact }
			</tr>
		</c:forEach>
		<tr>
			<td colspan=3>
			<form action="DeleteProc">
				<input type=text name=delID placeholder="input id to delete"><button>Delete</button>
			</form>
		</tr>
		<tr>
			<td colspan=3>
			<form action="ModifyProc" method=post>
				<input type=text name=name placeholder="input name to change"><br>
				<input type=text name=contact placeholder="input contact to change"><br>
				<input type=text name=seq placeholder="input seq to change"><button>Modify</button>
			</form>
		</tr>
		<tr>
			<td colspan=3 align=center><a href="index.html">Back</a>
		</tr>
	</table>
</body>
</html>