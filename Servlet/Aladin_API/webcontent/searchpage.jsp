<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="http://www.aladin.co.kr"></script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	function search() {
		var doc = document.getElementsByName("query")[0];
		var url = "http://www.aladin.co.kr/ttb/api/ItemSearch.aspx?ttbkey=ttbthal2001612002&Query="
			+ doc
			+ "&QueryType=Title&MaxResults=10&start=1&SearchTarget=Book&output=JS&CallBack=bookSearch&Version=20131101";
		
		$.ajax({
			url : url,
			dataType : "jsonp",
			jsonp : "bookSearch",
			crossDomain: true,
			success : function(data){
				console.log(data);
			}
		});
	};
</script>
<body>
	<h1>도서 검색</h1>
	<input type="text" name="query">
	<input type="button" value="검색" onclick="search();">
	
	<div></div>
</body>
</html>