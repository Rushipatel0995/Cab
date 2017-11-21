package com.capgemini.cab.dao;

import com.capgemeni.cab.exception.CabException;
import com.capgemini.cab.bean.CustomerBean;

public interface ICustomerDAO {
	public boolean insertCustomer(final CustomerBean customerBean) throws CabException;
	
	public int viewCabs(String pin) throws CabException;
	
	public int getId() throws CabException;
}
