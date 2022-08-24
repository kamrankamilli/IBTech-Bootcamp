package com.homework01.employee;

public class Test {
	public static void main(String[] args) {
		Employee employee = new Employee(201, "Erkan", "Ocaklı", "erkan@godoro.com", 5470);
		System.out.println(employee.getEmployeeId() + " " + employee.getFullName() + " " + employee.getMonthlySalary()
				+ " " + employee.getEmailAddress());
		sendEmail(employee);
	}

	public static void sendEmail(Person person) {
		System.out.println();
		System.out.println("Email gönderiliyor...");
		System.out.println("Kime: " + person.getEmailAddress());
		System.out.println("Konu: " + person.getGreeting());
		System.out.println("Gövde: " + person.getFullName());
	}

}
