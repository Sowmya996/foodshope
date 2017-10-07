package com.niit.foodshope.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.foodshope.dao.CategoryDao;
import com.niit.foodshope.dao.ProductDao;
import com.niit.foodshope.dao.UserDao;
import com.niit.foodshope.model.User;

@Controller
public class HomeController {
	@Autowired
	UserDao userdao;
	@Autowired
	CategoryDao categorydao;
    @Autowired
    ProductDao productdao;
    
	@RequestMapping(value="/")
	public ModelAndView home(){
		return new ModelAndView("Home","categories", categorydao.viewCategories()).addObject("user",userdao);
	}
	
	@RequestMapping(value="/Home")
	public ModelAndView aboutUs(){
		return new ModelAndView("Home");
	}
	@RequestMapping(value="/Category")
	public ModelAndView category(){
		return new ModelAndView("Category");
	}
	@RequestMapping(value="/Admin")
	public ModelAndView admin(){
		return new ModelAndView("Admin");
	}
	@RequestMapping(value="/Login",method=RequestMethod.GET)
	public ModelAndView login(){
		return new ModelAndView("Login","command",new User());
	}
	@RequestMapping(value="/Signup",method=RequestMethod.GET)
	public ModelAndView signUp(){
		return new ModelAndView("Signup","command",new User());
	}
	
	@RequestMapping(value="/{category}/{id}")
	public ModelAndView viewProducts(@PathVariable(value="category") String categoryName,@PathVariable(value="id") Integer categoryId){
		return new ModelAndView("products").addObject("image", userdao).addObject("user",userdao);
	}
	
	@RequestMapping(value="/Product/{product}/{id}")
	public ModelAndView viewProduct(@PathVariable(value="product") String productName,@PathVariable(value="id") Integer productId) throws IOException{
		return new ModelAndView("productDetails","product",productdao.getProduct(productId)).addObject("user",userdao).addObject("suppliers",productdao.viewSuppliers(productId));
	}

	
	List<ObjectError> errors;
	
	@RequestMapping(value="/Profile")
	public ModelAndView viewProfile(HttpServletRequest request){
		return new ModelAndView("profile","user",userdao);
	}
	
	
	@RequestMapping(value = "/403")
	public ModelAndView errorPage() {
		ModelAndView model = new ModelAndView("errorPage");
		return model;
	}
}
