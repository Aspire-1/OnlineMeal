package com.aspire.OnlineMeal.webSocket;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.aspire.OnlineMeal.publicPOJO.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * 
 * @author Aspire
 * webSocket处理器类
 *
 */
@Component
public class MyWebSocketHandler implements WebSocketHandler {

	//定义一个用户会话队列
	public static final Map<String,WebSocketSession> userSocketSessionMap;
	//定义一个商家会话队列
	public static final Map<String,WebSocketSession> marchantSocketSessionMap;
	
	static {
		userSocketSessionMap = new HashMap<String,WebSocketSession>();
		marchantSocketSessionMap = new HashMap<String,WebSocketSession>();
	}
	/**
	 * 关闭连接后
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus arg1) throws Exception {
		
	}

	/**
	 * 建立连接之后
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println(session.getUri());
		System.out.println("--------连接成功------------");
		System.out.println("webSocket id: "+session.getId());
		//区分是用户会话还是商家会话 然后将其存储起来
		if("user".equals(session.getAttributes().get("type"))){
			String userId = (String) session.getAttributes().get("id");
			if(userSocketSessionMap.get(userId) == null){
				userSocketSessionMap.put(userId, session);
			}else{
				userSocketSessionMap.put(userId, session);
			}
		}else if("marchant".equals(session.getAttributes().get("type"))){
			
			String marchantId = (String) session.getAttributes().get("id");
			
			if(marchantSocketSessionMap.get(marchantId) == null){
				marchantSocketSessionMap.put(marchantId, session);
			}else{
				marchantSocketSessionMap.put(marchantId, session);
			}
		}
	}

	/**
	 * 处理消息
	 */
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		if(message.getPayloadLength() == 0){
			return;
		}else{
			Message gsonMsg = new Gson().fromJson(message.getPayload().toString(),Message.class);
			gsonMsg.setDate(new Date());
			sendMessageToUser(gsonMsg.getToId(),new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(gsonMsg)),(String)session.getAttributes().get("type"));
		}
	}
	
	/**
	 * 给某个session发送消息
	 */
	public void sendMessageToUser(String id,TextMessage message,String type) throws Exception{
		
		WebSocketSession session = null;
		
		if("user".equals(type)){
			//获取商家session的id 因为是用户发起的  那么ToId就是发送给商家的信息，应该找到商家的session去发送通知
			session = marchantSocketSessionMap.get(id);
		}else if("marchant".equals(type)){
			session = userSocketSessionMap.get(id);
		}
		if(session != null && session.isOpen()){
			System.out.println("发消息的session"+session.getId());
			session.sendMessage(message);
		}
		
	}

	@Override
	public void handleTransportError(WebSocketSession arg0, Throwable arg1) throws Exception {
		
	}

	@Override
	public boolean supportsPartialMessages() {

		return false;
	}

}
