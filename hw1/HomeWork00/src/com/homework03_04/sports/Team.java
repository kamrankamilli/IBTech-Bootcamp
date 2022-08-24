package com.homework03_04.sports;

import java.util.List;

public class Team {
	private long teamId;
	private String teamName;
	private List<Player> players;
	private League league;
	
	public Team(long teamId, String teamName) {
		this.teamId = teamId;
		this.teamName = teamName;
	}
	
	
	public Team() {
	}

	public long getTeamId() {
		return teamId;
	}
	
	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public List<Player> getPlayers() {
		return players;
	}


	public void setPlayers(List<Player> players) {
		this.players = players;
	}


	public League getLeague() {
		return league;
	}


	public void setLeague(League league) {
		this.league = league;
	}

	
	
	
	
	
	
}
