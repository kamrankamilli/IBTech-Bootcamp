package com.homework.sports.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import com.homework.sports.manager.PlayerManager;
import com.homework.sports.response.Response;
import com.homework.sports.utils.XmlHelper;
import com.homework.sports.xml.PlayerXml;

@WebServlet("/player/list")
public class PlayerListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PlayerManager playerManager = new PlayerManager();
		Document document;
		try {
			document = PlayerXml.format(playerManager.list());
			response.setContentType("application/xml; charset=UTF-8");
			XmlHelper.dump(document, response.getOutputStream());
		} catch (ParserConfigurationException | SQLException | TransformerException e) {
			e.printStackTrace();
			Response.sendResponse(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Something went wrong!");
		}

	}

}
