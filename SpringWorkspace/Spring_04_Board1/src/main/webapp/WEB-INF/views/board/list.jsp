<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Free Board</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="//cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet"
	href="//cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<style>
	.paginate_
</style>
</head>
<body>

	<!-- Table API 클라우드테이블 -->
	<table id="myTable" class="display" style="width:100%">
        <thead>
            <tr>
                <th></th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="i" items="${list }">
            <tr>
                <td>${i.seq }</td>
                <td><a href="/board/toDetail?seq=${i.seq}">${i.title }</a></td>
                <td>${i.writer }</td>
                <td>${i.write_date }</td>
                <td>${i.view_count }</td>
            </tr>
            </c:forEach>
        </tbody>
        <tfoot>
        	<tr>
        		<td colspan=5 align=right><button id="write">글쓰기</button>
        	</tr>
        </tfoot>
    </table>
	

	<script>
		$('#myTable').DataTable({
			order:[[0, 'desc']], // 역순 정렬
			ordering: true,
			bStateSave: true // 테이블 위치 저장
		});
		
		$("#write").on("click", () => {
			location.href="/board/writeForm";
		})
		
	</script>
</body>
</html>