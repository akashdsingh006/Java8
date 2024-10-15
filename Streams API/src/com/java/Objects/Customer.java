package com.java.Objects;

import java.util.List;

public class Customer {

	Integer customerId;
	String customerName;
	String customerEmails;
	List<Long> phoneNumber;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmails() {
		return customerEmails;
	}
	public void setCustomerEmails(String customerEmails) {
		this.customerEmails = customerEmails;
	}
	public List<Long> getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(List<Long> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Customer(Integer customerId, String customerName, String customerEmails, List<Long> phoneNumber) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmails = customerEmails;
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmails="
				+ customerEmails + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
}
