<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
<a href="boardform.do">글작성</a><br>
글갯수 : ${listcount}개
<table border=1 align="center" width=800>
 <caption>게시판 목록</caption>
  <tr>
  <th>번호</th>
  <th>제목</th>
  <th>작성자</th>
  <th>날짜</th>
  <th>조회수</th>
  </tr>
  
  <!-- 화면 출력번호 -->
  <c:set var="num" value="${listcount-(page-1)*10}"/>
  <c:forEach var="b" items="${boardlist}">
  <tr>
  <td>
   <c:out value="${num}"/><!-- out태그나 el로 바로 출력 -->
   <c:set var="num" value="${num-1}"/>
  </td>
  <td>
  <a href="boardcontent.do?no=${b.no}&page=${page}">
  ${b.subject}
  </a>
  </td>
  <td>${b.writer}</td>
  <td>
      <fmt:formatDate value="${b.register}"
      pattern="yyyy-MM-dd HH:mm:ss"/>
  </td>
  <td>${b.readcount}</td>
  </tr>
  </c:forEach>
</table>

<!-- 페이지 처리 : <center>태그 안에 처리 -->
<center> 
<!-- 글이있을때만 아래내용 실행 -->
<c:if test="${listcount>0}"> 

<!-- 1page로 이동 -->
<a href="boardlist.do?page=1" style="text-decoration:none"><<</a>
<!-- style="text-decoration:none" 밑줄없애기 -->

<!-- 이전블록으로 이동 -->
<!--이조건을만족해야 이동할값이있음 -->
<c:if test="${startPage>10}"> 
<a href="boardlist.do?page=${startPage-10}" style="text-decoration:none">[이전]</a>
</c:if>

<!-- 각 블럭에 10개의 페이지 출력 -->
<c:forEach var="i" begin="${startPage}" end="${endPage}">
  <c:if test="${i==page}"> <!-- 현재페이지 -->
    [${i}]
  </c:if>
    <c:if test="${i!=page}"> <!-- 현재페이지가 아닌경우 -->
    <a href="boardlist.do?page=${i}">[${i}]</a>
  </c:if>
</c:forEach>

<!-- 다음블럭으로 이동 -->
<c:if test="${endPage<pageCount}">
 <a href="boardlist.do?page=${startPage+10}" style="text-decoration:none">[다음]</a>
</c:if>

<!-- 마지막 페이지로 이동 -->
<a href="boardlist.do?page=${pageCount}" style="text-decoration:none">>></a>

</c:if>
</center>
</body>
</html>