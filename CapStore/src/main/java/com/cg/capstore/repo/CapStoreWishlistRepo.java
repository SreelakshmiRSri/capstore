package com.cg.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capstore.beans.WishlistBean;

public interface CapStoreWishlistRepo extends JpaRepository<WishlistBean, String> {

}
