package com.job.JobFinder.Reviews;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>>getAllReviews(@PathVariable Long companyId)
    {
      return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatusCode.valueOf(200));
    }
    @PostMapping("/create-review")
    public ResponseEntity<String>createReview(@RequestBody Review review, @PathVariable Long companyId)
    {
        return new ResponseEntity<>(reviewService.createReview(review,companyId), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/get-company-review/{review_Id}")
    public ResponseEntity<Review>getReview(@PathVariable Long review_Id,@PathVariable Long CompanyId)
    {
        return new ResponseEntity<>(reviewService.findReview(review_Id,CompanyId),HttpStatusCode.valueOf(200));
    }

    @PutMapping("/update/{review_Id}")
    public ResponseEntity<String>updateReview(@RequestBody Review review,@PathVariable("review_Id") Long review_Id,@PathVariable Long CompanyId)
    {
        return new ResponseEntity<>(reviewService.updateReview(review,review_Id,CompanyId),HttpStatusCode.valueOf(200));
    }

}
