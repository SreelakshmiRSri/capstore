package com.cg.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.capstore.beans.PromosBean;

public interface CapStorePromoRepo extends JpaRepository<PromosBean, String> {
	@Query(value="SELECT c.email FROM CustomerBean c WHERE c.email=(:email)")
	public String findCustomerEmail(@Param(value="email") String customerName);

}
