package com.homework.client;

import com.homework.transaction.Transaction;
import com.homework.transaction.TransactionConverter;
import com.homework.utils.StreamUtilities;

public class GetClient {

	public static void main(String[] args) throws Exception {
		String address = "http://localhost:8080/HomeWork05-03/get?transactionId=3&transactionName=elektrik&amountLocal=43343";
		String text = StreamUtilities.get(address);
		Transaction transaction = TransactionConverter.parse(text, ";");
		System.out.println(transaction.getTransactionId() + " " + transaction.getTransactionName() + " " + transaction.getAmountLocal());

	}

}
