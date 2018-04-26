package com.aspire.OnlineMeal.model;

import java.math.BigDecimal;

public class MarchantQualified {
    private BigDecimal id;

    private BigDecimal marchantId;

    private String managerName;

    private String managerIdentifyType;

    private String managerIdentifyCode;

    private String busLicenseCode;

    private String busLicenseName;

    private String busLicenseAddress;

    private String busLicenseValidTime;

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

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName == null ? null : managerName.trim();
    }

    public String getManagerIdentifyType() {
        return managerIdentifyType;
    }

    public void setManagerIdentifyType(String managerIdentifyType) {
        this.managerIdentifyType = managerIdentifyType == null ? null : managerIdentifyType.trim();
    }

    public String getManagerIdentifyCode() {
        return managerIdentifyCode;
    }

    public void setManagerIdentifyCode(String managerIdentifyCode) {
        this.managerIdentifyCode = managerIdentifyCode == null ? null : managerIdentifyCode.trim();
    }

    public String getBusLicenseCode() {
        return busLicenseCode;
    }

    public void setBusLicenseCode(String busLicenseCode) {
        this.busLicenseCode = busLicenseCode == null ? null : busLicenseCode.trim();
    }

    public String getBusLicenseName() {
        return busLicenseName;
    }

    public void setBusLicenseName(String busLicenseName) {
        this.busLicenseName = busLicenseName == null ? null : busLicenseName.trim();
    }

    public String getBusLicenseAddress() {
        return busLicenseAddress;
    }

    public void setBusLicenseAddress(String busLicenseAddress) {
        this.busLicenseAddress = busLicenseAddress == null ? null : busLicenseAddress.trim();
    }

    public String getBusLicenseValidTime() {
        return busLicenseValidTime;
    }

    public void setBusLicenseValidTime(String busLicenseValidTime) {
        this.busLicenseValidTime = busLicenseValidTime == null ? null : busLicenseValidTime.trim();
    }
}