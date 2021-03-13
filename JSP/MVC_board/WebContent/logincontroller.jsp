<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.mvc.dao.BDMemberDao" %>
<%@ page import="com.mvc.dto.BDMemberDto" %>
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
		//만약 요청이 logout라면?
	} else if(command.equals("logout")){
		//login시 설정한 session 정보 삭제함
		session.invalidate();
		response.sendRedirect("login.jsp");
		
		//만약 요청이 userinfo라면?
	} else if(command.equals("userinfo")){
		int bm_no = Integer.parseInt(request.getParameter("bm_no"));
		BDMemberDto dto = dao.selectUser(bm_no);
		
		request.setAttribute("dto", dto);
		pageContext.forward("userinfo.jsp");
		
		//만약 요청이 insertuser라면?
	} else if(command.equals("insertuser")){
		String bm_id = request.getParameter("bm_id");
		String bm_pw = request.getParameter("bm_pw");
		String bm_name = request.getParameter("bm_name");
		String bm_addr = request.getParameter("bm_addr");
		String bm_email = request.getParameter("bm_email");
		String bm_phone = request.getParameter("bm_phone");
		
		BDMemberDto dto = new BDMemberDto();
		dto.setBm_id(bm_id);
		dto.setBm_pw(bm_pw);
		dto.setBm_name(bm_name);
		dto.setBm_addr(bm_addr);
		dto.setBm_email(bm_email);
		dto.setBm_phone(bm_phone);
		
		int res = dao.insertUser(dto);
		
		if(res>0){
%>
		<script type="text/javascript">
			alert("회원가입 성공");
			location.href="login.jsp";
		</script>
<%			
		} else {
%>
		<script type="text/javascript">
			alert("회원가입 실패");
			location.href="registform.jsp";
		</script>
<%			
		}
		
		//만약 요청이 idchk라면?
	} else if(command.equals("idchk")){
		String bm_id = request.getParameter("bm_id");
		String res = dao.idChk(bm_id);
		
		boolean idnotused = true;	
		
		if(res != null){
			idnotused = false;
		}
		
		response.sendRedirect("idchk.jsp?idnotused="+idnotused);
		
		//만약 요청이 deleteuser라면?
	} else if(command.equals("deleteuser")){
		int bm_no = Integer.parseInt(request.getParameter("bm_no"));
		
		boolean res = dao.deleteUser(bm_no);
		
		if(res){
%>
			<script type="text/javascript">
				alert("탈퇴 성공");
				location.href="logincontroller.jsp?command=logout";
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
		
		//만약 요청이 updatepage라면?
	} else if(command.equals("updatepage")){
		int bm_no = Integer.parseInt(request.getParameter("bm_no"));
		BDMemberDto dto = dao.selectUser(bm_no);
		
		request.setAttribute("dto", dto);
		pageContext.forward("updateuser.jsp");
	
		//만약 요청이 updateuser라면?
	} else if(command.equals("updateuser")){
		String bm_addr = request.getParameter("bm_addr");
		String bm_email = request.getParameter("bm_email");
		String bm_phone = request.getParameter("bm_phone");
	
		int bm_no = Integer.parseInt(request.getParameter("bm_no"));
		
		BDMemberDto dto = new BDMemberDto();
		dto.setBm_addr(bm_addr);
		dto.setBm_email(bm_email);
		dto.setBm_phone(bm_phone);
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
		//만약 요청이 userlist라면?
	} else if(command.equals("userlist")){
		List<BDMemberDto> list = dao.selectAll();
		request.setAttribute("list", list);
		pageContext.forward("userlist.jsp");
	
		//만약 요청이 userlistenabled라면?
	} else if(command.equals("userlistenabled")){
		List<BDMemberDto> list = dao.selectEnabled();
		request.setAttribute("list", list);
		pageContext.forward("userlistenabled.jsp");
	
		//만약 요청이 updaterolePage라면?
	} else if(command.equals("updaterolePage")){
		int bm_no = Integer.parseInt(request.getParameter("bm_no"));
		
		BDMemberDto dto = dao.selectUser(bm_no);
		
		request.setAttribute("selectuser", dto);
		pageContext.forward("updaterolePage.jsp");
		
	}
	
	
	
	
%>
</body>
</html>