package com.homework01.customerpattern;

import java.util.List;

public class TestList {

	public static void main(String[] args) {
		CustomerManager customerManager = new CustomerManager();
		System.out.println("Tüm müşteri listesi: ");
		try {
			List<Customer> customerList = customerManager.list();
			for (Customer customer : customerList) {
				System.out.println(customer.getCustomerId() + " "  + customer.getCustomerName() + " " + customer.getTotalCredit());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Toplam krediye göre listele: ");
		try {
			List<Customer> customerList = customerManager.list(6000);
			for (Customer customer : customerList) {
				System.out.println(customer.getCustomerId() + " "  + customer.getCustomerName() + " " + customer.getTotalCredit());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
