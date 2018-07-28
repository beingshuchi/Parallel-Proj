package com;

import java.util.Scanner;

import com.cg.bean.Account;
import com.cg.exception.AccountException;
import com.cg.service.AccountService;
import com.cg.service.AccountServiceImpl;

public class Client {
	Scanner sc= new Scanner(System.in);
	AccountService service= new AccountServiceImpl();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String option="";
		Client c= new Client();
		while(true){
			System.out.println("1. Create Account");
			System.out.println("2. Show Balance");
			System.out.println("3. Deposit");
			System.out.println("4. Withdraw");
			System.out.println("5. Fund Transfer");
			System.out.println("6. Print Transaction");
			System.out.println("7. Exit");
			System.out.println();
			System.out.println("Enter option: ");
			option=c.sc.nextLine();
			switch(option){
			case"1":
				c.AddEmployee();
				break;
			case "2":
				c.showBalance();
				break;
			case"3":
				break;
			case "4":
				break;
			case"5":
				break;
			case "6":
				break;
			case"7":
				c.sc.close();
				System.exit(1);
			default:
				System.err.println("Enter between 1 and 7");
			}
		}
		
	}
	
	private void AddEmployee(){
		Account ac = new Account();
		System.out.println("Enter name: ");
		ac.setName(sc.nextLine());
		System.out.println("Enter mobile number: ");
		ac.setMobileNo(sc.nextLine());
		System.out.println("Enter email: ");
		ac.setEmail(sc.nextLine());
		System.out.println("Enter Bal: ");
		ac.setBalance(Double.parseDouble(sc.nextLine()));
		try {
			String mobileNo=service.createAccount(ac);
			System.out.println("Account created with the mobile number"+mobileNo);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println(e.getMessage());
			System.out.println();
		}
		
	}
	
	private void showBalance(){
		System.out.println("Enter mobile number: ");
		String mobNo=sc.nextLine();
		try {
			double bal=service.showBalance(mobNo);
			System.out.println("The account with mobile no "+mobNo+" is having balance: "+bal);
		} catch (AccountException e) {
			System.out.println();
			System.err.println(e.getMessage());
			System.out.println();
		}
		
	}

}
