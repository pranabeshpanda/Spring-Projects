package com.motocart.shoppingcart.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "MOTOCART_TRANSACTION", //
		uniqueConstraints = { @UniqueConstraint(columnNames = "TX_ID") })
public class Transaction implements Serializable {
	private static final long serialVersionUID = -2576670215015463100L;

	private String transactionId;
	private Date transactionDate;
	private int transactionNum;
	private double transactionAmount;

	private String customerName;
	private String customerAddress;
	private String customerEmail;
	private String customerPhone;

	@Id
	@Column(name = "TX_ID", length = 50)
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	@Column(name = "TX_DATE", nullable = false)
	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Column(name = "TX_NUM", nullable = false)
	public int getTransactionNum() {
		return transactionNum;
	}

	public void setTransactionNum(int transactionNum) {
		this.transactionNum = transactionNum;
	}

	@Column(name = "TX_AMOUNT", nullable = false)
	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@Column(name = "CUSTOMER_NAME", length = 255, nullable = false)
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column(name = "CUSTOMER_ADDRESS", length = 255, nullable = false)
	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Column(name = "CUSTOMER_EMAIL", length = 128, nullable = false)
	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	@Column(name = "CUSTOMER_PHONE", length = 128, nullable = false)
	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
}
