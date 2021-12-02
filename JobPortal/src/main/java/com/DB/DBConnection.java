package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
	private static Connection conn;

	public static Connection getConn() throws SQLException
	{
		try 
		{
			if (conn == null)
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BATMAN", "admin");
			}
			else
			{
				System.out.println("Connected");
			}
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}

		return conn;
	}

}
