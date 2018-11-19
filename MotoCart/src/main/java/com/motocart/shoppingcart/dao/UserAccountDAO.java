package com.motocart.shoppingcart.dao;

import com.motocart.shoppingcart.entity.UserAccount;

public interface UserAccountDAO {
	public UserAccount findAccount(String userName);

}