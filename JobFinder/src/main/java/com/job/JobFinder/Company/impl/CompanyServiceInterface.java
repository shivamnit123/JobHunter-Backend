package com.job.JobFinder.Company.impl;

import com.job.JobFinder.Company.Company;
import com.job.JobFinder.Jobs.Job;

import java.util.List;

public interface CompanyServiceInterface{

    public List<Company> getAllCompany();
    public String CreateCompany(Company company);
    public Company findCompany(Long company_Id);
    public String deleteCompany(Long company_Id);
    public Company updateCompnay(Company compamny,Long company_Id);
}
