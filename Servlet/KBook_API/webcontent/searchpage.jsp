<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<p></p>
</body>
</html>