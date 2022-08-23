package com.godoro.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TryTest {

	public static void main(String[] args) {
		String path = "/home/kam/Documents/IBTech/out.txt";
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(path));
			bw.write("Java\r\n");
			bw.write("JDBC\r\n");
			bw.write("JAXP\r\n");
			bw.write("JSON-P\r\n");
			bw.write("JSON\r\n");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(bw!=null) {
					bw.close();
				}
			}catch(IOException e2){
				e2.printStackTrace();
			}
		}
	}

}
