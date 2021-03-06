<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 보기</h1>
	<table border="1">
			<col width="50px">
			<col width="100px">
			<col width="200px">
			<col width="100px">
			<col width="50px">
			<tr>
				<th>NAME</th>
				<td>${dto.bd_name }</td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td>${dto.bd_title }</td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td><textarea rows="10" cols="60">${dto.bd_content }</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="button" value="수정" onclick="">
					<input type="button" value="삭제" onclick="">
					<input type="button" value="목록" onclick="location.href='controller.do?command=main'">					
				</td>
			</tr>
	</table>
</body>
</html>