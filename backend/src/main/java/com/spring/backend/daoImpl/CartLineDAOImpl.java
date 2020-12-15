
package com.spring.backend.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.backend.dao.CartLineDAO;
import com.spring.backend.dto.Cart;
import com.spring.backend.dto.CartLine;
@Repository("cartLineDAO")
@Transactional
public class CartLineDAOImpl implements CartLineDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public CartLine get(int id) {

		return sessionFactory.getCurrentSession().get(CartLine.class,id);
	}

	@Override
	public boolean add(CartLine cartLine) {
	 
		try {
			sessionFactory.getCurrentSession().persist(cartLine);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
		
	}

	@Override
	public boolean update(CartLine cartLine) {
		try {
			sessionFactory.getCurrentSession().update(cartLine);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
		
	}

	@Override
	public boolean delete(CartLine cartLine) {
		try {
			sessionFactory.getCurrentSession().delete(cartLine);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	
	}

	@Override
	public List<CartLine> list(int cartId) {
		
		String query = "FROM CartLine WHERE cartId =: cartId";
		return sessionFactory.getCurrentSession()
				 .createQuery(query, CartLine.class)
				   .setParameter("cartId", cartId)
				     .getResultList();
		
	}

	@Override
	public List<CartLine> listAvailble(int cartId) {

		String query = "FROM CartLine WHERE cartId =: cartId AND availble =:availble";
		
		
		return sessionFactory.getCurrentSession()
				   .createQuery(query,CartLine.class)
				     .setParameter("cartid",cartId)
				       .setParameter("availble", true)
				         .getResultList();
	}

	@Override
	public CartLine getByCartAndProduct(int cartId, int productId) {
		String query = "FROM CartLine WHERE cartId =:cartId AND product.id =:productId";
		try {
		return sessionFactory.getCurrentSession()
				  .createQuery(query,CartLine.class)
				    .setParameter("cartId", cartId)
				      .setParameter("productId", productId)
				       .getSingleResult();
		
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
	
	//related to the cart
	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

}
