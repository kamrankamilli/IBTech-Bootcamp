package com.homework.sports.client;

import java.io.InputStream;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.homework.sports.entity.Player;
import com.homework.sports.utils.StreamUtilities;
import com.homework.sports.utils.XmlHelper;

public class GetPlayerFind {
	public static void main(String[] args) {
		String address = "http://localhost:8080/HomeWork06-04/player/find?id=1";
		try {
			InputStream in = StreamUtilities.get(address);
			Document document = XmlHelper.parse(in);
			Element root = document.getDocumentElement();
			long playerId = XmlHelper.getAttribute(root, "id", 0);
			String playerName = XmlHelper.getSingleElementText(root, "Name", "");
			double averageScore = XmlHelper.getSingleElementText(root, "AverageScore", 0);
			Player player = new Player(playerId, playerName, averageScore);
			System.out.println(player.getPlayerId() + " " + player.getPlayerName() + " " + player.getAverageScore());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
