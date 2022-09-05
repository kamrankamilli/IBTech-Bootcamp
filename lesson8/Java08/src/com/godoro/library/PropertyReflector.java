package com.godoro.library;

import java.lang.reflect.Method;

public class PropertyReflector {
	
	private Class<?> parent;
	private String name;
	private Class<?> type;
	private Method getter;
	private Method setter;

	
	
	public PropertyReflector(Class<?> parent, String name, Method getter, Method setter) {
		this.parent = parent;
		this.name = name;
		this.getter = getter;
		this.setter = setter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class<?> getType() {
		return type;
	}

	public Method getGetter() {
		return getter;
	}

	public void setGetter(Method getter) {
		this.getter = getter;
	}

	public Method getSetter() {
		return setter;
	}

	public void setSetter(Method setter) {
		this.setter = setter;
	}

	public Class<?> getParent() {
		return parent;
	}

	public void setParent(Class<?> parent) {
		this.parent = parent;
	}
	
}
