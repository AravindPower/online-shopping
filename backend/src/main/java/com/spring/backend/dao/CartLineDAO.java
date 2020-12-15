package com.spring.backend.dao;

import java.util.List;

import com.spring.backend.dto.Cart;
import com.spring.backend.dto.CartLine;

public interface CartLineDAO {

	//The common methods from previously coded one
	public CartLine get(int id);
	
	public boolean add(CartLine cartLine);
	
	public boolean update(CartLine cartLine);
	
	public boolean delete(CartLine cartLine);
	
	public List<CartLine> list(int cartId);
	
	//Other business method related to cart Line
	public List<CartLine> listAvailble(int cartId);
	
	public CartLine getByCartAndProduct(int carrId, int productId);
	
	//update an cart
   boolean updateCart(Cart cart);
	
}
