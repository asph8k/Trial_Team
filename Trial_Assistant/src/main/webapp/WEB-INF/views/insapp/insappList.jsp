<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>

	<title>기관 신청자 정보 목록</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

	<!-- 페이지 무조건 추가  -->
	<link rel="shortcut icon" type="image/x-icon"
		href="${pageContext.request.contextPath }/resources/images/favicon.ico">
	
	
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/templatemo.css">
	
	
	<!-- Load fonts style after rendering the layout styles -->
	<link rel="stylesheet"
		href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/fontawesome.min.css">
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
	
	<!-- 아이콘 깨지는 것 해결하는 script -->
	<script src="https://kit.fontawesome.com/22ff043012.js"
		crossorigin="anonymous"></script>
	
	<!-- Start Script -->
	<script
		src="${pageContext.request.contextPath }/resources/js/jquery-1.11.0.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/js/jquery-migrate-1.2.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/js/templatemo.js"></script>
	<script src="${pageContext.request.contextPath }/resources/js/custom.js"></script>
	<!-- End Script -->
	
	<!-- 무조건 페이지 추가  -->

    <style>
      #notice_hit {
        text-align: left !important;
      }

      #middle-sect {
        padding-top: 100px;
        padding-bottom: 100px;
      }

      .btn-page {
        width: 80%;
        font-size: 10px;
        padding: 0, 0%;
      }

      .andBtns {
        width: 100%;
        display: flex;
        justify-content: space-between;
      }
      .paging-btns {
        margin: 0 auto;
      }

      .del-btn{
        display: flex;
        justify-content : center;
      }

      .sec-list{
        padding: 10% !important;
      }

      .file-btn{
    font-size: 15px !important;
    font-weight: 500;
}
.sec-list{
        padding: 10% !important;
}


/* 여기서부터 추가 */
.form-total{
    padding-top: 100px;
}

.side-sec{
    float: left;
    width: 10%;
    margin-left: 0;
}

.total-sec{
    width: 70%;
    float: right;
    margin-right: 100px;
}

.notice-regi-btn{
    margin-top: 10px;
    float: right;
    padding-bottom: 100px;
}

/*
    왼쪽 사이드 카테고리
*/

.col-lg-3 {
    margin-top: 150px;
    margin-left: 100px;
    width: 360px;
}

.pb-3 a {
    font-weight: bold;
    padding-bottom: 15px;
}

.pb-3 a:hover {
    color: #5a95f5;
}

/*-----------------------------------------------------------------*/

/*
    사이드 버튼 이벤트 효과
*/

.action-btn {
    padding: 15px 100px;
    margin:10px 4px;
    font-family: sans-serif;
    text-transform: uppercase;
    text-align: center;
    position: relative;
    text-decoration: none;
    display:inline-block;
    
}

.action-btn::before{
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    display: block;
    width: 100%;
    height: 100%;
    z-index: -1;
    transform: scaleX(.3);
    opacity: 0;
    transition: all .3s
}
  .action-btn:hover::before{
    opacity: 1;
    background-color: #212934;
    -webkit-transform: scaleX(1);
    transform: scaleX(1);
    transition: -webkit-transform .6s cubic-bezier(.08, .35, .13, 1.02), opacity .4s;
    transition: transform .6s cubic-bezier(.08, .35, .13, 1.02), opacity;   
}

.pb-3 a:hover {
    color: white;
}

/*-----------------------------------------------------------------*/


/* title style */
.announcement-detail-title{
    width: 100%;
    margin-bottom: 80px;
}
.announcement-detail-title h3{
    text-align: center;
    margin: 0 auto;
    border-top:2px solid #888888 ;
    border-bottom:2px solid #888888 ;
    padding: 15px;
    color: #808080;
    width: 50%;
    font-size: 20px;
}

/* 검색 버튼  */
.search-btn{
  display: flex;
  justify-content: center;
  margin: 0%;
}

/* 페이징 디자인 추가하기 */
#pagination {
	padding-left: 550px;
}

#beforeBtn {
	padding-left: 15px;
}

.pageBtn{
	margin-right:10px;
}
/* 페이징 디자인 추가하기 */

