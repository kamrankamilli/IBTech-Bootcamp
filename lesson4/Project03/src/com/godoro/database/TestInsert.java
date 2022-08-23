package com.godoro.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestInsert {
	public static void main(String[] args) throws Exception {

		String url="jdbc:postgresql://localhost/dbgodoro";
		String user="postgres";
		String password="somepassword";
		
		String driver ="org.postgresql.Driver";
		Class.forName(driver);
		
		Connection connection = DriverManager.getConnection(url,user,password);
		
		String sql = "INSERT INTO product(productName,salesPrice) values(?,?)";	
		PreparedStatement statement =connection.prepareStatement(sql);
		
		statement.setString(1, "Cep Telefonu");
		statement.setDouble(2, 5465);
		int affected = statement.executeUpdate();
		
		connection.close();
		
		System.out.println("Etkilenmiş " + affected);

	}

}
