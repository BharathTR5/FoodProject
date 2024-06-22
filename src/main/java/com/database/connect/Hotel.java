package com.database.connect;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String Name;
	String Email;
	String Address;
	String GSTINNO;
	String Password;
	
	
	
	public int getId() {
		return id;
	}


	public String getName() {
		return Name;
	}


	public String getEmail() {
		return Email;
	}


	public String getAddress() {
		return Address;
	}


	public String getGSTINNO() {
		return GSTINNO;
	}


	public String getPassword() {
		return Password;
	}


	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Hotel(String name, String email, String address, String gSTINNO, String password) {
		super();
		Name = name;
		Email = email;
		Address = address;
		GSTINNO = gSTINNO;
		Password = password;
	}
	
}
