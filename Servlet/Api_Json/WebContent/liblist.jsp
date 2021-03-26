<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
<% request.setCharacterEncoding("UTF-8"); %> 
<% response.setContentType("text/html; charset=UTF-8"); %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="./js/lib01.js"></script>
</head>
<body>
	<form action="lib.do" method="post">
		<input type="submit" value="db로 연동">
		<input type="hidden" name="command" value="listdb"> <!-- listdb 요청으로 db에 데이터 저장하기 -->
		<table border="1">
			<thead>
			</thead>
			<tbody>
			</tbody>
		</table>
	</form>
</body>
</html>