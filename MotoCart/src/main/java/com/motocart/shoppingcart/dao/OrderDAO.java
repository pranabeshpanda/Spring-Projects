package com.motocart.shoppingcart.dao;

import java.util.List;

import com.motocart.shoppingcart.model.CartInfo;
import com.motocart.shoppingcart.model.OrderDetailInfo;
import com.motocart.shoppingcart.model.OrderInfo;
import com.motocart.shoppingcart.model.PaginationResult;

public interface OrderDAO {
	public void saveOrder(CartInfo cartInfo);
	public PaginationResult<OrderInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage);
	public OrderInfo getOrderInfo(String orderId);
	public List<OrderDetailInfo> listOrderDetailInfos(String orderId);

}