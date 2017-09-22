package org.marketing.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import java.io.Serializable;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Created by gn033604 on 9/23/17.
 */
@Entity
@Table(name="PRODUCT")
public class Product implements Serializable{

    private static final long serialVersionUID = 1L;

    @Column(name="PRODUCT_NAME")
    private String productName;

    @Id
    @Column(name="PRODUCT_ID")
    private String productId;

    @Column(name="HSN_CODE")
    private String hsnCode;

    @Column(name="GST_PERCENTAGE")
    private Float gstPercentage;

    @Column(name="WEIGHT_PER_JAR")
    private Float weightPerJar;

    @Column(name="NUMBER_OF_PIECES_PER_JAR")
    private Integer noOfPiecesPerJar;

    @Column(name="NUMBER_OF_JARS_PER_CARTOON")
    private Integer noOfJarsPerCartoon;

    @Column(name="BASIC_PRICE")
    private Float basicPrice;

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

    public Float getGstPercentage() {
        return gstPercentage;
    }

    public void setGstPercentage(Float gstPercentage) {
        this.gstPercentage = gstPercentage;
    }

    public Float getWeightPerJar() {
        return weightPerJar;
    }

    public void setWeightPerJar(Float weightPerJar) {
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

    public Float getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(Float basicPrice) {
        this.basicPrice = basicPrice;
    }
}
