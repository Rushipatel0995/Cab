package com.capgemini.cab.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemeni.cab.exception.CabException;
import com.capgemini.cab.bean.PurchaseDetailsBean;
import com.capgemini.cab.dao.ICustomerDAO;
import com.capgemini.cab.dao.IPurchaseDetailsDAO;
import com.capgemini.cab.dao.MobileDAOImpl;
import com.capgemini.cab.dao.PurchaseDetailsDAOImpl;

public class ServicePurchaseImpl implements IServicePurchaseMobile {

	@Override
	public boolean insertPurchaseDetails(PurchaseDetailsBean purchaseDetailsBean)
			throws CabException {
		
		
		int mobileQuantity=0;
		boolean isItInserted=false;
		boolean isUpdated=false;
		IPurchaseDetailsDAO purchaseDetailsDAO=new PurchaseDetailsDAOImpl();
		ICustomerDAO mobileDAO=new MobileDAOImpl();
		
		mobileQuantity=mobileDAO.getQuantity(purchaseDetailsBean.getMobileId());
		
		if(mobileQuantity>0){
			isItInserted = purchaseDetailsDAO.insertPurchase(purchaseDetailsBean);	
			mobileQuantity--;
			isUpdated=mobileDAO.updateMobile(purchaseDetailsBean.getMobileId(), mobileQuantity);
		}
		
		return (isItInserted && isUpdated);
		
	}

	public boolean isValidCName(String cname) throws CabException{
		boolean isValid=false;
		
		String pattern="[A-Z]{1}[A-za-z]{1,19}";
		Pattern ptn=Pattern.compile(pattern);
		Matcher matcher=ptn.matcher(cname);
		
		isValid=matcher.matches();
		if(!isValid){
			throw new CabException("Invalid name");
		}
		
		return isValid;
		
	}
	
	public boolean isValidPhoneNo (String phone) throws CabException{
		boolean isValid=false;
		
		String pattern="[\\d]{10}";
		Pattern ptn=Pattern.compile(pattern);
		Matcher matcher=ptn.matcher(phone);
		
		isValid=matcher.matches();
		if(!isValid){
			throw new CabException("Invalid Phone number");
		}
		
		return isValid;
		
	}
	
	public boolean isValidMail(String mail) throws CabException{
		boolean isValid=false;
		
		String pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$";
		Pattern ptn=Pattern.compile(pattern);
		Matcher matcher=ptn.matcher(mail);
		
		
		isValid=matcher.matches();
		if(!isValid){
			throw new CabException("Invalid Mail id");
		}
		return isValid;
	}
	
	
	
	
	
}