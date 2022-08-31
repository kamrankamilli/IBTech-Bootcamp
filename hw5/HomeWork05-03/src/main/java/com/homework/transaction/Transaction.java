package com.homework.transaction;

public class Transaction {
	private long transactionId;
	private String transactionName;
	private double amountLocal;

	public Transaction(long transactionId, String transactionName, double amountLocal) {
		this.transactionId = transactionId;
		this.transactionName = transactionName;
		this.amountLocal = amountLocal;
	}
	
	public Transaction() {
		
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionName() {
		return transactionName;
	}

	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}

	public double getAmountLocal() {
		return amountLocal;
	}

	public void setAmountLocal(double amountLocal) {
		this.amountLocal = amountLocal;
	}
	
	
}
