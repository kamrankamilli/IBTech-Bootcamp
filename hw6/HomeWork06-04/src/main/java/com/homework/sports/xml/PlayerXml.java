package com.homework.sports.xml;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.homework.sports.entity.Player;
import com.homework.sports.utils.XmlHelper;


public class PlayerXml {
	
	public static Document format(Player player) throws ParserConfigurationException {
		Document document = XmlHelper.create("Player");
		Element root = document.getDocumentElement();
		root.setAttribute("id", Long.toString(player.getPlayerId()));
		XmlHelper.addSingleElementText(document, root, "Name", player.getPlayerName());
		XmlHelper.addSingleElementText(document, root, "AverageScore", player.getAverageScore());
		return document;
	}
	public static Document format(List<Player> playerList) throws ParserConfigurationException {
		Document document = XmlHelper.create("Players");
		if(playerList.size()>0) {
			for (Player player : playerList) {
				Element root = document.getDocumentElement();
				Element playerElement = XmlHelper.addSingleElementText(document, root, "Player","");
				playerElement.setAttribute("id", Long.toString(player.getPlayerId()));
				XmlHelper.addSingleElementText(document, playerElement, "Name", player.getPlayerName());
				XmlHelper.addSingleElementText(document, playerElement, "AverageScore", player.getAverageScore());
			}
		}
		return document;
	}
	
	public static Player parseXml(InputStream in) throws ParserConfigurationException, SAXException, IOException {
		Document document = XmlHelper.parse(in);
		Element root = document.getDocumentElement();
		long playerId = XmlHelper.getAttribute(root, "id", 0);
		String playerName = XmlHelper.getSingleElementText(root, "Name", "");
		double averageScore = XmlHelper.getSingleElementText(root, "AverageScore", 0);
		Player player = new Player(playerId, playerName, averageScore);
		return player;
	}
	
	
	
	
	

}
