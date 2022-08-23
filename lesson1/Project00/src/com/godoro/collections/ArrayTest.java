package com.godoro.collections;

public class ArrayTest {

	public static void main(String[] args) {
		int[] array = new int[4];
		array[0] = 3;
		array[1] = -7;
		array[2] = 11;
		array[3] = 6;

		int x = array[2];
		System.out.println("3. öge: " + x);

		for (int i = 0; i < array.length; i++) {
			System.out.println((i + 1) + ". " + array[i]);
		}

		int sum = 0;
		int product = 1;
		
		for (int element : array) {
			System.out.println("$ " + element);
			sum += element;
			product *= element;
		}
		
		System.out.println("Özetim: " + sum);
		System.out.println("Çarpım: " + product);

	}

}
