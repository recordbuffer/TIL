<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.my.dto.MyBoardDto" %>
<%@ page import="com.my.dao.MyBoardDao" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String myname = request.getParameter("myname");
	String mytitle = request.getParameter("mytitle");
	String mycontent = request.getParameter("mycontent");
	
	MyBoardDto dto = new MyBoardDto();
	dto.setMyname(myname);
	dto.setMytitle(mytitle);
	dto.setMycontent(mycontent);
	
	MyBoardDao dao = new MyBoardDao();
	int res = dao.insert(dto);

	if(res>0){
%>
	<script type="text/javascript">
		alert("글 등록 성공");
		location.href="mylist.jsp";
	</script>
<%
	} else{
%>
	<script type="text/javascript">
		alert("글 등록 실패");
		location.href="myinsert.jsp";
	</script>
<%		
	}
	
%>

</body>
</html>