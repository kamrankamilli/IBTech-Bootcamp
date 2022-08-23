package com.godoro.geometry;

public class Rectangle {

	private int width;
	private int height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public Rectangle() {
		this(1, 1);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		if (width < 0) {
			this.width = -width;
		} else {
			this.width = width;
		}
	}

	public int getHeight() {
		return width;
	}

	public void setHeight(int height) {
		if (height < 0) {
			throw new IllegalArgumentException("Yükseklik eksi olamaz: " + height);
		}
		this.height = height;
	}

	public int getArea() {
		return width * height;
	}

	public int getPerimeter() {
		return 2 * (width + height);
	}

}
