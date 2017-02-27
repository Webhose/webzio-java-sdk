package com.webhoseio.sdk.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Facebook {

	@SerializedName("likes")
	@Expose
	private Integer likes;
	@SerializedName("comments")
	@Expose
	private Integer comments;
	@SerializedName("shares")
	@Expose
	private Integer shares;

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Integer getComments() {
		return comments;
	}

	public void setComments(Integer comments) {
		this.comments = comments;
	}

	public Integer getShares() {
		return shares;
	}

	public void setShares(Integer shares) {
		this.shares = shares;
	}
}
