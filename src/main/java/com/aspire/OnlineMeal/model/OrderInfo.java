package com.aspire.OnlineMeal.model;

import java.math.BigDecimal;

public class OrderInfo {
    private BigDecimal id;

    private String dishedId;

    private String dishedName;

    private BigDecimal dishedCount;

    private BigDecimal dishedPrice;

    private BigDecimal dishedDiscount;

    private BigDecimal dishedDiscountPrice;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDishedId() {
        return dishedId;
    }

    public void setDishedId(String dishedId) {
        this.dishedId = dishedId == null ? null : dishedId.trim();
    }

    public String getDishedName() {
        return dishedName;
    }

    public void setDishedName(String dishedName) {
        this.dishedName = dishedName == null ? null : dishedName.trim();
    }

    public BigDecimal getDishedCount() {
        return dishedCount;
    }

    public void setDishedCount(BigDecimal dishedCount) {
        this.dishedCount = dishedCount;
    }

    public BigDecimal getDishedPrice() {
        return dishedPrice;
    }

    public void setDishedPrice(BigDecimal dishedPrice) {
        this.dishedPrice = dishedPrice;
    }

    public BigDecimal getDishedDiscount() {
        return dishedDiscount;
    }

    public void setDishedDiscount(BigDecimal dishedDiscount) {
        this.dishedDiscount = dishedDiscount;
    }

    public BigDecimal getDishedDiscountPrice() {
        return dishedDiscountPrice;
    }

    public void setDishedDiscountPrice(BigDecimal dishedDiscountPrice) {
        this.dishedDiscountPrice = dishedDiscountPrice;
    }
}