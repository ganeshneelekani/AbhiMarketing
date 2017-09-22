package org.marketing.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by gn033604 on 9/24/17.
 */
@Entity
@Table(name="CONSIGNEE")
public class Consignee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="NAME")
    private String consigneeName;

    @Column(name="ADDRESS")
    private String address;

    @Column(name="MOBILE_NUMBER")
    private String mobileNo;

    @Column(name="PINCODE")
    private Integer pincode;

    @Column(name="STATE")
    private String state;

    @Column(name="STATE_CODE")
    private String stateCode;

    @Column(name="GSTIN")
    private String gstin;

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }
}
