package com.aspire.OnlineMeal.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MarchantInfo {
    private BigDecimal infoId;

    private String name;

    private String address;

    private String contact;

    private String longitude;

    private String latitude;

    private String managerName;

    private String managerPhone;

    private BigDecimal qualifiedAudutId;

    private String isAudit;

    private String state;

    private String registTime;

    private String type;

    private String startTime;

    private String endTime;

    private BigDecimal totalScore;

    private BigDecimal foodScore;

    private BigDecimal serviceSocre;

    private BigDecimal environmentScore;

    private String note;
    //登陆状态
    private String loginState;
    //商家头像 
    @JsonIgnore
    private byte[] photo;
    //商家头像路径
    private String photoSrc;
    //附件文件名
  	private String photoFileName=null;
  	//附件文件类型
  	private String photoContentType=null;	

    
    public String getPhotoSrc() {
		return photoSrc;
	}

	public void setPhotoSrc(String photoSrc) {
		this.photoSrc = photoSrc;
	}

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

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getLoginState() {
		return loginState;
	}

	public void setLoginState(String loginState) {
		this.loginState = loginState;
	}

	public BigDecimal getInfoId() {
        return infoId;
    }

    public void setInfoId(BigDecimal infoId) {
        this.infoId = infoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName == null ? null : managerName.trim();
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone == null ? null : managerPhone.trim();
    }

    public BigDecimal getQualifiedAudutId() {
        return qualifiedAudutId;
    }

    public void setQualifiedAudutId(BigDecimal qualifiedAudutId) {
        this.qualifiedAudutId = qualifiedAudutId;
    }

    public String getIsAudit() {
        return isAudit;
    }

    public void setIsAudit(String isAudit) {
        this.isAudit = isAudit == null ? null : isAudit.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getRegistTime() {
        return registTime;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime == null ? null : registTime.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public BigDecimal getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(BigDecimal totalScore) {
        this.totalScore = totalScore;
    }

    public BigDecimal getFoodScore() {
        return foodScore;
    }

    public void setFoodScore(BigDecimal foodScore) {
        this.foodScore = foodScore;
    }

    public BigDecimal getServiceSocre() {
        return serviceSocre;
    }

    public void setServiceSocre(BigDecimal serviceSocre) {
        this.serviceSocre = serviceSocre;
    }

    public BigDecimal getEnvironmentScore() {
        return environmentScore;
    }

    public void setEnvironmentScore(BigDecimal environmentScore) {
        this.environmentScore = environmentScore;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}