package com.azharx.jobservice.job.dto;

import com.azharx.jobservice.job.Job;
import com.azharx.jobservice.job.external.Company;
import lombok.Data;

@Data
public class JobWithCompanyDTO {

    private Job job;
    private Company company;
}
