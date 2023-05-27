package org.ncu.Travel_booking_application.Entity;

public class Hotel {

	@Override
	public String toString() {
		return "Hotel [HotelId=" + HotelId + ", HotelName=" + HotelName + ", HotelLocation=" + HotelLocation
				+ ", Price=" + Price + ", Duration=" + Duration + ", Rating=" + Rating + ", SellerId=" + SellerId
				+ ", BuyerId=" + BuyerId + "]";
	}
	int HotelId;
	String HotelName;
	String HotelLocation;
	int Price;
	int Duration;
	int Rating;
	int SellerId;
	int BuyerId;
	String Search;
	public String getSearch() {
		return Search;
	}
	public void setSearch(String search) {
		Search = search;
	}
	public int getHotelId() {
		return HotelId;
	}
	public void setHotelId(int hotelId) {
		HotelId = hotelId;
	}
	public String getHotelName() {
		return HotelName;
	}
	public void setHotelName(String hotelName) {
		HotelName = hotelName;
	}
	public String getHotelLocation() {
		return HotelLocation;
	}
	public void setHotelLocation(String hotelLocation) {
		HotelLocation = hotelLocation;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getDuration() {
		return Duration;
	}
	public void setDuration(int duration) {
		Duration = duration;
	}
	public int getRating() {
		return Rating;
	}
	public void setRating(int rating) {
		Rating = rating;
	}
	public int getSellerId() {
		return SellerId;
	}
	public void setSellerId(int sellerId) {
		SellerId = sellerId;
	}
	public int getBuyerId() {
		return BuyerId;
	}
	public void setBuyerId(int buyerId) {
		BuyerId = buyerId;
	}
	
}
