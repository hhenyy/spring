package com.ch.webSock;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebChatHandler extends TextWebSocketHandler { 
	Map<String, WebSocketSession> users = new HashMap<String, WebSocketSession>();
	
	@Override  	  // 웹소켓 연결 직후에 처리
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users.put(session.getId(), session);
	}
	
	@Override    // 웹소켓 연결이 닫힌 직후에 처리
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		users.remove(session.getId());
	}
	
	@Override    // 웹소켓 연결후 세션과 메시지를 처리
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String msg = message.getPayload();
		TextMessage tMsg = new TextMessage(msg.substring(4));
		Collection<WebSocketSession> list = users.values();
		for (WebSocketSession wss : list) {
			wss.sendMessage(tMsg);
		}
	}
}