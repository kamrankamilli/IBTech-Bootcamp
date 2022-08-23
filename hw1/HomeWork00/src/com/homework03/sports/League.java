package com.homework03.sports;

import java.util.List;

public class League {
	private long leagueId;
	private String leagueName;
	private List<Team> teams;
	
	
	public League(long leagueId, String leagueName) {
		this.leagueId = leagueId;
		this.leagueName = leagueName;
	}
	

	public League() {
	}

	public long getLeagueId() {
		return leagueId;
	}
	
	public void setLeagueId(long leagueId) {
		this.leagueId = leagueId;
	}
	
	public String getLeagueName() {
		return leagueName;
	}
	
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	
	public List<Team> getTeams() {
		return teams;
	}
	
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
	
}
