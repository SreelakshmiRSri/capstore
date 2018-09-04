package com.cg.capstore.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "product")
public class ProductBean {

	@Id
	@Column(name = "product_id")
	private String productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "price")
	private Double price;

	@ManyToMany
	@JoinColumn(name = "merchant_id")
	private List<MerchantBean> merchant;

	@Column(name = "quantity")
	private Double quantity;

	@Column(name = "category")
	private String category;

	@OneToOne
	@JoinColumn(name = "promo_code")
	private PromosBean promoCode;

	@OneToOne
	@JoinColumn(name = "discount_id")
	private DiscountBean discount;

	@OneToMany
	@Column(name = "image_id")
	private List<ImageBean> imageId;

	@OneToMany
	@Column(name = "feedback_id")
	private List<FeedbackProductBean> feedbackProduct;
	
	@Column
	private Integer count; 

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<FeedbackProductBean> getFeedbackProduct() {
		return feedbackProduct;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getQuantity() {
		return quantity;
	}

	public List<MerchantBean> getMerchant() {
		return merchant;
	}

	public void setMerchant(List<MerchantBean> merchant) {
		this.merchant = merchant;
	}

	public void setFeedbackProduct(List<FeedbackProductBean> feedbackProduct) {
		this.feedbackProduct = feedbackProduct;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public PromosBean getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(PromosBean promoCode) {
		this.promoCode = promoCode;
	}

	public DiscountBean getDiscount() {
		return discount;
	}

	public void setDiscount(DiscountBean discount) {
		this.discount = discount;
	}

	public List<ImageBean> getImageId() {
		return imageId;
	}

	public void setImageId(List<ImageBean> imageId) {
		this.imageId = imageId;
	}

	@Override
	public String toString() {
		return "ProductBean [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", merchant=" + merchant + ", quantity=" + quantity + ", category=" + category + ", promoCode="
				+ promoCode + ", discount=" + discount + ", imageId=" + imageId + ", feedbackProduct=" + feedbackProduct
				+ ", count=" + count + "]";
	}

	public ProductBean(String productId, String productName, Double price, List<MerchantBean> merchant, Double quantity,
			String category, PromosBean promoCode, DiscountBean discount, List<ImageBean> imageId,
			List<FeedbackProductBean> feedbackProduct) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.merchant = merchant;
		this.quantity = quantity;
		this.category = category;
		this.promoCode = promoCode;
		this.discount = discount;
		this.imageId = imageId;
		this.feedbackProduct = feedbackProduct;
	}

	public ProductBean() {
		super();
		// TODO Auto-generated constructor stub
	}
}
