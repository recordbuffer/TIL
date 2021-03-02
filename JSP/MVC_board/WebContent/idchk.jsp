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
			opener.document.getElementsByName("bm_pw")[0].focus();
			opener.document.getElementsByName("bm_id")[0].title="y"; 	//id 중복 체크 했으니 title 속성 'y'로 변경
		}else{
			opener.document.getElementsByName("bm_id")[0].focus();
		}
		self.close();
	}
</script>
</head>
<body>
<% String idnotused = request.getParameter("idnotused"); %>
<table border="1">
	<tr>
		<td><input type="text" name="id"></td>
	</tr>
	<tr>
		<td><%=idnotused.equals("true")?"아이디 생성가능":"아이디 중복" %></td>
	</tr>
	<tr>
		<td><input type="button" value="확인" onclick="idok('<%=idnotused%>');"></td>
	</tr>
</table>	
</body>
</html>