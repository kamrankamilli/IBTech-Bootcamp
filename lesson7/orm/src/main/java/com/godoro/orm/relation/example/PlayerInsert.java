package com.godoro.orm.relation.example;

import com.godoro.orm.relation.entity.Player;
import com.godoro.orm.relation.entity.Team;
import com.godoro.orm.relation.repository.PlayerRepository;
import com.godoro.orm.relation.repository.TeamRepository;

public class PlayerInsert {
	public static void main(String[] args) {
		long teamId = 2;
		TeamRepository teamRepository = new TeamRepository();
		Team team = teamRepository.find(teamId);
		
		Player player = new Player(0, "Musa Eroglu", 2.2);
		player.setTeam(team);
		
		PlayerRepository playerRepository = new PlayerRepository();
		playerRepository.insert(player);

		System.out.println("Sokuldu " + player.getPlayerId());
	}
}
