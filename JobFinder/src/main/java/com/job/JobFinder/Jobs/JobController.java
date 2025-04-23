package com.job.JobFinder.Jobs;

import com.job.JobFinder.Jobs.impl.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobService jobService;  /// we have not intialised jobservice.....@service comes in the picture

    public JobController(JobService jobService) {  //
        this.jobService = jobService; // here intialise jobservice
    }

    @GetMapping("/get-all-jobs")
//    public List<Job> getAllJobs()
//    {
//      return jobService.getAllJobs();
//    }
    public ResponseEntity<List<Job>> getAllJobs()
    {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @PostMapping("/create-job")
    public ResponseEntity<String> CreateJob(@RequestBody Job job)
    {
         jobService.CreateJob(job);
         return new ResponseEntity<>("Job added successfully",HttpStatusCode.valueOf(200));
    }

    @GetMapping("/find-by-id/{id}")
//    public String FindJob(@PathVariable("id") Long job_Id)
//    {
//       return jobService.FindJob(job_Id);
//    }
   public ResponseEntity<Job> FindJob(@PathVariable("id") Long job_Id)
    {
        Job job = jobService.FindJob(job_Id);
        if(job!=null)
        return new ResponseEntity<>(job, HttpStatusCode.valueOf(200));
        return new ResponseEntity<>(HttpStatusCode.valueOf(404));
    }

    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable("id")Long job_id) throws Throwable {
        return ResponseEntity.ok(jobService.DeleteJob(job_id));
    }

    @PutMapping("update-by-id/{id}")
    public ResponseEntity<Job> updateJob(@RequestBody Job job,@PathVariable("id")Long job_id)
    {
        Job updatedjob = jobService.updateJob(job,job_id);
        if(updatedjob!=null)
        {
            return new ResponseEntity<>(updatedjob,HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(updatedjob,HttpStatus.BAD_REQUEST);
    }

}