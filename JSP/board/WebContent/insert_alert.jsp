<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>    
<%@ page import="com.db.dto.BoardDto" %>
<%@ page import="com.db.dao.BoardDao" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String bd_name = request.getParameter("bd_name");
	String bd_title = request.getParameter("bd_title");
	String bd_content = request.getParameter("bd_content");
	
	BoardDto dto = new BoardDto();
	dto.setBd_name(bd_name);
	dto.setBd_title(bd_title);
	dto.setBd_content(bd_content);
	
	BoardDao dao = new BoardDao();
	int res = dao.insert(dto);
	
	if(res>0){
%>
	<script type="text/javascript">
		alert("글 등록 성공");
		location.href="main.jsp";
	</script>
<%
	} else{
%>
	<script type="text/javascript">
		alert("글 등록 실패");
		location.href="insert.jsp";
	</script>
<%
	}
%>
</body>
</html>