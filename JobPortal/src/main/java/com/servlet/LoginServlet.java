package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;  
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.DB.DBConnection;
import com.dao.UserDAO;
import com.entity.User;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet
{
	Log logger = LogFactory.getLog(getClass());

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		logger.info("doPost() of LoginServlet Begins......");
		
		try
		{
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			User user1 = new User();
			
			HttpSession session = req.getSession();
			
			if("admin@gmail.com".equals(email) && "121".equals(password))
			{
				session.setAttribute("userObj", user1);
				user1.setRole("admin");
				resp.sendRedirect("Admin.jsp");
			}
			else
			{
				UserDAO dao = new UserDAO(DBConnection.getConn());
				User user = dao.login(email, password);
				
				if(user != null) 
				{
					session.setAttribute("userObj", user);
					resp.sendRedirect("Home.jsp");
				}
				else
				{							
					session.setAttribute("succMsg", "Invalid Email or Password!!");
					resp.sendRedirect("Login.jsp");
				}	
			}
					
			
		}
		catch(Exception e)
		{
			logger.error("Error in LoginServlet ::: doPost() : " , e);
			e.printStackTrace();
		}
		
		logger.info("doPost() of LoginServlet Ends......");
	}
	
}
