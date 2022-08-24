package com.homework01.filer;

public class CustomerFiler extends BaseFiler<Customer> {

	public CustomerFiler() {

	}

	public CustomerFiler(String path) {
		super(path);
	}

	@Override
	protected Customer parse(String line) {
		String[] tokens = line.split(DELIMETER);
		Customer customer = new Customer();
		customer.setCustomerId(Long.parseLong(tokens[0]));
		customer.setCustomerName(tokens[1]);
		customer.setTotalDebit(Double.parseDouble(tokens[2]));

		return customer;
	}

	@Override
	protected String format(Customer customer) {
		StringBuilder builder = new StringBuilder();
		builder.append(customer.getCustomerId()).append(DELIMETER).append(customer.getCustomerName()).append(DELIMETER)
				.append(customer.getTotalDebit());
		return builder.toString();
	}

}
