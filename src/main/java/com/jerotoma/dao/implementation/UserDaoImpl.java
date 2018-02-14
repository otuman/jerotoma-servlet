package com.jerotoma.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jerotoma.controllers.dbconfig.Database;
import com.jerotoma.dao.UserDao;
import com.jerotoma.model.User;

public class UserDaoImpl implements UserDao {
 
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	public UserDaoImpl() {
		
	}
	

	public List<User> getUsers() {
		// TODO Auto-generated method stub
	    List<User> users  = new ArrayList<User>();
	    String query = "SELECT * FROM users";
	   // database = Database.getInsatnce();	
		
	    try {
	    	preparedStatement = getConnection().prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				User user = new User();
				user.setFirstName(resultSet.getString("first_name"));
				user.setLastName(resultSet.getString("last_name"));
				user.setPassword(resultSet.getString("password"));
				user.setUserId(resultSet.getString("id"));
				user.setUsername(resultSet.getString("username"));
				user.setCreatedOn(resultSet.getDate("created_on"));
				user.setUpdatedOn(resultSet.getDate("updated_on"));
				
				user.setFullName(user.getFirstName() +" "+user.getLastName());
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			getDatabase().haltConnection(preparedStatement,resultSet);			
		}
	    
		
		return users;
	}

	public Database getDatabase() {
		return Database.getInsatnce();
	}

	public Connection getConnection() {
		return getDatabase().getConnection();
	}

	
	public User getUser(int id) {
		// TODO Auto-generated method stub
	    
				String query = "SELECT * FROM users WHERE id=?";
				User user = new User();	
			    try {
										
					preparedStatement = getConnection().prepareStatement(query);
					preparedStatement.setInt(1, id);
					resultSet = preparedStatement.executeQuery();
					
					if(resultSet.next()) {						
						user.setFirstName(resultSet.getString("first_name"));
						user.setLastName(resultSet.getString("last_name"));
						user.setPassword(resultSet.getString("password"));
						user.setUserId(resultSet.getString("id"));
						user.setUsername(resultSet.getString("username"));
						user.setCreatedOn(resultSet.getDate("created_on"));
						user.setUpdatedOn(resultSet.getDate("updated_on"));					
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					getDatabase().haltConnection(preparedStatement,resultSet);					
				}
				return user;
	}

	
	public User upadate(User user) {
		// TODO Auto-generated method stub
		 String query = "UPDATE users SET first_name =?, last_name=?,password=?, updated_on=? WHERE id =?";
		 Database.getInsatnce();
			// create the sql insert prepared statement
		 try { 
			 
			  preparedStatement = getConnection().prepareStatement(query);
			  preparedStatement.setString (2, user.getFirstName());
			  preparedStatement.setString (3, user.getLastName());
			  preparedStatement.setString (5, user.getPassword());
			  preparedStatement.setDate(7, user.getUpdatedOn());
		      
		      // execute the preparedstatement
			  preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}finally {
			getDatabase().haltConnection(preparedStatement,resultSet);			
		}
		return null;
	}

	
	public User save(User user) {
		// TODO Auto-generated method stub
		
		String query = "INSERT INTO users (first_name, last_name, username,password,created_on, updated_on) VALUES (?,?,?,?,?,?)";
		int user_id = 0;
	  	// create the sql insert prepared statement
	     
	      try {
	    	  preparedStatement = getConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	    	  preparedStatement.setString (1, user.getFirstName());
	    	  preparedStatement.setString (2, user.getLastName());
	    	  preparedStatement.setString (3, user.getUsername());
	    	  preparedStatement.setString (4, user.getPassword());
	    	  preparedStatement.setDate(5, user.getCreatedOn());
	    	  preparedStatement.setDate(6, user.getUpdatedOn());		      
		     
	    	  //execute the prepared statement
	    	  preparedStatement.executeUpdate();
	    	  ResultSet rs = preparedStatement.getGeneratedKeys();
	    	  
	    	  
		      if(rs.next()){
		    	  user_id = rs.getInt("id");
		    	  System.out.println(user_id);
		      }
		      
		} catch (SQLException e) {
			
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}finally {
				getDatabase().haltConnection(preparedStatement,resultSet);				
		}
	    if(user_id > 0)
		  return getUser(user_id);
	    
	    else
	      return null;
	}

	public boolean delete(int id) {
		
	    
		String query = "SELECT * FROM users WHERE id=?";
		Database.getInsatnce();
		try {
			preparedStatement = getConnection().prepareStatement(query);
			preparedStatement.setInt(1, id);
			// execute delete SQL stetement
		    preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}finally {
			getDatabase().haltConnection(preparedStatement,resultSet);			
		}
		return true;
	}

	
	public User getUser(String username) {
		// TODO Auto-generated method stub
	    
		String query = "SELECT * FROM users WHERE username=?";
		User user = new User();				
		//Statement preparedStatement;
		try {
			preparedStatement = getConnection().prepareStatement(query);
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			//System.out.println("Nimefika");
			if(rs.next()){						
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setPassword(rs.getString("password"));
				user.setUserId(rs.getString("id"));
				user.setUsername(rs.getString("username"));
				user.setCreatedOn(rs.getDate("created_on"));
				user.setUpdatedOn(rs.getDate("updated_on"));					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}finally {
			getDatabase().haltConnection(preparedStatement,resultSet);			
		}
		return user;
	}

}
