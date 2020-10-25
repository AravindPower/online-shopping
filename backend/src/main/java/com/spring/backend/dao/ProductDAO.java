package com.spring.backend.dao;

import java.util.List;

import com.spring.backend.dto.Product;

public interface ProductDAO {
	
	
	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	//business methoda
	List<Product> listActiveProducts();
	List<Product> listActiveByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);

}
