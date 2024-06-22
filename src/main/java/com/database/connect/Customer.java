package com.database.connect;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String email;
	String password;
	long mobileno;
	String address;
	
	
	
	
	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getEmail() {
		return email;
	}


	public String getPassword() {
		return password;
	}


	public long getMobileno() {
		return mobileno;
	}


	public String getAddress() {
		return address;
	}


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(String name, String email, String password, long mobileno, String address) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileno = mobileno;
		this.address = address;
	}	
}
