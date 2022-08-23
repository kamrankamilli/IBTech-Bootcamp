package com.godoro.console;

public class BuilderTest {

	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder("Godoro: ");
		builder.append("HTML").append(", ");
		builder.append("CSS").append(", ");
		builder.append("JavaScript").append(", ");
		builder.append("XML").append(", ");
		builder.append("JSON").append(", ");
		builder.append("SQL").append(". ");
		String string = builder.toString();
		System.out.println("Sicim: " + string);
		
		
		String string2 = new StringBuilder("Godoro: ")
				.append("HTML").append(", ")
				.append("CSS").append(", ")
				.append("JavaScript").append(", ")
				.append("XML").append(", ")
				.append("JSON").append(", ")
				.append("SQL").append(". ")
				.toString();
		System.out.println("Sicim: " + string2);

	}

}
