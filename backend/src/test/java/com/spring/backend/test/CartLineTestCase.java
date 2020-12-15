package com.spring.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.backend.dao.CartLineDAO;
import com.spring.backend.dao.ProductDAO;
import com.spring.backend.dao.UserDAO;
import com.spring.backend.dto.Cart;
import com.spring.backend.dto.CartLine;
import com.spring.backend.dto.Product;
import com.spring.backend.dto.User;

public class CartLineTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CartLineDAO cartLineDAO = null;
	
	private static ProductDAO productDAO = null;
	
	private static UserDAO userDAO = null;
	
	private Product product = null;
	
	private User user = null;
	
	private Cart cart = null;
	
	private CartLine cartLine = null;
	
	@BeforeClass
	public static void init() {
		
	context = new AnnotationConfigApplicationContext();
	context.scan("com.spring.backend");
	context.refresh();
	productDAO = (ProductDAO)context.getBean("productDAO");
	userDAO = (UserDAO)context.getBean("userDAO");
	cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
	
	}
	
	@Test
	public void testAddNewCartLine() {
		//get the user
		user = userDAO.getByEmail("charan@gmail.com");
		
		//fetch the cart
		cart = user.getCart();
		
		//get the product 
		product = productDAO.get(5);	
		
		//create a new cartLine
		cartLine  = new CartLine();
		
		cartLine.setBuyingprice(product.getUnitPrice());
		
		cartLine.setProductCount(cartLine.getProductCount()+1);
		
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		
		cartLine.setAvailble(true);
		
		cartLine.setCartId(cart.getId());
		
		cartLine.setProduct(product);
		
		assertEquals("Failed to add the cart line", true,cartLineDAO.add(cartLine));
		
		//updating the cart 
		
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		cart.setCartLines(cart.getCartLines());
		assertEquals("failed to update the cart ", true,cartLineDAO.updateCart(cart));
	}
	
	
	
	

}
