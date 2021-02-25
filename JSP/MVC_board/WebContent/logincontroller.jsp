<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.mvc.dao.BDMemberDao" %>
<%@ page import="com.mvc.dto.BDMemberDto" %>
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
	
	BDMemberDao dao = new BDMemberDao();
	
	//만약 요청이 login이라면?
	if(command.equals("login")){
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		BDMemberDto dto = dao.login(id, pw); //dto에 연결된 db에 있는 id,pw면 로그인 성공!
	
		if(dto.getBm_id()!=null){  //db에 해당 id가 있다면
			//설정한 시간동안만 값 공유하게 함
			session.setAttribute("dto", dto);
			session.setMaxInactiveInterval(60*60);  //단위:초 -> 총 60분
		
			//로그인 성공시
			//관리자 계정으로 로그인한 경우 -> 관리자 페이지로
			if(dto.getBm_role().equals("ADMIN")){
				response.sendRedirect("adminpage.jsp");
			} else if(dto.getBm_role().equals("USER")){
				response.sendRedirect("userpage.jsp");
			}
			//로그인 실패시
		} else {
%>
		<script type="text/javascript">
			alert("로그인 실패");
			location.href="browser.html";
		</script>
<%
		}	
		//만약 요청이 userinfo라면?
	} else if(command.equals("userinfo")){
		int bm_no = Integer.parseInt(request.getParameter("bm_no"));
		BDMemberDto dto = dao.selectUser(bm_no);
		
		request.setAttribute("dto", dto);
		pageContext.forward("userinfo.jsp");
	
		//만약 요청이 updatepage라면?
	} else if(command.equals("updatepage")){
		int bm_no = Integer.parseInt(request.getParameter("bm_no"));
		BDMemberDto dto = dao.selectUser(bm_no);
		
		request.setAttribute("dto", dto);
		pageContext.forward("updateuser.jsp");
	
		//만약 요청이 updateuser라면?
	} else if(command.equals("updateuser")){
		String newaddr = request.getParameter("bm_addr");
		String newemail = request.getParameter("bm_email");
		String newphone = request.getParameter("bm_phone");
	
		int bm_no = Integer.parseInt(request.getParameter("bm_no"));
		
		BDMemberDto dto = new BDMemberDto();
		dto.setBm_addr(newaddr);
		dto.setBm_email(newemail);
		dto.setBm_phone(newphone);
		dto.setBm_no(bm_no);
		
		boolean res = dao.updateUser(dto);
		
		if(res){
%>
		<script type="text/javascript">
			alert("수정 성공");
			location.href="logincontroller.jsp?command=userinfo&bm_no=<%=bm_no%>";
		</script>
<%		
		} else{
%>
		<script type="text/javascript">
			alert("수정 실패");
			location.href="logincontroller.jsp?command=userinfo&bm_no=<%=bm_no%>";
		</script>
<%			
		}
		
	}
	
	
	
	
%>
</body>
</html>