package com.weiss.xinqing.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.weiss.xinqing.model.Category;
import com.weiss.xinqing.model.PicturesWithTimestamp;
import com.weiss.xinqing.model.SimplePicture;

public class HttpclientUtil {

	private static final HttpClient httpclient = new DefaultHttpClient();

	private static String doPost(HttpEntity entity) throws ClientProtocolException, IOException {
		String content = null;
		HttpPost httppost = new HttpPost(Constant.SERVICE_SEARCH_URL);
		httppost.setEntity(entity);

		HttpResponse response = httpclient.execute(httppost);
		HttpEntity respEntity = response.getEntity();
		if (respEntity != null) {
			content = EntityUtils.toString(respEntity, "utf-8");
			respEntity.consumeContent();
		}
		return content;
	}

	public static PicturesWithTimestamp loadHotPictures() throws IOException {

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("params", ParamConstructor.getHotParamsForPic()));
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");

		String content = doPost(entity);
		String[] split = content.split(Constant.SEMICOLON);

		PicturesWithTimestamp result = new PicturesWithTimestamp();
		result.setTimestamp(Long.parseLong(split[0].substring(split[0].indexOf("=") + 1)));
		result.setPictureList(split[1]);

		return result;
	}

	public static PicturesWithTimestamp loadClassifyPictures() {
		return null;
	}

	public static List<SimplePicture> loadKeywordsPictures() {
		return null;
	}

	public static List<SimplePicture> loadMorePictures() {
		return null;
	}

	public static List<String> loadKeywords() {
		return null;
	}

	public static Category loadCategory() {
		return null;
	}

	public static void main(String[] args) {

	}
}
