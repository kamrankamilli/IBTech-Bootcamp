package com.godoro.filer;

public class Supplier {
	private long supplierID;
	private String supplierName;
	private double totalCredit;
	
	public Supplier(long supplierID, String supplierName, double totalCredit) {
		this.supplierID = supplierID;
		this.supplierName = supplierName;
		this.totalCredit = totalCredit;
	}
	
	public Supplier() {
	}
	
	public long getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(long supplierID) {
		this.supplierID = supplierID;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public double getTotalCredit() {
		return totalCredit;
	}
	public void setTotalCredit(double totalCredit) {
		this.totalCredit = totalCredit;
	}
	
	
}
