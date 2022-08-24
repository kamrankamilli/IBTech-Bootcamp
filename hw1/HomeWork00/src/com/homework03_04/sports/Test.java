package com.homework03_04.sports;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		Team team1 = new Team(801,"Godoro Spor");
		team1.setPlayers(new ArrayList<>());
		
		Player player1 = new Player(401,"Teoman Alpay",4.67);
		team1.getPlayers().add(player1);
		
		Player player2 = new Player(402,"Yusuf Nalkesen",7.89);
		team1.getPlayers().add(player2);
		
		Player player3 = new Player(403,"Avni Anıl", 6.61);
		team1.getPlayers().add(player3);
		
		System.out.println(team1.getTeamId() + " " + team1.getTeamName());
		
		for (Player player  : team1.getPlayers()) {
			System.out.println("\t" + player.getPlayerId() + " " + player.getPlayerName() + " " + player.getAverageScore());
		}
		

	}

}
