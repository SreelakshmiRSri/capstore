package com.cg.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.capstore.beans.MerchantBean;

public interface CapStroreMerchantRepo extends JpaRepository<MerchantBean, String> {
	@Query("select p from MerchantBean p where p.emailId = :email")
	MerchantBean getByEmail(@Param("email") String email);
}
