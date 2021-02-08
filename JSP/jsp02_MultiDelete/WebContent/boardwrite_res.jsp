<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.multi.dto.MDBoardDto" %>
<%@ page import="com.multi.dao.MDBoardDao" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	MDBoardDto dto = new MDBoardDto(writer, title, content); //string string string 생성자 dto에 추가

	MDBoardDao dao = new MDBoardDao();
	int res = dao.insert(dto);
	
	if(res>0){
%>
	<script type="text/javascript">
		alert("글 등록 성공");
		location.href="boardlist.jsp";
	</script>
<%
	} else{
%>
	<script type="text/javascript">
		alert("글 등록 실패");
		location.href="boardwrite.jsp";	
		/*
			history.back(); -> 이전페이지로 돌아가기
			history.go(-1);
		*/
	</script>
<%
	}
%>
</body>
</html>