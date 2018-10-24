package com.motocart.shoppingcart.model;

import com.motocart.shoppingcart.entity.Product;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
 
public class ProductInfo {
    private String productCode;
    private String productName;
    private double productPrice;
 
    private boolean isNewProduct=false;
 
    // Upload file.
    private CommonsMultipartFile productFileData;
 
    public ProductInfo() {
    }
 
    public ProductInfo(Product product) {
        this.productCode = product.getProductCode();
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
    }
  

    public ProductInfo(String productCode, String productName, double productPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
    }
 
    public String getProductCode() {
        return productCode;
    }
 
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
 
    public String getProductName() {
        return productName;
    }
 
    public void setProductName(String productName) {
        this.productName = productName;
    }
 
    public double getProductPrice() {
        return productPrice;
    }
 
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
 
    public CommonsMultipartFile getProductFileData() {
        return productFileData;
    }
 
    public void setProductFileData(CommonsMultipartFile productFileData) {
        this.productFileData = productFileData;
    }
 
    public boolean isNewProduct() {
        return isNewProduct;
    }
 
    public void setIsNewProduct(boolean isNewProduct) {
        this.isNewProduct = isNewProduct;
    }
 
}