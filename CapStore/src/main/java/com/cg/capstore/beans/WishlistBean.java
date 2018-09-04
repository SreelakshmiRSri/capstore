package com.cg.capstore.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="WishList")
public class WishlistBean {
	@Id
	@Column(name="wishlist_id")
	private String wishlistId;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@Column(name="product_id")
	private List<ProductBean> product;

	public String getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(String wishlistId) {
		this.wishlistId = wishlistId;
	}

	public List<ProductBean> getProduct() {
		return product;
	}

	public void setProduct(List<ProductBean> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "WishlistBean [wishlistId=" + wishlistId + ", product=" + product + "]";
	}

	public WishlistBean(String wishlistId, List<ProductBean> product) {
		super();
		this.wishlistId = wishlistId;
		this.product = product;
	}

	public WishlistBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
