<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>PlaceHolder</title>
<link rel="shortcut icon" type="image/x-icon"
	href="/semi-img/favicon.ico" />
<!-- 제이쿼리CDN -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- 부트스트랩CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<!-- 폰트어썸CDN -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous">
<!-- 구글 폰트CDN -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="/semi-css/hotelList.css">
</head>

<body>

	<div class="container">
		<div class="containerIn">
			<div class="container">

				<!-- 사이드바 코드 시작 -->
          <div class="row header">
            <div class="col-3 align-self-center">
              <a href="index.jsp"><img src="/semi-img/logos.png" id="logo"></a>
            </div>
            <div class="col-8 align-self-center throwE">

              <input type="text" placeholder="HotelName" id="topSearch">
              <button type="button" class="top-search" id="topSearchBtn">
                <i class="fas fa-search"></i>
              </button>

            </div>
            <!-- 햄버거메뉴 -->
            <div class="col-1  align-self-center justify-content-end">
              <nav class="navbar navbar-light">
                <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas"
                  data-bs-target="#offcanvasNavbar">
                  <span class="navbar-toggler-icon"></span>
                </button>
                <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar"
                  aria-labelledby="offcanvasNavbarLabel">
                  <div class="offcanvas-header">
                    <h5 class="offcanvas-title" id="offcanvasNavbarLabel">PlaceHolder</h5>

                    <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas"
                      aria-label="Close"></button>
                  </div>
                  <hr>
                  <div class="offcanvas-body">

                    <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                      <c:choose>
                        <c:when test="${loginId != null}">
                          <!-- 로그인 이후 보일 내용 -->
                          <li class="nav-item" id="loginAcc">
                            <div class="row">
                              <div class="col-12 loginAcc"></div>
                            </div>
                            <div class="row">
                              <div class="col-8 loginMent">${loginId}님, 안녕하세요.</div>
                              <div class="col-4"><a href="/logout.user"><button class="logOut">로그아웃</button></a></div>
                            </div>
                            <div class="row loginAccBannerH">
                              <div class="col-3">
                                <a href="/list.hotel"><button class="loginAccBanner">Hotels</button></a>
                              </div>
                              <div class="col-3">
                                <a href="/inquiryList.qna"><button class="loginAccBanner">고객센터</button></a>
                              </div>
                              <div class="col-3">
                                <a href="/likeList.like?loginId=${loginId}"><button
                                    class="loginAccBanner">찜목록</button></a>
                              </div>
                              <div class="col-3">
                                <a href="/mypage.home"><button class="loginAccBanner">MyPage</button></a>
                              </div>
                            </div>
                          </li>

                          <c:if test="${loginId == 'admin00'}">
                            <button id="adminBtn">관리자 창으로</button>
                          </c:if>

                          <!-- 빠른예약 -->
                          <li class="nav-item" id="speedRevMargin">
                            <form action="/confirm.book" method="get" id="form">
                              <div class="row">
                                <hr>
                                <p class="sidetxt">빠른 예약</p>
                                <div class="nav3 col-12">
                                  <select id="sideHotelSelect" onchange="selectBoxChange(this.value);">
                                        <option >----- 호텔 선택 -----</option>
                                    <c:forEach var="list" items="${hotelListS }">
                                      <option value=${list.hotelId}>${list.hotelName}</option>
                                    </c:forEach>
                                  </select>
                                  <input type="text" name="hotelId" id="sideHotelId">
                                </div>
                                <div class="nav3 row">
                                  <div class="col-6 speedRevIn">
                                    CheckIn
                                    <input type=date name="checkIn" id="speedRevIn" min="2021-12-25" max="2022-12-30">
                                  </div>
                                  <div class="col-6 speedRevOut">
                                    CheckOut
                                    <input type=date name="checkOut" id="speedRevOut" min="2021-12-26" max="2022-12-31" onchange="onChange()">
                                  </div>
                                </div>

                                <div class="row sideRoomTypeBox">
                                  <div calss="col-8" id="sideRoomTypeBox">
                                  <span class="sideFontS">RoomType</span>
                                    <select id="selectRoomType" onchange="selectRoomChange(this.value);">
                                      <option >----- 방 선택 -----</option>   
                                      <option value="스탠다드룸">스탠다드룸</option>
                                      <option value="더블룸">더블룸</option>
                                      <option value="디럭스룸">디럭스룸</option>
                                      <option value="스위트룸">스위트룸</option>
                                      <option value="이그제큐티브룸">이그제큐티브룸</option>
                                    </select>
                                    <input type="text" name="revRoomType" id="revRoomType" display="none">
                                  </div>
                                  <div class="col-2">
                                  <span class="sideFontS">방갯수</span>
                                    <select name="revQuantity" id="revQuantity">
                                      <option value="1">1 개</option>
                                      <option value="2">2 개</option>
                                      <option value="3">3 개</option>
                                      <option value="4">4 개</option>
                                      <option value="5">5 개</option>
                                    </select>
                                  </div>
                                  <div class="col-2 align-self-right">
                                  <span class="sideFontS">객실당</span>
                                    <select name="addPrice" id="addPrice">
                                      <option value="1">1 명</option>
                                      <option value="2">2 명</option>
                                      <option value="3">3 명</option>
                                      <option value="4">4 명</option>
                                      <option value="5">5 명</option>
                                      <option value="6">6 명</option>
                                    </select>
                                  </div>
                                </div>

                                <button type="button" class="nav-2" id="sideReserveBtn">
                                  Reservation
                                </button>
                              </div>
                            </form>
                          </li>
                          <!-- 빠른예약 끝 -->

                        </c:when>
                        <c:otherwise>
                          <!-- 로그인 폼 -->
                          <li class="nav-item">
                            <div class="row signBox">
                              <form action="/login.user" method="post">
                                <div class="col-12 signInput">
                                  <input type="text" placeholder="Input ID" class="inputId" name="id" id="inputId">
                                  <input type="password" placeholder="Input PW" class="inputPw" name="pw" id="inputPw">
                                </div>
                                <div class="row">
                                  <div class="col-6 sign">
                                    <button type="button" class="signBtns" id="loginBtn">로그인</button>
                                  </div>
                                  <div class="col-6 sign">
                                    <a href="/signupPage.user"><button type="button"
                                        class="signBtns signUp">회원가입</button></a>
                                  </div>
                                </div>
                              </form>
                            </div>
                          </li>

                          <!-- 로그인 밑 캐러셀 -->

                          <li class="nav-item" id="sideC">
                            <div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
                              <div class="carousel-inner sideCBackBox">
                                <div class="sideCBack">PlaceHolder</div>
                                <div class="carousel-item active">
                                  <img src="/semi-img/sideC1.jpg" class="d-block w-100" alt="여행을 해보세요">
                                </div>
                                <div class="carousel-item">
                                  <img src="/semi-img/sideC2.jpg" class="d-block w-100" alt="나만의 공간">
                                </div>
                                <div class="carousel-item">
                                  <img src="/semi-img/sideC3.jpg" class="d-block w-100" alt="PlaceHolder">
                                </div>
                              </div>
                            </div>
                          </li>

                        </c:otherwise>
                      </c:choose>
                      <li class="nav-item nav-banner">
                        <a href="/main.home"><button type="button" class="sideBanner">처음으로</button></a>
                      </li>
                      <li class="nav-item nav-banner">
                        <a href="/articleList.article"><button type="button" class="sideBanner">자유게시판</button></a>
                      </li>
                    </ul>
                  </div>
                </div>
              </nav>
            </div>
          </div>
          <!-- 사이드바 코드 끝 -->

				<div class="row" id="banner">
					<div class="col-2 goHome bannerIn">
						<p id="goHome">처음으로</p>
					</div>
					<div class="col-2 reservation bannerIn">
						<p id="pagereload">목록다시보기</p>
					</div>
					<div class="col-2 community bannerIn">
						<p class="boardGo">커뮤니티</p>
					</div>
					<div class="col-2 qna bannerIn">
						<p class="inquiryList">고객센터</p>
					</div>
					<div class="col-2 mypage bannerIn" id="mypageGo">
							<p>마이페이지</p>
					</div>
				</div>

				<!-- 배너 밑 검색바 -->
				<div class="row bannerSearch">
					<div class="col-2">
						<select id="searchOption">
							<option>이름</option>
							<option>위치</option>
						</select>
						<button id="likeListBtn">찜목록</button>
					</div>
					<div class="col-8">
						<input type="text" placeholder="상세검색어를 입력해주세요."
							class="detailSearch">
					</div>
					<div class="col-2 align-self-start">
						<button class="detailSearchBtn">검색</button>
					</div>
				</div>
				<hr class="bannerHr">


				<!-- 리스트콘텐츠 시작 -->
				<c:forEach var="list" items="${hotelList}" varStatus="status">
					<div id="detailBox">
						<div class="row detailBox">
							<div class="col-3">
								<div class="hotelDetailPhoto">
									<img src=${list.hotelImg}>
								</div>
							</div>
							<div class="col-9">

								<div class="detailCaption">
									<div class="row">
										<div class="col-8 hotelName">
											<p class="hotelNameIn">${list.hotelName}</p>
											<span>${list.hotelRoadAddress}</span>
										</div>
										<div class="col-1 star">
											<img src="/semi-img/star.png">${list.hotelScore}
										</div>
										<div class="col-3 zzimUp">
											<c:choose>
												<c:when test="${likeDto[status.index].listLike == false}">
													<input type="text" class="heartNone" value=${list.hotelId}>
													<img src="/semi-img/false.png" id="heart" class="heartBox">
												</c:when>
												<c:when test="${likeDto[status.index].listLike == true}">
													<input type="text" class="heartNone" value=${list.hotelId}>
													<img src="/semi-img/true.png" id="heart" class="heartBox">
												</c:when>
											</c:choose>
											<form action="/goods.room" method="get">
												<input type="text" class="hotelId" name="hotelId"
													value=${list.hotelId}>
												<button class="reservationGo">예약하기</button>
											</form>
										</div>
									</div>
									<hr>

									<div class="row">
										<div class="col-12">
											<div>선택 가능한 옵션</div>
											<select class="hotelOption">
												<option>스탠다드룸</option>
												<option>더블룸</option>
												<option>디럭스룸</option>
												<option>패밀리룸</option>
												<option>이그제큐티브룸</option>
											</select>
										</div>
									</div>

									<div class="row" id="detailtxt">
										<div class="col-12">
											<p class="detailtxt">${list.hotelInfo }</p>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>
				</c:forEach>

				<div id="inner"></div>

				<div class="row" id="readMoreUp">
					<div class="col-5">
						<!-- 더보기 버튼 위치지정용 col -->
					</div>
					<div class="col-2">
						<button id="readMore">더보기</button>
					</div>
					<div class="col-5">
						<!-- 더보기 버튼 위치지정용 col -->
					</div>
				</div>
			</div>
			<!-- 푸터 -->
			<div class="container-fluid footBack">
				<div class="container">
					<div id="footer">
						<div id="footerIn">
							<div class="row">
								<div class="col-3 footer-left">

									<a href="index.jsp" class="fot_logo"></a>

								</div>
								<div class="col-3 footer-center"></div>
								<div class="col-6 footer-right">
									<ul class="foot-ul-blog">
										<li><a
											href="https://section.blog.naver.com/BlogHome.naver?directoryNo=0&currentPage=1&groupId=0">블로그</a>
										</li>
										<li><a href="/footer.jsp" target='_blank'>이용약관</a></li>
										<li><a href="/footer2.jsp" target='_blank'>개인정보처리방침</a></li>
										<li><a href="/inquiryList.qna">고객 문의</a></li>
									</ul>
								</div>
							</div>

							<div class="row">

								<div class="col-4">
									<ul class="foot-sangho">
										<li>상호명 : <a href="index.jsp" class="foot-sangho-a">PlaceHolder</a></li>
										<li>공동대표 : 기억해조</li>
										<li>사업자등록번호 : 230-00-12345</li>
										<li>동신판매업신고번호 : 2021-서울종로-05000</li>
									</ul>
								</div>

								<div class="col-5">
									<ul class="foot-sangho">
										<li>&nbsp;</li>
										<li>대표전화 : 02-1234-5678</li>
										<li>이메일 : PlaceHolder@LoremIpsum.com</li>
										<li>영업소재지 : 서울특별시 중구 남대문로 120 대일빌딩 2F, 3F</li>
									</ul>
								</div>

								<div class="col-3">
									<ul class="foot-logos">

										<li><a
											href="https://section.blog.naver.com/BlogHome.naver?directoryNo=0&currentPage=1&groupId=0"
											target='_blank' class="nblog"></a></li>
										<li><a href="https://twitter.com/" target='_blank'
											class="twitter"></a></li>
										<li><a href="https://www.instagram.com/" target='_blank'
											class="instargram"></a></li>
										<li><a href="https://www.facebook.com/" target='_blank'
											class="facebook"></a></li>

									</ul>
								</div>

							</div>
							<hr class="bottomHr">
							<div class="row">
								<div class="col-9">
									<p class="foot_caution">PlaceHolder는 통신판매중개자이자 통신판매 당사자
										입니다. 따라서 PlaceHolder는 공간 거래정보 및 거래내역을 소유할 수 있습니다.</p>
								</div>
								<div class="col-3">
									<p class="foot_caution">Copyright PLACEHOLDER Corp. All
										Rights Reserved.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<script>
        // 사이드바 관련 스크립트 시작
        $("#loginBtn").on("click", () => {
          let logId = $("#inputId").val();
          let logPw = $("#inputPw").val();
          $.ajax({
            type: "POST",
            url: "/login.user",
            data: {
              "id": logId,
              "pw": logPw
            }
          }).done(function (res) {
            if (res == 'true') {
              if (logId == 'admin00') {
                console.log("어드민 로그인");
                location.href = "/user.admin";
              } else {
                alert(`\${logId}님 환영합니다.`);
                location.reload();
              }
            } else if (res == 'false') {
              alert("아이디와 비밀번호를 확인해주세요.");
            }
          })
        })

        $(".signUp").on("click", function () {
          location.href = "/signupPage.user";
        })

        // 빠른 예약 select box 함수 ***** 현우 : 호텔 select box
        let selectBoxChange = function (value) {
          console.log(value);
          $("#sideHotelId").val(value);
        }
        // 룸 타입 selectbox 함수
        let selectRoomChange = function (value) {
          console.log(value);
          $("#revRoomType").val(value);
        }

        $(".logOut").on("click", () => {
          alert("로그아웃 되었습니다.");
        })

        // 체크인 체크아웃 날짜 확인
        function onChange(){
        	
        	let checkIn = new Date(document.getElementById("speedRevIn").value);
        	let checkOut = new Date(document.getElementById("speedRevOut").value);
        	console.log(checkIn + '' +checkOut);
        	if(checkOut <= checkIn){
        		alert("체크아웃은 체크인 날짜 다음날부터 가능합니다.");
        		$("#speedRevOut").val("");
        	}
        }
        
        // 예약 제출 전
        $("#sideReserveBtn").on("click", function () {
          let hotelId = document.getElementById("sideHotelId").value;
          let checkIn = document.getElementById("speedRevIn").value;
          let checkOut = document.getElementById("speedRevOut").value;
          let revRoomType = document.getElementById("revRoomType").value;
          let revQuantity = document.getElementById("revQuantity").value;
          let addPrice = document.getElementById("addPrice").value;

          console.log(checkIn + checkOut + revRoomType + revQuantity + addPrice);
			if(hotelId == ''){
				alert("호텔을 선택해주세요");
        }else if (checkIn == '' || checkOut == '') {
            alert("체크인, 체크아웃 날짜를 입력해주세요");
            return false;
          } else if (checkIn >= checkOut) {
            alert("체크아웃 날짜는 체크인 다음날부터 가능합니다.");
            return false;
          } else if (revRoomType == '') {
            alert("방 타입을 선택해주세요.");
            return false;
          } else if (revQuantity == '') {
            alert("방 개수를 선택해주세요.");
            return false;
          } else if (addPrice == '') {
            alert("방 1개 당 인원을 선택해주세요.");
            return false;
          } else {
            if (confirm("예약 하시겠습니까?")) {
              alert("예약이 완료되었습니다.");
              $("#form").submit();
            }
          }
        })

        // 관리자 이동버튼
        $("#adminBtn").on("click", () => {
          location.href = "/user.admin";
        })

        // 사이드바 관련 스크립트 끝


        // 검색하여 페이지 새로고침 될 시 더보기 없애기
        $(function () {
          let link = document.location.search;
          if (link != '') {
            readMore.style.display = "none";
          }
        });


        let searchBtn = document.querySelector(".detailSearchBtn");
        searchBtn.addEventListener("click", function () { // 검색버튼을 누를때 option의 값을 빼냄

          let searchTxt = document.querySelector(".detailSearch").value; // 검색창 value값 추출

          let searchBox = document.querySelector("#searchOption");
          let searchOption = searchBox.options[searchBox.selectedIndex].value; // 검색 옵션값 추출
          location.href = "/listSearch.hotel?option=" + searchOption + "&Keyword=" + searchTxt; // get으로 검색값 전달
        })

        // 더보기 버튼 ajax 
        let readMore = document.getElementById("readMore");
        let btn = 1;
        let inner = document.getElementById("inner");
        let ContentPlus = document.getElementById("readMoreUp");
        let div = '';

        readMore.addEventListener("click", function () {
          btn += 10;
          $.ajax({
            url: "/listPlus.hotel",
            data: { "btn": btn }
          }).done(function (res) {
            let result = JSON.parse(res);
            for (let i = 0; i < result.length; i++) {
              console.log("몇번 도나?" + i);
              div += `<div id="detailBox">
                <div class="row detailBox">
                  <div class="col-3">
                    <div class="hotelDetailPhoto">
                      <img src="\${result[i].hotelImg}">
                    </div>
                  </div>
                  <div class="col-9">

                    <div class="detailCaption">
                      <div class="row">
                        <div class="col-8 hotelName">
                          <p class="hotelNameIn">\${result[i].hotelName}</p>
                          <div class="hotelId">\${result[i].hotelId}</div>
                          <span>\${result[i].hotelRoadAddress}</span>
                        </div>
                        <div class="col-1 star">
                          <img src="/semi-img/star.png"> 4.9
                        </div>
                        <div class="col-3 zzimUp">
                          <input type="text" class="heartNone" value=\${result[i].hotelId}>
                          <img src="/semi-img/\${result[i].listLike}.png" id="heart" class="heartBox">
                          <form action="/goods.room" method="get">
                            <input type="text" class="hotelId" name="hotelId" value=\${result[i].hotelId}>
                            <button class="reservationGo">예약하기</button>
                          </form>
                        </div>
                      </div>
                      <hr>

                      <div class="row">
                        <div class="col-12">
                          <select class="hotelOption">
                            <option>스탠다드룸</option>
                            <option>더블룸</option>
                            <option>디럭스룸</option>
                            <option>패밀리룸</option>
                            <option>스위트룸</option>
                          </select>
                        </div>
                      </div>

                      <div class="row" id="detailtxt">
                        <div class="col-12">
                          <p class="detailtxt">\${result[i].hotelInfo }</p>
                        </div>
                      </div>

                    </div>
                  </div>
                </div>
              </div>`
              inner.innerHTML = div;
            }
            if (result.length < 10) { // 넘어올 호텔 목록이 10보다 작다면 더보기 삭제
              readMore.style.display = "none";
            }
          })
        });

        // 동적바인딩 시도중인 코드

        // 얘는 동적바인딩이 안걸림.
        // let resGo = document.getElementsByClassName("reservationGo"); // 예약하기 버튼임
        // for (let i = 0; i < resGo.length; i++) {
        //   resGo[i].addEventListener("click", function(){
        //     let hotelId = document.getElementsByClassName("hotelId")[i].innerHTML;
        //     console.log(hotelId);
        //     location.href = "/goods.room?hotelId="+hotelId;
        //   })
        // }

        // Cannot read properties of undefined (reading 'text') 에러
        // for (let i = 0; i < $(".reservationGo").length; i++){
        //   $(document).on("click", ".reservationGo", function(){
        //     let hotelId = $(".hotelid")[i].text();
        //     console.log(hotelId);
        //   })
        // }

        // 갯수 동적바인딩이 안걸림
        // for (let i = 0; i < $(".reservationGo").length; i++){
        //   $(document).on("click", ".reservationGo", function(){
        //     console.log(i);
        //   })
        // }

        // 얘는 언디파인드만 불러와짐.
        // $(document).on("click", ".reservationGo", function(){
        //   let hotelId = this.document.getElementsByClassName("hotelId")[0].innerHTML;
        //     let hotelId = $(".hotelId").text();
        //     location.href = "/goods.room?hotelId="+hotelId
        // })

        // for문 돌려서 값빼로면 break할까 생각했는데 결국 값이 처음부터 불러와짐.

        // 이건 그냥 에러
        // $(document).on("click", ".reservationGo", function(){
        //     let hotelId = document.getElementsByClassName("hotelId")[1].innerHTML;
        //     let par1 = $(".reservationGo").parent();
        //     console.log(par1);
        //     // location.href = "/goods.room?hotelId="+hotelId
        //   })

        // 강사님이 해결해주신 코드
        // $(document).on("click", ".reservationGo", function(){
        //   console.log($(this).prev().val());
        // })

        // 이건 차례대로 다불러와짐.
        // $(document).on("click", ".reservationGo", function(){
        //   for (let i = 0; i < $(".reservationGo").length; i++){
        //     console.log($($(".hotelId")[i]).text());
        //   }
        // })

        // 다선택됨
        // $(document).on("click", ".reservationGo", function(){
        //   console.log($(".reservationGo").parent());
        // })

        // 버튼 name속성에 호텔ID를 줘보기.
        // $(document).on("click", ".reservationGo", function(){
        //   console.log(this.);
        // })


        // 페이지 새로고침
        document.querySelector("#pagereload").addEventListener("click", function () {
          location.href = "/list.hotel";
        })

        // 홈으로
        document.querySelector("#goHome").addEventListener("click", function () {
          location.href = "/index.jsp";
        })

        // 커뮤니티로
        $(".boardGo").on("click", function () {
          location.href = "/articleList.article";
        })

        // 마이페이지 로그인시에만 이동
				$("#mypageGo").on("click", () => {
					if ('${loginId}' == ''){
						alert("로그인을 해주세요.");
					} else {
						location.href="/mypage.home";
					}
				})
				
		 // *** 현우 추가 : 고객센터
        document.querySelector(".inquiryList").addEventListener("click", function(){
        	location.href="/inquiryList.qna";
        })		

        // 좋아요 기능
        $(document).on("click", ".heartBox", function () {
          const $heart = $(this); // 미리 담아둠
          if ('${loginId}' == '') {
            alert("로그인을 해주세요");
            return
          } else {
            $.ajax({
              url: "/detailClick.like",
              data: {
                "loginId": '${loginId}',
                "hotelId": $(this).prev().val()
              }
            }).done(function (res) {
              if (res == 'add') { // 추가가 오면 하트 빨간색
                $heart.attr("src", "/semi-img/true.png");
              } else if (res == 'del') { // 삭제가 오면 하트 검정색
                $heart.attr("src", "/semi-img/false.png");
              }
            })
          }
        })

        // 찜목록 기능
        document.getElementById("likeListBtn").addEventListener("click", () => {
          if ('${loginId}' == '') {
            alert("로그인을 해주세요");
            return
          } else {
            let loginId = '${loginId}';
            location.href = "/likeList.like?loginId=" + loginId;
          }
        })

        // 최상단 검색창
        document.getElementById("topSearchBtn").addEventListener("click", () => {
          let keyword = document.getElementById("topSearch").value;
          location.href = "/listSearch.hotel?option=이름" + "&Keyword=" + keyword;
        })

				

      </script>

</body>

</html>