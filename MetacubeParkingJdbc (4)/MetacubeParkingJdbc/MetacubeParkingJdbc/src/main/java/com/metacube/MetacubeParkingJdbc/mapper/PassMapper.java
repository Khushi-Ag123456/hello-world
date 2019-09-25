package com.metacube.MetacubeParkingJdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.MetacubeParkingJdbc.model.PassDetails;

/**
 * Mapper for pass
 * @author Khushi
 *
 */
public class PassMapper implements RowMapper<PassDetails> {

	@Override
	public PassDetails mapRow(ResultSet resultSet, int i) throws SQLException {
		PassDetails pass = new PassDetails();
		pass.setDaily(resultSet.getDouble("daily"));
		pass.setMonthly(resultSet.getDouble("monthly"));
		pass.setYearly(resultSet.getDouble("yearly"));
		return pass;
		
	}
	
	

}
