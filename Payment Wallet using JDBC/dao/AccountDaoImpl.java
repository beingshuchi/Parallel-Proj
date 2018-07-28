package com.cg.dao;

import java.util.HashMap;

import com.cg.bean.Account;
import com.cg.db.AccountDB;
import com.cg.exception.AccountException;

/**
 * 
 * Class name: AccountDaoImpl
 * Number of Interface:1
 * Name of Interface: AccountDao
 * Number of Methods: 6
 * Number of constructor:0
 * Purpose: This is the Dao layer class for  manipulation and updation to be done on the database
 * Name of methods: String createAccount(Account acount),
 *                 double showBalance(String mobileNo), Account deposit(String mobileNo),
 *                 Account withdraw(String mobileNo),  Boolean fundTransfer(String mobileNum),
 *                 Account printTransactionDetails(String mobileNum)
 *                 
 * Author: Shuchita
 * Date of creation: 11.7.2018
 * Last updated:14.7.2018
 *
 */

public class AccountDaoImpl implements AccountDao{
static HashMap<String, Account> accMap= AccountDB.getAccountData();
//static HashMap<String, Account> transactionMap= AccountDB.getTransaction();
	@Override
	public String createAccount(Account acount) throws AccountException{
		accMap.put(acount.getMobileNo(), acount);
		return acount.getMobileNo();
	}
	@Override
	public double showBalance(String mobileNo) throws AccountException {
		Account ac= accMap.get(mobileNo);
		if(ac==null){
			throw new AccountException("The entered mobile number does not exists.");
		}
		return ac.getBalance();
	}
	@Override
	public Account deposit(String mobileNo) throws AccountException {
		// TODO Auto-generated method stub
		Account ac=accMap.get(mobileNo);
		if(ac==null){
			throw new AccountException("The entered mobile number does not exists.");
		}
		
		return ac;
	}
	@Override
	public Account withdraw(String mobileNo) throws AccountException {
		Account ac=accMap.get(mobileNo);
		if(ac==null){
			throw new AccountException("The entered mobile number does not exists.");
		}
		
		return ac;
	}
	@Override
	public Account printTransactionDetails(String mobileNum)
			throws AccountException {
		Account ac= accMap.get(mobileNum);
		
		if(ac==null){
			throw new AccountException("The entered mobile number does not exists.");
		}
		//transactionMap.put(ac.getMobileNo(), ac);
		return ac;
	}
}
