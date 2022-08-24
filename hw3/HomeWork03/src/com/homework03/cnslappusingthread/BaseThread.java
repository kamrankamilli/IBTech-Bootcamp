package com.homework03.cnslappusingthread;

public abstract class BaseThread {
	protected SupplierFiler supplierFiler;

	public BaseThread(SupplierFiler supplierFiler) {
		this.supplierFiler = supplierFiler;
	}

	public SupplierFiler getSupplierFiler() {
		return supplierFiler;
	}

	public void setSupplierFiler(SupplierFiler supplierFiler) {
		this.supplierFiler = supplierFiler;
	}
	
}
