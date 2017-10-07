package com.niit.foodshope.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.niit.foodshope.model.Category;
import com.niit.foodshope.model.Product;
import com.niit.foodshope.model.Supplier;
import com.niit.foodshope.model.User;

@Repository
@Service("productDao")
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private SessionFactory factory;

	@Transactional(propagation=Propagation.SUPPORTS)
	public void addProduct(Product product) {
		Session session=factory.getCurrentSession();
	    Transaction tx=session.beginTransaction();
	    tx.begin();
	    session.saveOrUpdate(product);
	    tx.commit();
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public Product getProduct(int productId) {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(Product.class);
		cr.add(Restrictions.eq("id",productId));
		Product product=(Product)cr.uniqueResult();
		tx.commit();
		return product;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public void deleteProduct(int productId) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(getProduct(productId));
		tx.commit();
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Product> viewProducts(Category category) {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(Product.class);
		cr.add(Restrictions.eq("categoryId",category));
		List<Product> products =cr.list();
		tx.commit();
		return products;
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	public void addSupplier(Supplier supplier) {
		Session session=factory.getCurrentSession();
	    Transaction tx=session.beginTransaction();
	    tx.begin();
	    session.saveOrUpdate(supplier);
	    tx.commit();
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void updateSupplier(Supplier supplier){
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(supplier);
		tx.commit();
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void delete(Supplier supplier){
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(supplier);
		tx.commit();
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Product> viewProducts(User user){
		Session session=factory.getCurrentSession();
	    Transaction tx=session.beginTransaction();
	    tx.begin();
	    Criteria cr=session.createCriteria(Supplier.class);
	    cr.add(Restrictions.eq("userId",user));
	    List<Product> products = cr.list();
	    tx.commit();
	    return products;
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public Supplier getProduct(int supplierId,User user){
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(Supplier.class);
		cr.add(Restrictions.eq("id",supplierId));
		cr.add(Restrictions.eq("userId",user));
		Supplier supplier=(Supplier)cr.uniqueResult();
		tx.commit();
	    return supplier;
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Product> updateProductAvailablity(){
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Criteria pcr=session.createCriteria(Product.class);
		List<Product> p=pcr.list();
		for(Product pd:p){
		Criteria cr=session.createCriteria(Supplier.class);
		cr.setProjection(Projections.sum("quantity"));
		cr.add(Restrictions.eq("product",pd));
		List result=cr.list();
		try{
		Number number = (Number) result.get(0);
		pd.setAvailable(number.intValue());
		session.saveOrUpdate(pd);
		System.out.println(number.intValue());}
		catch(Exception e){
			pd.setAvailable(0);
			session.saveOrUpdate(pd);
		}
		}
		tx.commit();
		return p;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Supplier> viewSuppliers(int productId) {
		updateProductAvailablity();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(Supplier.class);
		cr.add(Restrictions.eq("product", getProduct(productId)));
		List<Supplier> s=cr.list();
		tx.commit();
		return s;
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Product> viewProducts() {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(Product.class);
		List<Product> products =cr.list();
		tx.commit();
		return products;
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Product> showProducts() {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(Product.class).setProjection(Projections.property("name"));
		List<Product> products = cr.list();
		tx.commit();
		return products;
	}


}
