package com.spring.online.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.backend.dao.CategoryDAO;
import com.spring.backend.dao.ProductDAO;
import com.spring.backend.dto.Category;
import com.spring.backend.dto.Product;
import com.spring.online.util.FileUploadUtility;
import com.spring.online.validator.ProductValidator;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	private Logger log = Logger.getLogger(ManagementController.class);
	
	
	@RequestMapping(value="/products",method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation",required=false)String operation) {
		
		ModelAndView  mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title","Manage Products");
		Product nProduct = new Product();
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mv.addObject("product", nProduct);
		
		if(operation!=null) {
			if(operation.equals("product")) {
				mv.addObject("message", "Product Submitted successfully !");
			}else if(operation.equals("category")) {
				mv.addObject("message", "Category Submitted successfully !");

			}
				
		}
		
		return mv;
	}
	
	@RequestMapping(value="/{id}/product",method = RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id) {
		ModelAndView  mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title","Manage Products");
		//fetch the product from database
		Product nProduct = productDAO.get(id);
		//set the product fetch from database
		
		mv.addObject("product", nProduct);
		
		return mv;
		
	}
	
	
	
	
	@RequestMapping(value="/products",method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct,
			BindingResult results,Model model,HttpServletRequest request) {
		
				//handle image validation for new products
				if(mProduct.getId() == 0) {
					new ProductValidator().validate(mProduct, results);
				}
				else {
					// edit check only when the file has been selected
					if(!mProduct.getFile().getOriginalFilename().equals("")) {
						new ProductValidator().validate(mProduct, results);
					}			
				}
			
		//checking if there are errors
		log.info("Error has Encountered");
		if(results.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title","Manage Products");
			model.addAttribute("message", "Validation failed for submission");
			return "page";
		}
		
		
		log.info(mProduct.toString());
		if (mProduct.getId() == 0) {
			//saving a new product
			productDAO.add(mProduct);
		} else {
			//updating the product if id is not 0	
			productDAO.update(mProduct);
		}
		log.info("Page inserted");
		
		//Image upload logic for product category
		
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request,mProduct.getFile(),mProduct.getCode());
		}
		return "redirect:/manage/products?operation=product";
	}
	
	
	

	@RequestMapping(value = "/product/{id}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String managePostProductActivation(@PathVariable int id) {		
		//going to fetch the product from database
		Product product = productDAO.get(id);
		//
		boolean isActive = product.isActive();
		//activating and deactivating based on the value of active field
		product.setActive(!product.isActive());
		//update the product
		productDAO.update(product);		
		return (isActive)? "Product Dectivated Successfully!"+product.getId(): "Product Activated Successfully"+product.getId();
	}
	
	@RequestMapping(value="/category", method = RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category) {
		//add the new category
		categoryDAO.add(category);
		return "redirect:/manage/products?operation=category";
		
	}
	
	
	//returning categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		
		return categoryDAO.list();
		
	}
	
	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
	
	
	
	

}
