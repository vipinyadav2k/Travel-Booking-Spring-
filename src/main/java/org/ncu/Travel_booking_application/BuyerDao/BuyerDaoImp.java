package org.ncu.Travel_booking_application.BuyerDao;

import java.util.List;

import org.ncu.Travel_booking_application.Entity.Hotel;
import org.ncu.Travel_booking_application.Entity.User;
import org.ncu.Travel_booking_application.RowMapper.BuyerRowMapper;
import org.ncu.Travel_booking_application.RowMapper.HotelRowMapper;
import org.ncu.Travel_booking_application.RowMapper.SellerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BuyerDaoImp implements BuyerDao {

	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public int insertRecord(User obj) {
		String Query="insert into buyerregister values(?,?,?,?)";
		Object[] arg = {obj.getId(),obj.getName(),obj.getEmail(),obj.getPassword()};
		int rowsaffected=jdbc.update(Query, arg);
		if(rowsaffected!=0)
			System.out.println("Inserted Successfull");
		return rowsaffected;
	}

	@Override
	public int objcheck(User obj) {
		String Query="update buyerregister set email=? where email=? and password=?";
		Object[] arg= {obj.getEmail(),obj.getEmail(),obj.getPassword()};
		int present=jdbc.update(Query, arg);
		return present;
	}

	@Override
	public List<Hotel> getlist(int id) {
		String Query="Select * from hotelinfo where BuyerId=?";
		RowMapper<Hotel> Rmapper = new HotelRowMapper();
		List<Hotel> listofobj = jdbc.query(Query, Rmapper,id);
		return listofobj;
	}

	@Override
	public int addBuyer(int id,int BuyerId) {
		String Query="update hotelinfo set BuyerId=? where HotelId=?";
		Object[] args= {BuyerId,id};
		int rowsaffected=jdbc.update(Query, args);
		return rowsaffected;
	}

	@Override
	public int getBuyerId(User obj) {
		String email=obj.getEmail();
		String Query="select * from buyerregister where Email=?";
		User objnew=jdbc.queryForObject(Query, new BuyerRowMapper(),email);
		return objnew.getId();
	}

	@Override
	public int removehotel(int id) {
		String Query="update hotelinfo set BuyerId=0 where HotelId=?";
		int rowaffected=jdbc.update(Query, id);
		return rowaffected;
	}
}
