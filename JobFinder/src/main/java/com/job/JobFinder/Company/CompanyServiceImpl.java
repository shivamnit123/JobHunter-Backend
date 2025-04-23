package com.job.JobFinder.Company;

import com.job.JobFinder.Company.impl.CompanyServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyServiceInterface {

    CompanyRepository companyrepo;


    public CompanyServiceImpl(CompanyRepository companyrepo) {
        this.companyrepo = companyrepo;
    }

    @Override
    public List<Company> getAllCompany() {
        List<Company>list = companyrepo.findAll();
        return list;
    }

    @Override
    public String CreateCompany(Company company) {
        companyrepo.save(company);
        return "Company Added Successfully";
    }

    @Override
    public Company findCompany(Long company_Id) {
        Optional<Company>op = companyrepo.findById(company_Id);
        return op.get();
    }

    @Override
    public String deleteCompany(Long company_Id) {
       Optional<Company>op = companyrepo.findById(company_Id);
       if(op.isPresent())
       {
           companyrepo.delete(op.get());
           return "Company Deleted";
       }
       return "Resource Not Found";
    }

    @Override
    public Company updateCompnay(Company company,Long company_Id) {
            Optional<Company>op = companyrepo.findById(company_Id);
            if(op.isPresent())
            {
                Company newcompany = op.get();
                newcompany.setCompany_Name(company.getCompany_Name());
                newcompany.setCompany_Info(company.getCompany_Info());
                newcompany.setCompany_Location(company.getCompany_Location());
                companyrepo.save(newcompany);
                return newcompany;
            }
            return op.get();
    }
}
