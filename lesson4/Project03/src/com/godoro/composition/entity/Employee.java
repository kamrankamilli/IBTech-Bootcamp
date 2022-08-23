package com.godoro.composition.entity;

public class Employee {
	private long employeeId;
	private String employeeName;
	private double montlySalary;
	
	private Department department;

	public Employee(long employeeId, String employeeName, double montlySalary) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.montlySalary = montlySalary;
	}

	public Employee() {
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getMontlySalary() {
		return montlySalary;
	}

	public void setMontlySalary(double montlySalary) {
		this.montlySalary = montlySalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
