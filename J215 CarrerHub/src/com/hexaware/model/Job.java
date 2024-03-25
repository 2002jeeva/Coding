package com.hexaware.model;

import java.time.LocalDate;

public class Job {
      private int jobId;
      private int companyId;
      private String jobTitle;
      private String jobDescription;
      private String jobLoaction;
      private double salary;
      private String JobType;
      private LocalDate postedDate;
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Job(int jobId, int companyId, String jobTitle, String jobDescription, String jobLoaction, double salary,
			String jobType, LocalDate postedDate) {
		super();
		this.jobId = jobId;
		this.companyId = companyId;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.jobLoaction = jobLoaction;
		this.salary = salary;
		JobType = jobType;
		this.postedDate = postedDate;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getJobLoaction() {
		return jobLoaction;
	}
	public void setJobLoaction(String jobLoaction) {
		this.jobLoaction = jobLoaction;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getJobType() {
		return JobType;
	}
	public void setJobType(String jobType) {
		JobType = jobType;
	}
	public LocalDate getPostedDate() {
		return postedDate;
	}
	
	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}
	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", companyId=" + companyId + ", jobTitle=" + jobTitle + ", jobDescription="
				+ jobDescription + ", jobLoaction=" + jobLoaction + ", salary=" + salary + ", JobType=" + JobType
				+ ", postedDate=" + postedDate + "]";
	}
      
}
