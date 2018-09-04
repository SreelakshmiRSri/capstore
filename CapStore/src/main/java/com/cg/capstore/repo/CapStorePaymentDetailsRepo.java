package com.cg.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.capstore.beans.PaymentDetailsBean;

public interface CapStorePaymentDetailsRepo extends JpaRepository<PaymentDetailsBean, String>{
	@Query("select p from PaymentDetailsBean p where p.order.orderId = (:orderId)")
	PaymentDetailsBean refund(@Param(value="orderId") String orderId);
}
