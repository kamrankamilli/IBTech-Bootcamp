package com.homework03.account;

public class AccountTest {
	public static void main(String[] args) {
		
		String line = "601;Kasa Hesabı;23560";
		String[] tokens = line.split(";");

		Account account = new Account(Long.parseLong(tokens[0]), tokens[1], Double.parseDouble(tokens[2]));
		System.out.println(account.getAccountId() + " " + account.getAccountName() + " " + account.getAmountLocal());
		
		StringBuilder builder = new StringBuilder("")
				.append(account.getAccountId()).append(";")
				.append(account.getAccountName()).append(";")
				.append(account.getAmountLocal());
		
		String accountString = builder.toString();
		System.out.println(accountString);
	}
}
