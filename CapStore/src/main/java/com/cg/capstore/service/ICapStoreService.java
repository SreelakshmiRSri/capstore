package com.cg.capstore.service;

import java.util.List;

import com.cg.capstore.beans.FeedbackProductBean;
import com.cg.capstore.beans.OrderBean;
import com.cg.capstore.beans.ProductBean;
import com.cg.capstore.beans.PromosBean;
import com.cg.capstore.beans.WishlistBean;
import com.cg.capstore.exception.CapStoreException;

public interface ICapStoreService {
	
	/*
	public WishlistBean wish(WishlistBean wish) throws CapStoreException;
	
	//public ProductBean product(ProductBean product) throws CapStoreException;
	
	public PromosBean promo(PromosBean p) throws CapStoreException;
	*/
	public OrderBean getTransactionalDetails(String orderId) throws CapStoreException;
	
	public FeedbackProductBean createFeedback(FeedbackProductBean feedback) throws CapStoreException;
	
	public Double ratingAvg() throws CapStoreException;
	
	public OrderBean updateStatus(OrderBean status) throws CapStoreException;
	
	public String forgotPassword(String email) throws CapStoreException;
	
	public String sendPromo(String name) throws CapStoreException;
	public List<ProductBean> sortByLowToHigh(String category) throws CapStoreException;
	public List<ProductBean> sortByHighToLow(String category) throws CapStoreException;
	
	public List<ProductBean> rangeSort(double min,double max, String category) throws CapStoreException;
	//public List<ProductBean> sortByBestSeller() throws CapStoreException;
	public List<ProductBean> sortByMostViewed(String category) throws CapStoreException;
	public ProductBean count(ProductBean productId) throws CapStoreException ; 
	
	public String refund(String orderId);

}
