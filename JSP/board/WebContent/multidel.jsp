<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.db.dao.BoardDao" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[] bd_no = request.getParameterValues("chk");

	BoardDao dao = new BoardDao();
	int res = dao.multiDelete(bd_no);
	
	if(res==bd_no.length){
%>
	<script type="text/javascript">
		alert("체크된 글 모두 삭제 성공");
		location.href="main.jsp";
	</script>
<%
	}else {
%>		
	<script type="text/javascript">
		alert("체크된 글 모두 삭제 실패");
		location.href="main.jsp";
	</script>
<%
	}
%>
</body>
</html>