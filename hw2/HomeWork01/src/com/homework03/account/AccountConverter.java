package com.homework03.account;

public class AccountConverter {
	
	public static Account parse(String line) {
		String[] tokens = line.split(";");
		return new Account(Long.parseLong(tokens[0]), tokens[1], Double.parseDouble(tokens[2]));
	}
	
	public static String format(Account account) {
		
		StringBuilder string = new StringBuilder("")
				.append(account.getAccountId()).append(";")
				.append(account.getAccountName()).append(";")
				.append(account.getAmountLocal());
		
		return string.toString();
	}
}
