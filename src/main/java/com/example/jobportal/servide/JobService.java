package com.example.jobportal.service;

import com.example.jobportal.model.Job;
import com.example.jobportal.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository repository;

    public JobService(JobRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Job createJob(Job job) {
        return repository.save(job);
    }

    // READ ALL
    public List<Job> getAllJobs() {
        return repository.findAll();
    }

    // READ BY ID
    public Job getJobById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id " + id));
    }

    // DELETE
    public void deleteJobById(Long id) {
        repository.deleteById(id);
    }
    public Job updateJob(Long id, Job updatedJob) {
        Job existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id " + id));

        existing.setTitle(updatedJob.getTitle());
        existing.setCompany(updatedJob.getCompany());
        existing.setLocation(updatedJob.getLocation());
        existing.setSalary(updatedJob.getSalary());

        return repository.save(existing);
    }

}
