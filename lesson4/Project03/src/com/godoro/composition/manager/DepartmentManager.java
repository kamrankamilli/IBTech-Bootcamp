package com.godoro.composition.manager;

import java.sql.ResultSet;

import com.godoro.composition.entity.Department;

public class DepartmentManager extends BaseManager<Department>{
	
	protected Department parse(ResultSet resultSet) throws Exception {

		long departmentId = resultSet.getLong("employeeId");
		String departmentName = resultSet.getString("employeeName");

		return new Department(departmentId, departmentName);
	}
}
