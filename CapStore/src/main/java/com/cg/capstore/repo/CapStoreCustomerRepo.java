package com.cg.capstore.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.capstore.beans.CustomerBean;
@Repository
public interface CapStoreCustomerRepo extends JpaRepository<CustomerBean,String>{
@Query("select p from CustomerBean p where p.email = :email")
CustomerBean getByEmail(@Param("email") String email);
/*
@Query("select p.password from CustomerBean p where p.email = :email")
String getBy(@Param("email") String email);*/
}
