package com.homework02.sales;

public class CustomerTest2 {

	public static void main(String[] args) {

		Customer customer = new Customer(501, "Neşet Etaş", 4350);
		System.out.println("Müşteri No: " + customer.getCustomerId());
		System.out.println("Müşteri İsmi: " + customer.getCustomerName());
		System.out.println("Toplam Borç: " + customer.getTotalDebit());
	}

}
