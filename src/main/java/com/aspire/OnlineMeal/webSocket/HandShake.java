package com.aspire.OnlineMeal.webSocket;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

public class HandShake implements HandshakeInterceptor {

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
	}

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) 
			throws Exception {
		System.out.println("Websocket:用户[ID:" 
			+ ((ServletServerHttpRequest) request).getServletRequest().getSession(false).getAttribute("id") 
			+ "]已经建立连接");
		
		if( request instanceof ServerHttpRequest){
			//从request中获取httpSession
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			HttpSession session = servletRequest.getServletRequest().getSession(false);
			
			// 标记用户 从HTTPSession中获取用户信息
			String id = (String) session.getAttribute("id");
			String type = (String) session.getAttribute("type");
			
			if(id != null && type != null){
				attributes.put("id", id);
				attributes.put("type", type);  	//确定用户类型
				//attributes是与websocketSession相互关联的一个桥梁 存储在 attributes中的值可以被websocketSession获取得到
			}else{
				return false;
			}
		}
		return true;
	}

}
