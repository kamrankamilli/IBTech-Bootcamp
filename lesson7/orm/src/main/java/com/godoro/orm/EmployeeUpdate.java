package com.godoro.orm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeUpdate {
	public static void main(String[] args) {
		long employeeId=1;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");

		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Employee employee = manager.find(Employee.class, employeeId);
		employee.setEmployeeName("Coskun Sabah");
		employee.setMonthlySalary(24300);
		manager.merge(employee);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}
}
