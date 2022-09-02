package com.homework.sports.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Document;

import com.homework.sports.entity.Player;
import com.homework.sports.manager.PlayerManager;
import com.homework.sports.response.Response;
import com.homework.sports.utils.XmlHelper;
import com.homework.sports.xml.PlayerXml;

@WebServlet("/player/find")
public class PlayerFindServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("id") != null) {
			long playerId=0;
			try {
				playerId = Long.parseLong(request.getParameter("id"));
			}catch(NumberFormatException e) {
				e.printStackTrace();
				Response.sendResponse(response, 422, "Invalid data type");
			}
			
			PlayerManager playerManager = new PlayerManager();
			try {

				Player player = playerManager.find(playerId);
				Document document = PlayerXml.format(player);
				response.setContentType("application/xml; charset=UTF-8");
				XmlHelper.dump(document, response.getOutputStream());

			} catch (Exception e) {
				e.printStackTrace();
				Response.sendResponse(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
			}
		} else {
			Response.sendResponse(response, HttpServletResponse.SC_BAD_REQUEST, "Parameter id is needed");
		}

	}
}
