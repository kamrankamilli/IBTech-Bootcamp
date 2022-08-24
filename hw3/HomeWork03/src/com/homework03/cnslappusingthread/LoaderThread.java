package com.homework03.cnslappusingthread;

import java.io.IOException;
import java.util.List;

public class LoaderThread extends BaseThread implements Runnable {
	

	public LoaderThread(SupplierFiler supplierFiler) {
		super(supplierFiler);
	}

	@Override
	public void run() {
		try {
			List<Supplier> supplierList = supplierFiler.load();
			supplierFiler.setSupplierList(supplierList);
			System.out.println("Yüklendi");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
