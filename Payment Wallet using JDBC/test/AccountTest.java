package com.cg.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cg.bean.Account;
import com.cg.exception.AccountException;
import com.cg.service.AccountService;
import com.cg.service.AccountServiceImpl;

/**
 * 
 * Class name:AccountDaoTest
 * Number of Interface:0
 * Number of Methods: 28
 * Number of constructor:0
 * Purpose: This tests the methods of the DAO layer Class AccountDaoImp
 * Author: Shuchita
 * Date of creation: 11.7.2018
 *  Last updated:14.7.2018
 *
 */

public class AccountTest {

	AccountService acService;

	@Before
	public void init() {
		acService = new AccountServiceImpl();
	}

	@Test
	public void testPhoneCreateAcc() {
		Account ac = new Account();
		ac.setMobileNo("1234");
		ac.setName("Shweta");
		ac.setBalance(300);
		ac.setEmail("abc@gmail.com");
		try {
			acService.createAccount(ac);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The mobile number must contain only 10 digits",
					e.getMessage());
		}

	}

	@Test
	public void testPhoneDoesNotExistCreateAcc() {
		Account ac = new Account();
		ac.setMobileNo("9546123011");
		ac.setName("Shweta");
		ac.setBalance(300);
		ac.setEmail("abcdef@gmail.com");
		try {
			acService.createAccount(ac);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The entered mobile number does not exists.",
					e.getMessage());
		}

	}

	@Test
	public void testNameCreateAcc() {
		Account ac = new Account();
		ac.setMobileNo("9123872300");
		ac.setName("Shital45");
		ac.setBalance(300);
		ac.setEmail("abc@gmail.com");
		try {
			acService.createAccount(ac);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals(
					"The name should contain only alphabets,minimum of 2 and maximum of 12",
					e.getMessage());
		}

	}

	@Test
	public void testEmailCreateAcc() {
		Account ac = new Account();
		ac.setMobileNo("9123872300");
		ac.setName("Shweta");
		ac.setBalance(300);
		ac.setEmail("abc.gmail.com");
		try {
			acService.createAccount(ac);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The email address entered is invalid", e.getMessage());
		}
	}

	@Test
	public void testBalCreateAcc() {
		Account ac = new Account();
		ac.setMobileNo("9123872300");
		ac.setName("Shweta");
		ac.setBalance(-23);
		ac.setEmail("abc@gmail.com");
		try {
			acService.createAccount(ac);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The balance cannot be less than or zero",
					e.getMessage());
		}
	}

	@Test
	public void testNameEmptyCreateAcc() {
		Account ac = new Account();
		ac.setMobileNo("9123872300");
		ac.setName("");
		ac.setBalance(300);
		ac.setEmail("abc@gmail.com");
		try {
			acService.createAccount(ac);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The name cannot be left empty.", e.getMessage());
		}

	}

	@Test
	public void testCreateAcc() {
		Account ac = new Account();
		ac.setMobileNo("9124872300");
		ac.setName("Shweta");
		ac.setBalance(230);
		ac.setEmail("abcdef@gmail.com");
		try {
			String s = acService.createAccount(ac);
			assertNotNull(s);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testPhoneShowBal() {

		try {
			acService.showBalance("93547");
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The mobile number must contain only 10 digits",
					e.getMessage());
		}

	}

	@Test
	public void testPhoneDoesNotExistShowBal() {

		try {
			acService.showBalance("9358877700");
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The entered mobile number does not exists.",
					e.getMessage());
		}

	}

	public void testShowBal() {

		try {
			double bal = acService.showBalance("9876545005");
			assertNotNull(bal);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testPhonDeposit() {
		try {
			acService.deposit("12345", 300);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The mobile number must contain only 10 digits",
					e.getMessage());
		}

	}

	@Test
	public void testPhoneDoesNotExistDeposit() {
		try {
			acService.deposit("9546123011", 300);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The entered mobile number does not exists.",
					e.getMessage());
		}

	}

	@Test
	public void testAmtNegDeposit() {

		try {
			acService.deposit("9876545005", -1);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The deposited amount must be greater than 0.",
					e.getMessage());
		}
	}

	@Test
	public void testDeposit() {

		try {
			Account ac = acService.deposit("9876545005", 300);
			assertNotNull(ac);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testPhonWithdraw() {
		try {
			acService.withdraw("12345", 300);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The mobile number must contain only 10 digits",
					e.getMessage());
		}

	}

	@Test
	public void testPhoneDoesNotExistWithdraw() {
		try {
			acService.withdraw("9546123011", 300);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The entered mobile number does not exists.",
					e.getMessage());
		}

	}

	@Test
	public void testAmtNegWithdraw() {

		try {
			acService.withdraw("9876545005", -1);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The amount to be withdrawn must be less than the"
					+ " available balance and greater than 0.", e.getMessage());
		}
	}

	@Test
	public void testAmtWithdraw() {

		try {
			acService.withdraw("9876545005", 5000);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The amount to be withdrawn must be less than the"
					+ " available balance and greater than 0.", e.getMessage());
		}
	}

	@Test
	public void testWithdraw() {

		try {
			Account ac = acService.deposit("9876545005", 300);
			assertNotNull(ac);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	

	@Test
	public void testPhone1FundTransfer1() {
		try {
			acService.fundTransfer("12345","9876545005", 300);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The mobile number must contain only 10 digits",
					e.getMessage());
		}

	}
	@Test
	public void testPhoneFundTransfer2() {
		try {
			acService.fundTransfer("9876545005","12345", 300);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The mobile number must contain only 10 digits",
					e.getMessage());
		}

	}

	/*@Test
	public void testPhoneDoesNotExistFundTransfer1() {
		try {
			acService.fundTransfer("9546123011","9876545005", 200);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The entered mobile number does not exists.",
					e.getMessage());
		}

	}*/
	
	@Test
	public void testPhoneDoesNotExistFundTransfer2() {
		try {
			acService.fundTransfer("9876545005","9546123011", 300);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The entered mobile number does not exists.",
					e.getMessage());
		}

	}
	
	

	@Test
	public void testAmtFundTransfer() {

		try {
			acService.fundTransfer("9542120221","9876545005", 5000);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The amount to be withdrawn must be less than the"
					+ " available balance and greater than 0.", e.getMessage());
		}
	}
	
	@Test
	public void testAmtNegFundTranfer() {

		try {
			acService.fundTransfer("9542120221","9876545005", -1);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The deposited amount must be greater than 0.",
					e.getMessage());
		}
	}
	
	@Test
	public void testFundTransfer() {

		try {
			boolean b = acService.fundTransfer("9876545005","9542120221", 300);
			assertTrue(b);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}


	@Test
	public void testPhonePrintTransaction() {
		String mobileNum="1234";
		try {
			acService.printTransactionDetails(mobileNum);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The mobile number must contain only 10 digits",
					e.getMessage());
		}

	}

	@Test
	public void testPhoneDoesNotExistPrintTrans() {
		String mobileNum="9546123011";
		try {
			acService.printTransactionDetails(mobileNum);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The entered mobile number does not exists.",
					e.getMessage());
		}

	}
	@Test
	public void testPrintTransacrion() {

		try {
			Account ac = acService.printTransactionDetails("9876545005");
			assertNotNull(ac);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	
	
}
