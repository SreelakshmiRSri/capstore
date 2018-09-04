package com.cg.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capstore.beans.OrderBean;

public interface CapStoreOrderRepo extends JpaRepository<OrderBean, String>{
	
}
