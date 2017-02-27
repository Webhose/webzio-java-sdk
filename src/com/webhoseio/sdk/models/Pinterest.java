package com.webhoseio.sdk.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pinterest {

	@SerializedName("shares")
	@Expose
	private Integer shares;

	public Integer getShares() {
		return shares;
	}

	public void setShares(Integer shares) {
		this.shares = shares;
	}
}