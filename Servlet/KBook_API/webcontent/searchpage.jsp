<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link href='bootstrap/bootstrap.min.css' rel='stylesheet' />
    <script src='bootstrap/bootstrap.css'></script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function () {
    $("#search").click(function () {
        $.ajax({
            method: "GET",
            url: "https://dapi.kakao.com/v3/search/book?target=title",
            data: { query: $("#bookName").val() },
            headers: { Authorization: "KakaoAK a4ccc8c49af3856c0536a0310208e7fa" }
        })
            .done(function (msg) {
                console.log(msg.documents[0].title);
                console.log(msg.documents[0].thumbnail);
                $("#coverimg").append("<img src='" + msg.documents[0].thumbnail + "'/>");
                $("h5").append("<strong>" + msg.documents[0].title + "</strong>");
                $(".card-text").append(msg.documents[0].contents);
                $(".card-author").append(msg.documents[0].authors);
                $(".card-publisher").append(msg.documents[0].publisher);
                
            });
    });
});
</script>
</head>
<body>
	<h1>도서 검색</h1>
    <input id="bookName" value="" type="text">
    <button id="search">검색</button>	
    
   <div style="height:50px;"></div>
    
    
    <!-- 결과값 담는 곳 -->
	<div class="card mb-3" style="max-width: 100%;">
	<div class="row g-0">
    <div class="col-md-4" id="coverimg"></div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title"></h5>
        <p class="card-author"></p>
        <p class="card-publisher"></p>        
        <p class="card-text"></p>
      </div>
    </div>
  </div>
</div>
</body>
</html>