<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원삭제</title>
</head>
<body>

<form method="post" action="delete">
<input type="hidden" name="id" value="${sessionScope.id}">
<table border=1 width="300" align="center">
	<caption>회원삭제</caption>
	<tr>
		<td>비밀번호</td>
		<td><input type="text" name="passwd" required="required"></td>
	</tr>
	<tr>
		<td colspan=2 align=center>
			<input type="submit" value="삭제">
			<input type="reset" value="취소" onClick="history.go(-1)">
		</td>
	</tr>	
</table>
</form>

</body>
</html>