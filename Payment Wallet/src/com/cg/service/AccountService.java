package com.cg.service;

import com.cg.bean.Account;
import com.cg.exception.AccountException;

public interface AccountService {
	String createAccount(Account acount)throws AccountException;
	double showBalance(String mobileNo)throws AccountException;
	Account deposit(String mobileNo,double depositAmt)throws AccountException;
	Account withdraw(String mobileNo,double withdrawAmt)throws AccountException;
	boolean fundTransfer(String srcMobileNo, String destMobNo,double amt)throws AccountException;
	Account printTransactionDetails(String mobileNum)throws AccountException;
}
