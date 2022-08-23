package com.godoro.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionTest {
	public static void main(String[] args) throws Exception {

		String url="jdbc:postgresql://localhost/dbgodoro";
		String user="postgres";
		String password="somepassword";
		
		String driver ="org.postgresql.Driver";
		Class.forName(driver);
		
		Connection connection = DriverManager.getConnection(url,user,password);
		connection.setAutoCommit(false);
		
		String sql = "INSERT INTO product(productName,salesPrice) values(?,?)";	
		PreparedStatement statement1 =connection.prepareStatement(sql);
		
		statement1.setString(1, "Cep Telefonu");
		statement1.setDouble(2, 5465);
		int affected1 = statement1.executeUpdate();
		
		PreparedStatement statement2 =connection.prepareStatement(sql);
		
		statement2.setString(1, "Cep Telefonu");
		statement2.setDouble(2, 5465);
		int affected2 = statement2.executeUpdate();
		
		
		PreparedStatement statement3 =connection.prepareStatement(sql);
		
		statement3.setString(1, "Cep Telefonu");
		statement3.setDouble(2, 5465);
		int affected3 = statement3.executeUpdate();
		
		connection.commit();
		connection.close();
		
		System.out.println("Etkilenmiş " + affected1);
		System.out.println("Etkilenmiş " + affected2);
		System.out.println("Etkilenmiş " + affected3);

	}

}
