package com.cg.capstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.capstore.beans.CustomerBean;
import com.cg.capstore.beans.ProductBean;

public interface CapStoreProductRepo extends JpaRepository<ProductBean, String> {
	@Query("select p from ProductBean p where p.category =(:category) order by p.price desc ")
	List<ProductBean> sortHighToLow(@Param(value = "category") String category);

	@Query("select p from ProductBean p  where p.category =(:category) order by p.price  ")
	List<ProductBean> sortByLowToHigh(@Param(value = "category") String category);

	/*
	 * @Query("select p from ProductBean p Where p.price BETWEEN :min ")
	 * List<ProductBean> sortByRange();
	 */
	@Query("select p from ProductBean p Where p.price BETWEEN (:min) AND (:max) and  p.category =(:category) order by p.price ")
	List<ProductBean> sortByRange(@Param(value = "min") double min, @Param(value = "max") double max,
			@Param(value = "category") String category);

	// @Query("select p from ProductBean p inner join FeedbackProductBean on
	// p.feedbackProduct=FeedbackProductBean.rating order by p.feedbackProduct")
/*	@Query(" SELECT AVG(rating) FROM FeedbackProductBean")
	List<ProductBean> sortByBestSeller();*/
	

	@Query("SELECT p FROM ProductBean p where p.category =(:category) order by p.count desc")
	List<ProductBean> sortByMostViewed(@Param(value = "category") String category);
}
