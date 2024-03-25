package com.hexaware.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.ApplicantDao;
import com.hexaware.dao.CompanyDao;
import com.hexaware.dao.JobApplicantDao;
import com.hexaware.dao.JobDao;
import com.hexaware.model.Applicant;
import com.hexaware.model.Company;
import com.hexaware.model.Job;
import com.hexaware.model.JobApplication;

public class JobController implements JobInterface {
	Job job;
    Company company;
    Applicant applicant;
    JobApplication jobApplication;
    List<Job> jobList=new ArrayList<>();
    List<Company> companyList=new ArrayList<>();
    List<Applicant> applicantList=new ArrayList<>();
    List<JobApplication> jobApplicationList=new ArrayList<>();
    JobDao jDao=new JobDao();
    CompanyDao cDao=new CompanyDao();
    ApplicantDao aDao=new ApplicantDao();
    JobApplicantDao jaDao=new JobApplicantDao();
    Scanner sc=new Scanner(System.in);
	@Override
	public void addJob() {
		// TODO Auto-generated method stub
		job=new Job();
		System.out.println("Enter the Job Id");
		int jobId=sc.nextInt();
		job.setJobId(jobId);
		System.out.println("Enter the Company Id");
		int companyId=sc.nextInt();
		job.setCompanyId(companyId);
		System.out.println("Enter the Job Title");
		String jobTitle=sc.next();
		job.setJobTitle(jobTitle);
        System.out.println("Enter the Job Description");
        String jobDescription =sc.next();
        job.setJobDescription(jobDescription);
        System.out.println("Enter the Job Location");
        String jobLocation=sc.next();
        job.setJobLoaction(jobLocation);
        System.out.println("Enter the salary");
        double salary=sc.nextDouble();
        job.setSalary(salary);
        System.out.println("Enter the Job Type");
        String jobType=sc.next();
        job.setJobType(jobType);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    sc.nextLine();
        System.out.println("Enter the postedDate  (yyyy-MM-dd):");
        String dateInput=sc.nextLine();
        LocalDate postedDate = LocalDate.parse(dateInput, dateFormatter);
        job.setPostedDate(postedDate);
        jDao.addJob(job);
        jobList.add(job);
        System.out.println("Job "+job.getJobId()+" "+"sucessfully added");
		
	}

	@Override
	public void addCompany() {
		// TODO Auto-generated method stub
		company=new Company();
		System.out.println("Enter the Company Id");
		int companyId=sc.nextInt();
		company.setCompanyId(companyId);
		System.out.println("Enter the Company Name");
		String companyName=sc.next();
		company.setCompanyName(companyName);
		sc.nextLine();
		System.out.println("Enter the Location");
		String location=sc.nextLine();
		company.setLocation(location);
		cDao.addCompany(company);
		companyList.add(company);
		 System.out.println("Job "+company.getCompanyId()+" "+"sucessfully added");
			
	}

	@Override
	public void addApplicant() {
		applicant=new Applicant();
		System.out.println("Enter the Applicant Id");
		int applicantId=sc.nextInt();
		applicant.setApplicantId(applicantId);
		System.out.println("Enter the First Name");
		String firstName=sc.next();
		applicant.setFirstName(firstName);
		System.out.println("Enter the Last Name");
		String lastName=sc.next();
		applicant.setLastName(lastName);
		System.out.println("Enter the Email");
		String email=sc.next();
		applicant.setEmail(email);
		System.out.println("Enter the phone");
		String phone=sc.next();
		applicant.setPhone(phone);
		System.out.println("Enter the Resume");
		String resume=sc.next();
		applicant.setResume(resume);
		aDao.addApplicant(applicant);
		applicantList.add(applicant);
		 System.out.println("Job "+applicant.getApplicantId()+" "+"sucessfully added");
		
	}

	@Override
	public void addJobApplicant() {
		// TODO Auto-generated method stub
		jobApplication =new JobApplication();
		System.out.println("Enter the Application Id");
		int applicationId=sc.nextInt();
		jobApplication.setApplicationId(applicationId);
		System.out.println("Enter the job id");
		int jobId=sc.nextInt();
		jobApplication.setJobId(jobId);
		System.out.println("Enter the Applicant Id");
		int applicantId=sc.nextInt();
		jobApplication.setApplicantId(applicantId);
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		sc.nextLine();
		System.out.println("Enter the Application Date (yyyy-MM-dd):");
		String dateInput=sc.nextLine();
	    LocalDate applicationDate = LocalDate.parse(dateInput, dateFormatter);
		jobApplication.setApplicationDate(applicationDate);
		System.out.println("Enter the Cover Letter");
		String coverLetter=sc.next();
		jobApplication.setCoverLetter(coverLetter);
		jaDao.addJobApplicant(jobApplication);
		jobApplicationList.add(jobApplication);
		System.out.println("Job "+jobApplication.getApplicantId()+" "+"sucessfully added");
		
		
	}

	@Override
	public void retrieveJob() {
		// TODO Auto-generated method stub
		List<Job> j=new ArrayList<>();
		System.out.println(jobList);
		
	}

	@Override
	public void retrieveCompany() {
		List<Company> c=new ArrayList<>();
		c.addAll(cDao.reteriveCompany(company));
		//System.out.println(companyList);
		for(Company c1:c) {
			System.out.print(c1+" ");
		}
		System.out.println();
	}

	@Override
	public void retrieveApplicant() {
	  aDao.reteriveApplicant(applicant);
     System.out.println(applicantList);
		
	}

	@Override
	public void retrieveJobApplicant() {
		jaDao.reteriveJobApplicant(jobApplication);
		System.out.println(jobApplicationList);
		
	}
    
}
