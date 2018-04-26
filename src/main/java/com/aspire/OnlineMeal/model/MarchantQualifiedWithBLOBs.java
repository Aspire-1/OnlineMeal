package com.aspire.OnlineMeal.model;

public class MarchantQualifiedWithBLOBs extends MarchantQualified {
    private byte[] facadePhoto;

    private byte[] innerPhoto1;

    private byte[] innerPhoto2;

    private byte[] idcardFront;

    private byte[] idcardBack;

    private byte[] busLicense;

    private byte[] cateringServiceLicense;

    public byte[] getFacadePhoto() {
        return facadePhoto;
    }

    public void setFacadePhoto(byte[] facadePhoto) {
        this.facadePhoto = facadePhoto;
    }

    public byte[] getInnerPhoto1() {
        return innerPhoto1;
    }

    public void setInnerPhoto1(byte[] innerPhoto1) {
        this.innerPhoto1 = innerPhoto1;
    }

    public byte[] getInnerPhoto2() {
        return innerPhoto2;
    }

    public void setInnerPhoto2(byte[] innerPhoto2) {
        this.innerPhoto2 = innerPhoto2;
    }

    public byte[] getIdcardFront() {
        return idcardFront;
    }

    public void setIdcardFront(byte[] idcardFront) {
        this.idcardFront = idcardFront;
    }

    public byte[] getIdcardBack() {
        return idcardBack;
    }

    public void setIdcardBack(byte[] idcardBack) {
        this.idcardBack = idcardBack;
    }

    public byte[] getBusLicense() {
        return busLicense;
    }

    public void setBusLicense(byte[] busLicense) {
        this.busLicense = busLicense;
    }

    public byte[] getCateringServiceLicense() {
        return cateringServiceLicense;
    }

    public void setCateringServiceLicense(byte[] cateringServiceLicense) {
        this.cateringServiceLicense = cateringServiceLicense;
    }
}