<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 페이지</title>
</head>
<body>

<table border=1 width=400 align="center">
  <caption>상세 페이지</caption>
  <tr>
    <th>작성자</th>
    <td>${board.writer}</td>
  </tr>
  <tr>
   <th>날짜</th>
   <td>
    <fmt:formatDate value="${board.register}" 
    pattern="yyyy-MM-dd HH:mm:ss"/>
   </td>
  </tr>
  <tr>
  <th>조회수</th>
  <td>${board.readcount}</td>
  </tr>
   <tr>
  <th>제목</th>
  <td>${board.subject}</td>
  </tr>
   <tr>
  <th>내용</th> <!-- 두가지 방법 -->
  <td><pre>${board.content}</pre>
  ${content}</td>
  </tr>
  <tr>
  <td colspan=2 align=center>
    <input type="button" value="목록"
 onClick="location.href='boardlist.do?page=${page}'">
    <input type="button" value="수정"
 onClick="location.href='boardupdateform.do?page=${page}&no=${board.no}'">
    <input type="button" value="삭제"
onClick="location.href='boarddeleteform.do?page=${page}&no=${board.no}'">
  </td>
  </tr>
</table>

</body>
</html>