package com.spring.online.handler;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.spring.backend.dao.UserDAO;
import com.spring.backend.dto.Address;
import com.spring.backend.dto.Cart;
import com.spring.backend.dto.User;
import com.spring.online.model.RegisterModel;

@Component
public class RegisterHandler implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public RegisterModel init() {
		return new RegisterModel();
	}
	
	
	public void addUser(RegisterModel registerModel, User user) {
		
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}
	
	
	public String validateUser(User user, MessageContext error) {
		
		String transitionValue = "success";
		
		if(!(user.getPassword().equals(user.getConfirmPassword()))) {
			
			error.addMessage(new MessageBuilder().error()
					.source("confirm Password")
						.defaultText("Password Does Not match").build());
			
			transitionValue = "failure";
		}
		
		//check unique email
		if(userDAO.getByEmail(user.getEmail())!=null) {
			
			error.addMessage(new MessageBuilder().error().source("email").defaultText("Mail id is already taken").build());
			
			transitionValue = "failure";
			
			
		}
		
		return transitionValue;
		
		
	}
	
	
	public String saveAll(RegisterModel model) {
		String 	transitionValue = "success";
		
		//fetch the user
		User user = model.getUser();
		
		if(user.getRole().equals("USER")) {
			
			Cart cart =  new Cart();
			cart.setUser(user);
			user.setCart(cart);
			
		}
		//encode the password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		// save the user
		userDAO.addUser(user);
		
		//get the address
		Address billing = model.getBilling();
		billing.setId(user.getId());
		billing.setBilling(true);
		
		userDAO.addAddress(billing);
		
		
		
		return transitionValue;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
