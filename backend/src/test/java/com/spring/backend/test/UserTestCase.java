package com.spring.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.backend.dao.UserDAO;
import com.spring.backend.dto.Address;
import com.spring.backend.dto.Cart;
import com.spring.backend.dto.User;

public class UserTestCase {
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.spring.backend");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");

	}
	
////	@Test
////	public void testAddUser() {
////		
////		user = new User() ;
////		user.setFirstName("Hrithik");
////		user.setLastName("Roshan");
////		user.setEmail("hr@gmail.com");
////		user.setContactNumber("1234512345");
////		user.setRole("USER");
////		user.setEnabled(true);
////		user.setPassword("12345");
////		
////		
////		
//////		address = new Address();
//////		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
//////		address.setAddressLineTwo("Near Kaabil Store");
//////		address.setCity("Mumbai");
//////		address.setState("Maharashtra");
//////		address.setCountry("India");
//////		address.setPostalCode("400001");
//////		address.setBilling(true);
//////		
//////		
//////		
//////		// linked the address with the user
//////		address.setUserId(user.getId());
//////		
//////		assertEquals("Failed to add the billing address!", true, userDAO.addAddress(address));
////		
////		if(user.getRole().equals("USER")) {
////			//create a cart for this user
////			cart = new Cart();
////			cart.setUser(user);
////			
////			//attach cart with the user
////			user.setCart(cart);
////			
//////			assertEquals("failed to add cart", true,userDAO.updateCart(cart));
//////			address = new Address();
//////			address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
//////			address.setAddressLineTwo("Near Kudrat Store");
//////			address.setCity("Mumbai");
//////			address.setState("Maharashtra");
//////			address.setCountry("India");
//////			address.setPostalCode("400001");
//////			address.setShipping(true);
//////			
//////			address.setUserId(user.getId());
//////			
//////			assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
////		}
////		assertEquals("failed to add user", true, userDAO.addUser(user));
////		
////	
////	}
	
//   @Test
//   public void testUpdateCart() {
//	   //fetch the user by its email
//	   user = userDAO.getByEmail("hr@gmail.com");
//	   
//	   //get the cart of the user
//	   cart = user.getCart();
//	   
//	   cart.setGrandTotal(5555);
//	   cart.setCartLines(2);
//	   
//	   assertEquals("failed to update the cart", true, userDAO.updateCart(cart));
//	   
//	   
//   }

	
//	@Test
//	public void testAddAddress() {
//		
//		
//		//need to add a user
//		user = new User() ;
//     	user.setFirstName("Hrithik");
//     	user.setLastName("Roshan");
//     	user.setEmail("hr@gmail.com");
//     	user.setContactNumber("1234512345");
//     	user.setRole("USER");
//     	user.setEnabled(true);
//     	user.setPassword("12345");
//		
//		//add the user
//     	assertEquals("Failed to add user", true, userDAO.addUser(user));
//		
//		
//		
//		//we are going to add the address
//		
//     	
//     	
//     	address = new Address();
//     	address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
//     	address.setAddressLineTwo("Near Kaabil Store");
//     	address.setCity("Mumbai");
//     	address.setState("Maharashtra");
//     	address.setCountry("India");
//     	address.setPostalCode("400001");
//     	address.setBilling(true);
//     	
//     	//attach the address to the user
//     	address.setUser(user);
//     	
//     	assertEquals("failed to add address", true, userDAO.addAddress(address));
//		
//		//we are also going to 	add the shipping address
//     	
//     	address = new Address();
//     	address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
//     	address.setAddressLineTwo("Near Kudrat Store");
//     	address.setCity("Mumbai");
//     	address.setState("Maharashtra");
//     	address.setCountry("India");
//     	address.setPostalCode("400001");
//     	address.setShipping(true);
//     	
//     	//attach the address to the user
//     	address.setUser(user);
//     	
//     	assertEquals("failed to add shipping address", true, userDAO.addAddress(address));
//		
//     	
//	}
 
//@Test	
//public void testAddAddress() {
//	
//	user = userDAO.getByEmail("hr@gmail.com");
//	
//	address = new Address();
// 	address.setAddressLineOne("302/B unknown Society, Kishan Kanhaiya Nagar");
// 	address.setAddressLineTwo("Near Kudrat Store");
// 	address.setCity("Hyderabad");
// 	address.setState("Telangana");
// 	address.setCountry("India");
// 	address.setPostalCode("500090");
// 	address.setShipping(true);
// 	
// 	//attach the address to the user
// 	address.setUser(user);
// 	
// 	assertEquals("failed to add shipping address", true, userDAO.addAddress(address));
//	
//	
//}
	@Test
	public void testGetAddress() {
		user = userDAO.getByEmail("hr@gmail.com");
		
		assertEquals("failed to fetch the list of address  and size does not match",
						 2, userDAO.listOfShippingAddress(user).size());
		
		assertEquals("failed to fetch the list of address  and size does not match",
				 "Mumbai", userDAO.getBillingAddress(user).getCity());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}