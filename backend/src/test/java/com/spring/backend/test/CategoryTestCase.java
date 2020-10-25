package com.spring.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.backend.dao.CategoryDAO;
import com.spring.backend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.spring.backend");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	
	  @Test public void testAddCategory() { 
	  category = new Category();
	  category.setName("Laptop");
	  category.setDescription("laptop will have high prices");
	  category.setImages("laptop.png");
	  
	  assertEquals("Successfully added a category inside the table ",true,
	  categoryDAO.add(category));
	  
	  }
	 
	/*
	 * @Test public void testSingleCategory() { category = categoryDAO.get(3);
	 * assertEquals("Succesfully value fetched from category","Laptop",category.
	 * getName()); }
	 */
	
//	@Test
//	public void testUpdateCategory() {
//		category = categoryDAO.get(2);
//		
//		category.setName("mobile");
//		assertEquals("succesfully set name ",true, categoryDAO.delete(category));
//		
//		
//	}
//	@Test
//	public void testListCategory() {
//		
//		
//		assertEquals("succesfully set name ",2, categoryDAO.list().size());
//		
//		
//	}
//	
	
	
		/*
		 * @Test //test for every operation on dao layer public void
		 * testAllCrudOperations() { //adding product category = new Category();
		 * category.setName("Television");
		 * category.setDescription("tv is used to see videos");
		 * category.setImages("tv.png");
		 * assertEquals("Successfully added a category inside the table ",true,
		 * categoryDAO.add(category));
		 * 
		 * //adding 2nd product category = new Category(); category.setName("Laptop");
		 * category.setDescription("Descrption of laptop");
		 * category.setImages("laptop.png");
		 * assertEquals("Successfully added a category inside the table ",true,
		 * categoryDAO.add(category));
		 * 
		 * //updating category category = categoryDAO.get(2);
		 * category.setName("Mobiles"); assertEquals("succesfully set name ",true,
		 * categoryDAO.update(category));
		 * 
		 * //deleting or deactivating category
		 * assertEquals("succesfully set name ",true, categoryDAO.delete(category));
		 * 
		 * //getting list of categories assertEquals("succesfully set name ",1,
		 * categoryDAO.list().size());
		 * 
		 * 
		 * 
		 * }
		 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
