package com.azharx.jobservice.job.dto;

import com.azharx.jobservice.job.external.Company;
import com.azharx.jobservice.job.external.Review;
import lombok.Data;

import java.util.List;

@Data
public class JobDTO {

    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
    private Company company;
    private List<Review> reviews;
}
