package com.job.JobFinder.Jobs;

import com.job.JobFinder.Jobs.impl.JobService;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.Iterator;


import java.util.List;
import java.util.Optional;

@Service  // when we mark as a service here it provide all services at run time and i twill enjected to the controller
public class JobServiceImpl implements JobService {

//    private List<Job>joblist = new ArrayList<>();

    JobRepository jobrepository;
    private Long nextId = 1L;

    public JobServiceImpl(JobRepository jobrepository) {  // this is the bean hndle by spring
        this.jobrepository = jobrepository;  // we dont need to create object manually ..spring do this ...autowired
    }

    @Override
    public List<Job> getAllJobs() {

        List<Job>joblist = jobrepository.findAll();
        return joblist;
    }

    @Override
    public String CreateJob(Job job) {
        jobrepository.save(job);
        return "Job Added successfully";
    }
    @Override
    public Job FindJob(Long job_Id) {
        try{
            Optional<Job>op =  jobrepository.findById(job_Id);
            return op.get();
        }catch(Exception e) {
            return null;
        }
    }

    @Override
    public String DeleteJob(Long job_id) throws Throwable {
//        for(Job job:joblist)
//        {
//            if(job.getJob_Id().equals(job_id))
//            {
//                joblist.remove(job);
//                return "Job deleted successfully";
//            }
//        }
         // jobrepository.findById(job_id).orElseThrow(()-> new IllegalStateException("Resource Not Found"));
       Optional<Job>opjob = jobrepository.findById(job_id);
       if(opjob.isPresent()) {
           jobrepository.deleteById(job_id);
           return "Job deleted successfully";
       }
       return "Resource Not Found";
    }

    @Override
    public Job updateJob(Job jobs,Long job_id) {
//        for(Job job:joblist)
//        {
//            if(job.getJob_Id().equals(job_id))
//            {
//               // job.setJob_Id(jobs.getJob_Id());
//                if(jobs.companyName.length()!=0)
//                {
//                    job.companyName=jobs.companyName;
//                }
//                if(jobs.job_Id!=0)
//                {
//                    job.job_Id=jobs.job_Id;
//                }
//                if(jobs.maxSalary.length()!=0)
//                {
//                    job.maxSalary=jobs.maxSalary;
//                }
//                if(jobs.minSalary.length()!=0)
//                {
//                    job.minSalary=jobs.minSalary;
//                }
//                if(jobs.location.length()!=0)
//                {
//                    job.location=jobs.location;
//                }
//                return job;
//            }
//        }
//
          Job job = jobrepository.findById(job_id).get();
          job.setLocation(jobs.getLocation());
          job.setCompanyName(jobs.getCompanyName());
          job.setMaxSalary(jobs.getMaxSalary());
          job.setMinSalary(jobs.getMinSalary());
          return jobrepository.save(job);
    }

//    public boolean deleteJob(Long job_id) {
//        Iterator<Job> it = joblist.iterator();
//        while (it.hasNext()) {
//            Job job = it.next();
//            if (job.getJob_Id().equals(job_id))it.remove() return true;
//        }
//        return false;
//    }

}
