<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="java.util.List" %>
<%@ page import="com.mvc.dto.MVCBoardDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	function allChk(bool){
		var chks = document.getElementsByName("chk");
		for(var i=0; i<chks.length; i++){
			chks[i].checked = bool;
		}
	}
	//체크한 글 없으면 submit 이벤트 취소 
	$(function(){
			$("#multidelete").submit(function(){
				if($("#multidelete input:checked").length==0){
					alert("하나 이상 체크하세요");
					return false;
				}
		});
	});
</script>
</head>
<body>
<% List<MVCBoardDto> list = (List<MVCBoardDto>)request.getAttribute("boardlist"); %>
	<h4 style="text-align:right; margin-right:30px;"><a href="login.jsp">로그인</a></h4>
	<h1>게시판 목록</h1>
	<form action="controller.jsp" method="post" id="multidelete">
		<input type="hidden" name="command" value="multidel">
		<table border="1">
			<col width="30px">
			<col width="50px">
			<col width="100px">
			<col width="200px">
			<col width="100px">
			<col width="50px">
			<col width="50px">
			<tr>
				<th><input type="checkbox" name="all" onclick="allChk(this.checked);"></th>
				<th>No</th>
				<th>Name</th>
				<th>Title</th>
				<th>Date</th>
				<th>update</th>
				<th>delete</th>
			</tr>
<%
		//for 반복문으로 테이블에 tr 태그 추가
		for(MVCBoardDto dto : list){
%>
		<tr>
			<td><input type="checkbox" name="chk" value="<%=dto.getBd_no() %>"></td>
			<td><%=dto.getBd_no()%></td>
			<td><%=dto.getBd_name()%></td>
			<td><a href="controller.jsp?command=selectone&bd_no=<%=dto.getBd_no()%>"><%=dto.getBd_title()%></a></td>
			<td><%=dto.getBd_date()%></td>
			<td><a href="controller.jsp?command=bd_update&bd_no=<%=dto.getBd_no()%>">수정</a></td>
			<td><a href="controller.jsp?command=bd_delete&bd_no=<%=dto.getBd_no()%>">삭제</a></td>
		</tr>
<% 
		}	
%>	
		<tr>
			<td colspan="7">
				<input type="submit" value="삭제">
				<input type="button" value="글쓰기" onclick="location.href='controller.jsp?command=bd_insert'">
			</td>
		</tr>
		</table>
	</form>
</body>
</html>