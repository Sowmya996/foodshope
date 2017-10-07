package com.niit.foodshope.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.niit.foodshope.model.Cart;
import com.niit.foodshope.model.WishList;
import com.niit.foodshope.dao.CartDao;
import com.niit.foodshope.dao.ProductDao;
import com.niit.foodshope.dao.UserDao;
import com.niit.foodshope.model.CartGroup;
import com.niit.foodshope.model.CartItem;
import com.niit.foodshope.model.ListItem;
import com.niit.foodshope.model.WishGroup;



@RestController
@RequestMapping("/Cart")
public class CartController {
	
	@Autowired(required=true)
	private ProductDao productdao;
	
	@Autowired(required=true)
	private CartDao cartdao;
	
	@Autowired(required=true)
	private UserDao userdao;
	

	@RequestMapping(value="/")
	public ModelAndView Cart(){
		return new ModelAndView("viewCart","command",new CartItem()).addObject("cart",cartdao.getCart(userdao.getUser())).addObject("user",userdao);
	}
	
	@RequestMapping(value="/WishList")
	public ModelAndView WishList(){
		return new ModelAndView("viewCart","command",new CartItem()).addObject("wishes",cartdao.getWishList(userdao.getUser())).addObject("user",userdao);
	}
	
	@RequestMapping(value="/WishList/delete/{listItem}/{product}")
	public String deleteWish(@PathVariable(value="listItem") Integer listItemId,@PathVariable(value="product") Integer productId){
		cartdao.deleteWishListItem(listItemId,productId);
		return "redirect:/Cart/WishList";
	}
	
	@RequestMapping(value="/WishList/delete/{wishList}")
	public String deleteWishList(@PathVariable(value="wishList") Integer wishListId){
		cartdao.deleteWishList(wishListId);
		return "redirect:/Cart/WishList";
	}
	
	@RequestMapping(value={"/addToCart/{product}","/buyNow/{product}","addWish/{product}"})
	public String addToCart(HttpServletRequest request,@PathVariable(value="product") Integer productId){
		String redirect="redirect:/";
		
		try{
			userdao.getUser().getFirstName();
		}catch(Exception e){
			redirect="redirect:/login";
			return redirect;
		}

		if(request.getRequestURI().contains("addWish")){

			WishList wishList=new WishList();
			wishList.setUserId(userdao.getUser());
				try{
					wishList.setId(cartdao.getWishList(userdao.getUser()).getId());
				}catch(Exception e){cartdao.addWishList(wishList);}
				
				WishGroup wishGroup=new WishGroup(); 
				wishGroup.setProduct(productdao.getProduct(productId));
				wishGroup.setWishList(wishList);
				
				ListItem listItem = new ListItem();
				listItem.setWishGroup(wishGroup);
				
				try{wishList.getListItems().addAll(cartdao.getWishList(userdao.getUser()).getListItems());
				}catch(Exception e){}

				wishList.getListItems().add(listItem);

				cartdao.addWishListItem(listItem);
				cartdao.addWishList(wishList);
				
				return "redirect:"+request.getHeader("referer");
		}
		else{
			Cart cart=new Cart();
			try{
				cart.setCartId(cartdao.getCart(userdao.getUser()).getCartId());
			}catch(Exception e){}
				cart.setUserId(userdao.getUser());
			
			CartGroup cartGroup=new CartGroup();
			cartGroup.setProductId(productdao.getProduct(productId));
			cartGroup.setCartId(cart);
			
			CartItem cartItem=new CartItem();
			cartItem.setQuantity(1);
			cartItem.setTotatPrice(productdao.getProduct(productId).getPrice());
			cartItem.setCartGroupId(cartGroup);
			cartdao.addCartItem(cartItem);
			
			cart.getCartItems().addAll(cartdao.getCart(userdao.getUser()).getCartItems());
			cart.getCartItems().add(cartItem);
			cartdao.updateCart(cart);
			redirect="redirect:/Cart/";
			if(request.getRequestURI().contains("buyNow")){
				redirect="redirect:/User/shipTo?c="+cart.getCartId()+"&&p="+productId;
			}
		}
			
		return redirect;
	}
	
	@RequestMapping(value="/updateCart/{cart}/{product}")
	public String updateCart(HttpServletRequest requset ,@PathVariable(value="cart") Integer cartId,@PathVariable(value="product") Integer productId){
		CartItem cartItem=cartdao.getCart(productId, cartId).get(0);
		int q=Integer.parseInt(requset.getParameter("q"));
		cartItem.setQuantity(q);
		cartItem.setTotatPrice(cartItem.getCartGroupId().getProductId().getPrice()*q);
		cartdao.addCartItem(cartItem);
		return "redirect:/Cart/";
	}
	
	@RequestMapping(value="/delete/{cart}/{product}")
	public String deleteCartItem(@PathVariable(value="cart") Integer cartId,@PathVariable(value="product") Integer productId){
		cartdao.deleteCartItem(cartId, productId);
		return "redirect:/Cart/";
	}
	
	@RequestMapping(value="/delete/{cart}")
	public String deleteCart(@PathVariable(value="cart") Integer cartId){
		cartdao.deleteCart(cartId);
		return "redirect:/Cart/";
	}
	
	//Payment Options
	
	@RequestMapping(value="/payment")
	public ModelAndView PayCart(){
		return new ModelAndView("Payment");
	}
	
	@RequestMapping(value="/card")
	public ModelAndView PayCard(){
		return new ModelAndView("card");
	}
	
	@RequestMapping(value={ "/cod", "/net","/wallet" })
	public ModelAndView PayCod(HttpServletRequest request){
		String payment="",str=request.getRequestURL().toString();
		str=str.substring(str.lastIndexOf("/")+1);
		if(str.equals("wallet")){
			payment="E-Wallet";
		}
		else if(str.equals("net")){
			payment="Net Banking";
		}
		else{
			payment="Cash on Delivery";
		}
		return new ModelAndView("cod","payment",payment);
	}
		
	//CRUD on Order
	
	@RequestMapping(value="/createOrder")
	public ModelAndView createOrder(){
		return new ModelAndView("wallet");
	}
	
	@RequestMapping(value="/viewOrder")
	public ModelAndView viewOrder(){
		return new ModelAndView("viewOrders");
	}
	
	@RequestMapping(value = "/removeItem/{itemId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem (@PathVariable(value = "itemId") int itemId) {
    	System.out.println("product id:"+itemId);
    	
    }
}
