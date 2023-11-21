<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제폼</title>
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

<form method=post action="boarddelete">
<input type="hidden" name="no" value="${board.no}">
<input type="hidden" name="page" value="${page}">
<input type="hidden" name="pass" id="pass" value="${board.passwd}">

<table border=1 width=500 align=center>
	<caption>글삭제</caption>
	<tr>
		<th>비밀번호</th>
		<td><input type=password name="passwd" id="passwd" required="required"></td>	
	</tr>
	<tr>
		<td colspan=2 align=center>
			<input type=submit value="글삭제">
			<input type=reset value="취소">
		</td>	
	</tr>
</table>
</form>

</body>
</html>