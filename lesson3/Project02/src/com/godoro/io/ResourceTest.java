package com.godoro.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class ResourceTest {

	public static void main(String[] args) {
		String path = "/home/kam/Documents/IBTech/out.txt";
		//InputStreamReader ist = new InputStreamReader(in, Charset.forName("UTF-8"));
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path));) {
			bw.write("Java\r\n");
			bw.write("JDBC\r\n");
			bw.write("JAXP\r\n");
			bw.write("JSON-P\r\n");
			bw.write("JSON\r\n");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
