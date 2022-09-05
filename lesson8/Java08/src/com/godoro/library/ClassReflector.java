package com.godoro.library;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ClassReflector {
	private Class<?> type;
	private Constructor<?> constructor;
	private Map<String, PropertyReflector> properties = new HashMap<>();

	public ClassReflector(Class<?> clazz) throws NoSuchMethodException, SecurityException {
		setType(type);
	}

	public ClassReflector(String className) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		setType(Class.forName(className));
	}

	public Class<?> getType() {
		return type;
	}

	public void setType(Class<?> type) throws NoSuchMethodException, SecurityException {
		this.type = type;
		constructor = type.getConstructor();
		findProperties();
	}

	private void findProperties() {
		for (Method method : type.getDeclaredMethods()) {
			if (method.getName().startsWith("get") && method.getParameterCount() == 0) {
				String sub = method.getName().substring(3);
				String property = Character.toLowerCase(sub.charAt(0)) + sub.substring(1);
				String title = Character.toUpperCase(property.charAt(0)) + property.substring(1);
				String get= "get";
			}
		}
	}

	public Object newInstance()
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return constructor.newInstance();
	}
}
