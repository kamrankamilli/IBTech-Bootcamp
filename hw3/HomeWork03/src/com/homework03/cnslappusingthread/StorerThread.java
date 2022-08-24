package com.homework03.cnslappusingthread;

import java.io.IOException;

public class StorerThread extends BaseThread implements Runnable {

	
	public StorerThread(SupplierFiler supplierFiler) {
		super(supplierFiler);
	}

	@Override
	public void run() {
		try {
			supplierFiler.store(supplierFiler.getSupplierList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(supplierFiler.getSupplierList().size() + " supplier " + supplierFiler.getPath() + " dizine saklandı");
	}

}
