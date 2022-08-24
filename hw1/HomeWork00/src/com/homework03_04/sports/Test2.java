package com.homework03_04.sports;

import java.util.ArrayList;

public class Test2 {
	public static void main(String[] args) {
		League league = new League(601, "Süperlig");
		league.setTeams(new ArrayList<>());

		Team team1 = new Team(801, "Godoro Spor");
		league.getTeams().add(team1);
		team1.setPlayers(new ArrayList<>());

		Team team2 = new Team(802, "Fibiler Spor");
		league.getTeams().add(team2);
		team2.setPlayers(new ArrayList<>());
		

		team1.getPlayers().add(new Player(401, "Teoman Alpay", 4.67));
		
		team1.getPlayers().add(new Player(402, "Yusuf Nalkesen", 7.89));

		team1.getPlayers().add( new Player(404, "Avni Anıl", 6.61));

		
		team2.getPlayers().add(new Player(403, "Yıldırım Gürses", 2.93));
		
		team2.getPlayers().add(new Player(405, "Erdoğan Berker", 8.11));
		
		
		System.out.println(league.getLeagueId() + " " + league.getLeagueName());

		for (Team team : league.getTeams()) {

			System.out.println("\t" + team.getTeamId() + " " + team.getTeamName());

			for (Player player : team.getPlayers()) {
				System.out.println("\t\t" + player.getPlayerId() + " " + player.getPlayerName() + " " + player.getAverageScore());
			}

		}

	}
}
