package com.aspire.OnlineMeal.model;

import java.math.BigDecimal;

public class MarchantMenu {
    private BigDecimal id;

    private String name;

    private BigDecimal marchantId;

    private String createTime;

    private String state;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getMarchantId() {
        return marchantId;
    }

    public void setMarchantId(BigDecimal marchantId) {
        this.marchantId = marchantId;
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
}