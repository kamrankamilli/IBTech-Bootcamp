package com.godoro.relation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AggregatedList {
	public static void main(String[] args) throws Exception {
		String url="jdbc:postgresql://localhost/dbgodoro";
		String user="postgres";
		String password="somepassword";
		
		String driver ="org.postgresql.Driver";
		Class.forName(driver);
		
		Connection connection = DriverManager.getConnection(url,user,password);
		
		String sql = "select e.departmentid, departmentname, sum(montlySalary) as salarySum\n"
				+ "from employee e \n"
				+ "right join department d  on e.departmentid  = d.departmentid \n"
				+ "group  by e.departmentid , d.departmentname";	
		PreparedStatement statement =connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {

			double departmentId = resultSet.getDouble("departmentId");
			String departmnetName = resultSet.getString("departmentName");
			double salarySum = resultSet.getDouble("salarySum");
			System.out.println(departmentId + " " +departmnetName + " " + salarySum);
		}

		connection.close();

	}
}
