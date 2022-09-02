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

import com.homework.sports.manager.PlayerManager;
import com.homework.sports.response.Response;
import com.homework.sports.utils.XmlHelper;

@WebServlet("/player/delete")
public class PlayerDeleteServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InputStream in = request.getInputStream();

		try {
			Document document = XmlHelper.parse(in);
			Element root = document.getDocumentElement();
			long playerId = XmlHelper.getAttribute(root, "id", 0);
			if (playerId != 0) {
				PlayerManager playerManager = new PlayerManager();
				boolean isDeleted = playerManager.delete(playerId);

				response.setContentType("application/xml; charset=UTF-8");
				document = XmlHelper.create("Response");
				root = document.getDocumentElement();

				if (isDeleted) {
					Response.sendResponse(response, HttpServletResponse.SC_OK, "Player deleted");

				} else {
					Response.sendResponse(response, HttpServletResponse.SC_NOT_FOUND, "Player not found!");
				}
			} else {
				Response.sendResponse(response, HttpServletResponse.SC_BAD_REQUEST, "Player id must be valid");
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
