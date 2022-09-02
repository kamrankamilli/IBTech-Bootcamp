package com.homework.sports.client;

import java.io.IOException;

import com.homework.sports.utils.StreamUtilities;

public class PostPlayerUpdate {
	public static void main(String[] args) {
		String address = "http://localhost:8080/HomeWork06-04/player/update";
		try {
			String response = StreamUtilities.post(address,
					"<Player id='3'><Name>Yunus Emre</Name><AverageScore>7745</AverageScore></Player>");
			System.out.println("Response: ");
			System.out.println(response);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
