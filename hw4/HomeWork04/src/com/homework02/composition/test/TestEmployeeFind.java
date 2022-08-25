package com.homework02.composition.test;

import com.homework02.composition.entity.Employee;
import com.homework02.composition.manager.EmployeeManager;

public class TestEmployeeFind {

	public static void main(String[] args) {
		EmployeeManager employeeManager = new EmployeeManager();
		try {
			Employee employee = employeeManager.find(1);
			System.out.println(employee.getEmployeeId() + " " + employee.getEmployeeName() + " " + employee.getMontlySalary());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
