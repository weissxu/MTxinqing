package com.weiss.xinqing.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	public static class SubCategory implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int subCatId;
		private boolean hot;
		private Category superCat;
		private String subCatName;
		private String param;
		private String searchValue;
		private String picUrl;
		private String info;

		public SubCategory() {
		}

		public SubCategory(int subCatId, String subCatName, String param, String searchValue, String picUrl) {
			super();
			this.subCatId = subCatId;
			this.subCatName = subCatName;
			this.param = param;
			this.searchValue = searchValue;
			this.picUrl = picUrl;
		}

		public boolean isHot() {
			return hot;
		}

		public void setHot(boolean hot) {
			this.hot = hot;
		}

		public Category getSuperCat() {
			return superCat;
		}

		public void setSuperCat(Category superCat) {
			this.superCat = superCat;
		}

		public int getSubCatId() {
			return subCatId;
		}

		public void setSubCatId(int subCatId) {
			this.subCatId = subCatId;
		}

		public String getSubCatName() {
			return subCatName;
		}

		public void setSubCatName(String subCatName) {
			this.subCatName = subCatName;
		}

		public String getParam() {
			return param;
		}

		public void setParam(String param) {
			this.param = param;
		}

		public String getSearchValue() {
			return searchValue;
		}

		public void setSearchValue(String searchValue) {
			this.searchValue = searchValue;
		}

		public String getPicUrl() {
			return picUrl;
		}

		public void setPicUrl(String picUrl) {
			this.picUrl = picUrl;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + subCatId;
			result = prime * result + ((superCat == null) ? 0 : superCat.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SubCategory other = (SubCategory) obj;
			if (subCatId != other.subCatId)
				return false;
			if (superCat == null) {
				if (other.superCat != null)
					return false;
			} else if (!superCat.equals(other.superCat))
				return false;
			return true;
		}

	}

	private int catId;
	private String catName;
	private String info;
	private List<SubCategory> subCats = new ArrayList<SubCategory>();
	private String picUrl;

	public Category() {
	}

	public Category(int catId, String catName) {
		super();
		this.catId = catId;
		this.catName = catName;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<SubCategory> getSubCats() {
		return subCats;
	}

	public void setSubCats(List<SubCategory> subCats) {
		this.subCats = subCats;
	}

	public void addSubCat(SubCategory subCat) {
		subCats.add(subCat);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + catId;
		result = prime * result;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (catId != other.catId)
			return false;
		return true;
	}
}
