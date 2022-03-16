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
			<td>emp_id
			<td>emp_name
			<td>dept_title
			<td>email
		</tr>
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.emp_id }
				<td>${dto.emp_name }
				<td>${dto.dept_title }
				<td>${dto.email }
			</tr>
		</c:forEach>
		<tr>
			<td colspan=4 align=center><a href="index.jsp">Back</a>
		</tr>
	</table>
</body>
</html>