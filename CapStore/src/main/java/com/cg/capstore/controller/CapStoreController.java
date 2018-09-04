package com.cg.capstore.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capstore.beans.FeedbackProductBean;
import com.cg.capstore.beans.OrderBean;
import com.cg.capstore.beans.ProductBean;
import com.cg.capstore.beans.PromosBean;
import com.cg.capstore.beans.WishlistBean;
import com.cg.capstore.exception.CapStoreException;
import com.cg.capstore.service.ICapStoreService;

@RestController
public class CapStoreController {
	@Autowired
	private ICapStoreService service;
	@Autowired
	private JavaMailSender sender;

	

	// *****************for forgot password*******************************
	@RequestMapping(value = "/fetchPassword", method = RequestMethod.GET)
	public String getPassword(String email) throws CapStoreException {
		
		return service.forgotPassword(email);
		
	}

	
	
	@RequestMapping(value = "/sortHighToLow", method = RequestMethod.GET)
	public List<ProductBean> sortHighToLow(String category) throws CapStoreException {
		return service.sortByHighToLow(category);

	}

	@RequestMapping(value = "/sortLowToHigh", method = RequestMethod.GET)
	public List<ProductBean> sortLowToHigh(String category) throws CapStoreException {
		return service.sortByLowToHigh(category);

	}

	@RequestMapping(value = "/rangesort", method = RequestMethod.POST)
	public List<ProductBean> rangeSort(Double min, Double max, String category) throws CapStoreException {

		return service.rangeSort(min, max,category);

	}

	
	/*@RequestMapping(value = "/sortByBestSeller", method = RequestMethod.GET)
	public List<ProductBean> sortByBestSeller() throws CapStoreException {
		return service.sortByBestSeller();
	
	}*/
	@RequestMapping(value = "/sortByMostViewed", method = RequestMethod.GET)
	public List<ProductBean> sortByMostViewed(String category) throws CapStoreException {
		return service.sortByMostViewed(category);
	
	}
	

	@RequestMapping(value = "/getTransactionalDetails", method = RequestMethod.GET)
	public OrderBean getTransactionalDetails(String orderId) throws CapStoreException {
		return service.getTransactionalDetails(orderId);

	}

	@RequestMapping(value = "/Avg", method = RequestMethod.GET)
	public Double ratingAvg() throws CapStoreException {
		return service.ratingAvg();

	}

	@RequestMapping(value = "/statusUpdate", method = RequestMethod.POST)
	public OrderBean setStatus(OrderBean o) throws CapStoreException {
		return service.updateStatus(o);

	}

	@RequestMapping(value = "/sendPromo", method = RequestMethod.GET)
	public String sendPromo(String email, String Email) throws MessagingException, CapStoreException {
		String customerEmail = service.sendPromo(email);
		// sendInvitationToFriend(Email);
		return "Success, Sending promo to " + Email + "from your mail " + customerEmail;
	}

	public void sendPromo(String email) throws MessagingException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		// helper.setFrom(customerEmail);
		helper.setTo("sadsa@gmail.com");
		helper.setText("Test Message...");
		helper.setSubject("Inviting You to use Promo for this website");

		sender.send(message);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
		public ProductBean count(ProductBean productId) throws CapStoreException {
			return service.count(productId);
			
		}
	
	@RequestMapping(value = "/refund", method = RequestMethod.GET)
	public String refund(String orderId) {
		return service.refund(orderId);
		
	}

	@RequestMapping(value = "/checkingStatus", method = RequestMethod.GET)
	public OrderBean checkingStatus(String orderId) throws CapStoreException {
		return service.getTransactionalDetails(orderId);

	}

}