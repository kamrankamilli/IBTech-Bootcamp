package com.godoro.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestAggregate {
	public static void main(String[] args) throws Exception {

		String url="jdbc:postgresql://localhost/dbgodoro";
		String user="postgres";
		String password="somepassword";
		
		String driver ="org.postgresql.Driver";
		Class.forName(driver);
		
		Connection connection = DriverManager.getConnection(url,user,password);
		
		String sql = "SELECT avg(salesprice) as averagePrice FROM product";	
		PreparedStatement statement =connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		if(resultSet.next()) {
			double averagePrice = resultSet.getDouble("averagePrice");
			System.out.println("Ortalama Eder: " + averagePrice);
		}

		
		connection.close();
		

	}
}
