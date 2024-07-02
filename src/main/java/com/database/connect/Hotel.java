package com.database.connect;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String Name;
	String Email;
	long Mobileno;
	String Address;
	String GSTINNO;
	String Password;
	@Lob
	private byte[] image;
	
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long getMobileno() {
		return Mobileno;
	}
	public void setMobileno(long mobileno) {
		Mobileno = mobileno;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getGSTINNO() {
		return GSTINNO;
	}
	public void setGSTINNO(String gSTINNO) {
		GSTINNO = gSTINNO;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Hotel(String name, String email, long mobileno, String address, String gSTINNO, String password,
			byte[] image) {
		super();
		Name = name;
		Email = email;
		Mobileno = mobileno;
		Address = address;
		GSTINNO = gSTINNO;
		Password = password;
		this.image = image;
	}
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}