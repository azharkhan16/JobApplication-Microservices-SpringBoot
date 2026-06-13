package com.azharx.jobservice.job.mapper;

import com.azharx.jobservice.job.Job;
import com.azharx.jobservice.job.dto.JobWithCompanyDTO;
import com.azharx.jobservice.job.external.Company;

public class JobMapper {

    public static JobWithCompanyDTO mapToJobWithCompanyDto(Job job, Company company) {

        JobWithCompanyDTO jobWithCompanyDTO = new JobWithCompanyDTO();
        jobWithCompanyDTO.setId(job.getId());
        jobWithCompanyDTO.setTitle(job.getTitle());
        jobWithCompanyDTO.setDescription(job.getDescription());
        jobWithCompanyDTO.setMinSalary(job.getMinSalary());
        jobWithCompanyDTO.setMaxSalary(job.getMaxSalary());
        jobWithCompanyDTO.setLocation(job.getLocation());
        jobWithCompanyDTO.setCompany(company);

        return jobWithCompanyDTO;
    }
}

//===== IMP => refactor: replace nested job DTO structure with flattened response using JobMapper =====
//getJobById() response before JobMapper Class :
//        {
//        "job": { ... },
//        "company": { ... }
//        }
//
//getJobById() response after JobMapper Class :
//        {
//        "id": 1,
//        "title": "...",
//        "company": { ... }
//        }
