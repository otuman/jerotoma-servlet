package com.jerotoma.services;

import java.util.List;


import com.jerotoma.dao.implementation.UserDaoImpl;
import com.jerotoma.model.User;

public class UserService {
	
	
	private User user;
	private UserDaoImpl userDaoImpl;
	
	public UserService() {
		userDaoImpl = new UserDaoImpl();
	}
	
	public User authentication(String username, String password) {
		
		user  = userDaoImpl.getUser(username);
		System.out.println(user.getFirstName());
		
		if((username != null && username.trim() != "" && username.trim().equals(user.getUsername())) && 
		   (password != null && password.trim() != "" && password.trim().equals(user.getPassword()))) {
			
			user.setValidUser(true);
			user.setFullName(user.getFirstName()+" "+ user.getLastName());
						
			return user;
		}else {
			user.setValidUser(false);
		    return user;
		}	
			
		
	}
	
	public User save(User user) {
		
		return userDaoImpl.save(user);
	}
	public User update(User user) {
		
		return userDaoImpl.upadate(user);
	}
	
	public boolean delete(int id) {
		return userDaoImpl.delete(id);
	}
	public List<User> getUsers() {
		return userDaoImpl.getUsers();
	}
	
}
