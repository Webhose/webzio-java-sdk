package com.webhoseio.sdk.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thread {

	@SerializedName("uuid")
	@Expose
	private String uuid;
	@SerializedName("url")
	@Expose
	private String url;
	@SerializedName("site_full")
	@Expose
	private String siteFull;
	@SerializedName("site")
	@Expose
	private String site;
	@SerializedName("site_section")
	@Expose
	private String siteSection;
	@SerializedName("site_categories")
	@Expose
	private List<String> siteCategories = null;
	@SerializedName("section_title")
	@Expose
	private String sectionTitle;
	@SerializedName("title")
	@Expose
	private String title;
	@SerializedName("title_full")
	@Expose
	private String titleFull;
	@SerializedName("published")
	@Expose
	private String published;
	@SerializedName("replies_count")
	@Expose
	private Integer repliesCount;
	@SerializedName("participants_count")
	@Expose
	private Integer participantsCount;
	@SerializedName("site_type")
	@Expose
	private String siteType;
	@SerializedName("country")
	@Expose
	private String country;
	@SerializedName("spam_score")
	@Expose
	private Double spamScore;
	@SerializedName("main_image")
	@Expose
	private String mainImage;
	@SerializedName("performance_score")
	@Expose
	private Integer performanceScore;
	@SerializedName("domain_rank")
	@Expose
	private Object domainRank;
	@SerializedName("social")
	@Expose
	private Social social;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSiteFull() {
		return siteFull;
	}

	public void setSiteFull(String siteFull) {
		this.siteFull = siteFull;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getSiteSection() {
		return siteSection;
	}

	public void setSiteSection(String siteSection) {
		this.siteSection = siteSection;
	}

	public List<String> getSiteCategories() {
		return siteCategories;
	}

	public void setSiteCategories(List<String> siteCategories) {
		this.siteCategories = siteCategories;
	}

	public String getSectionTitle() {
		return sectionTitle;
	}

	public void setSectionTitle(String sectionTitle) {
		this.sectionTitle = sectionTitle;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleFull() {
		return titleFull;
	}

	public void setTitleFull(String titleFull) {
		this.titleFull = titleFull;
	}

	public String getPublished() {
		return published;
	}

	public void setPublished(String published) {
		this.published = published;
	}

	public Integer getRepliesCount() {
		return repliesCount;
	}

	public void setRepliesCount(Integer repliesCount) {
		this.repliesCount = repliesCount;
	}

	public Integer getParticipantsCount() {
		return participantsCount;
	}

	public void setParticipantsCount(Integer participantsCount) {
		this.participantsCount = participantsCount;
	}

	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getSpamScore() {
		return spamScore;
	}

	public void setSpamScore(Double spamScore) {
		this.spamScore = spamScore;
	}

	public String getMainImage() {
		return mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}

	public Integer getPerformanceScore() {
		return performanceScore;
	}

	public void setPerformanceScore(Integer performanceScore) {
		this.performanceScore = performanceScore;
	}

	public Object getDomainRank() {
		return domainRank;
	}

	public void setDomainRank(Object domainRank) {
		this.domainRank = domainRank;
	}

	public Social getSocial() {
		return social;
	}

	public void setSocial(Social social) {
		this.social = social;
	}

}