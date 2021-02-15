<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %> 
   
<%@ page import="com.mvc.dto.MVCBoardDto" %>
<%@ page import="com.mvc.dao.MVCBoardDao" %>
<%@ page import="java.util.List" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//요청이 담긴 command를 매개변수로 받아오기
	String command = request.getParameter("command");

	MVCBoardDao dao = new MVCBoardDao();
	
	//만약 요청이 main이라면?
	if(command.equals("main")){
		List<MVCBoardDto> list = dao.selectAll();
		request.setAttribute("boardlist", list);
		
		pageContext.forward("main.jsp");
	
		//만약 요청이 selectone이면? 
	} else if(command.equals("selectone")){
		int bd_no = Integer.parseInt(request.getParameter("bd_no"));
		
		MVCBoardDto dto = dao.selectOne(bd_no);
		request.setAttribute("dto", dto);
		
		pageContext.forward("selectone.jsp");
	}
%>
</body>
</html>