package com.spring.backend.dao;

import java.util.List;

import com.spring.backend.dto.Category;

public interface CategoryDAO {
	
	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	
}
