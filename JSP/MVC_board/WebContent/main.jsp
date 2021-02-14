<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="java.util.List" %>
<%@ page import="com.mvc.dto.MVCBoardDto" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	List<MVCBoardDto> list = (List<MVCBoardDto>)request.getAttribute("allList"); 
%>
	
	<h1>게시판 목록</h1>
		<table border="1">
			<col width="50px">
			<col width="100px">
			<col width="200px">
			<col width="100px">
			<col width="100px">
			<tr>
				<th>No</th>
				<th>Name</th>
				<th>Title</th>
				<th>Date</th>
				<th>update</th>
				<th>delete</th>
			</tr>
<%
		//for 반복문으로 테이블에 tr 태그추가
		for(int i=0; i<list.size(); i++){
%>
		<tr>
			<td><%=list.get(i).getBd_no() %></td>
			<td><%=list.get(i).getBd_name() %></td>
			<td><a href=""><%=list.get(i).getBd_title() %></a></td>
			<td><%=list.get(i).getBd_date() %></td>
			<td><a href="">수정</a></td>
			<td><a href="">삭제</a></td>
		</tr>
<%
		}
%>
		<tr>
			<td colspan="6">
				<input type="button" value="글쓰기" onclick="">
			</td>
		</tr>
		</table>
		
</body>
</html>