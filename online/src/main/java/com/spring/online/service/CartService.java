package com.spring.online.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.backend.dao.CartLineDAO;
import com.spring.backend.dto.Cart;
import com.spring.backend.dto.CartLine;
import com.spring.backend.dto.Product;
import com.spring.online.model.UserModel;

@Service("cartService")
public class CartService {

	@Autowired
	private CartLineDAO cartLineDAO;
	@Autowired
	private HttpSession	session;
	
	//returns the cart of user who has logged in 
	private Cart getCart() {
		
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
	
	//returns the entire cart lines
	
	public List<CartLine> getCartLines(){
		
		Cart cart = this.getCart();
		
		return cartLineDAO.list(cart.getId());
		
		
	}

	public String updateCartLine(int cartLineId, int count) {

		//fetch the cart line
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if(cartLine == null) {
			return  "result=error";
		}else {
			Product product = cartLine.getProduct();
			double oldTotal = cartLine.getTotal();
			
			if(product.getQuantity()<= count) {
				count = product.getQuantity();
			}
			cartLine.setProductCount(count);
			cartLine.setBuyingprice(product.getUnitPrice());
			cartLine.setTotal(product.getUnitPrice() * count);
			
			cartLineDAO.update(cartLine);
			
			Cart cart = this.getCart();
			
			cart.setGrandTotal(cart.getGrandTotal() - oldTotal +cartLine.getTotal());
			
			cartLineDAO.updateCart(cart);
			
			
		}
		
		
		return "result=updated";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
