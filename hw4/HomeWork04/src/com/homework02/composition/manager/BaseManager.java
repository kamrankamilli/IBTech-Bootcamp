package com.homework02.composition.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseManager<E> {
	private String url = "jdbc:postgresql://localhost/dbgodoro";
	private String user = "postgres";
	private String password = "Kamran7814";
	private String driver = "org.postgresql.Driver";

	protected Connection connection;

	public BaseManager() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void connect() throws Exception {
		connection = DriverManager.getConnection(url, user, password);
	}

	protected void disconnect() throws Exception {
		connection.close();
	}

	protected List<E> parseList(ResultSet resultSet) throws Exception {
		List<E> entityList = new ArrayList<>();
		while (resultSet.next()) {
			entityList.add(parse(resultSet));
		}
		return entityList;
	}

	protected abstract E parse(ResultSet resultSet) throws Exception;

}
