<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 목록</h1>
	<h4>${res.bm_name } 님 안녕하세요</h4>
	<input type="button" value="로그아웃" onclick="location.href='logout.do'">
	<table border="1">
		<colgroup>
			<col width="50">
			<col width="100">
			<col width="300">
			<col width="100">
		</colgroup>
		<tr>
			<th>NO</th>
			<th>NAME</th>
			<th>TITLE</th>
			<th>DATE</th>
		</tr>
		<c:forEach items="${list }" var="dto">
			<tr>
				<td>${dto.bd_no }</td>
				<td>${dto.bd_name }</td>
				<td><a href="one.do?bd_no=${dto.bd_no }">${dto.bd_title }</a></td>
				<td>${dto.bd_date }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4" align="right">
			<input type="button" value="글쓰기"
				onclick="location.href='insert.do'"></td>
		</tr>
	</table>
</body>
</html>