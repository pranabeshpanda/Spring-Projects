package com.motocart.shoppingcart.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOTOCART_USER_ACCOUNTS")
public class UserAccount implements Serializable {
	private static final long serialVersionUID = -2054386655979281969L;

	public static final String ROLE_MANAGER = "MANAGER";
	public static final String ROLE_EMPLOYEE = "EMPLOYEE";
	public static final String ROLE_CUSTOMER = "CUSTOMER";

	private String userName;
	private String password;
	private boolean active;
	private String userRole;

	@Id
	@Column(name = "USER_NAME", length = 50, nullable = false)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "USER_PASSWORD", length = 50, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "ACTIVE", length = 1, nullable = false)
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Column(name = "USER_ROLE", length = 20, nullable = false)
	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "[" + this.userName + "," + this.password + "," + this.userRole + "]";
	}
}
