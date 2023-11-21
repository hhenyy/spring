<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<form method="post" action="login">
<table border=1 width="400" align="center">
	<caption>로그인</caption>
	<tr>
		<th>ID</th>
		<td><input type="text" name="id" required="required"></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="passwd" required="required"></td>
	</tr>
	<tr>
		<td colspan="2" align=center>
			<input type="submit" value="로그인">
			<input type="reset" value="취소">
		</td>
	</tr>
</table>
</form>
</body>
</html>