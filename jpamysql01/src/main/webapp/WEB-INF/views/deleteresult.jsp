<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${result == 1 }">
	<script>
		alert("정보탈퇴 성공");
		location.href="main";
	</script>
</c:if>
<c:if test="${result != 1 }">
	<script>
		alert("정보탈퇴 실패");
		history.go(-1);
	</script>
</c:if>