package com.godoro.statics;

public class BankAccountTest {
	public static void main(String[] args) {
		BankAccount.setRate(24);
		
		BankAccount account1 = new BankAccount();
		account1.setInvestment(3000);
		BankAccount.setRate(36);
		System.out.println("Tutar Ⅰ 9 Aylık: " + account1.getAmount(9));
		System.out.println("Tutar Ⅰ Yıllık: " + account1.getAmount(BankAccount.MONTHS_IN_A_YEAR));
		
		BankAccount account2 = new BankAccount();
		account2.setInvestment(4000);
		System.out.println("Tutar Ⅱ 9 Aylık: " + account2.getAmount(9));
		System.out.println("TUtar Ⅱ Yıllık: " + account2.getAmount(BankAccount.MONTHS_IN_A_YEAR));
	}
}
