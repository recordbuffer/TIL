<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 목록</h1>
	<table border="1">
			<col width="50px">
			<col width="100px">
			<col width="200px">
			<col width="100px">
			<col width="50px">
			<col width="50px">
			<tr>
				<th>No</th>
				<th>Name</th>
				<th>Title</th>
				<th>Date</th>
				<th>update</th>
				<th>delete</th>
			</tr>
		<!-- foreach 태그로 테이블에 값 가져오기 -->
			<c:forEach var="dto" items="${list }">
				<tr>
					<td>${dto.Bd_no }</td>
					<td>${dto.Bd_name }</td>
					<td>${dto.Bd_title }</td>
					<td>${dto.Bd_date }</td>
					<td><a href="">수정</a></td>
					<td><a href="">삭제</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6">
					<input type="button" value="글쓰기" onclick="">
				</td>
			</tr>
	</table>
</body>
</html>