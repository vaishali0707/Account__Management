package com.cg.pecuniabank.accountmanagement.service;

import java.util.Date;

public interface Authentication {
	
	public boolean validateName(String name);
	public boolean validateAddress(String address);
	public boolean validateAdhaarNumber(String adhaar);
	public boolean validateContactNumber(String contact);
	public boolean validateGender(String contact);
	public boolean validateDateOfBirth(Date date);
	public boolean validateAccountId(String accountId);
	public boolean validateAccountType(String accountType);
}

