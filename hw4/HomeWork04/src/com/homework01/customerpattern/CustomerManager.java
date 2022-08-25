package com.homework01.customerpattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
	private String url = "jdbc:postgresql://localhost/dbgodoro";
	private String user = "postgres";
	private String password = "Kamran7814";
	private String driver = "org.postgresql.Driver";

	public CustomerManager() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean insert(Customer customer) throws Exception {

		Connection connection = DriverManager.getConnection(url, user, password);

		String sql = "INSERT INTO customer(customer_name,total_credit) VALUES(?,?)";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, customer.getCustomerName());
		statement.setDouble(2, customer.getTotalCredit());

		int affected = statement.executeUpdate();
		connection.close();

		return affected > 0;
	}

	public boolean update(Customer customer) throws Exception {

		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "UPDATE customer SET customer_name=?, total_credit=? WHERE customer_id=?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, customer.getCustomerName());
		statement.setDouble(2, customer.getTotalCredit());
		statement.setLong(3, customer.getCustomerId());

		int affected = statement.executeUpdate();
		connection.close();

		return affected > 0;
	}

	public boolean delete(Customer customer) throws Exception {

		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "DELETE FROM customer WHERE customer_id=?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, customer.getCustomerId());

		int affected = statement.executeUpdate();
		connection.close();

		return affected > 0;
	}

	public List<Customer> list() throws Exception {
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "SELECT * FROM customer";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		List<Customer> customerList = parseList(resultSet);
		connection.close();

		return customerList;
	}

	public List<Customer> list(double totalCredit) throws Exception {

		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "SELECT * FROM customer WHERE total_credit>=?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setDouble(1, totalCredit);

		ResultSet resultSet = statement.executeQuery();

		List<Customer> customerList = parseList(resultSet);
		connection.close();

		return customerList;
	}

	public Customer find(long customerId) throws Exception {
		Customer customer = null;
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "SELECT * FROM customer WHERE customer_id=?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, customerId);

		ResultSet resultSet = statement.executeQuery();
		

		if (resultSet.next()) {
			customer = parse(resultSet);
		}

		connection.close();
		return customer;
	}

	public Customer parse(ResultSet resultSet) throws Exception {

		long customerId = resultSet.getLong("customer_id");
		String customerName = resultSet.getString("customer_name");
		double totalCredit = resultSet.getDouble("total_credit");

		return new Customer(customerId, customerName, totalCredit);
	}

	public List<Customer> parseList(ResultSet resultSet) throws Exception {

		List<Customer> customerList = new ArrayList<>();

		while (resultSet.next()) {
			Customer customer = parse(resultSet);
			customerList.add(customer);
		}

		return customerList;
	}
}
