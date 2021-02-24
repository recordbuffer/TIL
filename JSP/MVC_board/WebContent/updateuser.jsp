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
<h1>내 정보 수정</h1>
<form action="">
	<table border="1">
		<tr>
			<th>I D</th>
			<td><%=dto.getBm_id() %></td>
		</tr>
		<tr>
			<th>NAME</th>
			<td><%=dto.getBm_name() %></td>
		</tr>
		<tr>
			<th>ADDR</th>
			<td><input type="text" name="newaddr" value="<%=dto.getBm_addr()%>"></td>
		</tr>
		<tr>
			<th>EMAIL</th>
			<td><input type="text" name="newemail" value="<%=dto.getBm_email() %>"></td>
		</tr>
		<tr>
			<th>PHONE</th>
			<td><input type="text" name="newphone" value="<%=dto.getBm_phone() %>"></td>
		</tr>
		<tr>
			<th>ROLE</th>
			<td><%=dto.getBm_role() %></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="완료">
			</td>
		</tr>
	</table>
</form>
</body>
</html>