package com.homework02.consoleapplication;

public class SupplierFiler extends BaseFiler<Supplier> {

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

}
