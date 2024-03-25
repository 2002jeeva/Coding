package com.hexaware.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.model.JobApplication;
import com.hexaware.util.DbUtil;

public class JobApplicantDao {
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;

	public void addJobApplicant(JobApplication jobApplication) {
		try {
			con = DbUtil.getDBConn();
			ps = con.prepareStatement(
					"insert into jobapplicant(Appliacation_id,job_id,applicant_id,application_date,cover_letter) values(?,?,?,?,?)");
		    ps.setInt(1, jobApplication.getApplicationId());
		    ps.setInt(2, jobApplication.getJobId());
		    ps.setInt(3, jobApplication.getApplicantId());
		    ps.setDate(4, Date.valueOf(jobApplication.getApplicationDate()));
		    ps.setString(5,jobApplication.getCoverLetter());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted Successfully in DB");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void reteriveJobApplicant(JobApplication jobApplication) {
		try {
			con = DbUtil.getDBConn();
			ps = con.prepareStatement("Select * from jobapplicant");
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("ApplicationId :"+" "+rs.getInt(1)+" "+"JobId :"+" "+rs.getInt(2)+" "+"ApplicantId :"+" "+rs.getInt(3)+" "+"ApplicationDate :"+" "+rs.getDate(4)
				+" "+"CoverLetter :"+" "+rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
