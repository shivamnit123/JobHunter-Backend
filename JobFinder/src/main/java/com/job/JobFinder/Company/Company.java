package com.job.JobFinder.Company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.job.JobFinder.Jobs.Job;
import com.job.JobFinder.Reviews.Review;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long companyId;
    public String company_Name;
    public String company_Location;
    public String company_Info;

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<Job> jobs;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public Company() {
    }

    public Company(Long companyId, String company_Name, String company_Location, String company_Info) {
        this.companyId = companyId;
        this.company_Name = company_Name;
        this.company_Location = company_Location;
        this.company_Info = company_Info;
    }

    public Long getCompany_Id() {
        return companyId;
    }

    public String getCompany_Name() {
        return company_Name;
    }

    public String getCompany_Location() {
        return company_Location;
    }

    public String getCompany_Info() {
        return company_Info;
    }
    public void setCompany_Id(Long company_Id) {
        this.companyId = company_Id;
    }

    public void setCompany_Name(String company_Name) {
        this.company_Name = company_Name;
    }

    public void setCompany_Location(String company_Location) {
        this.company_Location = company_Location;
    }

    public void setCompany_Info(String company_Info) {
        this.company_Info = company_Info;
    }


}
