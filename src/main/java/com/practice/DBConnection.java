package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {

	
	public Connection getConnection() {
		Connection connection = null;
		try{ 
			String dbPasswrd = "ORACLE";//prop.getProperty("db.datasource.password");
			String dbUserName ="COGNIFI";// prop.getProperty("db.datasource.username");
			String dbURL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";//prop.getProperty("db.datasource.url");
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			connection = DriverManager.getConnection(dbURL,dbUserName,dbPasswrd); 
			connection.setAutoCommit(false);
			
		}catch(Exception e){ 
			System.out.println("Error While getting db connections  "+e.getMessage());
			e.printStackTrace();
		} 
		
		return connection;
	}
	
	public void closeResources(Connection connection, Statement statement, ResultSet resultSet){
		try{
			if(connection != null){
				connection.close();
				System.out.println("Connection closed");
			}
				
			if(statement != null){
				statement.close();
				System.out.println("statement closed");
			}
			if(resultSet != null){
				resultSet.close();
				System.out.println("resultSet closed");
			}
			
		}catch(Exception e){
			System.out.println("Error while closing db resource : "+e.getMessage());
			e.printStackTrace();
		}
	}
}
