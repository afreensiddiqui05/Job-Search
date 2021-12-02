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


@WebServlet("/delete")
public class DeleteJobServlet extends HttpServlet
{
	Log logger = LogFactory.getLog(getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		logger.info("doGet() of DeleteJobServlet Begins......");
		
		try 
		{
			int id = Integer.parseInt(req.getParameter("id"));
			
			HttpSession session = req.getSession();

			JobDAO dao = new JobDAO(DBConnection.getConn());			
			boolean flag = dao.deleteJob(id);			

			if (flag) 
			{
				session.setAttribute("succMsg", "Job Deleted Successfully!!");
				resp.sendRedirect("ViewJobs.jsp");
			} 
			else 
			{
				session.setAttribute("succMsg", "Sorry, something went wrong :(");
				resp.sendRedirect("ViewJobs.jsp");
			}
		} 
		catch (Exception e) 
		{
			logger.error("Error in DeleteJobServlet ::: doGet() : " , e);
			e.printStackTrace();
		}
		
		logger.info("doGet() of DeleteJobServlet Ends......");
	}
	
}
