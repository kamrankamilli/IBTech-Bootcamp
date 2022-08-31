package com.godoro.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class StreamUtilities {
	public static String read(InputStream in) throws UnsupportedEncodingException, IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));

		String line;
		StringBuilder builder = new StringBuilder();
		while ((line = reader.readLine()) != null) {
			builder.append(line).append("\r\n");
		}
		reader.close();
		return builder.toString();
	}

	public static String get(String address) throws Exception {
		URL url = new URL(address);
		URLConnection connection = url.openConnection();
		InputStream in = connection.getInputStream();
		return read(in);
	}
	public static void write(OutputStream out, String output) throws UnsupportedEncodingException, IOException {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out,"utf-8"));
		writer.write(output);
		writer.flush();
		out.flush();
		out.close();
	}
	public static String post(String address, String output) throws MalformedURLException, IOException, UnsupportedEncodingException {
		URL url = new URL(address);

		URLConnection connection = url.openConnection();
		connection.setDoInput(true);
		connection.setDoOutput(true);

		StreamUtilities.write(connection.getOutputStream(),output);

		return StreamUtilities.read(connection.getInputStream());
	}
}
