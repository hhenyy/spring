<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글삭제</title>
</head>
<body>

<form method=post action="boarddelete.do">
<input type="hidden" name="no" value="${param.no}">
<input type="hidden" name="page" value="${param.page}">
<!--hidden값으로 post방식으로 넘김
no: update와 비번찾아서 비교시 필요(수정폼 페이지에서 비교를 해도되긴함)
page: 원래글목록으로돌아가야해서 필요 
상세페이지 하단에서 넘어온 no, page값을 param으로 받음 ${param.page}: request.getParameter역할-->
<table border=1 width=400 align=center>
	<caption>글삭제</caption>
	<tr><th>비밀번호</th>
		<td><input type=password name="passwd" required="required"></td>
	</tr>
	<tr><td colspan=2 align=center>
			<input type=submit value="글삭제">
			<input type=reset value="취소">
		</td>
	</tr>
</table>
</form>

</body>
</html>