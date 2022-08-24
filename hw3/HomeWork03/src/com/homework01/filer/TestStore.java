package com.homework01.filer;

import java.util.ArrayList;
import java.util.List;

public class TestStore {

	public static void main(String[] args) {

		try {
			List<Customer> customerList = new ArrayList<>();
			customerList.add(new Customer(784, "Kamran Kamilli", 4500));
			customerList.add(new Customer(524, "Erkan Yıldız", 2500));
			customerList.add(new Customer(124, "Alper Ak", 9500));
			
			String filePath = System.getProperty("user.home") + "/Documents/Customer.txt";
			CustomerFiler customerFiler = new CustomerFiler(filePath);
			customerFiler.store(customerList);
			System.out.println("Müşteriler " + filePath + " dizide kaydedildi");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
