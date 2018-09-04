package com.cg.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.capstore.beans.AdminBean;
import com.cg.capstore.beans.CustomerBean;
import com.cg.capstore.beans.FeedbackProductBean;
import com.cg.capstore.beans.MerchantBean;
import com.cg.capstore.beans.OrderBean;
import com.cg.capstore.beans.PaymentDetailsBean;
import com.cg.capstore.beans.ProductBean;
import com.cg.capstore.exception.CapStoreException;
import com.cg.capstore.repo.CapStoreAdminRepo;
import com.cg.capstore.repo.CapStoreCustomerRepo;
import com.cg.capstore.repo.CapStoreFeedbackRepo;
import com.cg.capstore.repo.CapStoreOrderRepo;
import com.cg.capstore.repo.CapStorePaymentDetailsRepo;
import com.cg.capstore.repo.CapStoreProductRepo;
import com.cg.capstore.repo.CapStorePromoRepo;
import com.cg.capstore.repo.CapStoreWishlistRepo;
import com.cg.capstore.repo.CapStroreMerchantRepo;

@Service
public class CapStoreServiceImpl implements ICapStoreService {
	@Autowired
	private CapStoreCustomerRepo custRepo;
	@Autowired
	private CapStoreWishlistRepo WishListRepo;
	@Autowired
	private CapStoreProductRepo productRepo;
	@Autowired
	private CapStorePromoRepo promoRepo;
	@Autowired
	private CapStoreOrderRepo orderRepo;
	@Autowired
	private CapStoreFeedbackRepo feedBackrepo;
	@Autowired
	private CapStoreAdminRepo adminRepo;
	@Autowired
	private CapStroreMerchantRepo merchantRepo;
	@Autowired
	private CapStorePaymentDetailsRepo paymentRepo;



//**************getTransactionDetails************************
	@Override
	public OrderBean getTransactionalDetails(String orderId) throws CapStoreException {

		return orderRepo.getOne(orderId);
	}

	@Override
	public FeedbackProductBean createFeedback(FeedbackProductBean feedback) throws CapStoreException {

		return feedBackrepo.save(feedback);
	}

//********************Rating***********************************
	@Override
	public Double ratingAvg() throws CapStoreException {

		return feedBackrepo.avgRating();
	}

//*************Checking, Updating Status of delivery*******************
	@Override
	public OrderBean updateStatus(OrderBean status) throws CapStoreException {

		OrderBean o = orderRepo.getOne(status.getOrderId());
		o.setOrderStatus(status.getOrderStatus());
		return orderRepo.save(o);
	}

	// *****************for forgot password*******************************
	@Override
	public String forgotPassword(String email) throws CapStoreException {

		AdminBean admin = adminRepo.getByEmail(email);

		MerchantBean merchant = merchantRepo.getByEmail(email);
		CustomerBean cust = custRepo.getByEmail(email);

		if (admin != null) {
			String a1 = admin.getPassword();
			int l1 = a1.length();
			String pass = (a1.substring(l1 / 2, l1));
			return pass;
		} else if (merchant != null) {
			String a1 = merchant.getPassword();
			int l1 = a1.length();
			// System.out.println(l1);
			String pass = (a1.substring(l1 / 2, l1));
			// System.out.println(pass);
			return pass;
		} else if (cust != null) {
			// return cust.getPassword();
			String a1 = cust.getPassword();
			int l1 = a1.length();
			String pass = (a1.substring(l1 / 2, l1));
			return pass;
		} else {
			throw new CapStoreException( "email does not exist");
		}

	}
	// ********************Sending New Promos & list of new
	// items*********************

	@Override
	public String sendPromo(String name) throws CapStoreException {

		return promoRepo.findCustomerEmail(name);
	}

//**********************sorting High to Low****************
	@Override
	public List<ProductBean> sortByHighToLow(String category) throws CapStoreException {
		return productRepo.sortHighToLow(category);
	}

	public List<ProductBean> rangeSort(double min, double max, String category) throws CapStoreException {

		return productRepo.sortByRange(min, max, category);
	}

	// ********************sorting**low to High*********************
	@Transactional
	@Override
	public List<ProductBean> sortByLowToHigh(String category) throws CapStoreException {
		return productRepo.sortByLowToHigh(category);
	}

	@Override
	public List<ProductBean> sortByMostViewed(String category) throws CapStoreException {
		// TODO Auto-generated method stub
		return productRepo.sortByMostViewed(category);
	}

	@Override
	public ProductBean count(ProductBean productId) throws CapStoreException {
		ProductBean prod = productRepo.getOne(productId.getProductId());
		int a = prod.getCount();
		if (a == 0) {
			prod.setCount(1);
		} else {

			Integer b = a + 1;
			prod.setCount(b);
		}

		return productRepo.save(prod);
	}
//***********************refund*****************
	@Override
	public String refund(String orderId) {
		OrderBean order = orderRepo.getOne(orderId);
		 order.setOrderStatus("returned");
		 orderRepo.save(order );
		double a =  (order.getMinBillingAmount())*(order.getQuantity());
		PaymentDetailsBean p = paymentRepo.refund(orderId);
		double d=p.getCapStoreRevenueAmount();
		double c = d-a;
		p.setCapStoreRevenueAmount(c);
		paymentRepo.save(p);
		return "refunded";
	}

	
}
