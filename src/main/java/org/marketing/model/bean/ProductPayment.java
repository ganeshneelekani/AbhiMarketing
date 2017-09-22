package org.marketing.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by gn033604 on 9/23/17.
 */
@Entity
@Table(name="PRODUCT_PAYMENT")
public class ProductPayment {

    private static final long serialVersionUID = 1L;

    @Column(name="PRODUCT_NAME")
    private String productName;

    @Id
    @Column(name="PRODUCT_ID")
    private String productId;

    @Column(name="HSN_CODE")
    private String hsnCode;

    @Column(name="GST_PERCENTAGE")
    private Integer gstPercentage;

    @Column(name="WEIGHT_PER_JAR")
    private Integer weightPerJar;

    @Column(name="NUMBER_OF_PIECES_PER_JAR")
    private Integer noOfPiecesPerJar;

    @Column(name="NUMBER_OF_JARS_PER_CARTOON")
    private Integer noOfJarsPerCartoon;

    @Column(name="BASIC_PRICE")
    private Integer basicPrice;

    @Column(name="ADD_OR_LESS_GST")
    private Integer addOrLessGST;

    @Column(name="BILLING_RATE_TO_SS")
    private Integer billingRateToSS;

    @Column(name="SS_MARGIN")
    private Integer ssMargin;

    @Column(name="BASIC_RATE_DISTRIBUTOR")
    private Integer basicRateDistributor;

    @Column(name="DISTRIBUTOR_GST")
    private  Integer distributorGst;

    @Column(name="BILLING_RATE_TO_DISTRIBUTOR")
    private Integer billingRateToDistributor;

    @Column(name="DISTRIBUTOR_MARGIN")
    private Integer distributorMargin;

    @Column(name="RETAILER_BASIC_RATE")
    private Integer retailerBasicRate;

    @Column(name="RETAILER_GST")
    private Integer retailerGst;

    @Column(name="BILLING_RATE_TO_RETAILER")
    private Integer billingRateToRetailer;

    @Column(name="RETAILER_MARGIN")
    private Integer retailerMargin;

    @Column(name="MRP")
    private Integer mrp;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getHsnCode() {
        return hsnCode;
    }

    public void setHsnCode(String hsnCode) {
        this.hsnCode = hsnCode;
    }

    public Integer getGstPercentage() {
        return gstPercentage;
    }

    public void setGstPercentage(Integer gstPercentage) {
        this.gstPercentage = gstPercentage;
    }

    public Integer getWeightPerJar() {
        return weightPerJar;
    }

    public void setWeightPerJar(Integer weightPerJar) {
        this.weightPerJar = weightPerJar;
    }

    public Integer getNoOfPiecesPerJar() {
        return noOfPiecesPerJar;
    }

    public void setNoOfPiecesPerJar(Integer noOfPiecesPerJar) {
        this.noOfPiecesPerJar = noOfPiecesPerJar;
    }

    public Integer getNoOfJarsPerCartoon() {
        return noOfJarsPerCartoon;
    }

    public void setNoOfJarsPerCartoon(Integer noOfJarsPerCartoon) {
        this.noOfJarsPerCartoon = noOfJarsPerCartoon;
    }

    public Integer getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(Integer basicPrice) {
        this.basicPrice = basicPrice;
    }

    public Integer getAddOrLessGST() {
        return addOrLessGST;
    }

    public void setAddOrLessGST(Integer addOrLessGST) {
        this.addOrLessGST = addOrLessGST;
    }

    public Integer getBillingRateToSS() {
        return billingRateToSS;
    }

    public void setBillingRateToSS(Integer billingRateToSS) {
        this.billingRateToSS = billingRateToSS;
    }

    public Integer getSsMargin() {
        return ssMargin;
    }

    public void setSsMargin(Integer ssMargin) {
        this.ssMargin = ssMargin;
    }

    public Integer getBasicRateDistributor() {
        return basicRateDistributor;
    }

    public void setBasicRateDistributor(Integer basicRateDistributor) {
        this.basicRateDistributor = basicRateDistributor;
    }

    public Integer getDistributorGst() {
        return distributorGst;
    }

    public void setDistributorGst(Integer distributorGst) {
        this.distributorGst = distributorGst;
    }

    public Integer getBillingRateToDistributor() {
        return billingRateToDistributor;
    }

    public void setBillingRateToDistributor(Integer billingRateToDistributor) {
        this.billingRateToDistributor = billingRateToDistributor;
    }

    public Integer getDistributorMargin() {
        return distributorMargin;
    }

    public void setDistributorMargin(Integer distributorMargin) {
        this.distributorMargin = distributorMargin;
    }

    public Integer getRetailerBasicRate() {
        return retailerBasicRate;
    }

    public void setRetailerBasicRate(Integer retailerBasicRate) {
        this.retailerBasicRate = retailerBasicRate;
    }

    public Integer getRetailerGst() {
        return retailerGst;
    }

    public void setRetailerGst(Integer retailerGst) {
        this.retailerGst = retailerGst;
    }

    public Integer getBillingRateToRetailer() {
        return billingRateToRetailer;
    }

    public void setBillingRateToRetailer(Integer billingRateToRetailer) {
        this.billingRateToRetailer = billingRateToRetailer;
    }

    public Integer getRetailerMargin() {
        return retailerMargin;
    }

    public void setRetailerMargin(Integer retailerMargin) {
        this.retailerMargin = retailerMargin;
    }

    public Integer getMrp() {
        return mrp;
    }

    public void setMrp(Integer mrp) {
        this.mrp = mrp;
    }
}
