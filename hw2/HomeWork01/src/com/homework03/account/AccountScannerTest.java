package com.homework03.account;

import java.util.Scanner;

public class AccountScannerTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("Account ID: ");
		long accountId = scanner.nextLong();

		System.out.println("Account Name: ");
		String accountName = scanner.next();

		System.out.println("Amount: ");
		double amount = scanner.nextDouble();

		scanner.close();

		Account account = new Account(accountId, accountName, amount);
		
		System.out.printf(account.getAccountId() + " " + account.getAccountName() + " " + account.getAmountLocal());
	}
}
