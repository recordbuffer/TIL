<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.mvc.dto.MVCBoardDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MVCBoardDto dto = (MVCBoardDto)request.getAttribute("dto");
%>

	<h1>글 수정</h1>
	<form action="controller.jsp" method="post">
		<input type="hidden" name="bd_no" value="<%=dto.getBd_no() %>">
		<input type="hidden" name="command" value="update">
		<table border="1">
			<tr>
				<th>NAME</th>
				<td><%=dto.getBd_name() %></td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td><input type="text" name="title" value="<%=dto.getBd_title()%>"></td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td><textarea rows="10" cols="60" name="content"><%=dto.getBd_content() %></textarea>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<input type="button" value="목록" onclick="location.href='controller.jsp?command=main'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>