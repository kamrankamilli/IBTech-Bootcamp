package com.godoro.filer;

import java.util.ArrayList;
import java.util.List;

public class TestStore {

	public static void main(String[] args) {
		try {
			List<Supplier> supplierList = new ArrayList<>();
			supplierList.add(new Supplier(601,"Cem Karaca",6540));
			supplierList.add(new Supplier(602,"Barış Manço",7645));
			supplierList.add(new Supplier(602,"Fikret Kızılok",3450));
			
			String filePath =  "/home/kam/Documents/IBTech/Supplier.txt";
			SupplierFiler supplierFiler = new SupplierFiler(filePath);
			supplierFiler.store(supplierList);
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
