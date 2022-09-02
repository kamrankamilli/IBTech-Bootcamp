package com.homework.sports.client;


import java.io.InputStream;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.homework.sports.entity.Player;
import com.homework.sports.utils.StreamUtilities;
import com.homework.sports.utils.XmlHelper;

public class GetPlayerList {
	public static void main(String[] args) {
		String address = "http://localhost:8080/HomeWork06-04/player/list";
		try {
			InputStream in = StreamUtilities.get(address);
			Document document = XmlHelper.parse(in);
			Element root = document.getDocumentElement();
			NodeList nodeList = root.getElementsByTagName("Player");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element element = (Element) nodeList.item(i);
				long playerId = XmlHelper.getAttribute(element, "id", 0);
				String playerName = XmlHelper.getSingleElementText(element, "Name", "");
				double averageScore = XmlHelper.getSingleElementText(element, "AverageScore", 0);
				Player player = new Player(playerId, playerName, averageScore);
				System.out
						.println(player.getPlayerId() + " " + player.getPlayerName() + " " + player.getAverageScore());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
