package com.webhoseio.sdk.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Social {

	@SerializedName("facebook")
	@Expose
	private Facebook facebook;
	@SerializedName("gplus")
	@Expose
	private Gplus gplus;
	@SerializedName("pinterest")
	@Expose
	private Pinterest pinterest;
	@SerializedName("linkedin")
	@Expose
	private Linkedin linkedin;
	@SerializedName("stumbledupon")
	@Expose
	private Stumbledupon stumbledupon;
	@SerializedName("vk")
	@Expose
	private Vk vk;

	public Facebook getFacebook() {
		return facebook;
	}

	public void setFacebook(Facebook facebook) {
		this.facebook = facebook;
	}

	public Gplus getGplus() {
		return gplus;
	}

	public void setGplus(Gplus gplus) {
		this.gplus = gplus;
	}

	public Pinterest getPinterest() {
		return pinterest;
	}

	public void setPinterest(Pinterest pinterest) {
		this.pinterest = pinterest;
	}

	public Linkedin getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(Linkedin linkedin) {
		this.linkedin = linkedin;
	}

	public Stumbledupon getStumbledupon() {
		return stumbledupon;
	}

	public void setStumbledupon(Stumbledupon stumbledupon) {
		this.stumbledupon = stumbledupon;
	}

	public Vk getVk() {
		return vk;
	}

	public void setVk(Vk vk) {
		this.vk = vk;
	}
}