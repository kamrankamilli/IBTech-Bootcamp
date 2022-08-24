package com.homework01.filer;

import java.util.List;

public class TestLoad {
	public static void main(String[] args) {
		try {

			String filePath = System.getProperty("user.home") + "/Documents/Customer.txt";
			CustomerFiler customerFiler = new CustomerFiler(filePath);
			List<Customer> customerList = customerFiler.load();

			for (Customer customer : customerList) {
				System.out.println(
						customer.getCustomerId() + " " + customer.getCustomerName() + " " + customer.getTotalDebit());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
