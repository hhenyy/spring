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

<c:if test="${result == 1 }">
	<script>
		alert("메일 전송 성공: EMail을 확인 하세요.");	
	</script>
</c:if>

<c:if test="${result != 1 }">
	<script>
		alert("메일 전송 실패: EMail설정을 확인하세요.");	
	</script>
</c:if>

</body>
</html>