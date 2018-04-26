package com.aspire.OnlineMeal.webSocket;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.aspire.OnlineMeal.publicPOJO.Message;
import com.aspire.OnlineMeal.service.IUserInfoService;
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
	
	@Autowired
	private IUserInfoService iuis = null;
	
	static {
		userSocketSessionMap = new HashMap<String,WebSocketSession>();
		marchantSocketSessionMap = new HashMap<String,WebSocketSession>();
	}
	/**
	 * 关闭连接后
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus arg1) throws Exception {
		String type = (String) session.getAttributes().get("type");
		String id = (String) session.getAttributes().get("id");
		if("user".equals(type)){
			userSocketSessionMap.remove(id);
		}else if("marchant".equals(type)){
			marchantSocketSessionMap.remove(id);
		}
		System.out.println("sessionId: "+session.getId()+"已下线");
	}

	/**
	 * 建立连接之后
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("--------连接成功------------");
		System.out.println("webSocket id: "+session.getId());
		
		//区分是用户会话还是商家会话 然后将其存储起来
		if("user".equals(session.getAttributes().get("type"))){
			String userId = (String) session.getAttributes().get("id");
			if(userSocketSessionMap.get(userId) == null){
				userSocketSessionMap.put(userId, session);
			}else{
				//给旧session发送消息，已被迫使下线
				WebSocketSession oldSession = userSocketSessionMap.get(userId);
				
				//此代码块有存在并发问题...
				sendMessageToUserOutLogin(oldSession);
				
				oldSession.close();
				System.out.println("已经迫使旧session下线");
				userSocketSessionMap.put(userId, session);
			}
		}else if("marchant".equals(session.getAttributes().get("type"))){
			
			String marchantId = (String) session.getAttributes().get("id");
			
			if(marchantSocketSessionMap.get(marchantId) == null){
				marchantSocketSessionMap.put(marchantId, session);
			}else{
				//给旧session发送消息，已被迫使下线
				WebSocketSession oldSession = marchantSocketSessionMap.get(marchantId);
				
				//此代码块有存在并发问题...
				sendMessageToUserOutLogin(oldSession);
				
				oldSession.close();
				System.out.println("已经迫使旧session下线");
				marchantSocketSessionMap.put(marchantId, session);
			}
		}
		System.out.println("商家列表");
		for(Map.Entry<String, WebSocketSession> entry : marchantSocketSessionMap.entrySet()){
            System.out.println("键 key: "+entry.getKey()+" 值value: "+entry.getValue()+"webscoketId: "+entry.getValue().getId());
        }
		
		System.out.println("用户列表");
		for(Map.Entry<String, WebSocketSession> entry : userSocketSessionMap.entrySet()){
            System.out.println("键 key: "+entry.getKey()+" 值value: "+entry.getValue()+"webscoketId: "+entry.getValue().getId());
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
			System.out.println("发消息的session："+session.getId());
			session.sendMessage(message);
		}
	}
	
	public void sendMessageToUserOutLogin(WebSocketSession session) throws Exception{
		WebSocketMessage message = new TextMessage("code:10,message:尊敬的用户你的账号在"+new Date()+"在别处登陆,如非本人操作请更改密码");
		System.out.println("给用户"+session.getId()+"发消息");
		session.sendMessage(message);
	}

	@Override
	public void handleTransportError(WebSocketSession arg0, Throwable arg1) throws Exception {
		
	}

	@Override
	public boolean supportsPartialMessages() {

		return false;
	}

}
