package com.homework02.composition.test;

import com.homework02.composition.entity.Employee;
import com.homework02.composition.manager.EmployeeManager;

public class TestEmployeeFind {

	public static void main(String[] args) {
		EmployeeManager employeeManager = new EmployeeManager();
		try {
			Employee employee = employeeManager.find(1);
			if(employee!=null) {
				System.out.println(employee.getEmployeeId() + " " + employee.getEmployeeName() + " " + employee.getMontlySalary());
			}
			else {
				System.out.println("Bulunmadı");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
