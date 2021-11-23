<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- 꼭 넣는것.(jar파일도) -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact list</title>
</head>
<body>

	EL(Expression Language)<br>
	
	${simple1 } : ${simple2 }<br>
	
	${array[0] }<br>
	${array[1] }<br>
	
	${contact.seq } : ${contact.name} : ${contact.contact}<br><!-- EL에선 필드명을 쓰면 알아서 게터로 바뀜. -->
	
	${list[0].seq } : ${list[0].name } : ${list[0].contact }<br>
	${list[1].seq } : ${list[1].name } : ${list[1].contact }<br>
	${list[2].seq } : ${list[2].name } : ${list[2].contact }<br>
	
	
	
	<hr>
	JSTL(Jsp Standard Tag Library)<br>
	
	${simple1==10 }<br>
	<c:if test="${simple1==10}">  <!-- if문 -->
		simple1 안에 저장된 값은 10 입니다.<br>
	</c:if>
	
	<c:choose> <!-- else if문 이 주석은 달아주면 에러남. -->
		<c:when test="${simple1==10 }">
			simple1 안에 저장된 값은 10 입니다.
		</c:when>
		<c:when test="${simple==11 }">
			simple1 안에 저장된 값은 11입니다.
		</c:when>
		<c:otherwise>
			simple1 안에 저장된 값은 10도 11도 아닙니다.
		</c:otherwise>
	</c:choose>
	
	<hr>
	<!-- forEach -->
	<!-- for(ContactDTO dto : list){} -->
	<c:forEach var="dto" items="${list}"> <!-- 위와 같다 -->
		${dto.seq } : ${dto.name } : ${dto.contact }<br>
	</c:forEach>
	
</body>
</html>