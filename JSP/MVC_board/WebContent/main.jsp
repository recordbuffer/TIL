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
<% List<MVCBoardDto> list = (List<MVCBoardDto>)request.getAttribute("allList"); %>

<%@ include file="./fix/header.jsp" %>	
	
	<h1>게시판 목록</h1>
	<form action="">
		<table border="1">
			<col width="30px">
			<col width="50px">
			<col width="100px">
			<col width="200px">
			<col width="100px">
			<col width="100px">
			<tr>
				<th><input type="checkbox" name="all" onclick="allChk(this.checked);"></th>
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
			<td><input type="checkbox" name="chk" value="<%=list.get(i).getBd_no()%>"></td>
			<td><%=list.get(i).getBd_no() %></td>
			<td><%=list.get(i).getBd_name() %></td>
			<td><a href=""><%=list.get(i).getBd_title() %></a></td>
			<td><%=list.get(i).getBd_date() %></td>
			<td><a>수정</a></td>
			<td><a>삭제</a></td>
		</tr>
<%
		}
%>
		<tr>
			<td colspan="7">
				<input type="submit" value="삭제">
				<input type="button" value="글쓰기" onclick="">
			</td>
		</tr>
		</table>
	</form>
	
<%@ include file="./fix/footer.jsp" %>
	
</body>
</html>