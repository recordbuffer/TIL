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
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#updateform").submit(function(){
		var count = 0;
		$(".updateval").each(function(){
			if($(this).val()==""||$(this).val()==null){
				alert($(this).parent().prev("th").text()+" 입력하세요");
				$(this).focus();
				count++;
				return;
			}
		});
		if(count>0){
			return false;
		}
	});
});
</script>
</head>
<body>
<% BDMemberDto dto = (BDMemberDto)request.getAttribute("dto"); %>
<h1>내 정보 수정</h1>
<form action="logincontroller.jsp" method="post" id="updateform">
	<input type="hidden" name="command" value="updateuser">
	<input type="hidden" name="bm_no" value="<%=dto.getBm_no() %>">
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
			<td><input type="text" class="updatedata" name="bm_addr" value="<%=dto.getBm_addr()%>"></td>
		</tr>
		<tr>
			<th>EMAIL</th>
			<td><input type="text" class="updatedata" name="bm_email" value="<%=dto.getBm_email() %>"></td>
		</tr>
		<tr>
			<th>PHONE</th>
			<td><input type="text" class="updatedata" name="bm_phone" value="<%=dto.getBm_phone() %>"></td>
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