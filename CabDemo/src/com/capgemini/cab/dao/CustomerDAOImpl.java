package com.capgemini.cab.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.capgemeni.cab.exception.CabException;
import com.capgemini.cab.bean.CustomerBean;
import com.capgemini.cab.util.DBConnection;

public class CustomerDAOImpl implements ICustomerDAO {

	@Override
	public boolean insertCustomer(CustomerBean customerBean)
			throws CabException {
		
		int records=0;
		boolean isInserted=false;
		try(Connection connPurchaseDetails = DBConnection.getInstance().getConnection();	
	
	PreparedStatement preparedStatement=
		connPurchaseDetails.prepareStatement(QueryMapperCustomer.INSERT_CUSTOMER);)
		{
			java.sql.Date regDate = Date.valueOf(LocalDate.now());
			
			/*String str = purchaseDetailsBean.getHiredate();
			 * 
			 * TemporalAccessor ta = dtf.parse(str);
			
			LocalDate localDate = LocalDate.from(ta);
			
			java.sql.Date translatedDate = java.sql.Date.valueOf(localDate);*/
			
			
			preparedStatement.setString(1, customerBean.getName());
			preparedStatement.setString(2, customerBean.getAddress());
			preparedStatement.setString(3, customerBean.getPhoneNo());
			preparedStatement.setDate(4, regDate/* translatedDate*/);
			preparedStatement.setString(5, customerBean.getPin());
			
			records=preparedStatement.executeUpdate();
			
			if(records>0){
				isInserted=true;
			}
			
		} catch(SQLException sqlEx){
			throw new CabException(sqlEx.getMessage());
		}
	return isInserted;
	}

	@Override
	public int viewCabs(String pin) throws CabException {
		int cabid=0;
try(Connection connMobile = DBConnection.getInstance().getConnection();	
				
				PreparedStatement preparedStatement=
					connMobile.prepareStatement(QueryMapperCustomer.VIEW_CABS);
					)
					{
						
						preparedStatement.setString(1, pin);
						
						ResultSet rsMobiles=preparedStatement.executeQuery();
						
						if(rsMobiles.next()){
							cabid= rsMobiles.getInt("cabid");
						}
						
					} catch(SQLException sqlEx){
						throw new CabException(sqlEx.getMessage());
					}
return cabid;
	}

	@Override
	public int getId() throws CabException {
		int customerId=0;
		try(Connection connMobile = DBConnection.getInstance().getConnection();	
						
						PreparedStatement preparedStatement=
							connMobile.prepareStatement(QueryMapperCustomer.SHOW_ID);
							)
							{
								ResultSet rsMobiles=preparedStatement.executeQuery();
								
								if(rsMobiles.next()){
									customerId= rsMobiles.getInt(1);
								}
								
							} catch(SQLException sqlEx){
								throw new CabException(sqlEx.getMessage());
							}
		return customerId;
	}

}
