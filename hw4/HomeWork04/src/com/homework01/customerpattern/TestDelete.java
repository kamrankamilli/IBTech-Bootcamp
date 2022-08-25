package com.homework01.customerpattern;

public class TestDelete {

	public static void main(String[] args) {
		Customer customer = new Customer(3, "Utku Gulen", 8324);

		CustomerManager customerManager = new CustomerManager();
		try {
			boolean isDeleted = customerManager.delete(customer);
			if (isDeleted) {
				System.out.println("Müşteri: " + customer.getCustomerName() + " silindi");
			} else {
				System.out.println("Hata oluştu! Müşteri: " + customer.getCustomerName() + " silenemedi");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
