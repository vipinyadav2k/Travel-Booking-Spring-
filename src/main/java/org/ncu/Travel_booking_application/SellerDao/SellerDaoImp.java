package org.ncu.Travel_booking_application.SellerDao;

import java.util.ArrayList;
import java.util.List;

import org.ncu.Travel_booking_application.Entity.Hotel;
import org.ncu.Travel_booking_application.Entity.User;
import org.ncu.Travel_booking_application.RowMapper.HotelRowMapper;
import org.ncu.Travel_booking_application.RowMapper.SellerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SellerDaoImp implements SellerDao {

	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public int insertRecord(User obj) {
		String Query="insert into sellerregister values(?,?,?,?)";
		Object[] arg = {obj.getId(),obj.getName(),obj.getEmail(),obj.getPassword()};
		int rowsaffected=jdbc.update(Query, arg);
		if(rowsaffected!=0)
			System.out.println("Inserted Successfull");
		return rowsaffected;
	}

	@Override
	public int objcheck(User obj) {
		String Query="update sellerregister set email=? where email=?";
		Object[] arg= {obj.getEmail(),obj.getEmail()};
		int present=jdbc.update(Query, arg);
		return present;
	}

	@Override
	public List<Hotel> getlist(int SellerId) {
		String Query="Select * from hotelinfo where SellerId = ?";
//		String Query="Select * from hotelinfo";
		RowMapper<Hotel> Rmapper = new HotelRowMapper();
		List<Hotel> listofobj = jdbc.query(Query, Rmapper,SellerId);
		return listofobj;
	}

	@Override
	public int InsertHotelRecord(Hotel obj, int SellerId) {
		String Query="insert into hotelinfo values(?,?,?,?,?,?,?,?)";
		Object[] arg = {obj.getHotelId(),obj.getHotelName(),obj.getHotelLocation(),obj.getPrice(),obj.getDuration(),obj.getRating(),SellerId,0};
		int rowsaffected=jdbc.update(Query, arg);
		if(rowsaffected!=0)
			System.out.println("Inserted Successfull");
		return rowsaffected;
	}

	@Override
	public int getSellerId(User obj) {
		String email=obj.getEmail();
		String Query="select * from sellerregister where Email=?";
		User objnew=jdbc.queryForObject(Query, new SellerRowMapper(),email);
		return objnew.getId();
	}

	@Override
	public List<Hotel> getSearch(String Search,int SellerId) {
		String Query="Select * from hotelinfo where SellerId = ?";
		RowMapper<Hotel> Rmapper = new HotelRowMapper();
		List<Hotel> listofobj = jdbc.query(Query, Rmapper,SellerId);
		List<Hotel>array=new ArrayList<Hotel>();
		for(Hotel obj : listofobj)
		{
			String HotelId=obj.getHotelId()+"";
			String Price=obj.getPrice()+"";
			String Duration=obj.getDuration()+"";
			String Rating=obj.getRating()+"";
			int flag=0;
			if(obj.getHotelName().toLowerCase().contains(Search.toLowerCase()) || obj.getHotelLocation().toLowerCase().contains(Search.toLowerCase()) ||HotelId.contains(Search)||Price.contains(Search)||Duration.contains(Search)||Rating.contains(Search))
			{
				flag=1;
			}
			if(flag==0)
			{
				array.add(obj);
			}
		}
		for(Hotel obj: array)
		{
			listofobj.remove(obj);
		}
		return listofobj;
	}

	@Override
	public int deleteRecord(int id) {
		String Query = "delete from hotelinfo where HotelId=?";
		int rowsaffected=jdbc.update(Query, id);
		return rowsaffected;
	}

	@Override
	public Hotel getHotel(int id) {
		String Query="select * from hotelinfo where HotelId=?";
		Hotel obj=jdbc.queryForObject(Query, new HotelRowMapper(),id);
		return obj;
	}

	@Override
	public int updateHotel(Hotel obj) {
		String Query="update hotelinfo set HotelName=?,HotelLocation=?,Price=?,Duration=?,Rating=? where HotelId=?";
		Object[] arg= {obj.getHotelName(),obj.getHotelLocation(),obj.getPrice(),obj.getDuration(),obj.getRating(),obj.getHotelId()};
		int rowsaffected=jdbc.update(Query, arg);
		return rowsaffected;
	}

	@Override
	public User getSeller(int id) {
		String Query="select * from sellerregister where SellerID=?";
		User user=jdbc.queryForObject(Query,new SellerRowMapper(),id);
		return user;
	} 
	
}
