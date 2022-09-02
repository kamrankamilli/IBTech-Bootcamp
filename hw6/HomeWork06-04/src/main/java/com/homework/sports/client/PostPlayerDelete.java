package com.homework.sports.client;

import java.io.IOException;

import com.homework.sports.utils.StreamUtilities;

public class PostPlayerDelete {
	public static void main(String[] args) {
		String address = "http://localhost:8080/HomeWork06-04/player/delete";
		try {
			String response = StreamUtilities.post(address, "<Player id='8'></Player>");
			System.out.println("Response: ");
			System.out.println(response);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
