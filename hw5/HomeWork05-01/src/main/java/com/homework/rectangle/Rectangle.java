package com.homework.rectangle;

public class Rectangle {

	private double width;
	private double length;

	public Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}

	public Rectangle() {
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getArea() {
		return width * length;
	}

	public double getPerimeter() {
		return 2 * (width + length);
	}

}
