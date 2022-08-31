package com.homework.transaction;

public class TransactionConverter {


	public static Transaction parse(String line,String delimeter) {
		Transaction transaction=null;
		String[] tokens = line.split(delimeter);
		if(tokens.length==3) {
			 transaction= new Transaction(Long.parseLong(tokens[0]), tokens[1], Double.parseDouble(tokens[2]));
		}
		return transaction;
	}

	public static String format(Transaction transaction) {
		StringBuilder sb = new StringBuilder();
		sb.append(transaction.getTransactionId()).append(";").append(transaction.getTransactionName()).append(";")
				.append(transaction.getAmountLocal());
		
		return sb.toString();
	}
}
