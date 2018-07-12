package net.sm.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.sm.onlineshopping.exception.ProductNotFoundException;
import net.sm.shoppingbackend.dao.CategoryDAO;
import net.sm.shoppingbackend.dao.ProductDAO;
import net.sm.shoppingbackend.dto.Category;
import net.sm.shoppingbackend.dto.Product;


@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	public CategoryDAO categoryDAO;
	@Autowired
	public ProductDAO productDAO;
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Home");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickHome",true);
		return mv;

	}
	@RequestMapping(value = {"/about"})
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About us");
		mv.addObject("userClickAbout",true);
		return mv;

	}
	@RequestMapping(value = {"/contact"})
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact us");
		mv.addObject("userClickContact",true);
		return mv;

	}
	/**
	 * 
	 * Methods to load products
	 */

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","All Products");
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickAllProducts",true);
		return mv;				
	}	
	
	@RequestMapping(value = "/show/category/{id}/products") 
	public ModelAndView showCategoryProducts(@PathVariable("id") int id)  {		
		ModelAndView mv = new ModelAndView("page");
		
		// categoryDAO to fetch a single category
		Category category = null;
		
		category = categoryDAO.get(id);
		
		mv.addObject("title",category.getName());
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		// passing the single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts",true);
		return mv;				
	}
	
	/**
	 *  viewing a single product
	 * */
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable("id") int id ) throws ProductNotFoundException {
		ModelAndView mv = new ModelAndView("page");
		Product product = productDAO.get(id);
		
		if(product==null) throw new ProductNotFoundException();
		
		//Update the count of views
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		
		//pass the title
		mv.addObject("title", product.getName());
		
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct",true);
		return mv;
	}
}
