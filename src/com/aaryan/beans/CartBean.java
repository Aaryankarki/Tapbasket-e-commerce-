package com.aaryan.beans;

import java.io.Serializable;
//cart bins

@SuppressWarnings("serial")
public class CartBean implements Serializable {

	public CartBean() {
	}

	public String userId;

	public String prodId;

	public int quantity;
	// i have used both the getter and setter methods

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
// constructor of cart bean
	public CartBean(String userId, String prodId, int quantity) {
		super();
		this.userId = userId;
		this.prodId = prodId;
		this.quantity = quantity;
	}

}
