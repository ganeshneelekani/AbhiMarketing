package org.marketing.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer {


    @Column(name="CUSTOMER_NAME")
    private String customerName;

    @Column(name="ADDRESS")
    private String address;

    @Id
    @Column(name="MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL_ADDRESS")
    private String customerEmailAddress;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }

    public void setCustomerEmailAddress(String userEmailAddress) {
        this.customerEmailAddress = userEmailAddress;
    }
}
