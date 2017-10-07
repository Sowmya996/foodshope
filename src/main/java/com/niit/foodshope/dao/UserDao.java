package com.niit.foodshope.dao;

import java.util.List;

import com.niit.foodshope.model.User;

public interface UserDao {
	public int addUser(User user);
	public User verifyUser(User user);
	public User loadUser(String mailId);
	public User getUser();
	public User getUser(int userId);
	public void updateUser(User user);
	public List<User> viewUsers();
	public void updateRole(int roleId);
	public String getRole();

}
