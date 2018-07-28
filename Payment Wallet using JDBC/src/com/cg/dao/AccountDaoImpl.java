package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.DB.DBUtil;
import com.cg.bean.Account;
import com.cg.exception.AccountException;

/**
 * 
 * Class name: AccountDaoImpl Number of Interface:1 Name of Interface:
 * AccountDao Number of Methods: 6 Number of constructor:0 Purpose: This is the
 * Dao layer class for manipulation and updation to be done on the database Name
 * of methods: String createAccount(Account acount), double showBalance(String
 * mobileNo), Account deposit(String mobileNo), Account withdraw(String
 * mobileNo), Boolean fundTransfer(String mobileNum), Account
 * printTransactionDetails(String mobileNum)
 * 
 * Author: Shuchita Date of creation: 11.7.2018 Last updated:14.7.2018
 *
 */

public class AccountDaoImpl implements AccountDao {

	@Override
	public String createAccount(Account acount) throws AccountException {
		Connection con = DBUtil.getConnection();
		PreparedStatement stat;
		try {
			con.setAutoCommit(false);
			stat = con.prepareStatement(IQueryMapper.Insert);
			stat.setString(1, acount.getName());
			stat.setString(2, acount.getEmail());
			stat.setString(3, acount.getMobileNo());
			stat.setDouble(4, acount.getBalance());
			int result = stat.executeUpdate();
			if (result == 1) {
				con.commit();
				return acount.getMobileNo();
			} else {
				throw new AccountException("Could not create the account");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AccountException(e.getMessage());
		}
		
	}

	@Override
	public double showBalance(String mobileNo) throws AccountException {
		Connection con=DBUtil.getConnection();
		PreparedStatement stat;
		
		try {
			stat = con.prepareStatement(IQueryMapper.getBal);
			stat.setString(1, mobileNo);
			ResultSet res=stat.executeQuery();
			con.commit();
			if(res != null){
				res.next();
				return res.getDouble("balance");
			}
			else{
				throw new AccountException(
						"The entered mobile number does not exists.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AccountException(e.getMessage());
		}
		
		
		
	}

	@Override
	public Account deposit(String mobileNo) throws AccountException {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getConnection();
		PreparedStatement stat;
		
		try {
			stat = con.prepareStatement(IQueryMapper.getAcc);
			stat.setString(1, mobileNo);
			ResultSet res=stat.executeQuery();
			if(res!=null){
				res.next();
				Account ac=new Account();
				ac.setName(res.getString("name"));
				ac.setEmail(res.getString("email"));
				ac.setMobileNo(res.getString("mobileNo"));
				ac.setBalance(res.getDouble("balance"));
				return ac;
			}
			else{
				throw new AccountException(
						"The entered mobile number does not exists.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AccountException(e.getMessage());
		}
		
	}

	@Override
	public Account withdraw(String mobileNo) throws AccountException {
		Connection con=DBUtil.getConnection();
		PreparedStatement stat;
		
		try {
			stat = con.prepareStatement(IQueryMapper.getAcc);
			stat.setString(1, mobileNo);
			ResultSet res=stat.executeQuery();
			if(res!=null){
				res.next();
				Account ac=new Account();
				ac.setName(res.getString("name"));
				ac.setEmail(res.getString("email"));
				ac.setMobileNo(res.getString("mobileNo"));
				ac.setBalance(res.getDouble("balance"));
				return ac;
			}
			else{
				throw new AccountException(
						"The entered mobile number does not exists.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AccountException(e.getMessage());
		}
	}

	@Override
	public Account printTransactionDetails(String mobileNum)
			throws AccountException {
		Connection con=DBUtil.getConnection();
		PreparedStatement stat;
		
		try {
			stat = con.prepareStatement(IQueryMapper.getAcc);
			stat.setString(1, mobileNum);
			ResultSet res=stat.executeQuery();
			if(res!=null){
				res.next();
				Account ac=new Account();
				ac.setName(res.getString("name"));
				ac.setEmail(res.getString("email"));
				ac.setMobileNo(res.getString("mobileNo"));
				ac.setBalance(res.getDouble("balance"));
				return ac;
			}
			else{
				throw new AccountException(
						"The entered mobile number does not exists.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AccountException(e.getMessage());
		}
	}
}
