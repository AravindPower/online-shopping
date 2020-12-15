package com.spring.online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.backend.dao.ProductDAO;
import com.spring.backend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	
	@Autowired
	private ProductDAO productDAO;
	
	
	@RequestMapping(value="/admin/all/products")
	@ResponseBody
	public List<Product> getAllProducts(){
		
		return productDAO.listActiveProducts();
		
	}
	
	
	
	@RequestMapping(value="/all/products")
	@ResponseBody
	public List<Product> getAllProductsForUser(){
		
		return productDAO.listActiveProducts();
		
	}

	

	
	@RequestMapping(value="/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id){
		
		return productDAO.listActiveByCategory(id);
		
	}

	
	
}
