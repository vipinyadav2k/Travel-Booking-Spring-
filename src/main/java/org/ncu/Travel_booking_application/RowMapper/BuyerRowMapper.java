package org.ncu.Travel_booking_application.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.ncu.Travel_booking_application.Entity.User;
import org.springframework.jdbc.core.RowMapper;

public class BuyerRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User obj=new User();
		obj.setId(rs.getInt("BuyerID"));
		obj.setEmail(rs.getString("Email"));
		obj.setName(rs.getString("BuyerName"));
		obj.setPassword(rs.getString("Password"));
		obj.setType("Seller");
		return obj;
	}

}
