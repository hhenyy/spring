<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정</title>
</head>
<body>

<form method="post" action="update">
<table border=1 width="300" align="center">
	<caption>회원수정</caption>
	<tr>
		<td>ID</td>
		<td><input type="text" name="id" value="${member.id}" readonly="readonly"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="text" name="passwd" required="required"></td>
	</tr>
	<tr>
		<td colspan=2 align=center>
			<input type="submit" value="수정">
			<input type="reset" value="취소" onClick="history.go(-1)">
		</td>
	</tr>	
</table>
</form>

</body>
</html>