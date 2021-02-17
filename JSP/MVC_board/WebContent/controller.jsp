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
	
		//만약 요청이 bd_insert라면?
	} else if(command.equals("bd_insert")){
		response.sendRedirect("bd_insert.jsp");
		
		//만약 요청이 insert라면?
	} else if(command.equals("insert")){
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MVCBoardDto dto = new MVCBoardDto();
		dto.setBd_name(name);
		dto.setBd_title(title);
		dto.setBd_content(content);
		
		int res = dao.insert(dto);
		
		if(res>0){
%>
		<script type="text/javascript">
			alert("글 작성 성공");
			location.href="controller.jsp?command=main";
		</script>
<%			
		} else {
%>
		<script type="text/javascript">
			alert("글 작성 실패");
			location.href="controller.jsp?command=bd_insert";
		</script>
<%			
		}
		//만약 요청이 bd_update라면?
	} else if(command.equals("bd_update")){
		//요청과 같이 넘어온 bd_no 값 받아줌
		int bd_no = Integer.parseInt(request.getParameter("bd_no"));
		
		MVCBoardDto dto = dao.selectOne(bd_no);
		request.setAttribute("dto", dto);
		
		pageContext.forward("bd_update.jsp");
		
		//만약 요청이 update라면?
	} else if(command.equals("update")){
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//요청과 같이 넘어온 bd_no 값 받아줌
		int bd_no = Integer.parseInt(request.getParameter("bd_no"));
		
		MVCBoardDto dto = new MVCBoardDto();
		dto.setBd_title(title);
		dto.setBd_content(content);
		dto.setBd_no(bd_no);
		
		int res = dao.update(dto);
		
		if(res>0){
%>
		<script type="text/javascript">
			alert("글 수정 성공");
			location.href="controller.jsp?command=selectone&bd_no="+<%=bd_no%>;
		</script>
<%
		} else {
%>
		<script type="text/javascript">
			alert("글 수정 실패");
			location.href="controller.jsp?command=bd_update&bd_no="+<%=bd_no%>;
		</script>
<%
		}
		//만약 요청이 bd_delete라면?
	} else if(command.equals("bd_delete")){
	//값 여러개 삭제 하는 dao 메소드 활용해서 하나만 선택 삭제하기
		String[] noArr = new String[1];
		noArr[0] = request.getParameter("bd_no");
		
		int res = dao.multiDelete(noArr);
		
		if(res>0){
%>
		<script type="text/javascript">
			alert("글 삭제 성공");
			location.href="controller.jsp?command=main";
		</script>
<%			
		} else{
%>
		<script type="text/javascript">
			alert("글 삭제 실패");
			location.href="controller.jsp?command=selectone&bd_no="+<%=noArr[0]%>;
		</script>
<%			
		}
		//만약 요청이 multidel라면?
	} else if(command.equals("multidel")){
		String[] bd_no = request.getParameterValues("chk");
		int res = dao.multiDelete(bd_no);
		
		if(res==bd_no.length){
%>
		<script type="text/javascript">
			alert("글 삭제 성공");
			location.href="controller.jsp?command=main";
		</script>
<%
		} else {
%>
		<script type="text/javascript">
			alert("글 삭제 실패");
			location.href="controller.jsp?command=main";
		</script>
<%			
		}
	}
	
%>
</body>
</html>