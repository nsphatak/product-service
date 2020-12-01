package com.eresh.spring.ws;

/**
 * Created By Gorantla, Eresh on 11/Dec/2019
 **/
public class WSDiscount {
	private String productId;
	private String maxDiscount;

	public WSDiscount() {
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getMaxDiscount() {
		return maxDiscount;
	}

	public void setMaxDiscount(String maxDiscount) {
		this.maxDiscount = maxDiscount;
	}

}
