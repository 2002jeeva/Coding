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
import com.hexaware.util.DbUtil;

public class CompanyDao {
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	public void addCompany(Company company) {
		try {
			con = DbUtil.getDBConn();
			ps = con.prepareStatement(
					"insert into company(company_id,company_name,location) values(?,?,?)");
			ps.setInt(1, company.getCompanyId());
			ps.setString(2, company.getCompanyName());
			ps.setString(3,company.getLocation());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted Successfully in DB");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List reteriveCompany(Company com) {
		List<Company> c=new ArrayList<>();
		try {
			con = DbUtil.getDBConn();
			ps = con.prepareStatement("Select * from company");
			rs = ps.executeQuery();
			while(rs.next()) {
				int companyId=rs.getInt(1);
				String companyName=rs.getString(2);
				String companyLocation=rs.getString(3);
				//System.out.println("CompanyId :"+" "+rs.getInt(1)+" "+"CompanyName :"+" "+rs.getString(2)+" "+"Location :"+" "+rs.getString(3));
			    Company company=new Company(companyId,companyName,companyLocation);
			    c.add(company);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
}
