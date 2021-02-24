<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.mvc.dto.BDMemberDto" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% BDMemberDto dto = (BDMemberDto)request.getAttribute("dto"); %>
<h1>내 정보</h1>
	<table border="1">
		<tr>
			<th>I D</th>
			<td><%=dto.getBm_id() %></td>
		</tr>
		<tr>
			<th>P W</th>
			<td><%=dto.getBm_pw() %></td>
		</tr>
		<tr>
			<th>NAME</th>
			<td><%=dto.getBm_name() %></td>
		</tr>
		<tr>
			<th>ADDR</th>
			<td><%=dto.getBm_addr() %></td>
		</tr>
		<tr>
			<th>EMAIL</th>
			<td><%=dto.getBm_email() %></td>
		</tr>
		<tr>
			<th>PHONE</th>
			<td><%=dto.getBm_phone() %></td>
		</tr>
		<tr>
			<th>ROLE</th>
			<td><%=dto.getBm_role() %></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="수정" onclick="location.href='logincontroller.jsp?command=updatepage&bm_no=<%=dto.getBm_no()%>'">
				<input type="button" value="탈퇴" onclick="">
				<input type="button" value="목록" onclick="location.href='userpage.jsp'">				
			</td>
		</tr>
	</table>
</body>
</html>