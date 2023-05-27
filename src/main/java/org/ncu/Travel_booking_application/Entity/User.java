package org.ncu.Travel_booking_application.Entity;

import java.util.ArrayList;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

public class User {

	@Override
	public String toString() {
		return "User [Name=" + Name + ", Id=" + Id + ", Email=" + Email + ", Password=" + Password + ", type=" + type
				+ ", userOption=" + userOption + "]";
	}
	@NotEmpty(message="Required")
    String Name;


    int Id;

    @NotEmpty(message="Required")
    @Email
    String Email;

    @NotEmpty(message="Required")
    @Size(min=3,max=20)
    String Password;

    @NotEmpty(message="Required")
    String type;
	ArrayList<String> userOption;
	
	public User() {
		userOption = new ArrayList<String>();
		userOption.add("Seller");
		userOption.add("Buyer");
	}
	
	public ArrayList<String> getUserOption() {
		return userOption;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
