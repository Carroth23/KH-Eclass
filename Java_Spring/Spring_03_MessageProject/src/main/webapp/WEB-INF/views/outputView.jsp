<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1 align=center>
		<tr>
			<th colspan=4>Message list
		</tr>
		<tr>
			<th>seq
			<th>writer
			<th>Message
			<th>write_date
		</tr>
		<c:forEach var="i" items="${list}">
			<tr>
				<th>${i.seq }
				<th>${i.writer }
				<th>${i.message }
				<th>${i.write_date }
			</tr>
		</c:forEach>
		<tr></tr>
		<tr>
			<th colspan=4>
			<form action="searchSeq" method="post">
				<input type="text" placeholder="searchSeq" name="seq"><button>Search</button>
			</form>
		</tr>
		<tr>
			<td colspan=4>
			<form action="deleteProc" method="get">
				<input type=text placeholder="Target Number to delete" name=seq><button>Delete</button>
			</form>
		</tr>
		<tr>
			<td colspan=4>
			<form action="updateProc" method="post">
			<input type="text" placeholder="Target Seq to update" name="seq"><br>
			<input type="text" placeholder="Target Name to update" name="writer"><br>
			<input type="text" placeholder="Target Contact to update" name="message"><br>
			<button>Update</button>
			</form>
		</tr>
		<tr>
			<td colspan=3 align=center><a href="/">back</a>
		</tr>
	</table>
</body>
</html>