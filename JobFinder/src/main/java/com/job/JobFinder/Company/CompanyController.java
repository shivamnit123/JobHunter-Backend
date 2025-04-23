package com.job.JobFinder.Company;

import org.springframework.data.util.Optionals;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

     private CompanyServiceImpl companyService;

    public CompanyController(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/get-all-company")
    public ResponseEntity<List<Company>> getAllCompany()
    {
        return ResponseEntity.ok(companyService.getAllCompany());
    }

    @PostMapping("/createcompany")
    public ResponseEntity<Company> createCompany(@RequestBody Company company)
    {
        companyService.CreateCompany(company);
        return new  ResponseEntity<>(company, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/find-company/{id}")
    public ResponseEntity<Company> findCompany(@PathVariable("id") Long company_Id)
    {
        Optional<Company> op = Optional.ofNullable(companyService.findCompany(company_Id));
        if(op.isPresent())return new  ResponseEntity(op,HttpStatusCode.valueOf(200));
        return new  ResponseEntity(op,HttpStatusCode.valueOf(404));
    }

    @PutMapping("/update-company/{id}")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company,@PathVariable("id") Long company_Id){

        Company updatedcompany = companyService.updateCompnay(company,company_Id);
        if(updatedcompany!=null)
        {
            return new ResponseEntity<>(updatedcompany,HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(updatedcompany,HttpStatusCode.valueOf(404));
    }

    @DeleteMapping("/delete-company/{id}")

    public ResponseEntity<String>deleteCompany(@PathVariable("id") Long company_Id)
    {
//        Company comp = companyService.findCompany(company_Id);
//        if(comp!=null)
//        {
//            companyService.deleteCompany(comp);
//            return new ResponseEntity<>("Deleted Successfully",HttpStatusCode.valueOf(200));
//        }
//        return new ResponseEntity<>("Resource Not Found",HttpStatusCode.valueOf(200));
        return ResponseEntity.ok(companyService.deleteCompany(company_Id));
    }

}
