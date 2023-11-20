<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
$(document).ready(function(){
	
	// 초기 버튼 설정
	$("#write").hide();       // 글작성
	$("#update").hide();      // 글수정
	$("#delete").hide();      // 글삭제
	
	
	$("#write").click(function(){
		location.href="board/boardform";
	});
	
	$("#list").click(function(){
//		location.href="board/boardlist/page/1";		
		boardlist(1);
	});
	
});

// 게시판 목록
function boardlist(page){
	$("#detail").hide();
	$("#updateform").hide();
	$("#mytable").show();
	
	$.ajax({
		type : "GET",
		url : "${pageContext.request.contextPath}/board/boardlist/"+page,
		success : function(result){			
			var content = "<tr><th>번호</th><th>제목</th><th>작성자</th><th>날짜</th><th>조회수</th></tr>"
			$.each(result, function(index, item){
				content += "<tr><td>"+item.no+"</td>" 
				content += "<td><a href='javascript:boardcontent("+item.no+","+page+")'>"+item.subject+"</a></td>"
				content += "<td>"+item.writer+"</td>" 
				content += "<td>"+item.register+"</td>" 
				content += "<td>"+item.readcount+"</td></tr>"				
			});				
			$("#mytbody").html(content);
		}			
	});		
}

// 상세 페이지
function boardcontent(no, page){
	$("#mytable").hide();
	$("#detail").show();	

	$.ajax({
		type : "GET",
		url : "${pageContext.request.contextPath}/board/boardcontent/"+no+"/"+page,
		success : function(result){
			
			var content = "<table border=1><caption>상세페이지</caption>"
			    content += "<tr><th>번호</th><td>"+result.no+"</td></tr>"
			    content += "<tr><th>제목</th><td>"+result.subject+"</td></tr>"
			    content += "<tr><th>작성자</th><td>"+result.writer+"</td></tr>" 
			    content += "<tr><th>날짜</th><td>"+result.register+"</td></tr>"
			    content += "<tr><th>내용</th><td>"+result.content+"</td></tr>"							
			    content += "<tr><td colspan=2 align=center>"							
			    content += "<input type=button value=수정  onclick='updateform("+result.no+","+page+")'>"							
			    content += "<input type=button value=삭제  onclick='delete1("+result.no+","+page+")'>"							
			    content += "</td></tr></table>"							
			
			$("#detail").html(content);
		}			
	});		
}

// 수정폼
function updateform(no, page){
//	alert(no);
//	alert(page);
	alert("수정폼");
	$("#detail").hide();
	$("#updateform").show();
	
	$.ajax({
		type : "GET",
		url : "${pageContext.request.contextPath}/board/updateform/"+no+"/"+page,
		success : function(result){
			
			var content = "<form id='myupdate'><table border=1>"
			    content += "<input type=hidden name=no value="+result.no+">"
			    content += "<tr><th>번호</th><td>"+result.no+"</td></tr>"
			    content += "<tr><th>제목</th><td><input type=text name=subject value="+result.subject+"></td></tr>"
			    content += "<tr><th>작성자</th><td><input type=text name=write value="+result.writer+"></td></tr>" 
			    content += "<tr><th>내용</th><td><input type=text name=content value="+result.content+"></td></tr>"							
			    content += "<tr><td colspan=2 align=center>"							
			    content += "<input type=button value=수정  onClick='update("+page+")'>"							
			    content += "</td></tr></table></form>"							
			
			$("#updateform").html(content);
		}			
	});		
	
}

// 글수정
function update(page){
	alert("수정");
	alert(page);
	
	$.ajax({
		type : "update",
		url : "${pageContext.request.contextPath}/board/boardupdate/"+page,
		data : $("#myupdate").serialize(),
		success : function(result){
			console.log(result);
			alert(result);
			if(result == 1){
				alert("수정성공");
			}else{
				alert("수정실패");
			}
			location.href="${pageContext.request.contextPath}/board/boardlist/page/1"
		}	
	});	
}

//글삭제
function delete1(no, page){
	alert(no);
	alert(page);
}
</script>
</head>
<body>

<form>
	<input type="button" id="write" value="글작성">
	<input type="button" id="list" value="글목록">
	<input type="button" id="update" value="글수정">
	<input type="button" id="delete" value="글삭제">
</form>

<!-- 글목록  -->
<table id="mytable" align="center" width=800>
	<tbody id="mytbody"></tbody>
</table>

<!-- 상세 페이지 -->
<div id="detail"></div>

<!-- 수정폼 페이지 -->
<div id="updateform"></div>

</body>
</html>