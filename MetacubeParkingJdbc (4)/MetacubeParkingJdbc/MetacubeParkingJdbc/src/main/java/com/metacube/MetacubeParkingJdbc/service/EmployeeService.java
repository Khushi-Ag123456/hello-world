package com.metacube.MetacubeParkingJdbc.service;

import java.util.List;

import com.metacube.MetacubeParkingJdbc.model.Employee;
import com.metacube.MetacubeParkingJdbc.model.Image;
import com.metacube.MetacubeParkingJdbc.model.PassDetails;
import com.metacube.MetacubeParkingJdbc.model.Vehicle;

/**
 * interface to represent services of an employee
 * @author Khushi
 *
 */
public interface EmployeeService {

	public boolean addEmployee(Employee emp);
	
	public int getEmployeeId();
	
	public String auth(String email);
	
	public boolean addVehicle(Vehicle v);
	
	public PassDetails getPassPrice(String type);
	
	public double getValueByCurrency(String plan, String currency);
	
	public Employee getEmployeeByEmail(String email);
	
	public boolean updateEmployee(Employee emp);
	
	public List<Employee> getFriends(String email);

	public boolean addImage(String image, String emailId);

	public String getImage(String email);
}
