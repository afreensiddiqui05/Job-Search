package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

import org.apache.log4j.Logger;  
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UserDAO
{
	private Connection conn;
	Log logger = LogFactory.getLog(getClass());

	public UserDAO(Connection conn) 
	{
		super();
		this.conn = conn;
	}
	
	public boolean addUser(User u)
	{
		logger.info("addUser of UserDAO Begins......");
		boolean flag = false;
		
		try 
		{
			String sql = "INSERT INTO USERS(NAME, QUALIFICATION, EMAIL, PASSWORD, ROLE) VALUES (?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getQualification());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setString(5, "User");
			
			int i = ps.executeUpdate();			
			if(i == 1)
			{
				flag = true;
			}
			
		} 
		catch (Exception e) 
		{
			logger.error("Error in UserDAO ::: addUser : " , e);
			e.printStackTrace();
		}
		
		logger.info("addUser of UserDAO Ends......");
		return flag;
	}
	
	public User login(String email, String password)
	{
		logger.info("login of UserDAO Begins......");
		User u = null;
		
		try 
		{
			String sql = "SELECT * FROM USERS WHERE EMAIL = ? AND PASSWORD = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setQualification(rs.getString(5));
				u.setRole(rs.getString(6));		
			}

		} 
		catch (Exception e) 
		{
			logger.error("Error in UserDAO ::: login : " , e);
			e.printStackTrace();
		}
		
		logger.info("login of UserDAO Ends......");
		return u;
	}
	
	public boolean updateUser(User u)
	{
		logger.info("updateUser of UserDAO Begins......");
		boolean flag = false;
		
		try 
		{
			String sql = "UPDATE USERS SET NAME =?, QUALIFICATION = ?, EMAIL = ?, PASSWORD = ? WHERE ID = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getQualification());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setInt(5, u.getId());
			
			int i = ps.executeUpdate();			
			
			if(i == 1)
			{
				flag = true;
			}
			
		} 
		catch (Exception e) 
		{
			logger.error("Error in UserDAO ::: updateUser : " , e);
			e.printStackTrace();
		}
		
		logger.info("updateUser of UserDAO Ends......");
		return flag;
	}

}
