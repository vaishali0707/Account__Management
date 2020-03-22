package com.cg.pecuniabank.accountmanagement.util;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.cg.pecuniabank.accountmanagement.dto.AccountManagement;

public class AccountRepository {

	ArrayList<AccountManagement> users = new ArrayList<AccountManagement>();
	
	// adds data to ArrayList
	public void addAccountUsersData()
	{

		users.add(new AccountManagement( "328281742093","2093","PUNBO339500","Current","Active",272000.00,3.00,new Date("2020/05/31")));
		users.add(new AccountManagement( "429862843021","3012","PUNBO339500","Savings","Active",89000.00,3.50,new Date("2020/02/03")));
		users.add(new AccountManagement( "431303298198","8198","PUNBO339500","Current","Active",20000.00,3.50,new Date("2019/12/31")));
		users.add(new AccountManagement( "243902141847","1874","PUNBO339500","Current","Active",38000.00,3.00,new Date("2020/02/06")));
		users.add(new AccountManagement( "298745498714","8714","PUNBO339500","Savings","Active",5000.00,3.50,new Date("2019/11/29")));
		users.add(new AccountManagement( "398714968291","8291","PUNBO339500","Current","Closed",0.00,0.00,new Date("2019/01/09")));
	}
	
	// return users list
	public ArrayList<AccountManagement> getAccountList()
	{
		return users; 
	}
	
	// adds data to users
	public void putData(AccountManagement am) 
	{
		users.add(am);
	}
	
	// outputs users data
	public void showData()
	{
		Iterator<AccountManagement> it=users.iterator();
		
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

