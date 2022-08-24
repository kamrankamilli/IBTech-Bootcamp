package com.homework02.math;

public class FunctionDrawer {

	public void draw(MathFunction function, double x1, double x2, int n) {
		double dx = (x2 - x1) / n;
		for (double x = x1; x < x2; x += dx) {
			double y = function.evaluate(x);
			System.out.println("(" + x + " " + y + ")");
		}
	}

}
