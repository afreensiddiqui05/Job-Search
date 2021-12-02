package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.DB.DBConnection;
import com.dao.UserDAO;
import com.entity.User;

@WebServlet("/addUser")
public class RegisterServlet extends HttpServlet
{
	Log logger = LogFactory.getLog(getClass());
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		logger.info("doPost() of RegisterServlet Begins......");
		
		try 
		{
			String name = req.getParameter("name");
			String qualification = req.getParameter("qualification");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			UserDAO dao = new UserDAO(DBConnection.getConn());
			
			User u = new User(name, email, password, qualification, "User");			
			
			HttpSession session = req.getSession();
			boolean flag = dao.addUser(u);		

			if (flag) 
			{
				session.setAttribute("succMsg", "Registration Completed Successfully!!");
				resp.sendRedirect("SignUp.jsp");
			} 
			else 
			{
				session.setAttribute("succMsg", "Sorry, something went wrong :(");
				resp.sendRedirect("SignUp.jsp");
			}
		} 
		catch (SQLException e)
		{
			logger.error("Error in RegisterServlet ::: doPost() : " , e);
			e.printStackTrace();
		}
		
		logger.info("doPost() of RegisterServlet Ends......");
	}

}
