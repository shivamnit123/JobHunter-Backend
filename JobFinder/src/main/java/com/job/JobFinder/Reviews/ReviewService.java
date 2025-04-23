package com.job.JobFinder.Reviews;

import com.job.JobFinder.Company.Company;
import com.job.JobFinder.Company.CompanyServiceImpl;
import com.job.JobFinder.Reviews.impl.ReviewServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ReviewService implements ReviewServiceInterface{

    private ReviewTRepository reviewrepo;
    private CompanyServiceImpl companyService;

    public ReviewService(ReviewTRepository reviewrepo,CompanyServiceImpl companyService) {
        this.reviewrepo = reviewrepo;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review>reviewlist = reviewrepo.findByCompany_CompanyId(companyId);
        Optional<List<Review>>op = Optional.ofNullable(reviewrepo.findByCompany_CompanyId(companyId));
        if(reviewlist.size()==0)return op.get();
        return reviewlist;
    }

    @Override
    public String createReview(Review review,Long companyId) {

        Company company = companyService.findCompany(companyId);
        if(company!=null)
        {
            review.setCompany(company);
            reviewrepo.save(review);
            return "Data Added successfully";
        }
        return "Company Not Found";
    }

    @Override
    public String deleteReview(Long review_Id,Long CompanyId) {
        Company company = companyService.findCompany(CompanyId);
        if(company==null)return "company not found";
        Review review  = reviewrepo.findById(review_Id).orElse(null);
        Company co = review.getCompany();
        co.getReviews().remove(review);
        review.setCompany(null);
        companyService.updateCompnay(co,CompanyId);
        reviewrepo.deleteById(review_Id);
        //List<Review> op = company.getReviews().stream().filter((a)->a.getReview_Id().equals(review_Id)).collect(Collectors.toList());
        return "Company Deleted";
    }

    @Override
    public String updateReview(Review newreview, Long review_Id,Long CompanyId) {

        Review review = findReview(review_Id,CompanyId);
        if(review!=null)
        {
            review.setDescription(newreview.getDescription());
            review.setRating(newreview.getRating());
            review.setTitle(newreview.getTitle());
            reviewrepo.save(review);
            return "Review Updated sucessfully";
        }
        return "nOT FOUND";
    }

    @Override
    public Review findReview(Long review_Id,Long CompanyId) {

       List<Review>list = reviewrepo.findByCompany_CompanyId(CompanyId);
       return list.stream().filter((a)->a.getReview_Id().equals(review_Id)).findFirst().orElse(null);
    }
}
