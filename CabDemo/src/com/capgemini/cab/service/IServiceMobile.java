package com.capgemini.cab.service;

import java.util.List;

import com.capgemeni.cab.exception.CabException;
import com.capgemini.cab.bean.MobileBean;

public interface IServiceMobile {
	
	
	public List<MobileBean> viewAll()throws CabException;
	
	public boolean deleteMobile(int mobileId)throws CabException;
	
	public List<MobileBean>search(float minPrice,float maxPrice)throws CabException;
	
	
	
	
}
