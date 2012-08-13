package com.weiss.xinqing.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PicturesWithTimestamp {
	private long timestamp;
	private List<SimplePicture> pictureList;

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public List<SimplePicture> getPictureList() {
		return pictureList;
	}

	public void setPictureList(List<SimplePicture> pictureList) {
		this.pictureList = pictureList;
	}

	public void setPictureList(String jsonStr) {
		this.pictureList = new ArrayList<SimplePicture>();
		try {
			JSONArray jsonArray = new JSONArray(jsonStr);
			int size = jsonArray.length();
			for (int i = 0; i < size; i++) {
				JSONObject object = (JSONObject) jsonArray.get(i);
				SimplePicture picture = new SimplePicture();
				picture.setAutoId(object.getInt("autoId"));
				picture.setUrl(object.getString("url"));
				picture.setLargeUrl(object.getString("largeUrl"));
				this.pictureList.add(picture);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
