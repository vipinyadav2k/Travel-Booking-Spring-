package org.ncu.Travel_booking_application.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.ncu.Travel_booking_application.Entity.Hotel;
import org.springframework.jdbc.core.RowMapper;

public class HotelRowMapper implements RowMapper<Hotel> {

	@Override
	public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
		Hotel obj = new Hotel();
		obj.setHotelId(rs.getInt("HotelId"));
		obj.setHotelName(rs.getString("HotelName"));
		obj.setHotelLocation(rs.getString("HotelLocation"));
		obj.setPrice(rs.getInt("Price"));
		obj.setDuration(rs.getInt("Duration"));
		obj.setRating(rs.getInt("Rating"));
		obj.setBuyerId(rs.getInt("BuyerId"));
		obj.setSellerId(rs.getInt("SellerId"));
		return obj;
	}
}
