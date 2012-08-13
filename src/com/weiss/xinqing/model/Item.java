package com.weiss.xinqing.model;

import java.io.Serializable;

public class Item implements Serializable, Comparable<Item> {
	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	protected int autoId;
	protected String url;

	public int getAutoId() {
		return autoId;
	}

	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int compareTo(Item o) {
		return new Integer(o.getAutoId()).compareTo(this.autoId);
	}
}
