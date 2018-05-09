package com.aspire.OnlineMeal.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserInfo {
    private BigDecimal id;

    private String registPhone;

    private String registEmail;

    private String registCode;

    private String registCodeTime;

    private String registTime;

    private String lastLoginTime;

    private String userName;

    private String password;

    private String loginState;

    private String state;

    private String isDelete;

    private String address;

    @JsonIgnore
    private byte[] headPhoto;
    //附件文件名
  	private String photoFileName=null;
  	//附件文件类型
  	private String photoContentType=null;

    private String openId;
    
    private String headPhotoUrl;
    
    public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public String getHeadPhotoUrl() {
		return headPhotoUrl;
	}

	public void setHeadPhotoUrl(String headPhotoUrl) {
		this.headPhotoUrl = headPhotoUrl;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getRegistPhone() {
        return registPhone;
    }

    public void setRegistPhone(String registPhone) {
        this.registPhone = registPhone == null ? null : registPhone.trim();
    }

    public String getRegistEmail() {
        return registEmail;
    }

    public void setRegistEmail(String registEmail) {
        this.registEmail = registEmail == null ? null : registEmail.trim();
    }

    public String getRegistCode() {
        return registCode;
    }

    public void setRegistCode(String registCode) {
        this.registCode = registCode == null ? null : registCode.trim();
    }

    public String getRegistCodeTime() {
        return registCodeTime;
    }

    public void setRegistCodeTime(String registCodeTime) {
        this.registCodeTime = registCodeTime == null ? null : registCodeTime.trim();
    }

    public String getRegistTime() {
        return registTime;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime == null ? null : registTime.trim();
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime == null ? null : lastLoginTime.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getLoginState() {
        return loginState;
    }

    public void setLoginState(String loginState) {
        this.loginState = loginState == null ? null : loginState.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public byte[] getHeadPhoto() {
        return headPhoto;
    }

    public void setHeadPhoto(byte[] headPhoto) {
        this.headPhoto = headPhoto;
    }
}