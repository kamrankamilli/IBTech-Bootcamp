package com.homework.sports.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.homework.sports.entity.Player;

public class PlayerManager extends BaseManager<Player> {

	public PlayerManager() {
		try {
			createTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Player find(long playerId) throws SQLException {
		Player player = null;
		connect();

		String sql = "SELECT * FROM player WHERE player_id=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, playerId);

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			player = parse(resultSet);
		}

		disconnect();
		return player;
	}

	public List<Player> list() throws SQLException {
		connect();

		String sql = "SELECT * FROM player";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		List<Player> playerList = parseList(resultSet);
		disconnect();

		return playerList;
	}

	public boolean insert(Player player) throws SQLException {
		connect();
		
		String sql = "INSERT INTO player(player_name,average_score) VALUES(?,?)";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, player.getPlayerName());
		statement.setDouble(2, player.getAverageScore());

		int affected = statement.executeUpdate();
		disconnect();

		return affected > 0;

	}

	public boolean update(Player player) throws SQLException {
		connect();

		String sql = "UPDATE player SET player_name=?, average_score=? WHERE player_id=?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, player.getPlayerName());
		statement.setDouble(2, player.getAverageScore());
		statement.setLong(3, player.getPlayerId());

		int affected = statement.executeUpdate();
		disconnect();

		return affected > 0;
	}

	public boolean delete(long playerId) throws SQLException {
		connect();

		String sql = "DELETE FROM player WHERE player_id=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, playerId);

		int affected = statement.executeUpdate();
		disconnect();

		return affected > 0;
	}

	private void createTable() throws SQLException {
		connect();
		String sql = "CREATE TABLE IF NOT EXISTS player(player_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,player_name VARCHAR(100) NOT NULL, average_score NUMERIC NOT NULL)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.executeUpdate();
		disconnect();
	}

	@Override
	protected Player parse(ResultSet resultSet) throws SQLException {

		long playerId = resultSet.getLong("player_id");
		String playerName = resultSet.getString("player_name");
		double averageScore = resultSet.getDouble("average_score");

		Player player = new Player(playerId, playerName, averageScore);

		return player;
	}

}
