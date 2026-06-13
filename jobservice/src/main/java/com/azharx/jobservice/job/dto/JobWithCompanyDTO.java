package com.azharx.jobservice.job.dto;

import com.azharx.jobservice.job.external.Company;
import lombok.Data;

@Data
public class JobWithCompanyDTO {

    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
    private Company company;
}
