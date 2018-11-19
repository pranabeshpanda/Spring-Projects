package com.motocart.shoppingcart.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
@Entity
@Table(name = "MOTOCART_TRANSACTION_DETAILS")
public class TransactionDetails implements Serializable {
 
    private static final long serialVersionUID = 7550745928843183535L;
 
    private String transactionId;
    private Transaction transaction;
 
    private Product product;
    private int quanity;
    private double price;
    private double amount;
 
    @Id
    @Column(name = "TX_ID", length = 50, nullable = false)
    public String getTransactionId() {
        return transactionId;
    }
 
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID", nullable = false, //
    foreignKey = @ForeignKey(name = "ORDER_DETAIL_ORD_FK") )
    public Transaction getTransaction() {
        return transaction;
    }
 
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false, //
    foreignKey = @ForeignKey(name = "MOTOCART_TRANSACTION_DETAIL_PROD_FK") )
    public Product getProduct() {
        return product;
    }
 
    public void setProduct(Product product) {
        this.product = product;
    }
 
    @Column(name = "QUANTITY", nullable = false)
    public int getQuanity() {
        return quanity;
    }
 
    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }
 
    @Column(name = "PRICE", nullable = false)
    public double getPrice() {
        return price;
    }
 
    public void setPrice(double price) {
        this.price = price;
    }
 
    @Column(name = "AMOUNT", nullable = false)
    public double getAmount() {
        return amount;
    }
 
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
}