<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- bootstrap css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

<style type="text/css">
.container {
	max-width: none;
	padding: 50px;
	margin-left: 50px;
}

h1 {
	margin-bottom: 60px;
}

table {
	width: inherit;
	text-align: center;
}

tr {
	height: 60px;
}
footer{
	text-align: center;
	font-weight: bold;
}
</style>
</head>
<body>

	<nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand">게시판</a>
			<form class="d-flex">
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search">
				<button class="btn btn-outline-info" type="submit">Search</button>
			</form>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<h1>게시판 목록</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-9">
				<table class="table-light table-striped">
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
						<td colspan="4" align="right"><input type="button"
							class="btn btn-outline-info" value="글쓰기"
							onclick="location.href='insert.do'"></td>
					</tr>
				</table>
			</div>
			<div class="col-md-3">
				<img alt="#" src="resources/img/v.jpg" style="height: 400px;">
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12" style="height: 100px;"></div>
		</div>
	</div>

	<footer class="footer mt-auto py-3 bg-dark">
		<div class="container">
			<span class="text-muted">비전공자 기록광_datamoney.tistory.com copyright ⓒ all rights reserved...</span>
		</div>
	</footer>



</body>
</html>