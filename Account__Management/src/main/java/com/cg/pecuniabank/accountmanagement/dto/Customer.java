package com.cg.pecuniabank.accountmanagement.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
	
	private String customerId;
	private String customerAccountId;
	private String customerName;
	private String customerAddress;     	
	private String customerAdhaar;
	private String customerPan;
	private String customerContact;
	private String customerGender;
	private Date customerDob;
	
	public Customer(String customerId,String customerAccountId, String customerName, String customerAddress, String customerAdhaar,
			String customerPan, String customerContact, String customerGender, Date customerDob) 
	{
		//super();
		this.customerId = customerId;
		this.customerAccountId=customerAccountId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerAdhaar = customerAdhaar;
		this.customerPan = customerPan;
		this.customerContact = customerContact;
		this.customerGender = customerGender;
		this.customerDob = customerDob;
	}
	
	public String getCustomerId() 
	{
		return customerId;
	}
	public void setCustomerId(String customerId)
	{
		this.customerId = customerId;
	}
	public String getCustomerName() 
	{
		return customerName;
	}
	public void setCustomerName(String customerName) 
	{
		this.customerName = customerName;
	}
	public String getCustomerAddress() 
	{
		return customerAddress; 
	}
	public void setCustomerAddress(String customerAddress)
	{
		this.customerAddress = customerAddress;
	}
	public String getCustomerAdhaar() 
	{
		return customerAdhaar;
	}
	public void setCustomerAdhaar(String customerAdhaar) 
	{
		this.customerAdhaar = customerAdhaar;
	}
	public String getCustomerPan() 
	{
		return customerPan;
	}
	public void setCustomerPan(String customerPan) 
	{
		this.customerPan = customerPan;
	}
	public String getCustomerContact()
	{
		return customerContact;
	}
	public void setCustomerContact(String customerContact)
	{
		this.customerContact = customerContact;
	}
	public String getCustomerGender() 
	{
		return customerGender;
	}
	public void setCustomerGender(String customerGender)
	{
		this.customerGender = customerGender;
	}
	public String getCustomerDob() 
	{
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		 String dob = formatter.format(customerDob);
		 return dob;
	}
	public void setCustomerDob(Date customerDob) 
	{
		this.customerDob = customerDob;
	}
	public String getCustomerAccountId()
	{
		return customerAccountId;
	}
	public void setCustomerAccountId(String customerAccountId)
	{
		this.customerAccountId = customerAccountId;
	}
	
	// to string method
	public String toString()
	{
		return customerId+ " " +customerAccountId+" "+customerName;
	}
}

