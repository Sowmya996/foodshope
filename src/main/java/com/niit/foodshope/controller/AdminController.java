package com.niit.foodshope.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.niit.foodshope.dao.CategoryDao;
import com.niit.foodshope.dao.ProductDao;
import com.niit.foodshope.dao.UserDao;
import com.niit.foodshope.dao.UtilityDao;
import com.niit.foodshope.model.Category;
import com.niit.foodshope.model.Product;

@RestController
@RequestMapping(value="/Admin")
public class AdminController {

	String error;
	int productId=0;
	@Autowired
	ProductDao productdao;
	@Autowired
	CategoryDao categorydao;
	@Autowired
	UserDao userdao;
	@Autowired
	UtilityDao utilitydao;
	
	@RequestMapping(value="/")
	public ModelAndView admin(){
		Authentication a = SecurityContextHolder.getContext().getAuthentication();
		User currentUser = (User)a.getPrincipal();
		System.out.println(currentUser.getUsername());
		userdao.loadUser(currentUser.getUsername());
		return new ModelAndView("Admin","products",productdao.viewProducts()).addObject("user",userdao);
	}
	
	
	@RequestMapping(value="/Product",method=RequestMethod.GET)
	public ModelAndView addProduct(){
		return new ModelAndView("AddProduct","command",new Product()).addObject("categories", categorydao.viewCategories());
	}
	
	@RequestMapping(value="/Product",method=RequestMethod.POST)
	public String addProduct(HttpServletRequest request,ModelMap model,@RequestParam("file") MultipartFile file, @Valid @ModelAttribute("fooshope") Product p,BindingResult result){
		int categoryId=Integer.parseInt(request.getParameter("categoryId"));
		p.setCategoryId(categorydao.viewCategory(categoryId));
		p.setAvailable(0);
		if(productId!=0){
			p.setProductId(productId);
			productId=0;
		}
		System.out.println(p.getProductId());
		productdao.addProduct(p);
		utilitydao.uploadImage(p.getProductImage(), file.getOriginalFilename(), "product", p.getProductId());
        return "redirect:./";
	}
	
	@RequestMapping(value="/edit/{productId}")
	public ModelAndView editProduct(@PathVariable(value="productId") Integer productId){
		return new ModelAndView("AddProduct","command",productdao.getProduct(productId)).addObject("categories", categorydao.viewCategories());
	}
	
	@RequestMapping(value="/delete/{productId}")
	public String deleteProduct(@PathVariable(value="productId") Integer productId){
		productdao.deleteProduct(productId);
		return "redirect:./";
	}
	
	
	@RequestMapping(value="/Category")
	public ModelAndView addCategory(){
		return new ModelAndView("AddCategory","command",new Category());
	}
	
	@RequestMapping(value="/Category",method=RequestMethod.POST)
	public String addCategory(ModelMap model,@RequestParam("file") MultipartFile file, @Valid @ModelAttribute("foodshope") Category c,BindingResult result){
		categorydao.addCategory(c);
		utilitydao.uploadImage(c.getCategoryImage(), file.getOriginalFilename(), "category", c.getId());
        return "redirect:./";
	}
	
	@RequestMapping(value="/approveSeller")
	public ModelAndView viewUsers(){
		return new ModelAndView("viewUsers","users",userdao.viewUsers());
	}
	
	@RequestMapping(value="/updateRole/{roleId}")
	public String updateRole(@PathVariable(value="roleId") Integer roleId){
		userdao.updateRole(roleId);
		return "redirect:./approveSeller";
	}
	
}
