package com.aspire.OnlineMeal.model;

import java.math.BigDecimal;
import java.util.List;

public class UserOrderInfo {
    private BigDecimal id;

    private BigDecimal marchantId;

    private String marchantName;

    private String marchantState;

    private String code;

    private BigDecimal userid;

    private String username;

    private String userphone;

    private String isToRestaurant;

    private BigDecimal member;

    private String reserveTime;

    private String sendAddress;

    private String createTime;

    private String state;

    private String payType;

    private String payState;

    private String productCount;

    private BigDecimal offestPrice;

    private BigDecimal totalPrice;

    private BigDecimal payPrice;

    private String note;
    
    private String table;

    //订单内容信息
    private List<OrderInfo> orderContents;
    
    
    public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public void setOrderContents(List<OrderInfo> orderContents) {
		this.orderContents = orderContents;
	}

	public List<OrderInfo> getOrderContents() {
		return orderContents;
	}

	public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getMarchantId() {
        return marchantId;
    }

    public void setMarchantId(BigDecimal marchantId) {
        this.marchantId = marchantId;
    }

    public String getMarchantName() {
        return marchantName;
    }

    public void setMarchantName(String marchantName) {
        this.marchantName = marchantName == null ? null : marchantName.trim();
    }

    public String getMarchantState() {
        return marchantState;
    }

    public void setMarchantState(String marchantState) {
        this.marchantState = marchantState == null ? null : marchantState.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public BigDecimal getUserid() {
        return userid;
    }

    public void setUserid(BigDecimal userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    public String getIsToRestaurant() {
        return isToRestaurant;
    }

    public void setIsToRestaurant(String isToRestaurant) {
        this.isToRestaurant = isToRestaurant == null ? null : isToRestaurant.trim();
    }

    public BigDecimal getMember() {
        return member;
    }

    public void setMember(BigDecimal member) {
        this.member = member;
    }

    public String getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(String reserveTime) {
        this.reserveTime = reserveTime == null ? null : reserveTime.trim();
    }

    public String getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress == null ? null : sendAddress.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState == null ? null : payState.trim();
    }

    public String getProductCount() {
        return productCount;
    }

    public void setProductCount(String productCount) {
        this.productCount = productCount == null ? null : productCount.trim();
    }

    public BigDecimal getOffestPrice() {
        return offestPrice;
    }

    public void setOffestPrice(BigDecimal offestPrice) {
        this.offestPrice = offestPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}