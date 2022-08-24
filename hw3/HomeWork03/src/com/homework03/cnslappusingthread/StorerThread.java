package com.homework03.cnslappusingthread;

import java.io.IOException;

public class StorerThread extends BaseThread<SupplierFiler> implements Runnable {

	
	public StorerThread(SupplierFiler supplierFiler) {
		super(supplierFiler);
	}

	@Override
	public void run() {
		try {
			getEntity().store(getEntity().getSupplierList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(getEntity().getSupplierList().size() + " supplier " + getEntity().getPath() + " dizine saklandı");
	}

}
