package com.cg.pecuniabank.accountmanagement.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import com.cg.pecuniabank.accountmanagement.dto.AccountManagement;
import com.cg.pecuniabank.accountmanagement.util.AccountRepository;


public class AccountManagementDao {
	
	// AccountRepository object
	AccountRepository repo = new AccountRepository();
	
	// ArrayList to hold account data;
	static ArrayList<AccountManagement> list;
	
	static String message = "";
	
	
	static int accountHolderId()
	{
		Random random = new Random();
		int number = random.nextInt(9999);
		return number;
	}
	
	public AccountManagementDao(String accountId,String accountType,double balance)
	{
		String accountHolderId;
		Date lastUpdated;
		
		accountHolderId = String.valueOf(accountHolderId());
		
		final String accountBranchId = "PUNBO339500";
		String accountStatus = "Active";
		Double accountInterest;
		
		if(accountType.equals("Savings"))
		{
			accountInterest = 3.50;
		}
		else
		{
			accountInterest = 3.00;
		}
		
		long millisInDay = 60*60*24*1000;
		long currentTime = new Date().getTime();
		long dateOnly = (currentTime/millisInDay) * millisInDay;
		
		lastUpdated = new Date(dateOnly);
		AccountManagement accountmanagement = new AccountManagement(accountId,accountHolderId,accountBranchId,accountType,accountStatus,balance,accountInterest,lastUpdated);
		repo.addAccountUsersData();
		repo.putData(accountmanagement);
		list = repo.getAccountList();
		
		System.out.println();
		System.out.println("---ACCOUNT IS CREATED---");
		repo.showData();
		
	}
	
	// check if account exists
	public static boolean accountExists(String accountId)
	{		
		if(list.size()==0)
		{
			return false;
		}
		
		for(AccountManagement am:list)
		{
			if((am.getAccountId().equals(accountId)))
			{
				return true;
			}
		}
			
		return false;
	}
	
	// deletes account
	public static void deleteAccountDao(String accountId) 
	{	
		for(AccountManagement am:list)
		{
			if(am.getAccountId().equals(accountId))
			{
				am.setAccountStatus("Closed");
				message = "!!!! ACCOUNT IS SUCCESSFULLY DELETED !!!!";
				
			}
	    }
		
		System.out.println();
		
		System.out.println(message);
		
		showDataDao();
	}
	
	// shows data
	public static void showDataDao()
	{
		Iterator<AccountManagement> it=list.iterator();
		
		System.out.println();
		
		System.out.printf("%-15s%-25s%-25s%-25s%-25s%-25s%-25s%-25s","ACCOUNT ID",
		"CUSTOMER ACCOUNT ID","CUSTOMER BRANCH ID","ACCOUNT TYPE","ACCOUNT STATUS","ACCOUNT BALANCE",
		"ACCOUNT INTEREST","ACCOUNT LAST UPDATED");
		
		System.out.println();
		
		while(it.hasNext())
		{
			AccountManagement am = (AccountManagement)it.next();
						
			System.out.printf("%-15s%-25s%-25s%-25s%-25s%-25f%-25f%-25s",am.getAccountId(),am.getAccountHolderId(),
			am.getAccountBranchId(),am.getAccountType(),am.getAccountStatus(),am.getAccountBalance(),
			am.getAccountInterest(),am.getLastUpdated());
			
			System.out.println();
		}
	}
	

}

