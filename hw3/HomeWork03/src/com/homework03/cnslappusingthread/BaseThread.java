package com.homework03.cnslappusingthread;

public abstract class BaseThread<E> {
	protected E entity;

	public BaseThread(E entity) {
		this.entity = entity;
	}

	public E getEntity() {
		return entity;
	}

	public void setEntity(E entity) {
		this.entity = entity;
	}
}
