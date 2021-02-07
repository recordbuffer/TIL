<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.db.dao.BoardDao" %>
<%@ page import="com.db.dto.BoardDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int bd_no = Integer.parseInt(request.getParameter("bd_no"));
	String bd_title = request.getParameter("bd_title");
	String bd_content = request.getParameter("bd_content");
	
	//Dto에서 int string string 매개변수로만 이루어진 생성자를 만들어준다.
	BoardDto dto = new BoardDto(bd_no, bd_title, bd_content);
	
	BoardDao dao = new BoardDao();
	int res = dao.update(dto);
	
	if(res>0){	
%>
	<script type="text/javascript">
		alert("글 수정 성공");
		location.href="selectone.jsp?bd_no=<%=dto.getBd_no()%>";
	</script>
<%
	} else{
%>
	<script type="text/javacript">
		alert("글 수정 실패");
		location.href="update.jsp?bd_no=<%=dto.getBd_no()%>";
	</script>
<%
	}
%>
</body>
</html>