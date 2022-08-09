package com.bean;

import java.util.HashSet;
import java.util.Set;

public class ProductBean {

	Integer productId;
	String productName;
	Integer price;

	Set<CategoryBean> categories = new HashSet<CategoryBean>();

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Set<CategoryBean> getCategories() {
		return categories;
	}

	public void setCategories(Set<CategoryBean> categories) {
		this.categories = categories;
	}

}
