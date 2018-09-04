package com.cg.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.capstore.beans.FeedbackProductBean;

public interface CapStoreFeedbackRepo extends JpaRepository<FeedbackProductBean, String> {
	@Query("SELECT AVG(rating) FROM FeedbackProductBean  ")
	Double avgRating();
}
 