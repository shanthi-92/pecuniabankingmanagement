package com.cg.pecunia.pl;

import java.util.*;
import java.util.Scanner;

import com.cg.pecunia.bean.Account;

import com.cg.pecunia.exception.AccountException;
import com.cg.pecunia.service.AccountService;
import com.cg.pecunia.service.AccountServiceImp;

public class Customer {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		AccountService accountService = new AccountServiceImp();
		Account account =null;
	
		List<Account> list = null;
		while(true) {
			System.out.println("1. Add Account");
			System.out.println("2. List Accounts");
			System.out.println("3. Exit");
			System.out.println("enter choice");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				try {
				account = new Account();
				
				
				System.out.println("Enter First name ");
				String fName = sc.next();
				if (!accountService.validateName(fName))
					throw new AccountException("Customer name must have only alphabets ");			
				account.setAccountName(fName);
				System.out.println("Enter Last name ");
				String lname = sc.next();
				if (!accountService.validateName(lname))
					throw new AccountException("Customer name must contain only alphabets ");

				account.setAccountName2(lname);
				
				
			
				System.out.println("Enter Aadhar number ");
				String aadhar = sc.next();  
				if (!accountService.validateAadhar(aadhar))
					throw new AccountException(" Only 12-digits are allowed. ");
				
				
				account.setAccountAadhar(aadhar);
			
				
				
				
				System.out.println("Enter Pan number ");
				String pan = sc.next();
				if (!accountService.validatePan(pan))
					throw new AccountException("Customer pan: (5 alphabets 4 numbers and 1 alphabet ");
				
				account.setAccountPan(pan);
				
				
				System.out.println("Enter dob ");
				String dob = sc.next();
				if (!accountService.validateDate(dob))
					throw new AccountException("Customer dob:(dd/mm/yyyy) ");
				account.setAccountDob(dob);
				
				
			
				System.out.println("Enter Gender ");
				String gender = sc.next();
				if (!accountService.validateGender(gender))
					throw new AccountException("Customer grnder:(male/female) ");
				account.setAccountGender(gender);
				
				
				
				System.out.println("Enter Contact number ");
				String contact = sc.next();
				if (!accountService.validateContact(contact))
					throw new AccountException("Customer contact (only 10 digits are allowed)");
				account.setAccountContact(contact);
				
				
				System.out.println("correct details(Y/N)?");
				char correct=sc.next().charAt(0);
				if(correct=='Y' ||correct=='y' ) {
					
				
				
				String accountNumber = accountService.addAccount(account);
				System.out.println("Account is created with Account Number : "+accountNumber+"");
				}
				else
					break;
			}
				catch(AccountException e) {
					System.out.println(e.getMessage());
				}break;
			
			
			  case 2: try { list = accountService.listAccounts(); if(list.isEmpty()) {
			  throw new AccountException("empty list"); } for(Account a: list)
			  System.out.println(a);
			  
			 } catch(AccountException e) { System.out.println(e.getMessage()); }break;
			 
			
				
		
			case 3:
				System.out.println("thankyou");
				return;
			default : System.out.println("enter valid options");
				break;
			}
		}
		
	}

}
