package com.cg.pecuniabank.accountmanagement.service;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.cg.pecuniabank.accountmanagement.dao.AccountManagementDao;
import com.cg.pecuniabank.accountmanagement.dao.CustomerServiceDao;
import com.cg.pecuniabank.accountmanagement.exception.CustomException;

public class CustomerService implements Authentication {
	
	// default constructor
	public CustomerService()
	{
		
	}
	
	// validates name
	public boolean validateName(String name)
	{
		try
		{
			if((name != null) && (!name.equals("")) && (name.matches("^[a-zA-Z\\s]*$")))
			{
				return true;
			}
			else
			{
				throw new CustomException("please enter only alphabets");
			}
			
		}catch(CustomException e){
			System.out.println(e.getMessage());
			return false;
		}	
	}
	
	// validates address;
	public boolean validateAddress(String address)
	{
		String arr[] = address.split("\\s*,\\s*");
		
		try
		{
			if(arr[0].matches("^[a-zA-Z0-9\\s\\W]*$")	
		    && arr[1].matches("^[a-zA-Z0-9\\s\\W]*$") 
			&& arr[2].matches("^[a-zA-Z\\s]*$")
			&& arr[3].matches("^[a-zA-Z\\s]*$")
			&& arr[4].matches("^[a-zA-Z\\s]*$")
			&& arr[5].matches( "^[0-9]{6}?$" ))
			{
				return true;
			}
			else
			{
				throw new CustomException("Please enter valid address");
			}
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			return false;	
		}
	}

	// validates adhaarNumber
	public boolean validateAdhaarNumber(String adhaar)
	{
		try
		{
			if(adhaar.matches("^[0-9]{12}?$" ))
			{
				return true;
			}
			else
			{
				throw new CustomException("Please enter 12 digit adhaar number");
			}
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	// validates panNumber
	public boolean validatePanNumber(String pan)
	{
		try
		{
			if(pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}"))
			{
				return true;
			}
			else
			{
				throw new CustomException("Please enter correct PAN number");
			}
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			return false;	
		}
    }
	
	// validates contact number
	public boolean validateContactNumber(String contact)
	{
		try
		{
			if(contact.matches("^[0-9]{10}?$" ))
			{
				return true;
			}
			else
			{
				throw new CustomException("Please enter 10 digit contact number");
			}
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	// validates gender
	public boolean validateGender(String gender)
	{
		if(gender.equals("Male")||gender.equals("Female")||gender.equals("female")||gender.equals("male"))
		{
			return true;
		}
		else
		{
			System.out.println("Please enter either Male or Female as gender");
			return false;
		}
	}

	// validates date of birth
	public boolean validateDateOfBirth(Date date1)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
	    String strDate = formatter.format(date1); 
	    try
	    {
	    	if(strDate.matches("^(3[01]"+"|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$"))
	    	{
	    		return true;
	    	}
	    	else
	    	{
	    		throw new CustomException("Please enter date in specified format");
	    	}	
		}
	    catch(CustomException e)
	    {
	    	System.out.println(e.getMessage());
			return false;	
	    }	
	}
	
	// validates account id 
	public boolean validateAccountId(String accountId)
	{
		try
		{
			if(accountId.matches("^[0-9]{12}?$" ))
			{
				return true;
			}
			else
			{
				throw new CustomException("Please enter 12 digit account ID");
			}
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	// validates account type
	public boolean validateAccountType(String accountType)
	{
		try
		{
			if(accountType.equals("Current")||accountType.equals("Savings"))
			{
				return true;
			}
			else
		    {
				throw new CustomException("Please enter valid type of Account");
		    }
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	// adds customer to data access object
	public static void addCustomerToDao(String id,String accountId,String name,String address,String adhaar,String pan,String contact,String gender,Date date1)
	{
		new CustomerServiceDao(id,accountId,name,address,adhaar,pan,contact,gender,date1);
	}
	
	// adds account to data access object
	public static void addAccountToDao(String accountId,String accountType,double balance)
	{
		new AccountManagementDao(accountId,accountType,balance);
	}
	
	// updates name
	public static void updateName(String accountId,String updatedName)
	{
		if((new CustomerServiceDao().accountExists(accountId)))
		{
			new CustomerServiceDao().updateNameDao(accountId,updatedName);
			
			showData();
		} 
		else
		{
			System.out.println("Account does not exists");
		}

		
	}
	
	// updates contact
	public static void updateContact(String accountId,String updatedContact)
	{
		if((CustomerServiceDao.accountExists(accountId)))
		{
			CustomerServiceDao.updateContactDao(accountId,updatedContact);
			
			showData();

		} 
		else
		{
			System.out.println("Account does not exists");
		}
	}
	
	// updates address
	public static void updateAddress(String accountId,String updatedAddress)
	{
		if((CustomerServiceDao.accountExists(accountId)))
		{
			CustomerServiceDao.updateAddressDao(accountId,updatedAddress);
			
			showData();

		} 
		
		System.out.println("Account does not exists");
	}
	
	// deletes account 
	public static void deleteAccount(String accountId)
	{
		
		if(!(AccountManagementDao.accountExists(accountId)))
		{
		 
		  System.out.println("Account does not exists");
		}
		else
		{
			AccountManagementDao.deleteAccountDao(accountId);
		}
	}
	
	// shows Data
	public static void showData()
	{
		CustomerServiceDao.showDataDao();
	}
}

