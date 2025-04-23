package com.job.JobFinder.Jobs.impl;

import com.job.JobFinder.Jobs.Job;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface JobService {

    public List<Job> getAllJobs();
    public String CreateJob(Job job);
    public Job FindJob(Long job_id);
    public String DeleteJob(Long job_id) throws Throwable;
    public Job updateJob(Job jobs,Long job_id);

}
