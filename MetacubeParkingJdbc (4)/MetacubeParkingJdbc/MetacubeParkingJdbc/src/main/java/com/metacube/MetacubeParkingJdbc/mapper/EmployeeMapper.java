package com.metacube.MetacubeParkingJdbc.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.MetacubeParkingJdbc.model.Employee;

/**
 * Mapper for employee class
 * @author Khushi
 *
 */
public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

		Employee emp = new Employee();
		emp.setFullName(resultSet.getString("fullName"));
		emp.setEmailId(resultSet.getString("emailId"));
		emp.setGender(resultSet.getString("gender"));
		emp.setContactNumber(resultSet.getString("contactNo"));
		emp.setPassword(resultSet.getString("password"));
		emp.setOrganization(resultSet.getString("organization"));
		return emp;
	}
}
