<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- core는 c를 쓰는 컨벤션 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	EL(Expression Language)<br>
	${simple1 } : ${simple2 }<br>
	
	${array[0] }<br>
	${array[1] }<br>
	${array[2] }<br>
	
	${student.seq } : ${contact.name}<!-- 알아서 게터로 바쓈 -->
	
	
	
	<hr>
	JSTL(Jsp Standard Tag Library)<br>
	
	<c:if test="${simple1==10 }">
		simple1 안에 저장된 값은 10 입니당.<br><!-- 여긴 else가 없음 -->
	</c:if>
	
	<c:choose>
		<c:when test="${simple1==10 }">
			simple1 안에 저장된 값은 10입니다.
		</c:when>
		<c:when test="${simple2==11 }">
			simple1안에 저장된값은 11입니당
		</c:when>
		<c:otherwise>
			이건 else
		</c:otherwise>
	</c:choose>
	
	<c:forEach var="dto" items="${list }">
		${dto.seq } : ${dto.name }<br>
	</c:forEach>
	
</body>
</html>