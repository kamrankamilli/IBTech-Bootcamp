package com.godoro.orm.relation.example;

import com.godoro.orm.relation.entity.Team;
import com.godoro.orm.relation.repository.TeamRepository;

public class TeamFind {
	public static void main(String[] args) {
		long teamId = 2;
		TeamRepository teamRepository = new TeamRepository();
		Team team = teamRepository.find(teamId);
		System.out.println(team.getTeamId()+ " " + team.getTeamName());
	}
}
