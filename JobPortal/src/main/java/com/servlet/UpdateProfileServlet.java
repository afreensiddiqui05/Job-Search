package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.DB.DBConnection;
import com.dao.JobDAO;
import com.dao.UserDAO;
import com.entity.Jobs;
import com.entity.User;

@WebServlet("/Update_Profile")
public class UpdateProfileServlet extends HttpServlet 
{
	Log logger = LogFactory.getLog(getClass());
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		logger.info("doPost() of UpdateProfileServlet Begins......");
		
		try 
		{
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String qualification = req.getParameter("qualification");
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			UserDAO dao = new UserDAO(DBConnection.getConn());

			User u = new User();
			u.setId(id);
			u.setName(name);
			u.setQualification(qualification);
			u.setPassword(password);
			u.setEmail(email);
			
			boolean flag = dao.updateUser(u);
			
			HttpSession session = req.getSession();

			if (flag) 
			{
				session.setAttribute("succMsg", "Profile Updated Successfully!!");
				resp.sendRedirect("Home.jsp");
			} 
			else 
			{
				session.setAttribute("succMsg", "Sorry, something went wrong :(");
				resp.sendRedirect("Home.jsp");
			}
		} 
		catch (Exception e) 
		{
			logger.error("Error in UpdateProfileServlet ::: doPost() : " , e);
			e.printStackTrace();
		}
		
		logger.info("doPost() of UpdateProfileServlet Ends......");
	}

}
