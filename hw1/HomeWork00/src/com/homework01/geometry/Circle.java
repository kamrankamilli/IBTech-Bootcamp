package com.homework01.geometry;

public class Circle {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}
		
	public Circle() {
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if(radius<0) {
			throw new IllegalArgumentException("Radyus eksi olamaz: " + radius);
		}
		this.radius = radius;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}

	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

}
