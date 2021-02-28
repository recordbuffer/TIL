<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function idChk(){
		var doc = document.getElementsByName("bm_id")[0]; 	//입력한 id 가져옴
		if(doc.value.trim()=="" || doc.value==null){
			alert("아이디를 입력하세요.");
		} else{
			//입력한 id 중복 체크하기 위해 logincontroller.jsp로 idchk 요청
			var target = "logincontroller.jsp?command=idchk&bm_id="+doc.value.trim();
			window.open(target,"","width=500, height=500");
		}
	}
	//id 중복체크 안했을시 pw 입력 불가
	function idChkOk(){
		var chkid = document.getElementsByName("bm_id")[0].title; //id의 title 속성 가져옴 n? y?
		if(chkid=="n"){
			alert("아이디 중복체크를 해주세요.");
			document.getElementsByName("bm_id")[0].focus();	//강제로 focus를 id로 가게 함
		}
	}
</script>
</head>
<body>
<h1>회원가입</h1>
<form action="logincontroller.jsp" method="post">
	<input type="hidden" name="command" value="insertuser">
	<table border="1">
			<tr>
				<th>I D</th>
				<td><input type="text" name="bm_id" required="required" title="n">
				<input type="button" value="중복체크" onclick="idChk();"></td>
			</tr>		
			<tr>
				<th>P W</th>
				<td><input type="text" name="bm_pw" required="required" onclick="idChkOk();"></td>
			</tr>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="bm_name" required="required">
			</tr>
			<tr>
				<th>ADDR</th>
				<td><input type="text" name="bm_addr" required="required"></td>
			</tr>
			<tr>
				<th>EMAIL</th>
				<td><input type="text" name="bm_addr" placeholder="@MEMBER.COM" required="required"></td>
			</tr>
			<tr>
				<th>PHONE</th>
				<td><input type="text" name="bm_phone" required="required"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="가입">
				</td>
			</tr>
	</table>
</form>
</body>
</html>