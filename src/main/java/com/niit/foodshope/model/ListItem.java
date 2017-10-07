package com.niit.foodshope.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
 

@Entity
public class ListItem {
	
	@EmbeddedId
	WishGroup wishGroup;

	public WishGroup getWishGroup() {
		return wishGroup;
	}

	public void setWishGroup(WishGroup wishGroup) {
		this.wishGroup = wishGroup;
	}
	
	
}
