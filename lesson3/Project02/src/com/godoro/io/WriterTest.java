package com.godoro.io;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriterTest {

	public static void main(String[] args) throws Exception {
		String path = "/home/kam/Documents/IBTech/out.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(path));
		bw.write("Java\r\n");
		bw.write("JDBC\r\n");
		bw.write("JAXP\r\n");
		bw.write("JSON-P\r\n");
		bw.write("JSON\r\n");
		
		bw.close();
		

	}

}
