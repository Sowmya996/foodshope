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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.niit.foodshope.dao.CartDao;
import com.niit.foodshope.dao.CategoryDao;
import com.niit.foodshope.dao.ProductDao;
import com.niit.foodshope.dao.UserDao;
import com.niit.foodshope.model.Supplier;

@RestController
@RequestMapping(value="/Supplier")
public class SupplierController {
	@Autowired
	ProductDao productdao;
	@Autowired
	CategoryDao categorydao;
	@Autowired
	UserDao userdao;
	@Autowired
	CartDao cartdao;
	
	private Supplier s;
	
	@RequestMapping(value="/")
	public ModelAndView sell(){
		Authentication a = SecurityContextHolder.getContext().getAuthentication();
		User currentUser = (User)a.getPrincipal();
		userdao.loadUser(currentUser.getUsername());
		ModelAndView mv=new ModelAndView("management","command",new Supplier());
		mv.addObject("categories",categorydao.viewCategories());
		mv.addObject("products", productdao.viewProducts());
		mv.addObject("cart",cartdao);
		mv.addObject("sproducts",productdao.viewProducts(userdao.getUser()));
		mv.addObject("supplier",s);
		mv.addObject("user",userdao);
		return mv;
	}
	
	@RequestMapping(value="/edit/{productId}")
	public String edit(@PathVariable(value="productId") Integer productId){
		s=productdao.getProduct(productId,userdao.getUser());
		return "redirect:./";
	}
	
	@RequestMapping(value="/update")
	public String update(HttpServletRequest request){
		s.setQuantity(Integer.parseInt(request.getParameter("q")));
		productdao.updateSupplier(s);
		s=null;
		return "redirect:./";
	}
	
	@RequestMapping(value="/delete/{productId}")
	public String delete(@PathVariable(value="productId") Integer productId){
		s=productdao.getProduct(productId,userdao.getUser());
		productdao.delete(s);s=null;
		return "redirect:./";
	}
	
	@RequestMapping(value="/addSupplierProduct")
	public String addSupplierProduct(HttpServletRequest request,ModelMap model,@Valid @ModelAttribute("foodshope") Supplier s,BindingResult result){
		int pid=Integer.parseInt(request.getParameter("productId"));
		s.setProduct(productdao.getProduct(pid));
		s.setUserId(userdao.getUser());
		productdao.addSupplier(s);
		productdao.updateProductAvailablity();
		return "redirect:./";
	}

}
