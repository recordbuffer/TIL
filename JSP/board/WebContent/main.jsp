<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.db.dao.BoardDao" %>
<%@ page import="com.db.dto.BoardDto" %>
<%@ page import="java.util.List" %>

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
	//체크한 글 없다면 submit 이벤트 취소시키기 -> multidel.jsp로 이동 취소
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
<%
	BoardDao dao = new BoardDao();
	List<BoardDto> list = dao.selectAll();
%>
<body>
<%@ include file="./fix/header.jsp" %>

	<h1>게시판 목록</h1>
	<form action="multidel.jsp" method="post" id="multidelete">
	<table border="1">
		<col width="30px">
		<col width="50px">
		<col width="100px">
		<col width="200px">
		<col width="100px">
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
	for(int i=0; i<list.size(); i++){
%>
	<tr>
		<td><input type="checkbox" name="chk" value="<%=list.get(i).getBd_no()%>"></td>
		<td><%=list.get(i).getBd_no()%></td>
		<td><%=list.get(i).getBd_name()%></td>
		<td><a href="selectone.jsp?bd_no=<%=list.get(i).getBd_no()%>"><%=list.get(i).getBd_title()%></a></td>
		<td><%=list.get(i).getBd_date()%></td>
		<td><a href="update.jsp?bd_no=<%=list.get(i).getBd_no()%>">수정</a></td>
		<td><a href="delete.jsp?bd_no=<%=list.get(i).getBd_no()%>">삭제</a></td>
	</tr>
<% 
	}
%>	
	<tr>
		<td colspan="7">
			<input type="submit" value="삭제">
			<input type="button" value="글쓰기" onclick="location.href='insert.jsp'">
		</td>
	</tr>
	</table>
	</form>
	
<%@ include file="./fix/footer.jsp" %>
	
	
</body>
</html>