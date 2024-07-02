package com.database.connect;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	
	@OneToOne(cascade = CascadeType.ALL)
	Cart cart;	
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Order> orders = new ArrayList<Order>();
	
	
	
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public long getMobileno() {
		return mobileno;
	}


	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public List<Order> getOrders() {
		return orders;
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	public Customer(String name, String email, String password, long mobileno, String address, Cart cart,
			List<Order> orders) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileno = mobileno;
		this.address = address;
		this.cart = cart;
		this.orders = orders;
	}


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
}
