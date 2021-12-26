<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>게시판리슷흐</title>
      <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
      <style>
        * {
          box-sizing: border-box;
          padding: 0;
          margin: 0;
        }

        #topFix {
          width: 200px;
          height: 30px;
          background-color: aliceblue;
          position: fixed;
          top: 0;
          left: 0;
        }

        #container {
          width: 600px;
          height: 700px;
          margin: auto;
          border: 1px solid black;
          margin-top: 50px;
          margin-bottom: 20px;
        }

        #topHeader {
          width: 100%;
          height: 50px;
          display: flex;
          border-bottom: 1px solid gray;
        }

        .boardNumH {
          width: 10%;
        }

        .boardTitleH {
          width: 40%;
        }

        .boardWriterH {
          width: 20%;
        }

        .boardViewH {
          width: 15%;
        }

        .boardLikeH {
          width: 15%;
        }

        #topHeader div {
          text-align: center;
          line-height: 50px;
        }

        /* 게시글들 */
        #middle {
          width: 100%;
          height: 100%;
        }

        .boardList {
          display: flex;
        }

        .boardNum {
          text-align: center;
          width: 10%;
        }

        .boardTitle {
          width: 40%;
        }

        .boardWriter {
          text-align: center;
          width: 20%;
        }

        .boardView {
          text-align: center;
          width: 15%;
        }

        .boardLike {
          text-align: center;
          width: 15%;
        }
        .navi{
          margin-top:20px;
          margin:auto;
        }
      </style>
    </head>

    <body>
      <div id="topFix">
        ${loginId}님 게시판 입장
      </div>
      <div id="container">
        <div id="topHeader">
          <div class="boardNumH">
            번호
          </div>
          <div class="boardTitleH">
            제목
          </div>
          <div class="boardWriterH">
            작성자
          </div>
          <div class="boardViewH">
            조회수
          </div>
          <div class="boardLikeH">
            추천수
          </div>
        </div>
        <div id="middle">
          <c:forEach var="list" items="${list}">
            <div class="boardList">
              <div class="boardNum">
                ${list.seq}
              </div>
              <div class="boardTitle">
                <a href="/detail.board?seq=${list.seq}">${list.title}</a>
              </div>
              <div class="boardWriter">
                ${list.writer}
              </div>
              <div class="boardView">
                ${list.viewCount}
              </div>
              <div class="boardLike">
                ${likeCount}
              </div>
            </div>
          </c:forEach>
          <div class="navi">${navi}</div>
        </div>

      </div>

      <button id="write">글쓰기</button>
      <input type="text" placeholder="제목검색" id="search"><button id="searchBtn">검색</button>




      <script>
        document.querySelector("#write").addEventListener("click", () => {
          location.href = "/boardWrite.board";
        })

      </script>

    </body>

    </html>