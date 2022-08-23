package com.godoro.filer;


public class SupplierFiler extends BaseFiler<Supplier> {



	public SupplierFiler(String path) {
		super(path);
	}

	public SupplierFiler() {
	}
	
	

	protected String format(Supplier supplier) {
		StringBuilder builder = new StringBuilder();
		builder.append(supplier.getSupplierID()).append(DELIMETER).append(supplier.getSupplierName()).append(DELIMETER)
				.append(supplier.getTotalCredit());
		return builder.toString();
	}



	protected Supplier parse(String line) {
		String[] tokens = line.split(DELIMETER);
		Supplier supplier = new Supplier();
		supplier.setSupplierID(Long.parseLong(tokens[0]));
		supplier.setSupplierName(tokens[1]);
		supplier.setTotalCredit(Double.parseDouble(tokens[2]));
		return supplier;
	}




}
