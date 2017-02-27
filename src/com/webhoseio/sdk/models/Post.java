package com.webhoseio.sdk.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

	@SerializedName("thread")
	@Expose
	private Thread thread;
	@SerializedName("uuid")
	@Expose
	private String uuid;
	@SerializedName("url")
	@Expose
	private String url;
	@SerializedName("ord_in_thread")
	@Expose
	private Integer ordInThread;
	@SerializedName("author")
	@Expose
	private String author;
	@SerializedName("published")
	@Expose
	private String published;
	@SerializedName("title")
	@Expose
	private String title;
	@SerializedName("text")
	@Expose
	private String text;
	@SerializedName("highlightText")
	@Expose
	private String highlightText;
	@SerializedName("highlightTitle")
	@Expose
	private String highlightTitle;
	@SerializedName("language")
	@Expose
	private String language;
	@SerializedName("external_links")
	@Expose
	private List<String> externalLinks = null;
	@SerializedName("entities")
	@Expose
	private Entities entities;
	@SerializedName("rating")
	@Expose
	private Object rating;
	@SerializedName("crawled")
	@Expose
	private String crawled;

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

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

	public Integer getOrdInThread() {
		return ordInThread;
	}

	public void setOrdInThread(Integer ordInThread) {
		this.ordInThread = ordInThread;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublished() {
		return published;
	}

	public void setPublished(String published) {
		this.published = published;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getHighlightText() {
		return highlightText;
	}

	public void setHighlightText(String highlightText) {
		this.highlightText = highlightText;
	}

	public String getHighlightTitle() {
		return highlightTitle;
	}

	public void setHighlightTitle(String highlightTitle) {
		this.highlightTitle = highlightTitle;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<String> getExternalLinks() {
		return externalLinks;
	}

	public void setExternalLinks(List<String> externalLinks) {
		this.externalLinks = externalLinks;
	}

	public Entities getEntities() {
		return entities;
	}

	public void setEntities(Entities entities) {
		this.entities = entities;
	}

	public Object getRating() {
		return rating;
	}

	public void setRating(Object rating) {
		this.rating = rating;
	}

	public String getCrawled() {
		return crawled;
	}

	public void setCrawled(String crawled) {
		this.crawled = crawled;
	}
}
