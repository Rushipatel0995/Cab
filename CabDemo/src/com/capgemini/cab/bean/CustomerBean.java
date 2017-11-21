package com.capgemini.cab.bean;

import java.time.LocalDate;

public class CustomerBean {
	private int customerId;
	private String name;
	private String address;
	private String pin;
	private String phoneNo;
	private LocalDate regdate;
	
	public CustomerBean() {
		super();
	}


	public CustomerBean(String name, String address, String pin,
			String phoneNo, LocalDate regdate) {
		super();
		
		this.name = name;
		this.address = address;
		this.pin = pin;
		this.phoneNo = phoneNo;
		this.regdate = regdate;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPin() {
		return pin;
	}


	public void setPin(String pin) {
		this.pin = pin;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public LocalDate getRegdate() {
		return regdate;
	}


	public void setRegdate(LocalDate regdate) {
		this.regdate = regdate;
	}


	@Override
	public String toString() {
		return "CustomerBean [customerId=" + customerId + ", name=" + name
				+ ", address=" + address + ", pin=" + pin + ", phoneNo="
				+ phoneNo + ", regdate=" + regdate + "]";
	}
	
	
}