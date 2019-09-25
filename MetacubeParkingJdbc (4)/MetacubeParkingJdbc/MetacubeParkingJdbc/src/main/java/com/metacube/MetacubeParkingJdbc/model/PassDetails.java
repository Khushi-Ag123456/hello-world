package com.metacube.MetacubeParkingJdbc.model;

/**
 * pojo class for pass details for plans.
 * @author Khushi
 *
 */
public class PassDetails {

	private double daily;
	private double monthly;
	private double yearly;
	
	public double getDaily() {
		return daily;
	}
	public void setDaily(double daily) {
		this.daily = daily;
	}
	public double getMonthly() {
		return monthly;
	}
	public void setMonthly(double monthly) {
		this.monthly = monthly;
	}
	public double getYearly() {
		return yearly;
	}
	public void setYearly(double yearly) {
		this.yearly = yearly;
	}
	
	
}
