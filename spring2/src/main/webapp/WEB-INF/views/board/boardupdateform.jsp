<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
</head>
<body>

<form method=post action="boardupdate.do">
<input type="hidden" name="no" value="${board.no}">
<input type="hidden" name="page" value="${page}">
<!--hidden값으로 post방식으로 넘김
no: update와 비번찾아서 비교시 필요(수정폼 페이지에서 비교를 해도되긴함)
page: 원래글목록으로돌아가야해서 필요 -->
<table border=1 width=400 align=center>
	<caption>글수정</caption>
	<tr><th>작성자명</th> <!-- required="required" 글작성을 해야만 넘어감 -->
		<td><input type=text name="writer" required="required" value=${board.writer}></td>
	</tr>
	<tr><th>비밀번호</th>
		<td><input type=password name="passwd" required="required"></td>
	</tr>
	<tr><th>제목</th>
		<td><input type=text name="subject" required="required" value=${board.subject}></td>
	</tr>
	<tr><th>내용</th><!--textarea는 value속성 적용x,간격이 적용되서 간격없이  -->
		<td><textarea cols=40 rows=5 name="content" required="required">${board.content}
		</textarea></td>
	</tr>
	<tr><td colspan=2 align=center>
			<input type=submit value="글수정">
			<input type=reset value="취소">
		</td>
	</tr>
</table>
</form>

</body>
</html>