package com.weiss.xinqing.model;

import java.util.ArrayList;
import java.util.List;

public class DailySubject extends Item {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private String showingDate;
	private List<SimplePicture> picList = new ArrayList<SimplePicture>();

	public String getShowingDate() {
		return showingDate;
	}

	public void setShowingDate(String showingDate) {
		this.showingDate = showingDate;
	}

	public boolean addPic(SimplePicture pic) {
		return picList.add(pic);
	}

	public List<SimplePicture> getPicList() {
		return picList;
	}

	public void setPicList(List<SimplePicture> picList) {
		this.picList = picList;
	}

	@Override
	public int getAutoId() {
		return autoId;
	}

	@Override
	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int compareTo(Item item) {
		DailySubject o = (DailySubject) item;
		return showingDate.compareToIgnoreCase(o.getShowingDate());
	}
}