.announcement-search {
        width: 430px;
        margin-bottom: 10px;
        float: right;
        justify-content: center;
      }

      .announcement-search-input {
        margin-right: 0 !important;
        border-radius: 5px;
        padding: 3px 9px;
        border: 1px solid #d6d6d6;
      }

      #announcement-search-btn {
        border-radius: 5px;
        border: 1px solid black;
        font-size: 15px;
        padding: 7px 9px;
        background: white;
        color: black;
        width: 70px;
      }

      .total{
        padding-bottom: 100px;
      }

      /* 푸터 */
    .under-footer {
        height: 150px;
    }

    .footer-box2 {
        padding: 20px 0px;
        position: relative;
        left: 160px;
        bottom: 115px;
        font-size: 17px !important;
        font-weight: 100 !important;
        line-height: 30px;
    }

    </style>

</head>
<body>

	<%@ include file="../include/header2.jsp"%>
	
	        <!-- side바 추가 -->
      <div class="total clearfix">
          <!-- form을 감싸고 있음-->
      <div class="container side-sec">
          <div class="row">
  
            <div class="col-lg-3">
              <h1 class="h2 pb-4">구별 명단 관리</h1>
                  
                  <ul class="list-unstyled templatemo-accordion">
                      <li class="pb-3">
                          <a class="collapsed d-flex justify-content-between h3 text-decoration-none" onclick="location.href='<c:url value = "/app/appList"/>'">
                          	등재 신청자 정보 조회
                          </a>
                      </li>
                      <li class="pb-3">
                          <a class="collapsed d-flex justify-content-between h3 text-decoration-none myInfo" onclick="location.href='<c:url value = "/insapp/insappList"/>'">
                          	기관 신청자 정보 조회
                          </a>
                      </li>
                      <li class="pb-3">
                          <a class="collapsed d-flex justify-content-between h3 text-decoration-none" onclick="location.href='<c:url value = "/suppapp/suppappList"/>'">
                          	보완 요청자 정보 조회
                          </a>
                      </li>
                      <li class="pb-3">
                          <a class="collapsed d-flex justify-content-between h3 text-decoration-none" onclick="location.href='<c:url value = "/slctn/slctnList"/>'">
                          	조력자 신청 승인자 정보 조회
                          </a>
                      </li>
                      <li class="pb-3">
                          <a class="collapsed d-flex justify-content-between h3 text-decoration-none" onclick="location.href='<c:url value = "/unq/unqList"/>'">
                          	부적격자 명단 관리
                          </a>
                      </li>
                  </ul>
          </div>
          </div>
      </div>

    <!-- Start Categories of The Month -->
      <section class = "py-3 total-sec ">
        <div class="table-box col-lg second-section ">
        <div class="more-view" id="notice_title">
          <!-- 타이틀 추가 -->
          <div class="announcement-detail-title">
              <h3>기관 신청자 목록 조회</h3>
          </div>
        </div>

        <div class="announcement-search dropdown" style="width: 500px; display: flex; justify-content: flex-end;">
          <input type="text" id="keywordInput" class="announcement-search-input" placeholder="검색할 기관 이름을 입력하세요." name="keyword" value="${pc.paging.keyword}"/>
          <button id="announcement-search-btn">검색</button>
        </div>
        </div>

        <table class="announcement-table table table-hover">
          <thead style="background-color: #e9ecef; border-top:3px solid">
            <th scope="col">번호</th>
            <th scope="col">기관 이름</th>
            <th scope="col">기관 연락처</th>
            <th scope="col">등록일</th>
            <th scope="col">삭제유무</th>
          </thead>

          <tbody>
          <form method="post" name="ListForm">
          	<c:forEach var="insappLi" items="${insapplist}">
	            <tr style="border-top : 3px solid #e9ecef">
	              <td>${insappLi.appNum}</td>
	              <td>
	              	<a href="<c:url value='/insapp/insappDetail/${insappLi.appNum}${pc.makeURI(pc.paging.pageNum)}'/>">${insappLi.appInsName}</a>
	              </td>
	              <td>${insappLi.appInsPhone}</td>
	              <!-- Javascript를 사용해서 날짜 입력받거나  -->
	              <td><fmt:formatDate value="${insappLi.appDate}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate></td>
	              <td><button class="btn del-btn removeBtn" type="button" id="inputGroupFileAddon04">삭제</button></td>
	            </tr>
            </c:forEach>
           </form>
          </tbody>
        </table>

				<form action="<c:url value= '/insapp/insappList'/>" name="pageForm">
					<div class="text-center search-select">
						<ul id="pagination" class="pagination pagination-sm">
							<c:if test="${pc.prev }">
								<!-- 모델 객체로 보내진 pcv라는 이름의 값에서 prev가 true라면 밑의 내용 실행  -->
								<li><a href="#" id="beforeBtn" class="btn btn-outline-secondary"
									data-pagenum="${pc.beginPage-1 }">이전</a></li>
							</c:if>

							<c:forEach var="page" begin="${pc.beginPage }"
								end="${pc.endPage }">
								<!-- 페이지 구성  -->
								<li class="${pc.paging.pageNum == page ? 'active' : '' }" class="pageBtn"><a
									href="#" data-pagenum="${page}"
									class="btn btn-outline-secondary" >${page}</a></li>

								<!-- <li><a href="#">2</a></li>
	                        <li><a href="#">3</a></li>
	                        <li><a href="#">4</a></li>
	                        <li><a href="#">5</a></li> -->

							</c:forEach>

							<c:if test="${pc.next}">
								<li class="pageBtn"><a href="#" class="btn btn-outline-secondary" data-pagenum="${pc.endPage+1 }">다음</a></li>
							</c:if>
						</ul>

					</div>

					<!-- 페이지 관련 버튼(이전, 다음 , 페이지 번호) 클릭 시 같이 숨겨서 보내줄 공통 값 -->
					<input type="hidden" name="pageNum" value="${pc.paging.pageNum }">
					<input type="hidden" name="cpp" value="${pc.paging.cpp }">
					<input type="hidden" name="condition"
						value="${pc.paging.condition }"> <input type="hidden"
						name="keyword" value="${pc.paging.keyword }">
					<!-- type을 hidden으로 작성해서 해당 값들을 숨겨서 보내줌  -->
				</form>
    </section>
  
  </div>
	
	<%@ include file="../include/footer1.jsp"%>
	
