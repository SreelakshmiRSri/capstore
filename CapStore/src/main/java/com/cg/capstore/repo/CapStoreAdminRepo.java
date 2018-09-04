package com.cg.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.capstore.beans.AdminBean;
import com.cg.capstore.beans.CustomerBean;

public interface CapStoreAdminRepo  extends JpaRepository<AdminBean,String> {
	@Query("select p from AdminBean p where p.emailId = :email")
	
	AdminBean getByEmail(@Param("email") String email);
	
}
