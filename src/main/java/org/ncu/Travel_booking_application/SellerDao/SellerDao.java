package org.ncu.Travel_booking_application.SellerDao;

import java.util.List;

import org.ncu.Travel_booking_application.Entity.Hotel;
import org.ncu.Travel_booking_application.Entity.User;

public interface SellerDao {
	
	public int insertRecord(User obj);
	public int objcheck(User obj);
	public List<Hotel> getlist(int SellerId);
	public int InsertHotelRecord(Hotel obj,int SellerId);
	public int getSellerId(User obj);
	public List<Hotel> getSearch(String Search,int SellerId);
	public int deleteRecord(int id);
	public Hotel getHotel(int id);
	public int updateHotel(Hotel obj);
	public User getSeller(int id);
}
