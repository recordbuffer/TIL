<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>  

<%@ page import="java.util.List" %>
<%@ page import="com.mvc.dto.BDMemberDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% List<BDMemberDto> list = (List<BDMemberDto>)request.getAttribute("list"); %>
<h1>전체 회원 정보 조회</h1>
<table border="1">
	<col width="50"><col width="100"><col width="100"><col width="100">
	<col width="300"><col width="150"><col width="200"><col width="50"><col width="50">
	<tr>
		<th>N O</th>
		<th>I D</th>
		<th>P W</th>
		<th>NAME</th>
		<th>ADDR</th>
		<th>PHONE</th>
		<th>EMAIL</th>
		<th>ENABLED</th>
		<th>ROLE</th>
	</tr>
<%	
	for(BDMemberDto dto : list){ 
%>
	<tr>
		<td><%=dto.getBm_no() %></td>
		<td><%=dto.getBm_id() %></td>
		<td><%=dto.getBm_pw() %></td>
		<td><%=dto.getBm_name() %></td>
		<td><%=dto.getBm_addr() %></td>
		<td><%=dto.getBm_phone() %></td>
		<td><%=dto.getBm_email() %></td>
		<td><%=dto.getBm_enabled().equals("Y")? "가입":"탈퇴" %></td>
		<td><%=dto.getBm_role() %></td>
	</tr>
<% 
	} 
%>
	<tr>
		<td colspan="9" align="right">
			<button onclick="location.href='adminpage.jsp'">메인</button>
		</td>
	</tr>
</table>
</body>
</html>