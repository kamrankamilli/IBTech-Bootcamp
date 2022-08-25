package com.homework01.customerpattern;

public class TestInsert {
	public static void main(String[] args) {
		Customer customer = new Customer(0, "Kamran Kamilli", 7458);

		CustomerManager customerManager = new CustomerManager();

		try {
			boolean isInserted = customerManager.insert(customer);
			if (isInserted) {
				System.out.println("Müşteri: " + customer.getCustomerName() + " eklendi");
			} else {
				System.out.println("Hata oluştu! Müşteri: " + customer.getCustomerName() + " eklendi");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
