package com.godoro.pattern;

public class TestUpdate {

	public static void main(String[] args) {
		try {
			Product product = new Product(1, "Mikser", 450);
			ProductManager productManager = new ProductManager();
			boolean updated = productManager.update(product);
			if(updated) {
				System.out.println("Ürün güncellendi");
			}
			else {
				System.out.println("Ürün güncellenemedi");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
