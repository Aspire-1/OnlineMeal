package com.aspire.OnlineMeal.model;

import java.math.BigDecimal;

public class AddressInfo {
    private BigDecimal id;

    private BigDecimal userid;

    private String address;

    private String isDefault;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getUserid() {
        return userid;
    }

    public void setUserid(BigDecimal userid) {
        this.userid = userid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault == null ? null : isDefault.trim();
    }
}