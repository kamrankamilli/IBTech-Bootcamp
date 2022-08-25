package com.homework01.customerpattern;

public class Customer {
	private long customerId;
	private String customerName;
	private double totalCredit;
	
	public Customer(long customerId, String customerName, double totalCredit) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.totalCredit = totalCredit;
	}

	public Customer() {
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getTotalCredit() {
		return totalCredit;
	}

	public void setTotalCredit(double totalCredit) {
		this.totalCredit = totalCredit;
	}
	
	
	
}
