package com.job.JobFinder.Reviews;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.job.JobFinder.Company.Company;
import jakarta.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long review_Id;
    private String title;
    private String description;
    private Double rating;

    @JsonIgnore
    @ManyToOne
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Review() {
    }

    public Review(Long review_Id, String title, String description, Double rating) {
        this.review_Id = review_Id;
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    public Long getReview_Id() {
        return review_Id;
    }

    public void setReview_Id(Long review_Id) {
        this.review_Id = review_Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
