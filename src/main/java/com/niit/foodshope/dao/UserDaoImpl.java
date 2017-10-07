package com.niit.foodshope.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.niit.foodshope.model.User;
import com.niit.foodshope.model.UserRole;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private SessionFactory factory;
	private User user;
	
	
	@Transactional
	public int addUser(User u) {
		System.out.println(isNewUser(u));
		if(!isNewUser(u)){
			Session session=factory.getCurrentSession();
			Transaction tx=session.beginTransaction();
		tx.begin();	
		session.saveOrUpdate(u);
		UserRole userRole=new UserRole();
		userRole.setRoleId(u);
		userRole.setRoleName("ROLE_USER");
		session.saveOrUpdate(userRole);
		tx.commit();
		return 1;
		}
		return 0;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public User verifyUser(User u) {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(User.class);
		cr.add(Restrictions.eq("mailId",u.getMailId()));
		cr.add(Restrictions.eq("password",u.getPassword()));
		user=(User)cr.uniqueResult();
		tx.commit();
		return user;
	}
	
	public User getUser() {
		return user;
	}
	
	@Transactional
	public User getUser(int userId) {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria ct=session.createCriteria(User.class);
		ct.add(Restrictions.eq("id",userId));
		User u=(User)ct.uniqueResult();
		return u;
	}

	@Transactional
	public void updateUser(User user) {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
	}

	@Transactional
	public List<User> viewUsers() {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(UserRole.class);
		cr.addOrder(Order.asc("roleId"));
		Criteria usCr = cr.createCriteria("roleId");
		List<User> users=usCr.list();
		tx.commit();
		return users;
	}

	@Transactional
	public boolean isNewUser(User user) {
		boolean newUser=false;
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(User.class);
		cr.add(Restrictions.eq("mailId",user.getMailId()));
		List<User> users=cr.list();
		System.out.println("Size "+users.size());
		if(users.size()>0)
		{
			newUser=true;
		}
		tx.commit();
		return newUser;
	}

	@Transactional
	public void updateRole(int roleId) {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(User.class);
		cr.add(Restrictions.eq("id",roleId));
		Criteria rcr=session.createCriteria(UserRole.class);
		rcr.add(Restrictions.eq("roleId",(User)cr.uniqueResult()));
		UserRole ur=(UserRole)rcr.uniqueResult();
		System.out.println(ur.getRoleId().getId());
		ur.setRoleName("ROLE_SELLER");
		session.update(ur);
		tx.commit();
	}
	
	@Transactional
	public String getRole() {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(UserRole.class);
		cr.add(Restrictions.eq("roleId",getUser()));
		UserRole ur=(UserRole)cr.uniqueResult();
		tx.commit();
		return ur.getRoleName();
	}

	@Transactional
	public User loadUser(String mailId) {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(User.class);
		cr.add(Restrictions.eq("mailId",mailId));
		user=(User)cr.uniqueResult();
		tx.commit();
		return user;
	}

}
