package com.capgemini.cab.dao;

public interface QueryMapperCustomer {

	public static final String INSERT_CUSTOMER="INSERT INTO cabcustomer VALUES(customer_sequence.NEXTVAL,?,?,?,?,?)";
	
	public static final String VIEW_CABS="SELECT cabid FROM cab WHERE pincode=?";
	
	public static final String SHOW_ID="SELECT customer_sequence.CURRVAL FROM DUAL";
	
	
}
