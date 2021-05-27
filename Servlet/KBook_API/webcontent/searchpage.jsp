<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link href='bootstrap/bootstrap.css' rel='stylesheet' />
    <script src='bootstrap/bootstrap.min.css'></script>
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
                $("p").append("<strong>" + msg.documents[0].title + "</strong>");
                $("p").append("<img src='" + msg.documents[0].thumbnail + "'/>");
            });
    });
});
</script>
</head>
<body>
	<h1>도서 검색</h1>
    <input id="bookName" value="" type="text">
    <button id="search">검색</button>	
	<div class="card mb-3" style="max-width: 540px;">

<!-- 결과값 담는 곳 -->
  <div class="row g-0">
    <div class="col-md-4">
      <img src="..." alt="...">
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title"><p></p></h5>
        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
      </div>
    </div>
  </div>
</div>
</body>
</html>