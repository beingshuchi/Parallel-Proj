package com.cg.bean;

import java.time.LocalDateTime;
/**
 * 
 * Class name: Account
 * Number of Methods: 8
 * Number of constructor:2
 * Name of constructor: Account(String mobileNo, 
 *                                    String accountType, String customerName, double accountBalance)
 *                      Account();
 * Purpose: This is the bean class that contains the template for the account Details
 * Name of methods: setMobileNo(String mobileNo),String getMobileNo(),String getCustomerName(),
 *                  setCustomerName(String customerName),LocalDateTime getDate(),setDate(LocalDateTime date)
 *                  double getBalance(),setBalance(double Balance), String getEmail(),setEmail(String email)
 * Author: Shuchita
 * Date of creation: 12.7.2018
 * Last updated:14.7.2018
 *
 */

public class Account {
	String name;
	String email;
	String mobileNo;
	double balance;
	LocalDateTime date1;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account() {
		super();
	}
	public LocalDateTime getDate() {
		return date1;
	}
	public void setDate(LocalDateTime date1) {
		this.date1 = date1;
	}
	

	
}
