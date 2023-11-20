<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var websock;
	$(function() {
		$('#message').keypress(function(event) { //메시지 입력후 엔터키 눌렀을때도 이벤트 처리 
			var keycode = event.keyCode ? event.keyCode : event.which;
			if (keycode == 13)  //아스키 코드 13번: enter key 
				send();
			event.stopPropagation();
		});
		$('#enterBtn').click(function() {  //입장 버튼 클릭
			connect(); 
		});
		$('#exitBtn').click(function() {  // 퇴장 버튼 클릭
			disconnect();
		});
		$('#sendBtn').click(function() {  //전송 버튼 클릭
			send();
		});
	});
	function send() {
		var nickName = $('#nickName').val();
		var msg = $('#message').val();
		websocket.send('msg:' + nickName + ' => ' + msg);
		$('#message').val('');
	}
	function connect() {
		websock = new WebSocket("ws://localhost:80/webSock/chat-ws.do"); //인터셉터처럼 처리 
		websock.onopen = onOpen;
//		websock.onclose = onClose;
		websock.onmessage = onMessage;
	}
	function disconnect() {
		websock.close();
	}
	function send() {
		var nickname = $('#nickName').val();
		var message = $('#message').val();
		websock.send('msg:' + nickname + ' : ' + message);
		$('#message').val('');
	}
	function onOpen(event) {
		appendMessage("연결되었습니다.");
	}
	function onClose(event) {
		appendMessage("연결이 종료되었니다.");
	}
	function onMessage(event) {
		var data = event.data;
		appendMessage(data);
	}
	function appendMessage(msg) {
		$('#chatMessageArea').append(msg + "<br>");
		var chatAreaheight = $('#chatArea').height();
		var maxscroll = $('#chatMessageArea').height() - chatAreaheight;
		$('#chatArea').scrollTop(maxscroll);
	}
</script>
</head>
<body>
	<div class="container">
		별명 : <input type="text" id="nickName"> 
		     <input type="button" value="입장" id="enterBtn" class="btn btn-success"> 
		     <input	type="button" value="퇴장" id="exitBtn" class="btn btn-danger">
		     
			 <h2 class="text-primary">대화영역</h2>
			 <input type="text" id="message" required="required"> 
			 <input	type="button" value="전송" id="sendBtn" class="btn btn-info">
			 <div id="chatArea">
				<div id="chatMessageArea"></div>
			 </div>
	</div>
</body>
</html>