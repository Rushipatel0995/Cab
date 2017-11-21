package com.capgemini.cab.service;

import com.capgemeni.cab.exception.CabException;
import com.capgemini.cab.bean.PurchaseDetailsBean;

public interface IServicePurchaseMobile {
		public boolean insertPurchaseDetails(PurchaseDetailsBean purchaseDetailsBean)
		throws CabException;
		
		
		
		
}
