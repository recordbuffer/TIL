<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.multi.dto.MDBoardDto" %>
<%@ page import="com.multi.dao.MDBoardDao" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#updateform{
		display:none;
	}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	//수정버튼
	function updateFormView(){
		$("#detailform").hide();
		$("#updateform").show();
	}
	//수정취소버튼
	function detailFormView(){
		$("#detailform").show();
		$("#updateform").hide();
	}
</script>
</head>
<body>
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	MDBoardDao dao = new MDBoardDao();
	MDBoardDto dto = dao.selectOne(seq);
%>
<%@ include file="./form/header.jsp" %>

	<!-- 화면에 보여줄 게시글  -->
<div id="detailform">
	<h1>게시글 보기</h1>
	<table border="1">
		<tr>
			<th>NO</th>
			<td><%=dto.getSeq() %></td>
		</tr>	
		<tr>
			<th>WRITER</th>
			<td><%=dto.getWriter() %></td>
		</tr>
		<tr>
			<th>DATE</th>
			<td><%=dto.getRegdate() %></td>
		</tr>
		<tr>
			<th>TITLE</th>
			<td><%=dto.getTitle() %></td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td><textarea rows="10" cols="60" readonly="readonly"><%=dto.getContent() %></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="수정" onclick="updateFormView();">
				<input type="button" value="삭제" onclick="location.href='boarddelete.jsp?seq=<%=dto.getSeq()%>'">			
				<input type="button" value="목록" onclick="location.href='boardlist.jsp'">
			</td>
		</tr>
	</table>
</div>

<!-- 페이지를 바꿔주지 않고 기능 숨겨두고 필요시 쓰기 -->
<div id="updateform">
	<h1>글 수정</h1>
	
	<form action="boardupdate_res.jsp" method="post">
		<input type="hidden" name="seq" value="<%=dto.getSeq()%>">
		<table border="1">
			<tr>
				<th>NO</th>
				<td><%=dto.getSeq() %></td> <!-- 이미 데이터가 있으니 그냥 가져오기 -->
			</tr>
			<tr>
				<th>WRITER</th>
				<td><%=dto.getWriter() %></td>
			</tr>
			<tr>
				<th>DATE</th>
				<td><%=dto.getRegdate() %></td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td><input type="text" name="title" value="<%=dto.getTitle() %>" ></td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td><textarea rows="10" cols="60" name="content"><%=dto.getContent() %></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정완료">
					<input type="button" value="취소" onclick="detailFormView();">
				</td>
			</tr>
		</table>
	</form>
</div>


<%@ include file="./form/footer.jsp" %>

</body>
</html>