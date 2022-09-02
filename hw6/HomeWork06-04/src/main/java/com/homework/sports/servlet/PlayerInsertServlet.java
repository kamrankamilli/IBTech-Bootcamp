package com.homework.sports.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.homework.sports.entity.Player;
import com.homework.sports.manager.PlayerManager;
import com.homework.sports.response.Response;
import com.homework.sports.utils.StreamUtilities;
import com.homework.sports.utils.XmlHelper;
import com.homework.sports.xml.PlayerXml;

@WebServlet("/player/add")
public class PlayerInsertServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/xml; charset=UTF-8");
		InputStream in = request.getInputStream();
		;

		try {
			Player player = PlayerXml.parseXml(in);
			PlayerManager playerManager = new PlayerManager();
			boolean isInserted = playerManager.insert(player);
			if (isInserted) {
				Response.sendResponse(response, HttpServletResponse.SC_CREATED, "Player added");
			} else {
				Response.sendResponse(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Something went wrong!");
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			Response.sendResponse(response, HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
		}catch (SQLException e) {
			Response.sendResponse(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Something went wrong!");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			Response.sendResponse(response, 422, "Invalid data type");
		}

	}
}
