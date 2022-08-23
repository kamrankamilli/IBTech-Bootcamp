package com.godoro.inheritance;

public abstract class Person {

	protected String firstName;
	protected String lastName;
	protected String emailAddress;

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String email) {
		this.emailAddress = email;
	}

	public String getFullName() {
		return firstName+", "+lastName;
	}
	abstract public String getGreeting();

}
