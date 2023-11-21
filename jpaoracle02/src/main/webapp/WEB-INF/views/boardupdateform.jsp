<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정폼</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(function(){
		$("form").submit(function(){
			if($("#pass").val() != $("#passwd").val()){
				alert("비번이 일치하지 않습니다.");
				$("#passwd").val("").focus();
				return false;
			}
		});		
	});
</script>
</head>
<body>

<form method=post action="boardupdate">
<input type="hidden" name="no" value="${board.no}">
<input type="hidden" name="page" value="${page}">
<input type="hidden" name="regdate" value="<%=new Timestamp(System.currentTimeMillis())%>">
<input type="hidden" name="pass" id="pass" value="${board.passwd}">

<table border=1 width=500 align=center>
	<caption>글수정</caption>
	<tr>
		<th>작성자</th>
		<td><input type=text name="writer" value="${board.writer}" required="required"></td>	
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type=password name="passwd" id="passwd" required="required"></td>	
	</tr>
	<tr>
		<th>제목</th>
		<td><input type=text name="subject" value="${board.subject}" required="required"></td>	
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="5" cols="50" name="content" required="required">${board.content}</textarea></td>	
	</tr>
	<tr>
		<td colspan=2 align=center>
			<input type=submit value="글수정">
			<input type=reset value="취소">
		</td>	
	</tr>
</table>
</form>

</body>
</html>