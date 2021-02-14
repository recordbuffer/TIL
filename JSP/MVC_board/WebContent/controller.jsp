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
	//요청 -> command에 담아 매개변수로...
	String command = request.getParameter("command");
	
	MVCBoardDao dao = new MVCBoardDao();
	System.out.println("[command : "+command+"]");
	
	//'main.jsp'로 가라는 요청일때...
	if(command.equals("main")){
		List<MVCBoardDto> list = dao.selectAll();
		request.setAttribute("allList", list);	//request 객체 유지한채로 전달..
		
		pageContext.forward("main.jsp");
	}
%>
</body>
</html>