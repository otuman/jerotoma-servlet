package com.jerotoma.model;

import java.sql.Date;

public class User {
	private String username;
	private String fullName;
	private String userId;
	private boolean loggedIn;
	private String firstName;
	private String lastName;
	private String password;
	
	private Date createdOn;
	private Date updatedOn;
	
	public User() {
		
	}
	
	public String getUsername(){
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
   public String getFullName() {
	   return fullName;
   }
   public void setValidUser(boolean isLoggedIn) {
	   this.loggedIn = isLoggedIn;
   }
   public boolean isValidUser() {
	   return loggedIn;
   }
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}  
	
	
}
