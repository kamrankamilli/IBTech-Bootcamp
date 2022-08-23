package com.homework.employee;

public class Employee extends Person {
	private long employeeId;
	private double monthlySalary;

	public Employee(long employeeId, String firstName, String lastName, String emailAddress, double monthlySalary) {
		super(firstName, lastName, emailAddress);
		this.employeeId = employeeId;
		this.monthlySalary = monthlySalary;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	@Override
	String getGreeting() {
		return "Merhaba";
	}
	
	

}
