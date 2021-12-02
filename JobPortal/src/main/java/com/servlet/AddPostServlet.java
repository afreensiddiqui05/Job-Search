package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnection;
import com.dao.JobDAO;
import com.entity.Jobs;


import org.apache.log4j.Logger;  
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebServlet("/addJob")
public class AddPostServlet extends HttpServlet
{
	Log logger = LogFactory.getLog(getClass());
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{		
		logger.info("doPost() of AddPostServlet Begins......");
		
		try 
		{
			String title = req.getParameter("title");
			String location =  req.getParameter("location");
			String category =  req.getParameter("category");
			String status =  req.getParameter("status");
			String description =  req.getParameter("description");
			
			Jobs j = new Jobs();
			j.setTitle(title);
			j.setLocation(location);
			j.setCategory(category);
			j.setStatus(status);
			j.setDescription(description);
			
			HttpSession session = req.getSession();
			
			JobDAO dao = new JobDAO(DBConnection.getConn());
			boolean flag = dao.addJobs(j);
			
			if(flag)
			{
				session.setAttribute("succMsg", "Job Posted Successfully!!");
				resp.sendRedirect("AddJob.jsp");
			}
			else
			{
				session.setAttribute("succMsg", "Sorry, something went wrong :(");
				resp.sendRedirect("AddJob.jsp");
			}
		} 
		catch (Exception e)
		{		
			logger.error("Error in AddPostServlet ::: doPost() : " , e);
			e.printStackTrace();
		}
		
		logger.info("doPost() of AddPostServlet Ends......");
	}

	
}
