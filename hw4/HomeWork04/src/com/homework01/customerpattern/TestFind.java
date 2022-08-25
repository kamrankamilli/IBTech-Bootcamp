package com.homework01.customerpattern;

import java.util.List;

public class TestFind {
	public static void main(String[] args) {

		CustomerManager customerManager = new CustomerManager();
		try {
			Customer customer = customerManager.find(2);
			System.out.println(
					customer.getCustomerId() + " " + customer.getCustomerName() + " " + customer.getTotalCredit());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
