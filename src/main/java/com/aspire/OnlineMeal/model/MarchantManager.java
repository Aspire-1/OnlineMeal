package com.aspire.OnlineMeal.model;

import java.math.BigDecimal;

public class MarchantManager {
    private BigDecimal id;

    private BigDecimal marchantid;

    private String username;

    private String phone;

    private String password;

    private String managerLastloginTime;

    private String role;

    private String states;

    private String managerLoginStates;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getMarchantid() {
        return marchantid;
    }

    public void setMarchantid(BigDecimal marchantid) {
        this.marchantid = marchantid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getManagerLastloginTime() {
        return managerLastloginTime;
    }

    public void setManagerLastloginTime(String managerLastloginTime) {
        this.managerLastloginTime = managerLastloginTime == null ? null : managerLastloginTime.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states == null ? null : states.trim();
    }

    public String getManagerLoginStates() {
        return managerLoginStates;
    }

    public void setManagerLoginStates(String managerLoginStates) {
        this.managerLoginStates = managerLoginStates == null ? null : managerLoginStates.trim();
    }
}