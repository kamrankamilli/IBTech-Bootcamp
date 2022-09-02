package com.homework.sports.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.homework.sports.entity.Player;
import com.homework.sports.manager.PlayerManager;
import com.homework.sports.response.Response;
import com.homework.sports.utils.XmlHelper;
import com.homework.sports.xml.PlayerXml;
@WebServlet("/player/update")
public class PlayerUpdateServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputStream in = request.getInputStream();
		Player player;
		try {
			player = PlayerXml.parseXml(in);
			PlayerManager playerManager = new PlayerManager();
			boolean isUpdated = playerManager.update(player);
			
			response.setContentType("application/xml; charset=UTF-8");
			Document document = XmlHelper.create("Response");
			Element root = document.getDocumentElement();
			
			if (isUpdated) {
				Response.sendResponse(response, HttpServletResponse.SC_OK, "Player updated");
				
			}else {
				Response.sendResponse(response, HttpServletResponse.SC_NOT_FOUND, "Player not found");
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
			Response.sendResponse(response, HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			Response.sendResponse(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Something went wrong!");
		}

		
	}
}
