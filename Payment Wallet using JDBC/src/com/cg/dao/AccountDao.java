package com.cg.dao;

import com.cg.bean.Account;
import com.cg.exception.AccountException;

public interface AccountDao {
	String createAccount(Account acount)throws AccountException;
	double showBalance(String mobileNo)throws AccountException;
	Account deposit(String mobileNo)throws AccountException;
	Account withdraw(String mobileNo)throws AccountException;
	Account printTransactionDetails(String mobileNum)throws AccountException;
}
