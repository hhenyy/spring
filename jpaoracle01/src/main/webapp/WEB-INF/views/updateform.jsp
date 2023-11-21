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
<input type="hidden" name="id" value="${member.id }">
<table border=1 width="400" align="center">
	<caption>회원수정</caption>
	<tr>
		<th>ID</th>
		<td>${member.id }</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="passwd" required="required"></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><input type="text" name="name" value="${member.name }" required="required"></td>
	</tr>
	<tr>
		<th>E-Mail</th>
		<td><input type="text" name="email" value="${member.email }" required="required"></td>
	</tr>
	<tr>
		<td colspan="2" align=center>
			<input type="submit" value="회원수정">
			<input type="reset" value="취소" onClick="history.go(-1)">
		</td>
	</tr>
</table>
</form>
</body>
</html>