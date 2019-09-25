package com.metacube.MetacubeParkingJdbc.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Pojo class for vehicle with validations
 * @author Khushi
 *
 */
public class Vehicle {

	@NotBlank(message = "{blankMsg}")
	private String vehicleName;
	private String vehicleType;
	
	@NotBlank(message = "{blankMsg}")
	@Pattern(regexp = "^[A-Za-z]{2}[0-9]{6}$", message = "Enter a valid vehicle Number")
	private String vehicleNo;
	
	@NotNull(message = "${idMessage}")
	private Integer employeeId;
	
	private String identification;
	
	public String getVehicleName() {
		return vehicleName;
	}
	
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	public String getVehicleType() {
		return vehicleType;
	}
	
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	public String getVehicleNo() {
		return vehicleNo;
	}
	
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getIdentification() {
		return identification;
	}
	
	public void setIdentification(String identification) {
		this.identification = identification;
	}
}
