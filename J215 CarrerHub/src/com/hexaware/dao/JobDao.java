package com.hexaware.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.model.Company;
import com.hexaware.model.Job;
import com.hexaware.util.DbUtil;

public class JobDao {
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;

	public void addJob(Job job) {
		try {
			con = DbUtil.getDBConn();
			ps = con.prepareStatement(
					"insert into job(job_id,company_id,job_title,job_description,job_location,salary,job_type,poseted_date) values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, job.getJobId());
			ps.setInt(2, job.getCompanyId());
			ps.setString(3, job.getJobTitle());
			ps.setString(4, job.getJobDescription());
			ps.setString(5, job.getJobLoaction());
			ps.setDouble(6, job.getSalary());
			ps.setString(7, job.getJobType());
			ps.setDate(8, Date.valueOf(job.getPostedDate()));
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted Successfully in DB");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void reteriveJob(Job j) {
		List<Job> J=new ArrayList<>();
		try {
			con = DbUtil.getDBConn();
			ps = con.prepareStatement("Select * from job");
			rs = ps.executeQuery();
			while(rs.next()) {
				int jobId =rs.getInt(1);
				int companyId= rs.getInt(2);
				String jobTitle=rs.getString(3);
				String jobDescription=rs.getString(4);
				String jobLocation=rs.getString(5);
				Double salary=rs.getDouble(6);
				String jobType=rs.getString(7);
				Date postedDate=rs.getDate(8);
				System.out.println("JobId :"+" "+rs.getInt(1)+" "+"CompanyId :"+" "+rs.getInt(2)+" "+"JobTitle :"+" "+rs.getString(3)+" "+"JobDescription :"+" "+rs.getString(4)
				+" "+"JobLocation :"+" "+rs.getString(5)+" "+"Salary:"+" "+rs.getDouble(6)+" "+"JobType:"+" "+rs.getString(7)+" "+"PostedDate :"+" "+rs.getDate(8));
//			   Job job=new Job(jobId,companyId,jobTitle, jobDescription,jobLocation,salary,jobType,postedDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		return j;
	}
}
