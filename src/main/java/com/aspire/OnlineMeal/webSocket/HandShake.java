package com.aspire.OnlineMeal.webSocket;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

public class HandShake extends HttpSessionHandshakeInterceptor {

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception ex) {
		// TODO Auto-generated method stub
		
		super.afterHandshake(request, response, wsHandler, ex);
	}

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) 
			throws Exception {
		System.out.println("--------连接到了--------");
		if(request instanceof ServletServerHttpRequest){
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpServletRequest httpRequest = servletRequest.getServletRequest();
            String id= new String();
            String type=new String();
            if(httpRequest.getQueryString()!=null){
            	id= httpRequest.getParameter("id");
            	type=httpRequest.getParameter("type");
            }else{
            	HttpSession session = servletRequest.getServletRequest().getSession(false);

    			// 标记用户 从HTTPSession中获取用户信息
    			id = (String) session.getAttribute("id");
    			type = (String) session.getAttribute("type");
            }
            if(id != null && type != null){
				attributes.put("id", id);
				attributes.put("type", type);  	//确定用户类型
				//attributes是与websocketSession相互关联的一个桥梁 存储在 attributes中的值可以被websocketSession获取得到
			}else{
				return false;
			}
            System.out.println("Websocket:"+type+",[ID:" 
        			+ id 
        			+ "]已经建立连接");
		}
		
		return super.beforeHandshake(request, response, wsHandler, attributes);
	}

}
