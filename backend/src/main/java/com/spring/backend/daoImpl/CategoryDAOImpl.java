package com.spring.backend.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.backend.dao.CategoryDAO;
import com.spring.backend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Category> list() {
		
		String ActiveCategories = "FROM Category WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(ActiveCategories); 
		
		query.setParameter("active", true);
		
		
		return query.getResultList();
	}

	@Override // The is method is for getting the single category from database
	public Category get(int id) {
		Category cat = sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
		return cat;
	}

	@Override
	public boolean add(Category category) { // this method is for add product details in database for category

		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean update(Category category) {

		try {
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
