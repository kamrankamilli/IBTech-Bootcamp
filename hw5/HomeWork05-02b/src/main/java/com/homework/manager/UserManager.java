package com.homework.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.homework.entity.User;

public class UserManager extends BaseManager<User> {

	public UserManager() {
		try {
			createUserTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected User parse(ResultSet resultSet) throws Exception {
		long userId = resultSet.getLong("user_id");
		String userName = resultSet.getString("user_name");
		String userPassword = resultSet.getString("user_password");

		User user = new User(userId, userName, userPassword);

		return user;
	}

	public User findByUserName(String userName) throws Exception {
		User user = null;
		connect();

		String sql = "SELECT * FROM users WHERE user_name = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, userName);
		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			user = parse(resultSet);
		}
		disconnect();
		return user;

	}

	public boolean createUser(User user) throws Exception {
		int affected = 0;
		User exictedUser = findByUserName(user.getUserName());
		if (exictedUser == null) {
			connect();
			String sql = "INSERT INTO users(user_name, user_password) VALUES(?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, user.getUserName());
			statement.setString(2, user.getUserPassword());

			affected = statement.executeUpdate();
			disconnect();
		}
		return affected > 0;
	}

	private void createUserTable() throws SQLException {
		connect();
		String sql = "CREATE TABLE IF NOT EXISTS users(user_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,user_name VARCHAR(100) NOT NULL,user_password VARCHAR(128) NOT NULL)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.executeUpdate();
		disconnect();
	}
}
