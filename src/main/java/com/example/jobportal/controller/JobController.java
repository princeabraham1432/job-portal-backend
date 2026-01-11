package com.example.jobportal.controller;

import com.example.jobportal.model.Job;
import com.example.jobportal.service.JobService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // CREATE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Job createJob(@RequestBody Job job) {
        return jobService.createJob(job);
    }

    // READ ALL
    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }

    // DELETE BY ID
    @DeleteMapping("/{id}")
    public void deleteJobById(@PathVariable Long id) {
        jobService.deleteJobById(id);
    }
    @PutMapping("/{id}")
    public Job updateJob(@PathVariable Long id, @RequestBody Job job) {
        return jobService.updateJob(id, job);
    }

}
