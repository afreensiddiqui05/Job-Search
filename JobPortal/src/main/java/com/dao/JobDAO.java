package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;  
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.entity.Jobs;

public class JobDAO 
{
	private Connection conn;
//	Logger logger = Logger.getLogger(JobDAO.class.getName()); 
	
	Log logger = LogFactory.getLog(getClass());

	public JobDAO(Connection conn)
	{
		super();
		this.conn = conn;
	}
	
	public boolean addJobs(Jobs j)
	{
		logger.info("addJobs of JobDAO Begins......");
		boolean flag = false;
			
		try 
		{
			String sql = "INSERT INTO JOBS(TITLE, DESCRIPTION, CATEGORY, STATUS, LOCATION) VALUES (?,?,?,?,?)" ;
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, j.getTitle());
			ps.setString(2, j.getDescription());
			ps.setString(3, j.getCategory());
			ps.setString(4, j.getStatus());
			ps.setString(5, j.getLocation());
			
			int i = ps.executeUpdate();
			
			if(i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e) 
		{
			logger.error("Error in JobDAO ::: addJobs : ", e);
			e.printStackTrace();
		}
		
		logger.info("addJobs of JobDAO Ends......");
		return flag;
	}
	
	public List<Jobs> getAllJobs()
	{
		logger.info("getAllJobs of JobDAO Begins......");
		List<Jobs> list = new ArrayList<Jobs>();
		Jobs j = null;
		
		try 
		{
			String sql = "SELECT * FROM JOBS ORDER BY ID DESC";
			
			SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				j = new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPublishDate(sdf.format(rs.getTimestamp(7))+"");
				list.add(j);
			}
			
		} 
		catch (Exception e)
		{	
			logger.error("Error in JobDAO ::: getAllJobs : " , e);
			e.printStackTrace();
		}
		
		logger.info("getAllJobs of JobDAO Ends......");
		return list;
		
	}
	
	public Jobs getJobByID(int id)
	{	
		logger.info("getJobByID of JobDAO Begins......");
		Jobs j = null;
		
		try 
		{
			String sql = "SELECT * FROM JOBS WHERE ID = ?";
			
			SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy"); 
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				j = new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPublishDate(sdf.format(rs.getTimestamp(7))+"");
			}
			
		} 
		catch (Exception e)
		{		
			logger.error("Error in JobDAO ::: getJobByID : " , e);
			e.printStackTrace();
		}
		
		logger.info("getJobByID of JobDAO Ends......");
		return j;
		
	}
	
	public boolean updateJob(Jobs j)
	{
		logger.info("updateJob of JobDAO Begins......");
		boolean flag = false;
		
		try 
		{
			String sql = "UPDATE JOBS SET TITLE = ? , DESCRIPTION =? , CATEGORY =?, STATUS =?, LOCATION =? WHERE ID =?"; 
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, j.getTitle());
			ps.setString(2, j.getDescription());
			ps.setString(3, j.getCategory());
			ps.setString(4, j.getStatus());
			ps.setString(5, j.getLocation());
			ps.setInt(6, j.getId());
			
			int i = ps.executeUpdate();
			
			if(i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e) 
		{
			logger.error("Error in JobDAO ::: updateJob : " , e);
			e.printStackTrace();
		}
		
		logger.info("updateJob of JobDAO Ends......");
		return flag;
		
	}
	
	public boolean deleteJob(int id)
	{
		logger.info("deleteJob of JobDAO Begins......");
		boolean flag = false;
	
		try 
		{
			String sql ="DELETE FROM JOBS WHERE ID = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			
			if(i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e)
		{
			logger.error("Error in JobDAO ::: deleteJob : " , e);
			e.printStackTrace();
		}
		
		logger.info("deleteJob of JobDAO Ends......");
		return flag;
			
	}
	
	public List<Jobs> getAllJobsForUser()
	{
		logger.info("getAllJobsForUser of JobDAO Begins......");
		List<Jobs> list = new ArrayList<Jobs>();
		Jobs j = null;
		
		try 
		{
			String sql = "SELECT * FROM JOBS WHERE STATUS = ? ORDER BY ID DESC";
			
			SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "Active");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				j = new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPublishDate(sdf.format(rs.getTimestamp(7))+"");
				list.add(j);
			}
			
		} 
		catch (Exception e)
		{		
			logger.error("Error in JobDAO ::: getAllJobsForUser : " , e);
			e.printStackTrace();
		}
		
		logger.info("getAllJobsForUser of JobDAO Ends......");
		return list;
		
	}
	
	public Jobs getJobById(int id) 
	{
		logger.info("getJobById of JobDAO Begins......");
		Jobs j =null;
		
		try 
		{
			String sql = "SELECT * FROM JOBS WHERE ID = ?";
			SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				j = new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPublishDate(sdf.format(rs.getTimestamp(7))+"");
			}
		} 
		catch (Exception e) 
		{
			logger.error("Error in JobDAO ::: getJobById : " , e);
			e.printStackTrace();
		}
		
		logger.info("getJobById of JobDAO Ends......");
		return j;
	}
	
	public List<Jobs> getJobsBasedOnLocOrCat(String location, String category) 
	{
		logger.info("getJobsBasedOnLocOrCat of JobDAO Begins......");
		List<Jobs> list = new ArrayList<Jobs>();
		Jobs j =null;
		
		try 
		{
			String sql = "SELECT * FROM JOBS WHERE LOCATION = ? OR CATEGORY = ? ORDER BY ID DESC";
			SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, location);
			pstmt.setString(2, category);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				j = new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPublishDate(sdf.format(rs.getTimestamp(7))+"");
				list.add(j);
				
			}
		} 
		catch (Exception e) 
		{
			logger.error("Error in JobDAO ::: getJobsBasedOnLocOrCat : " , e);
			e.printStackTrace();
		}
		
		logger.info("getJobsBasedOnLocOrCat of JobDAO Ends......");
		return list;
	}

	public List<Jobs> getJobsBasedOnLocAndCat(String loc, String cat) 
	{
		logger.info("getJobsBasedOnLocAndCat of JobDAO Begins......");
		List<Jobs> list = new ArrayList<Jobs>();
		Jobs j =null;
		
		try 
		{
			String sql = "SELECT * FROM JOBS WHERE LOCATION = ? AND CATEGORY = ? ORDER BY ID DESC";
			SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loc);
			pstmt.setString(2, cat);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				j = new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPublishDate(sdf.format(rs.getTimestamp(7))+"");
				list.add(j);
				
			}
		} 
		catch (Exception e) 
		{
			logger.error("Error in JobDAO ::: getJobsBasedOnLocAndCat : " , e);
			e.printStackTrace();
		}
		
		logger.info("getJobsBasedOnLocAndCat of JobDAO Ends......");
		return list;
	}

	
}
