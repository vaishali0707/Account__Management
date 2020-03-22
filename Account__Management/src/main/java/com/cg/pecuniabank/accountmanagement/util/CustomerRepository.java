package com.cg.pecuniabank.accountmanagement.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.cg.pecuniabank.accountmanagement.dto.Customer;

public class CustomerRepository {
	
	// arrayList to store customer data;
	public ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	// method for static data;
	public void addCustomerDetails()
	{
		customerList.add(new Customer("201015","328281742093","Vishal Tiwari","127/211, W-2 Juhi Kalan,Kanpur,Uttar Pradesh,India,208027","326218244862","MNSUT1213B","7007820982","Male",new Date("1992/10/23")));
		customerList.add(new Customer("201016","429862843021","Vaishali Tiwari","718,Collector Ganj,Unnao,Uttar Pradesh,India,208012","142987248883","AAUPT0305M","9815406012","Female",new Date("1998/07/07")));
		customerList.add(new Customer("201017","431303298198","Amardeep Singh","Gujela, Ghatampur,Kanpur,Uttar Pradesh,India,209206","482955428768","SSTMN4321B","8840864659","Male",new Date("1990/03/05")));
     	customerList.add(new Customer("201018","243902141847","Pranav Sinha","58 ,Govindpura,New Delhi,New Delhi,India,111001","529811148262","APMUT4859B","9415546297","Male",new Date("1986/10/03")));
		customerList.add(new Customer("201019","298745498714","Satyam Sinha","East off Bustand, Gangjala,Saharsa,Bihar,India,855201","698523456528","BSTUM8565M","9592571818","Male",new Date("1992/02/04")));
		customerList.add(new Customer("201020","398714968291","Prabhjot","900, Bhagat Singh Nagar Model House,Jalandhar,Punjab,India,144003","498724448199","GTHMS4820S","8427435535","Female",new Date("1997/03/05")));
	}
	
	// adds customer object to customerList
	public void putData(Customer customer) 
	{
		customerList.add(customer);
	}
	
	// returns customerList;
	public ArrayList<Customer> getCustomerList()
	{
		return customerList; 
	}
	
	// shows data
	public void showData()
	{
		Iterator<Customer> it = customerList.iterator();
		
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
