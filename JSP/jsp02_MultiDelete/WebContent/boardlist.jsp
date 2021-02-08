<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.multi.dto.MDBoardDto" %>
<%@ page import="com.multi.dao.MDBoardDao" %>
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
	
	//체크를 하나도 하지 않았다면 submit 이벤트 취소
	$(function(){
		$("#muldelform").submit(function(){
			if($("#muldelform input:checked").length==0){
				alert("하나 이상 체크해주세요");
				return false;
			}
		});
	});
	
</script>
</head>
<body>
<% 
	MDBoardDao dao = new MDBoardDao();
	List<MDBoardDto> list = dao.selectAll();	
%>
<%@ include file="./form/header.jsp" %>
	
	<h1>List</h1>
	
	<form action="muldel.jsp" method="post" id="muldelform">
		<table border="1">
			<col width="30px">
			<col width="50px">
			<col width="100px">
			<col width="300px">
			<col width="100px">
			<tr>
				<th><input type="checkbox" name="all" onclick="allChk(this.checked);"></th>
				<th>NO</th>
				<th>WRITER</th>
				<th>TITLE</th>
				<th>DATE</th>
			</tr>
<%
			if(list.size()==0){
%>
			<tr><td colspan="5">-----글이 존재하지 않습니다-----</td></tr>
<%				
			}else{
				for(MDBoardDto dto : list){
%>					
			<tr>				
				<td><input type="checkbox" name="chk" value="<%=dto.getSeq()%>"></td>
				<td><%=dto.getSeq() %></td>
				<td><%=dto.getWriter() %></td>
				<td><a href="boarddetail.jsp?seq=<%=dto.getSeq()%>"><%=dto.getTitle() %></a></td>
				<td><%=dto.getRegdate() %></td>
			</tr>				
<%					
				}
			}
%>			
			<tr>
				<td colspan="5">
					<input type="submit" value="삭제">
					<input type="button" value="글쓰기" onclick="location.href='boardwrite.jsp'">
				</td>
			</tr>
			
		</table>
		
	</form>
	
<%@ include file="./form/footer.jsp" %>
	
	
	
</body>
</html>