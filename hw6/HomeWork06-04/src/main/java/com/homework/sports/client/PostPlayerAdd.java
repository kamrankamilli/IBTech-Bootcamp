package com.homework.sports.client;

import java.io.IOException;

import com.homework.sports.utils.StreamUtilities;

public class PostPlayerAdd {
	public static void main(String[] args) {
		String address = "http://localhost:8080/HomeWork06-04/player/add";
		try {
			String response = StreamUtilities.post(address,
					"<Player><Name>Luka Modric</Name><AverageScore>3333</AverageScore></Player>");
			System.out.println("Response: ");
			System.out.println(response);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
