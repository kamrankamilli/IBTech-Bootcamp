package com.homework.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class StreamUtilities {
	public static String get(String address) throws IOException {
		URL url = new URL(address);
		URLConnection connection = url.openConnection();
		InputStream in = connection.getInputStream();

		return read(in);
	}

	private static String read(InputStream in) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
		String line;
		StringBuilder builder = new StringBuilder();
		while ((line = reader.readLine()) != null) {
			builder.append(line).append("\r\n");
		}
		reader.close();
		return builder.toString();
	}
}
