package com.godoro.inventory;

public class Product {
	
	private long productId;
	private String productName;
	private double salePrce;
	
	
	
	public Product(long productId, String productName, double salePrce) {
		this.productId = productId;
		this.productName = productName;
		this.salePrce = salePrce;
	}
	
	public Product() {
	}

	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getSalePrce() {
		return salePrce;
	}
	public void setSalePrce(double salePrce) {
		this.salePrce = salePrce;
	}
	
	
	
}
