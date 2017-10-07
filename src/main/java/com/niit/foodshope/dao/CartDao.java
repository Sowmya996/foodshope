package com.niit.foodshope.dao;

import java.util.List;


import com.niit.foodshope.model.Cart;
import com.niit.foodshope.model.CartItem;
import com.niit.foodshope.model.ListItem;
import com.niit.foodshope.model.User;
import com.niit.foodshope.model.UserOrder;
import com.niit.foodshope.model.WishList;


public interface CartDao {
	public void addCartItem(CartItem cartItem);
	public void deleteCartItem(int cartId,int productId);
	public void deleteCart(int cartId);
	public Cart getCart(User user);
	public void updateCart(Cart cart);
	
	public void addWishListItem(ListItem listItem);
	public void addWishList(WishList wishList);
	public WishList getWishList(User user);
	public void deleteWishList(int wishListId);
	public void deleteWishListItem(int wishListId,int productId);
	
	public UserOrder addOrder(UserOrder order);
	
	public List<CartItem> viewCart(User user);
	public List<CartItem> getCart(int productId,int cartId);

}
