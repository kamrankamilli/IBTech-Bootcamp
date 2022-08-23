package com.godoro.filer;

import java.util.ArrayList;
import java.util.List;

public class TestFind {
	private static Supplier find(List<Supplier> supplierList, long supplierId) {
		for (Supplier supplier : supplierList) {
			if(supplier.getSupplierID()==supplierId) {
				return supplier;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		List<Supplier> supplierList = new ArrayList<>();
		supplierList.add(new Supplier(601,"Cem Karaca",6540));
		supplierList.add(new Supplier(602,"Barış Manço",7645));
		supplierList.add(new Supplier(602,"Fikret Kızılok",3450));
		
		long supplierId = 609;
		Supplier supplier = find(supplierList,supplierId);
		if(supplier!=null) {
			System.out.println(
					supplier.getSupplierID() + " " + supplier.getSupplierName() + " " + supplier.getTotalCredit());	
		}else {
			System.out.println("Satıcı bulunamadı: " + supplierId);
		}

	}

}
