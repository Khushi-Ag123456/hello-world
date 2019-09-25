package com.metacube.MetacubeParkingJdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.metacube.MetacubeParkingJdbc.mapper.EmployeeMapper;
import com.metacube.MetacubeParkingJdbc.mapper.PassMapper;
import com.metacube.MetacubeParkingJdbc.model.Employee;
import com.metacube.MetacubeParkingJdbc.model.Image;
import com.metacube.MetacubeParkingJdbc.model.PassDetails;
import com.metacube.MetacubeParkingJdbc.model.Vehicle;

/**
 * implements employeeDao
 * @author Khushi
 *
 */
@Repository
public class EmployeeDaoImp implements EmployeeDao {

	

	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_EMPLOYEE = "INSERT INTO employeeDetails(fullName, gender, emailId, password, contactNo, organization) values(?,?,?,?,?,?)";
	private final String SQL_GET_EMPLOYEEID = "SELECT LAST_INSERT_ID()";
	private final String SQL_INSERT_VEHICLE = "INSERT INTO vehicle(empId, name, type, vehicle_number, identification) VALUES(?,?,?,?,?)";
	private final String SQL_AUTH = "SELECT password FROM employeeDetails WHERE emailId = ?";
	private final String SQL_UPDATE_EMPLOYEE = "UPDATE employeeDetails SET fullName = ?, gender = ?, password = ?, contactNo = ?, organization = ? where emailId = ?";
	private final String SQL_GET_FRIENDS = "SELECT * FROM employeeDetails WHERE organization = (SELECT organization FROM employeeDetails WHERE emailId = ?) and emailId <> ?";
	private final String SQL_GET_PASS = "SELECT daily, monthly, yearly FROM pass WHERE vehicle_type = ?";
	private final String SQL_GET_EMPBYMAIL = "SELECT * FROM employeeDetails WHERE emailId = ?";
	private final String SQL_INSERT_IMAGE = "UPDATE employeeDetails SET image = ? WHERE emailId = ?";
	private final String SQL_GET_IMAGE = "SELECT image FROM employeeDetails WHERE emailId = ? ";
	
	/**
	 * constructor to initialize jdbctemplate.
	 * @param dataSource
	 */
	@Autowired
	public EmployeeDaoImp(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * to add an employee
	 * @param employee object
	 * @return integer value
	 */
	@Override
	public boolean addEmployee(Employee emp) {
		return jdbcTemplate.update(
				SQL_INSERT_EMPLOYEE,
				 emp.getFullName(), emp.getGender(),
						emp.getEmailId(), emp.getPassword(),
						emp.getContactNumber(), emp.getOrganization() ) > 0;

	}

	/**
	 * to get id of last inserted employee
	 * @return employee Id
	 */
	@Override
	public int getEmployeeId() {
		return jdbcTemplate.queryForObject(SQL_GET_EMPLOYEEID, Integer.class);
	}

	/**
	 * to authenticate  a user
	 * @param email address
	 * @return String i.e password for particular mailID
	 */
	@Override
	public String auth(String email) {
		return jdbcTemplate.queryForObject(SQL_AUTH, new Object[]{email}, String.class);
	}

	/**
	 * to register a vehicle
	 * @param vehicle object
	 */
	@Override
	public boolean addVehicle(Vehicle v) {
		return jdbcTemplate.update(
				SQL_INSERT_VEHICLE,
				 v.getEmployeeId(), v.getVehicleName(),
						v.getVehicleType(), v.getVehicleNo(),
						v.getIdentification() ) > 0;
	}

	/**
	 * to get pass details
	 * @param vehicle type.
	 */
	@Override
	public PassDetails getPassPrice(String type) {
		return jdbcTemplate.queryForObject(SQL_GET_PASS, new Object[]{type}, new PassMapper());
	}

	/**
	 * to get details of employee based on mail address.
	 * @param email address
	 */
	@Override
	public Employee getEmployeeByEmail(String email) {
		return jdbcTemplate.queryForObject(SQL_GET_EMPBYMAIL,
				new Object[] { email }, new EmployeeMapper());
	}

	/**
	 * to update an employee
	 * @param employee object
	 */
	@Override
	public boolean updateEmployee(Employee emp) {
		return jdbcTemplate.update(SQL_UPDATE_EMPLOYEE, emp.getFullName(),
				emp.getGender(), emp.getPassword(), emp.getContactNumber(),
				emp.getOrganization(), emp.getEmailId()) > 0;
	}

	/**
	 * to get list of friends
	 * @param email address
	 */
	@Override
	public List<Employee> getFriends(String email) {
		return jdbcTemplate.query(SQL_GET_FRIENDS, new Object[] {email, email}, new EmployeeMapper());
	}

	/**
	 * to insert an image
	 * @param image
	 * @param emailId
	 */
	@Override
	public boolean addImage(String image, String emailId) {
		return jdbcTemplate.update(SQL_INSERT_IMAGE, image, emailId) > 0;
	}

	@Override
	public String getImage(String email) {
		return jdbcTemplate.queryForObject(SQL_GET_IMAGE, new Object[] {email}, String.class);
	}

	

}