<script>
 $(function() {

	 const msg = '${msg}';
	  if(msg !== '') {
		  alert(msg);
	  }
	 
	  $('#pagination').on('click', 'a', function(event) {
			// pagination이라는 아이디의 자식인 a태그에 클릭이 발생한다면 함수 실행
			event.preventDefault();
			// a태그의 고유 기능 중지 

			// 현재 이벤트가 발생한 요소(버튼)의 data-pageNum의 값을 얻어서 변수에 저장
			// const value = event.target.dataset.pageNum;
			const value = $(event.target).data('pagenum');
			console.log(value);

			// 페이지 버튼들을 감싸고 있는 form태그를 name으로 지목해서 
			// 그 안에 숨겨져 있는 pageNum이라는 input 태그의 value에 위에서 얻은 
			// data-pageNum의 값을 삽입한 후 submit
			// 그러면 서버에서 page의 정보를 다시 받아서 다시 목록 출력 
			document.pageForm.pageNum.value = value;
			document.pageForm.submit();
		});
     
     $('.removeBtn').click(function() {
 		if(confirm("삭제하시겠습니까?")) {
 			const AppNum = $(this).parent().prev().prev().prev().prev().text();
 			console.log(AppNum);
 			
  			$('form[name=ListForm]').attr('action', '<c:url value="/insapp/insappDelete/' + AppNum + '"/>');
 			$('form[name=ListForm]').submit();
  		}
 	});
     
   //검색 버튼 이벤트 처리	
 	
 	$('#announcement-search-btn').click(function() {
 		const keyword = $('#keywordInput').val();
 		location.href="<c:url value='/insapp/insappList?keyword=" + keyword + "&page=1&cpp=10'/>";
 	});
 	
 	//검색창에서 엔터키 입력 시 이벤트 처리
 	$('#keywordInput').keydown(function(e) {
 		if(e.keyCode === 13) { //키가 13번이면 실행 (13 -> 엔터)
 			$('#searchBtn').click();
 		}
 	});

});
</script>

</body>
</html>