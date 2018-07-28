package com.cg.db;

import java.time.LocalDateTime;
import java.util.HashMap;

import com.cg.bean.Account;

public class AccountDB {
	private static HashMap<String, Account> accountDb=new HashMap<String, Account>();
	//private static HashMap<String, Account> transactons=new HashMap<String, Account>();
	public static HashMap<String, Account> getAccountData(){
		return accountDb;
	}
	static{
		accountDb.put("9876545005", new Account("Shalini", "shalini@gmail.com", "9876545005", 3400));
		accountDb.put("9866543035", new Account("Anu", "anu@gmail.com", "9866543035", 2340));
		accountDb.put("7876231066", new Account("Mark", "mark@gmail.com", "7876231066", 10044));
		accountDb.put("9542120221", new Account("Zoya", "zoya@gmail.com", "9542120221", 23584));

	}
	
/*	public static HashMap<String, Account> getTransaction(){
		return transactons;
	}*/
}
