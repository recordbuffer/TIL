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
$.ajax({
	//요청 정보
	  method: "GET",
	  url: "https://dapi.kakao.com/v3/search/book?target=title",
	  data: { query:"미움받을 용기" }
	})
	  .done(function( msg ) {
	    alert( "Data Saved: " + msg );
	  });
</script>
</head>
<body>
	<h1>도서 검색</h1>
		<input type="text" name="query">
		<input type="button" value="검색" onclick="search();">
	
	<div></div>
</body>
</html>