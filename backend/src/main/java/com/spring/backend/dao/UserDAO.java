package com.spring.backend.dao;

import java.util.List;

import com.spring.backend.dto.Address;
import com.spring.backend.dto.Cart;
import com.spring.backend.dto.User;

public interface UserDAO {
	//add an user
	boolean addUser(User user);
	
	
	// add an address
	boolean addAddress(Address address);
	
	
	
	//Alternatives for 
	// Address getBillingAddress(int userId);
	//List<Address> listOfShippingAddress(int userId);
	
	Address getBillingAddress(User user);
	
	List<Address> listOfShippingAddress(User user);

	User getByEmail(String email);

}
