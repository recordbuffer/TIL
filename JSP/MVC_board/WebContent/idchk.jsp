<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	onload=function(){
		var id = opener.document.getElementsByName("bm_id")[0].value;	
		document.getElementsByName("id")[0].value=id;
	}
	function idok(bool){
		if(bool=="true"){
			opener.document.getElementsByName("bm_pw")
		} self.close();
	}
</script>
</head>
<body>
<% String chk = request.getParameter("chk"); %>
<table border="1">
	<tr>
		<td><input type="text" name="id"></td>
	</tr>
	<tr>
		<td><%=chk.equals("true")?"아이디 생성가능":"아이디 중복" %></td>
	</tr>
	<tr>
		<td><input type="button" value="확인" onclick="idok(<%=chk%>);"></td>
	</tr>
</table>	
</body>
</html>