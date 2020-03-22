package com.cg.pecuniabank.accountmanagement.servicetest;
import org.junit.Test;

import com.cg.pecuniabank.accountmanagement.service.CustomerService;

import java.util.Date;

import org.junit.Assert;



public class ServiceTest {
	
	@Test
	public void validAccountId()
	{
		Assert.assertTrue(new CustomerService().validateAccountId("123456789091"));
	}
	@Test
	public void validAccountId1()
	{
		Assert.assertFalse(new CustomerService().validateAccountId("1234567091"));
	}
	@Test
	public void validAddress()
	{
		Assert.assertTrue(new CustomerService().validateAddress("127/211,Juhi Kalan,Kanpur,Uttar Pradesh,India,208027"));
	}
	@Test
	public void validAddress1()
	{
		Assert.assertFalse(new CustomerService().validateAddress("127/211,Juhi Kalan,Kanpur,Uttar Pradesh,India,20802723"));
	}
	@Test
	public void validAdhaarNumber()
	{
		Assert.assertTrue(new CustomerService().validateAdhaarNumber("987654321076"));
 	}
	@Test
	public void validAdhaarNumber1()
	{
		Assert.assertFalse(new CustomerService().validateAdhaarNumber("1234567890"));
	}
	@Test
	public void validContactNumber()
	{
		Assert.assertTrue(new CustomerService().validateContactNumber("9815406012"));
 	}
	@Test
    public void validContactNumber1()
	{
		Assert.assertFalse(new CustomerService().validateContactNumber("885145678"));
	}
	@Test
	public void validGender()
	{
		Assert.assertTrue(new CustomerService().validateGender("male"));
 	}
	@Test
    public void validGender1()
	{
		Assert.assertFalse(new CustomerService().validateGender("m"));
	}
	@Test
	public void validDateOfBirth()
	{
		Assert.assertTrue(new CustomerService().validateDateOfBirth(new Date(1998,12,11)));
 	}
	@Test
    public void validDateOfBirth1()
	{
		Assert.assertFalse(new CustomerService().validateDateOfBirth(new Date(12,03,1998)));
	}
	@Test
	public void validName()
	{
		Assert.assertTrue(new CustomerService().validateName("Vaishali"));
 	}
	@Test
    public void validName1()
	{
		Assert.assertFalse(new CustomerService().validateName("Vaishali123"));
	}
	@Test
	public void validPanNumber()
	{
		Assert.assertTrue(new CustomerService().validatePanNumber("AAUPM0987L"));
 	}
	@Test
    public void validPanNumber1()
	{
		Assert.assertFalse(new CustomerService().validatePanNumber("AAU09877L"));
	}

}

