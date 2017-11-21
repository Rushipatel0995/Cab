package com.capgemini.cab.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemeni.cab.exception.CabException;
import com.capgemini.cab.bean.MobileBean;
import com.capgemini.cab.dao.ICustomerDAO;
import com.capgemini.cab.dao.IPurchaseDetailsDAO;
import com.capgemini.cab.dao.MobileDAOImpl;
import com.capgemini.cab.dao.PurchaseDetailsDAOImpl;

public class ServiceMobileImpl implements IServiceMobile {
	
	private ICustomerDAO mobileDAO;
	
	public ServiceMobileImpl() {
		mobileDAO = new MobileDAOImpl();
	}
	
	@Override
	public List<MobileBean> viewAll() throws CabException {
		List<MobileBean> mobileList = mobileDAO.viewAll();
		return mobileList;
	}

	
	@Override
	public boolean deleteMobile(int mobileId) throws CabException {
		
		IPurchaseDetailsDAO purchaseDetailsDAO= new PurchaseDetailsDAOImpl();
		boolean isPurchasedDeleted = purchaseDetailsDAO.deletePurchaseDetails(mobileId);
		boolean isDeleted = mobileDAO.deleteMobile(mobileId);
		return (isDeleted && isPurchasedDeleted);
		
	}

	
	@Override
	public List<MobileBean> search(float minPrice, float maxPrice)
			throws CabException {
		
		List<MobileBean> mobileList=mobileDAO.searc(minPrice, maxPrice);
		return mobileList;
	
	}

	public boolean isValidMobileId(int mobileId) throws CabException{
		boolean isValid=false;
		
		String mobile=Integer.toString(mobileId);
		String pattern="[\\d]{4}";
		Pattern ptn=Pattern.compile(pattern);
		Matcher matcher=ptn.matcher(mobile);
		
		isValid=matcher.matches();
		if(!isValid){
			throw new CabException("Invalid mobile id.");
		}
		return isValid;
	}
	
}
