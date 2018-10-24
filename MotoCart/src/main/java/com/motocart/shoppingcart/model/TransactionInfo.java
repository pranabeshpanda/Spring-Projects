package com.motocart.shoppingcart.model;

import java.util.Date;
import java.util.List;
 
public class TransactionInfo {
 
    private String transactionId;
    private Date transactionDate;
    private int transactionNum;
    private double transactionAmount;
 
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private String customerPhone;
 
    private List<TransactionDetailInfo> transactionDetails;
 
    public TransactionInfo() {
 
    }
 
    // Using for Hibernate Query.
    
    public TransactionInfo(String transactionId, Date transactionDate, int transactionNum, //
            double transactionAmount, String customerName, String customerAddress, //
            String customerEmail, String customerPhone) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.transactionNum = transactionNum;
        this.transactionAmount = transactionAmount;
 
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
    }
 
    public String getTransactionId() {
        return transactionId;
    }
 
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
 
    public Date getTransactionDate() {
        return transactionDate;
    }
 
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
 
    public int getTransactionNum() {
        return transactionNum;
    }
 
    public void setTransactionNum(int transactionNum) {
        this.transactionNum = transactionNum;
    }
 
    public double getAmount() {
        return transactionAmount;
    }
 
    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
 
    public String getCustomerName() {
        return customerName;
    }
 
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
 
    public String getCustomerAddress() {
        return customerAddress;
    }
 
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
 
    public String getCustomerEmail() {
        return customerEmail;
    }
 
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
 
    public String getCustomerPhone() {
        return customerPhone;
    }
 
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
 
    public List<TransactionDetailInfo> getDetails() {
        return transactionDetails;
    }
 
    public void setDetails(List<TransactionDetailInfo> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }
 
}