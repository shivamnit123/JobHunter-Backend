package com.job.JobFinder.Reviews.impl;

import com.job.JobFinder.Reviews.Review;

import java.util.List;

public interface ReviewServiceInterface {

    public List<Review>getAllReviews(Long company_Id);
    public String createReview(Review review,Long company_Id);
    public String deleteReview(Long review_Id,Long CompanyId);
    public String updateReview(Review review,Long review_Id,Long CompanyId);
    public Review findReview(Long review_Id,Long CompanyId);
}
