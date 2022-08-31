package com.homework01.customerpattern;

public class TestFind {
	public static void main(String[] args) {

		CustomerManager customerManager = new CustomerManager();
		try {
			Customer customer = customerManager.find(2);
			if (customer != null) {
				System.out.println(
						customer.getCustomerId() + " " + customer.getCustomerName() + " " + customer.getTotalCredit());
			} else {
				System.out.println("Bulunmadı");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
