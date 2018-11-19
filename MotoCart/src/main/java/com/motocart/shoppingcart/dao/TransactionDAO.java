package com.motocart.shoppingcart.dao;

import java.util.List;

import com.motocart.shoppingcart.model.CartInfo;
import com.motocart.shoppingcart.model.TransactionDetailInfo;
import com.motocart.shoppingcart.model.TransactionInfo;
import com.motocart.shoppingcart.model.PaginationResult;

public interface TransactionDAO {

	public void saveTransaction(CartInfo cartInfo);

	public PaginationResult<TransactionInfo> listTransactionInfo(int page, int maxResult, int maxNavigationPage);

	public TransactionInfo getTransactionInfo(String transactionId);

	public List<TransactionDetailInfo> listTransactionDetailInfos(String transactionId);

}