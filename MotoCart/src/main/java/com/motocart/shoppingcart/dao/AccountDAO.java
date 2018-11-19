package com.motocart.shoppingcart.dao;

import com.motocart.shoppingcart.entity.Account;

public interface AccountDAO {
	public Account findAccount(String userName);
}