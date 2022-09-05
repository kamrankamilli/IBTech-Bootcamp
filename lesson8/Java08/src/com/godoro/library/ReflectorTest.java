package com.godoro.library;

import java.lang.reflect.InvocationTargetException;

public class ReflectorTest {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String className = "com.godoro.source.MyBean";
		ClassReflector classReflector = new ClassReflector(className);
		Object object = classReflector.newInstance();

	}
}
