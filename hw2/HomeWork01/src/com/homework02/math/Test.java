package com.homework02.math;

public class Test {

	public static void main(String[] args) {
		
		FunctionDrawer drawer = new FunctionDrawer();
		
		System.out.println("Identity Function");
		IdentityFunction f1 = new IdentityFunction();
		drawer.draw(f1, 10, 15, 100);
		
		System.out.println();
		
		System.out.println("Quadratic Polynomial");
		QuadraticPolynomial quadtatic = new QuadraticPolynomial(2,4,-5);
		drawer.draw(quadtatic, -5, 5, 100);
		
		
		System.out.println();
		
		System.out.println("Sinusoidal Polynomial");
		SinusoidalPolynomial sinusoidal = new SinusoidalPolynomial(3,5,6);
		drawer.draw(sinusoidal, -Math.PI, Math.PI, 100);
		

	}

}
