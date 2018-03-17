package com.aspire.OnlineMeal.model;

import java.math.BigDecimal;

public class DishedInfo {
    private BigDecimal infoId;

    private BigDecimal marchantMenuid;

    private String name;

    private String typeCode;

    private String typeName;

    private String specification;

    private BigDecimal store;

    private String introduce;

    private String photoSrc;

    private BigDecimal score;

    private BigDecimal price;

    private BigDecimal discount;

    private BigDecimal discountPrice;

    private byte[] photo;

    public BigDecimal getInfoId() {
        return infoId;
    }

    public void setInfoId(BigDecimal infoId) {
        this.infoId = infoId;
    }

    public BigDecimal getMarchantMenuid() {
        return marchantMenuid;
    }

    public void setMarchantMenuid(BigDecimal marchantMenuid) {
        this.marchantMenuid = marchantMenuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }

    public BigDecimal getStore() {
        return store;
    }

    public void setStore(BigDecimal store) {
        this.store = store;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getPhotoSrc() {
        return photoSrc;
    }

    public void setPhotoSrc(String photoSrc) {
        this.photoSrc = photoSrc == null ? null : photoSrc.trim();
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}