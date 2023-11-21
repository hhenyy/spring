<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="mailsend.do">
<table border=1 width="500" align="center">
	<caption>EMail 보내기</caption>
	<tr>
		<th>보낸사람</th>
		<td><input type=text name="sendmail" required="required"></td>
	</tr>
	<tr>
		<th>받는사람</th>
		<td><input type=text name="receivemail" required="required"></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><input type=text name="subject" required="required"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td>
			<textarea rows="5" cols="50" name="content" required="required"></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="전송">
		</td>
	</tr>
</table>
</form>

</body>
</html>