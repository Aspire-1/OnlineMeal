package com.aspire.OnlineMeal.publicPOJO;

import java.util.Date;

/**
 * 封装传递消息的类
 * @author Aspire
 *
 */
public class Message {
	//seesion所属者id (可能是用户可能是商家)
	private String fromId;
	//发送者名称
	private String name;
	//负责接收信息的session所属者id (可能是商家也可能是用户)
	private String toId;
	//收到的消息id
	private String orderId;
	//发送的日期
	private Date date;
	public String getFromId() {
		return fromId;
	}
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getToId() {
		return toId;
	}
	public void setToId(String toId) {
		this.toId = toId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
