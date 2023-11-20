<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${!empty sessionScope.id }">
	${sessionScope.id }님 환영 합니다.<br><br>
	
	<a href="updateform">정보수정</a><br>
	<a href="deleteform">회원탈퇴</a><br>
	<a href="logout">로그아웃</a><br>
</c:if>
<c:if test="${empty sessionScope.id }">
	<a href="memberform">회원가입</a><br>
	<a href="loginform">로그인</a><br>
</c:if>

</body>
</html>