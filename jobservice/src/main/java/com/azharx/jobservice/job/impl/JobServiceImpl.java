package com.azharx.jobservice.job.impl;
import com.azharx.jobservice.job.Job;
import com.azharx.jobservice.job.JobRepository;
import com.azharx.jobservice.job.JobService;
import com.azharx.jobservice.job.dto.JobWithCompanyDTO;
import com.azharx.jobservice.job.external.Company;
import com.azharx.jobservice.job.mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;

    @Autowired
    private RestTemplate restTemplate;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


    @Override
    public List<JobWithCompanyDTO> findAll() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public JobWithCompanyDTO getJobById(Long id) {
        Job job = jobRepository.findById(id).orElse(null);
        return convertToDto(job);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }

    private JobWithCompanyDTO convertToDto(Job job) {
            Company company = restTemplate
                    .getForObject("http://COMPANY-SERVICE:8081/companies/" + job.getCompanyId(), Company.class);
            JobWithCompanyDTO jobWithCompanyDTO = JobMapper.mapToJobWithCompanyDto(job, company);
            jobWithCompanyDTO.setCompany(company);

            return jobWithCompanyDTO;
    }

}
