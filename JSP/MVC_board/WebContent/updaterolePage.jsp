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
<% BDMemberDto dto = (BDMemberDto)request.getAttribute("selectuser"); %>
<h1>회원 등급 변경</h1>
<form action="logincontroller.jsp" method="post">
	<input type="hidden" name="command" value="updaterole">
	<input type="hidden" name="bm_no" value="<%=dto.getBm_no() %>">
	<table border="1">
		<col width="50"><col width="100">
		<tr>
			<th>NO</th>
			<td><%=dto.getBm_no() %></td>
		</tr>
		<tr>
			<th>ID</th>
			<td><%=dto.getBm_id() %>
		</tr>
		<tr>
			<th>NAME</th>
			<td><%=dto.getBm_name() %></td>
		</tr>
		<tr>
			<th>ROLE</th>
			<td>
				<select name="bm_role">
					<option value="USER" <%=dto.getBm_role().equals("USER")? "selected":"" %>>일반회원</option>
					<option value="MANAGER" <%=dto.getBm_role().equals("MANAGER")? "selected":"" %>>매니저</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="변경완료">
			</td>
		</tr>
	</table>
</form>
</body>
</html>