package com.homework01.customerpattern;

public class TestUpdate {
	
	
	public static void main(String[] args) {
		Customer customer = new Customer(3, "Utku Gulen", 8324);

		CustomerManager customerManager = new CustomerManager();
		
		try {
			boolean isUpdated = customerManager.update(customer);
			if (isUpdated) {
				System.out.println("Müşteri: " + customer.getCustomerName() + " güncellendi");
			} else {
				System.out.println("Hata oluştu! Müşteri: " + customer.getCustomerName() + " güncellenemedi");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
