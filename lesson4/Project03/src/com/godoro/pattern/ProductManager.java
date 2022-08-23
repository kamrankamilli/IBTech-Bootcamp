package com.godoro.pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
	private String url = "jdbc:postgresql://localhost/dbgodoro";
	private String user = "postgres";
	private String password = "somepassword";
	private String driver = "org.postgresql.Driver";

	public ProductManager() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private List<Product> parseList(ResultSet resultSet) throws Exception {
		List<Product> productList = new ArrayList<>();
		while (resultSet.next()) {
			productList.add(parse(resultSet));
		}
		return productList;
	}

	private Product parse(ResultSet resultSet) throws Exception {

		long productId = resultSet.getLong("productId");
		String productName = resultSet.getString("productName");
		double salesPrice = resultSet.getDouble("salesPrice");

		return new Product(productId, productName, salesPrice);
	}

	public Product find(long productId) throws Exception {
		Product product = null;
		Connection connection = DriverManager.getConnection(url, user, password);

		String sql = "SELECT * FROM product WHERE productId=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, productId);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			product = parse(resultSet);
		}

		connection.close();
		return product;
	}

	public List<Product> list(double salesPriceMin) throws Exception {

		Connection connection = DriverManager.getConnection(url, user, password);

		String sql = "SELECT * FROM product where salesPrice>=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setDouble(1, salesPriceMin);
		ResultSet resultSet = statement.executeQuery();
		List<Product> productList = parseList(resultSet);
		connection.close();
		return productList;
	}

	public List<Product> list() throws Exception {
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "SELECT * FROM product";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		List<Product> productList = parseList(resultSet);
		connection.close();
		return productList;
	}

	public boolean delete(Product product) throws Exception {
		Connection connection = DriverManager.getConnection(url, user, password);

		String sql = "delete from product where productId=?";
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setLong(1, product.getProductId());
		int affected = statement.executeUpdate();

		connection.close();

		return affected > 0;
	}

	public boolean update(Product product) throws Exception {
		Connection connection = DriverManager.getConnection(url, user, password);

		String sql = "UPDATE product SET productName = ?, salesPrice=? WHERE productId=?";
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setString(1, product.getProductName());
		statement.setDouble(2, product.getSalePrce());
		statement.setLong(3, product.getProductId());
		int affected = statement.executeUpdate();

		connection.close();

		return affected > 0;
	}

	public boolean insert(Product product) throws Exception {
		Connection connection = DriverManager.getConnection(url, user, password);

		String sql = "INSERT INTO product(productName,salesPrice) values(?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setString(1, product.getProductName());
		statement.setDouble(2, product.getSalePrce());
		int affected = statement.executeUpdate();

		connection.close();
		return affected > 0;
	}
}
