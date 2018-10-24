package com.motocart.shoppingcart.entity;

import java.io.Serializable;
import java.util.Date;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
 
@Entity
@Table(name = "MOTOCART_PRODUCTS")
public class Product implements Serializable {
 
    private static final long serialVersionUID = -1000119078147252957L;
 
    private String productCode;
    private String productName;
    private double productPrice;
    private byte[] productImage;
 
    // For sort.
    private Date productCreateDate;
 
    public Product() {
    }
 
    @Id
    @Column(name = "PRODUCT_CODE", length = 20, nullable = false)
    public String getProductCode() {
        return productCode;
    }
 
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
 
    @Column(name = "PRODUCT_NAME", length = 255, nullable = false)
    public String getProductName() {
        return productName;
    }
 
    public void setProductName(String productName) {
        this.productName = productName;
    }
 
    @Column(name = "PRODUCT_PRICE", nullable = false)
    public double getProductPrice() {
        return productPrice;
    }
 
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
 
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PRODUCT_CREATE_DATE", nullable = false)
    public Date getProductCreateDate() {
        return productCreateDate;
    }
 
    public void setProductCreateDate(Date productCreateDate) {
        this.productCreateDate = productCreateDate;
    }
 
    @Lob
    @Column(name = "PRODUCT_IMAGE", length = Integer.MAX_VALUE, nullable = true)
    public byte[] getProductImage() {
        return productImage;
    }
 
    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }
 
}