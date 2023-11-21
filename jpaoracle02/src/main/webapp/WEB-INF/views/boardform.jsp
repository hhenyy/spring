<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method=post action="boardinsert">
<table border=1 width=500 align=center>
	<caption>글작성</caption>
	<tr>
		<th>작성자</th>
		<td><input type=text name="writer" required="required"></td>	
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type=password name="passwd" required="required"></td>	
	</tr>
	<tr>
		<th>제목</th>
		<td><input type=text name="subject" required="required"></td>	
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="5" cols="50" name="content" required="required"></textarea></td>	
	</tr>
	<tr>
		<td colspan=2 align=center>
			<input type=submit value="글작성">
			<input type=reset value="취소">
		</td>	
	</tr>
</table>
</form>

</body>
</html>