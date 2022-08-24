package com.homework03.cnslappusingthread;

import java.util.ArrayList;
import java.util.List;

public class SupplierFiler extends BaseFiler<Supplier> {

	private static List<Supplier> supplierList = new ArrayList<>();

	public SupplierFiler(String path) {
		super(path);
	}

	public SupplierFiler() {

	}

	@Override
	protected Supplier parse(String line) {
		String[] tokens = line.split(DELIMETER);
		Supplier supplier = new Supplier();
		supplier.setSupplierId(Long.parseLong(tokens[0]));
		supplier.setSupplierName(tokens[1]);
		supplier.setTotalCredit(Double.parseDouble(tokens[2]));
		return supplier;
	}

	@Override
	protected String format(Supplier supplier) {
		StringBuilder builder = new StringBuilder();
		builder.append(supplier.getSupplierId()).append(DELIMETER).append(supplier.getSupplierName()).append(DELIMETER)
				.append(supplier.getTotalCredit());
		return builder.toString();
	}

	public List<Supplier> getSupplierList() {
		return supplierList;
	}

	public void setSupplierList(List<Supplier> supplierList) {
		SupplierFiler.supplierList = supplierList;
	}

}
