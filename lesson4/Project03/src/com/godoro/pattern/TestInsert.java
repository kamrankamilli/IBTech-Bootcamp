package com.godoro.pattern;

public class TestInsert {

	public static void main(String[] args) {
		try {
			Product product = new Product(0, "Buzdolabı", 4847);
			ProductManager productManager = new ProductManager();
			boolean inserted = productManager.insert(product);
			if(inserted) {
				System.out.println("Ürün eklendi");
			}
			else {
				System.out.println("Ürün eklenmedi");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
