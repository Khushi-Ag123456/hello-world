package com.metacube.MetacubeParkingJdbc.dao;

import java.util.List;

import com.metacube.MetacubeParkingJdbc.model.Employee;
import com.metacube.MetacubeParkingJdbc.model.Image;
import com.metacube.MetacubeParkingJdbc.model.Pass;
import com.metacube.MetacubeParkingJdbc.model.PassDetails;
import com.metacube.MetacubeParkingJdbc.model.Vehicle;

/**
 * Interface for employee functionalities.
 * @author Khushi
 *
 */
public interface EmployeeDao {

	public boolean addEmployee(Employee emp);
	
	public int getEmployeeId();
	
	public String auth(String email);
	
	public boolean addVehicle(Vehicle v);
	
	public PassDetails getPassPrice(String type);
		
	public Employee getEmployeeByEmail(String email);
	
	public boolean updateEmployee(Employee emp);
	
	public List<Employee> getFriends(String email);

	public boolean addImage(String image, String emailId);

	public String getImage(String email);

	
}
