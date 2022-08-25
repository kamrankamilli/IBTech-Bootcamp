package com.homework02.composition.test;

import java.util.List;

import com.homework02.composition.entity.Employee;
import com.homework02.composition.manager.EmployeeManager;

public class TestEmployeeList {

	public static void main(String[] args) {
		EmployeeManager employeeManager = new EmployeeManager();
		try {
			List<Employee> employeeList  = employeeManager.list();
			for (Employee employee : employeeList) {
				System.out.println(employee.getEmployeeId() + " " + employee.getEmployeeName() + " " +employee.getMontlySalary());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
