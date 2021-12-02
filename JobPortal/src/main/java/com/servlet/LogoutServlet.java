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

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet
{
	Log logger = LogFactory.getLog(getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		logger.info("doGet() of LogoutServlet Begins......");
		
		try
		{
			HttpSession session = req.getSession();
//			session.getAttribute("userObj");
			session.removeAttribute("userObj");
			session.setAttribute("succMsg", "You have successfully logged out!!");
			
			resp.sendRedirect("Login.jsp");
		
		} 
		catch (Exception e) 
		{
			logger.error("Error in LogoutServlet ::: doGet() : " , e);
			e.printStackTrace();
		}
		
		logger.info("doGet() of LogoutServlet Ends......");logger.info("doGet() of LogoutServlet Ends......");
	}
	
}
