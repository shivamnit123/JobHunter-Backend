package com.job.JobFinder.Jobs;

import com.job.JobFinder.Company.Company;
import jakarta.persistence.*;

@Entity
//@Table(name = "job_table")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long job_Id;
    public String companyName;
    public String maxSalary;
    public String minSalary;
    public String location;
    @ManyToOne
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Job() {  // without this constructor jpa cant instantiate enitity objects.
    }

    public Job(Long job_Id, String companyName, String maxSalary, String minSalary, String location) {
        this.job_Id = job_Id;
        this.companyName = companyName;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
        this.location = location;
    }

    public Long getJob_Id() {
        return job_Id;
    }

    public void setJob_Id(Long job_Id) {
        this.job_Id = job_Id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
