package com.jerotoma.controllers.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.jerotoma.helpers.AppConfig;

public class Database {
	
	private static Database database;
	private Connection connection;
	
	public Database() {
			
	}
	public static Database getInsatnce() {
		if(database == null) {
			database = new Database();
		}		
		return database;		
	} 	
	public Connection getConnection() {
		try {
			Class.forName(AppConfig.DRIVER);
			if(connection== null) 
			   connection = DriverManager.getConnection(AppConfig.DBURL, AppConfig.DBUSERNAME,	AppConfig.DBPASSWORD);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DB Closed");
		}
		return connection;
	}
	public void haltConnection(PreparedStatement preparedStatement, ResultSet resultSet) {
		
	        try {
                if (resultSet != null){
                	resultSet.close();                	
	            }	            	
            	if (preparedStatement != null) {
            		preparedStatement.close();            		
	   	         }	
            	           	
	            	
	         } catch(SQLException e){
				//TODO Auto-generated catch block
				e.printStackTrace();
				
				System.out.println("DB Closed 2");
			}	       
	}
	

}
