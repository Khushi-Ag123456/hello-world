package com.metacube.MetacubeParkingJdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.metacube.MetacubeParkingJdbc.dao.EmployeeDao;
import com.metacube.MetacubeParkingJdbc.model.Employee;
import com.metacube.MetacubeParkingJdbc.model.Image;
import com.metacube.MetacubeParkingJdbc.model.PassDetails;
import com.metacube.MetacubeParkingJdbc.model.Vehicle;

/**
 * implementation of employeeService interface
 * @author Khushi
 *
 */
@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public boolean addEmployee(Employee emp) {
		return employeeDao.addEmployee(emp);
	}

	@Override
	public int getEmployeeId() {
		return employeeDao.getEmployeeId();
	}

	@Override
	public String auth(String email) {
		return employeeDao.auth(email);
	}

	@Override
	public boolean addVehicle(Vehicle v) {
		return employeeDao.addVehicle(v);
	}

	@Override
	public PassDetails getPassPrice(String type) {
		return employeeDao.getPassPrice(type);
	}

	@Override
	public double getValueByCurrency(String plan, String currency) {
		double passPrice = Double.parseDouble(plan);
		if("YEN".equals(currency)) {
			passPrice *= 1.49;
		} else if ("USD".equals(currency)) {
			passPrice *= 0.014;
		}
		return passPrice;
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		return employeeDao.getEmployeeByEmail(email);
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		return employeeDao.updateEmployee(emp);
	}

	@Override
	public List<Employee> getFriends(String email) {
		return employeeDao.getFriends(email);
	}

	@Override
	public boolean addImage(String image, String emailId) {
		return employeeDao.addImage(image, emailId);
		
	}

	@Override
	public String getImage(String email) {
		return employeeDao.getImage(email);
	}

	
}
