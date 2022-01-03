<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/summernote/summernote-lite.js"></script>
<script src="/summernote/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="/summernote/summernote-lite.css">
<style>
        #container {
          width: 600px;
          height: 600px;
          margin: auto;
        }

        #title {
          width: 100%;
          height: 50px;
        }
      </style>
    </head>

    <body>
      <div id="container">
        <form action="/board/writeComplete" method="post" enctype="multipart/form-data">
          <div class="title">
            <input type="text" id="title" name="title">
            <input type="file" name="file" multiple>
          </div>
          <div class="contents">
            <textarea id="contents" name="contents"></textarea>
          </div>
          <button>작성완료</button>
          <button type="reset">내용 수정</button>
        </form>
      </div>

      <script>
        $('#contents').summernote({
 	    	placeholder: 'content',
	        minHeight: 370,
	        maxHeight: null,
	        lang : 'ko-KR'
	      });
      </script>
</body>
</html>