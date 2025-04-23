package com.job.JobFinder.Reviews;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewTRepository extends JpaRepository<Review, Long> {
    List<Review> findByCompany_CompanyId(Long companyId);
}
