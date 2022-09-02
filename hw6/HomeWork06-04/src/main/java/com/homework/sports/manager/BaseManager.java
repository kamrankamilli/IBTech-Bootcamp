package com.homework.sports.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseManager<E> {
	protected String url = "jdbc:postgresql://localhost/dbgodoro";
	protected String user = "postgres";
	protected String password = "somepassword";
	protected String driver = "org.postgresql.Driver";

	public BaseManager() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected Connection connection;

	protected void connect() throws SQLException {
		connection = DriverManager.getConnection(url, user, password);
	}

	protected void disconnect() throws SQLException {
		connection.close();
	}

	protected List<E> parseList(ResultSet resultSet) throws SQLException {
		List<E> entityList = new ArrayList<>();
		while (resultSet.next()) {
			entityList.add(parse(resultSet));
		}
		return entityList;
	}

	protected abstract E parse(ResultSet resultSet) throws SQLException;
}
