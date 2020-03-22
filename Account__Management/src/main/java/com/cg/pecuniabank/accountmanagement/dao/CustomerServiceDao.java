package com.cg.pecuniabank.accountmanagement.dao;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.cg.pecuniabank.accountmanagement.dto.Customer;
import com.cg.pecuniabank.accountmanagement.util.CustomerRepository;


public class CustomerServiceDao {
	
	// customer repository object;
	CustomerRepository repository = new CustomerRepository();
	
	// ArrayList to hold customer data;
	static ArrayList<Customer> list;
	
	static String message = "";
	
	// constructor
 	public CustomerServiceDao(String id,String accountId,String name,String address, String adhaar,
			String pan,String contact, String gender, Date date1)
	{
		Customer customer=new Customer(id,accountId,name,address,adhaar,pan,contact,gender,date1);
		repository.addCustomerDetails();
		repository.putData(customer);
		list = repository.getCustomerList();

		System.out.println();
		System.out.println("--- DATA SAVED ---");
		
		repository.showData();
	}

 	// default constructor
 	public CustomerServiceDao()
 	{
 		
 	}
 	
 	// checks if account exits
 	public static boolean accountExists(String accountId)
 	{
 		if(list.size()==0)
 		{
 			return false;
 		}
 		
 		for(Customer customer : list)
 		{
 			if((customer.getCustomerAccountId().equals(accountId)))
 			{
 				return true;
 			}
 		}
 		
 		return false;
 	}
 	
 	// update name
 	public void updateNameDao(String accountId,String updatedName)
 	{
 		//System.out.println(list);
 		System.out.println();
 		
 		for(Customer customer : list)
 		{
 			if(customer.getCustomerAccountId().equals(accountId))
			{
				customer.setCustomerName(updatedName);
				message = "!!!! NAME IS UPDATED SUCCESSFULLY !!!!";
			}
 			
 			//System.out.println(customer);
 		}
 		
 		System.out.println(message);
 		
 		// 
 		System.out.println();
 		
 	}
 	
 	// update contact
 	public static void updateContactDao(String accountId,String updatedContact)
 	{
 		System.out.println();
 		
 		for(Customer customer:list)
 		{
 			if(customer.getCustomerAccountId().equals(accountId))
 			{
 				customer.setCustomerContact(updatedContact);
 				message = "!!!! CONTACT NUMBER IS UPDATED SUCCESSFULLY !!!!";
 			}
 			
 			//System.out.println(customer);
 		}
 		
 		System.out.println(message);
 		
 		//
 		System.out.println();
 		
 	}  
 	
 	// update address
 	public static void updateAddressDao(String accountId, String updatedAddress) 
	{		
 		System.out.println();
 		
		for(Customer customer:list)
		{
			if(customer.getCustomerAccountId().equals(accountId))
			{
				customer.setCustomerAddress(updatedAddress);
				message = "!!!! ADDRESS IS UPDATED SUCCESSFULLY !!!!";
			}
			
			//System.out.println(customer);
	    }

		System.out.println(message);
		
		System.out.println();
     }	
 	
 	// show data
 	public static void showDataDao()
 	{
 		Iterator<Customer> it = list.iterator();
		
		System.out.println();
		
		System.out.printf("%-15s%-25s%-25s%-75s%-25s%-25s%-25s%-25s%-25s","CUSTOMER ID",
		"CUSTOMER ACCOUNT ID","CUSTOMER NAME","CUSTOMER ADDRESS","CUSTOMER ADHAAR","CUSTOMER PAN",
		"CUSTOMER CONTACT","CUSTOMER GENDER","CUSTOMER DOB");
		
		System.out.println();
		
		while(it.hasNext())
		{
			Customer c = (Customer)it.next();

			System.out.printf("%-15s%-25s%-25s%-75s%-25s%-25s%-25s%-25s%-25s",c.getCustomerId(),
			c.getCustomerAccountId(),c.getCustomerName(),c.getCustomerAddress(),c.getCustomerAdhaar(),
			c.getCustomerPan(),c.getCustomerContact(),c.getCustomerGender(),c.getCustomerDob());
			
			System.out.println();
		}
 	}
}

