package com.niit.foodshope.dao;

import java.util.List;

import com.niit.foodshope.model.Category;
import com.niit.foodshope.model.Product;
import com.niit.foodshope.model.Supplier;
import com.niit.foodshope.model.User;

public interface ProductDao {
	public void addProduct(Product product);
	public Product getProduct(int productId);
	public void deleteProduct(int productId);
	public List<Product> viewProducts(Category category);
	public List<Product> viewProducts();
	public void addSupplier(Supplier supplier);
	public List<Product> viewProducts(User user);
	public Supplier getProduct(int supplierId,User user);
	public void updateSupplier(Supplier supplier);
	public void delete(Supplier supplier);
	public List<Product> showProducts();
	public List<Product> updateProductAvailablity();
	public List<Supplier> viewSuppliers(int productId);
   
}
