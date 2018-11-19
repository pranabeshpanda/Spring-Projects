package com.motocart.shoppingcart.model;

public class TransactionDetailInfo {
	private String transactionId;

	private String productCode;
	private String productName;

	private int productQuanity;
	private double productPrice;
	private double productAmount;

	public TransactionDetailInfo() {

	}

	// Using for Hibernate Query.
	public TransactionDetailInfo(String transactionId, String productCode, //
			String productName, int productQuanity, double productPrice, double productAmount) {
		this.transactionId = transactionId;
		this.productCode = productCode;
		this.productName = productName;
		this.productQuanity = productQuanity;
		this.productPrice = productPrice;
		this.productAmount = productAmount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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

	public int getProductQuanity() {
		return productQuanity;
	}

	public void setProductQuanity(int productQuanity) {
		this.productQuanity = productQuanity;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public double getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(double productAmount) {
		this.productAmount = productAmount;
	}
}