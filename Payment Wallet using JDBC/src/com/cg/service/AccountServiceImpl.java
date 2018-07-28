package com.cg.service;

import java.time.LocalDateTime;

import com.cg.bean.Account;
import com.cg.dao.AccountDao;
import com.cg.dao.AccountDaoImpl;
import com.cg.exception.AccountException;
/**
 * 
 * Class name: AccountServiceImpl
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
public class AccountServiceImpl implements AccountService {
	AccountDao accDao= new AccountDaoImpl();
	@Override
	public String createAccount(Account acount) throws AccountException {
		// TODO Auto-generated method stub
		if (!acount.getMobileNo().matches("\\d{10}")) {
			throw new AccountException("The mobile number must contain only 10 digits");
		}
		if (acount.getName() == null || acount.getName().isEmpty()) {
			throw new AccountException("The name cannot be left empty.");
		} else {
			if (!acount.getName().matches("[A-Za-z]{2,}")) {
				throw new AccountException(
						"The name should contain only alphabets,minimum of 2 and maximum of 12");
			}
		}
		if(acount.getBalance()<=0){
			throw new AccountException("The balance cannot be less than or zero");
		}
		if (!acount.getEmail().matches("[a-z0-9_\\.]{3,}+@{1}+[a-z]{3,}+\\.com")) {
			throw new AccountException("The email address entered is invalid");
		}
		
	
		return accDao.createAccount(acount);
	}
	@Override
	public double showBalance(String mobileNo) throws AccountException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new AccountException("The mobile number must contain only 10 digits");
		}
		return accDao.showBalance(mobileNo);
	}
	@Override
	public Account deposit(String mobileNo,double depositAmt) throws AccountException {
		
		if (!mobileNo.matches("\\d{10}")) {
			throw new AccountException("The mobile number must contain only 10 digits");
		}
		Account ac=accDao.deposit(mobileNo);
		if(depositAmt<=0){
			throw new AccountException("The deposited amount must be greater than 0.");
		}
		
		double bal=ac.getBalance()+depositAmt;
		ac.setBalance(bal);
		ac.setDate(LocalDateTime.now());
		//accDao.printTransactionDetails(mobileNo);
		return accDao.deposit(mobileNo);
	}
	@Override
	public Account withdraw(String mobileNo, double withdrawAmt)throws AccountException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new AccountException("The mobile number must contain only 10 digits");
		}
		Account ac=accDao.withdraw(mobileNo);
		if(withdrawAmt>ac.getBalance()|| withdrawAmt<=0){
			throw new AccountException("The amount to be withdrawn must be less than the available balance and greater than 0.");
		}
		double bal=ac.getBalance()-withdrawAmt;
		ac.setBalance(bal);
		ac.setDate(LocalDateTime.now());
		//accDao.printTransactionDetails(mobileNo);
		return accDao.withdraw(mobileNo);
	}

	@Override
	public boolean fundTransfer(String srcMobileNo, String destMobNo, double amt)
			throws AccountException {
		AccountService acService=new AccountServiceImpl();
		Account ac2=acService.deposit(destMobNo, amt);
		Account ac1= acService.withdraw(srcMobileNo,amt);
		
		if(ac1!=null && ac2!=null){
			return true;
		}
		return false;
	}
	@Override
	public Account printTransactionDetails(String mobileNum)
			throws AccountException {
		// TODO Auto-generated method stub
		if (!mobileNum.matches("\\d{10}")) {
			throw new AccountException("The mobile number must contain only 10 digits");
		}
		return accDao.printTransactionDetails(mobileNum);
	}

}
