package com.godoro.inventory;

public class ProductTest1 {

	public static void main(String[] args) {
		Product product = new Product();
		product.setProductId(501);
		product.setProductName("Cep Telefonu");
		product.setSalePrce(1300);

		System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getSalePrce());
	}

}
