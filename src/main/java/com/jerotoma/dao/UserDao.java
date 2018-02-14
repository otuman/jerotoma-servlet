package com.jerotoma.dao;

import java.util.List;

import com.jerotoma.model.User;

public interface UserDao {
	
	public List<User> getUsers();
	public User getUser(int id);
	public User getUser(String username);
	public User upadate(User user);
	public User save(User user);
	public boolean delete(int id);
	
}
