package com.cg.pecuniabank.accountmanagement.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import com.cg.pecuniabank.accountmanagement.service.CustomerService;


public class Client {
	
	// generates random id;
	static int randomId()
	{
		Random random = new Random();
		int randomId = random.nextInt((999999-900000)+1)+900000;
		return randomId;
	}
	
	// generates random account id;
	static int randomAccountId()
	{
		Random random = new Random();
		int randomAccountId = random.nextInt((999999-900000)+1)+900000;
		return randomAccountId;
	}
	
	static void createAccount(Scanner scanner) throws ParseException
	{
		String id;
		String accountId;
		String name;
		String address;
		String adhaar;
		String pan;
		String contact;
		String gender;
		String dob;
		String accountType;
		Date date1;
		double balance;
		

		id = String.valueOf(randomId());
		accountId = String.valueOf(randomAccountId())+id;
		
		System.out.println();
		
		// validate name
		do
		{	
			scanner.nextLine();
			System.out.print("Enter customer's name: ");
			//System.out.println();
			name = scanner.nextLine();
		}while(!new CustomerService().validateName(name));
		
		
		do
		{
			System.out.println("Enter customer's Address(Address line 1,Address line 2,City,State,Country,"
				+ "Zipcode): ");
		    address=scanner.nextLine();
		}while(!new CustomerService() .validateAddress(address));
		
		// validate AdhaarNumber
		do {
			 System.out.print("Enter customer's adhaar number: ");
			 adhaar = scanner.next();
		 	 //System.out.println();
		}while(!new CustomerService().validateAdhaarNumber(adhaar));
		
		// validate PAN
		do
		{
			System.out.print("Enter customer's PAN Number: ");
			pan=scanner.next();
		}
		while(!new CustomerService().validatePanNumber(pan));
		
		// validate phone number
		do
		{
			System.out.print("Enter customer's Contact Number: ");
			//System.out.println();
		    contact=scanner.next();
		}
		while(!new CustomerService().validateContactNumber(contact));
			
		// validate gender
		do 
		{

			System.out.print("Enter customer's Gender: ");
			//System.out.println();
		    gender=scanner.next();
		}while(!new CustomerService().validateGender(gender));
		
		// validate date of birth
		do
		{
			System.out.print("Enter customer's date of birth (mm/dd/yyyy): ");
		    dob=scanner.next();
		    date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
		    
		}while(!new CustomerService().validateDateOfBirth(date1));
		
		
		// validates account type
		do
		{
			System.out.print("Enter the type of account(Current/Savings): ");
			//System.out.println();
			accountType=scanner.next();
		}
		while(!new CustomerService().validateAccountType(accountType));
		
		//balance
		System.out.print("Enter the opening balance of the account: ");
		balance = scanner.nextDouble();
		
		// adds customer data to data access object
		CustomerService.addCustomerToDao(id, accountId, name, address, adhaar, pan, contact, gender, date1);
		CustomerService.addAccountToDao(accountId,accountType,balance);
	}
	
	static void updateAccount(Scanner scanner,int updateChoice)
	{
		String accountId;
		String updatedName;
		String updatedContact;
		String updatedAddress;
		
		// name
		if(updateChoice==1)
		{
			// validates account id
			do
			{ 
				System.out.print("Please enter your Account Id : ");
			    accountId=scanner.next();
			}
			while(!new CustomerService().validateAccountId(accountId));
			
			// validates name
			do
			{
				System.out.print("Enter the name to update : ");
				scanner.nextLine();
				updatedName=scanner.nextLine();
			}
			while(!new CustomerService().validateName(updatedName));
			
			// updates name
			CustomerService.updateName(accountId, updatedName);
		}
		else if(updateChoice==2)
		{
			do 
			{
				System.out.print("Please enter your Account Id : ");
			    accountId=scanner.nextLine();
			}
			while(!new CustomerService().validateAccountId(accountId));
			
			do
			{
				System.out.println("Enter the contact number to update:");
				updatedContact=scanner.next();
			}
			while(!new CustomerService().validateContactNumber(updatedContact));	
			
			// updates contact number
			CustomerService.updateContact(accountId,updatedContact);
		}
		else if(updateChoice==3)
		{
			do {
				
				System.out.print("Please enter your Account Id : ");
			    accountId=scanner.nextLine();
			}while(!new CustomerService().validateAccountId(accountId));
			
			do
			{
			    System.out.println("Enter the address to update :");
			    updatedAddress=scanner.nextLine();
			}while(!new CustomerService().validateAddress(updatedAddress));
			
			CustomerService.updateAddress(accountId,updatedAddress);
		}
		else
		{
			System.out.println("Wrong input");
		}
	}

	public static void main(String[] args) throws ParseException {
		
		// scanner variable to take user inputs
		Scanner scanner = new Scanner(System.in);
		
		// variable to store your choice;
		int choice = -1;
		
		do {
			
			// choices present for the user;
			System.out.println();
			System.out.println();
			System.out.println("Press 1 to create a new account");
			System.out.println("Press 2 to update an account");
			System.out.println("Press 3 to delete an account");
			System.out.println("Press 0 to exit");
			System.out.print("Enter your choice : ");
			choice = scanner.nextInt();
			
			// creates new account
			if(choice==1)
			{
				// creates account
				createAccount(scanner);
			}
			else if(choice==2)
			{
				System.out.println();
				System.out.println();
				System.out.println("Press 1 to Update Name");
				System.out.println("Press 2 to Update Contact Number");
				System.out.println("Press 3 to Update Address"); 
				System.out.print("Enter your choice : ");
				
				int updateChoice = scanner.nextInt();
				scanner.nextLine();
				
				// updates account
				updateAccount(scanner,updateChoice);
			}
			else if(choice==3)
			{
				String accountId;
				
				do
				{
					System.out.print("Please enter Account Id to remove : ");
				    accountId=scanner.next();
				}
				while(!new CustomerService().validateAccountId(accountId));
				CustomerService.deleteAccount(accountId);
			}
			else if(choice==0)
			{
				System.exit(0);
			}
			else
			{
				System.out.println("Please select valid option");
			}
			
		}while(choice!=0);
	}
}

