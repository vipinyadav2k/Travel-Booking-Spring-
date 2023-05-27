package org.ncu.Travel_booking_application.BuyerDao;

import java.util.List;

import org.ncu.Travel_booking_application.Entity.Hotel;
import org.ncu.Travel_booking_application.Entity.User;

public interface BuyerDao {

	public int insertRecord(User obj);
	public int objcheck(User obj);
	List<Hotel> getlist(int id);
	int addBuyer(int id,int BuyerId);
	int getBuyerId(User id);
	int removehotel(int id);
}
