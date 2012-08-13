package com.weiss.xinqing;

import java.io.IOException;

import android.test.AndroidTestCase;

import com.weiss.xinqing.model.PicturesWithTimestamp;
import com.weiss.xinqing.util.HttpclientUtil;

public class HttpclientTest extends AndroidTestCase {
	public void testLoadHot() throws IOException {
		PicturesWithTimestamp loadHotPictures = HttpclientUtil.loadHotPictures();
		System.out.println("timastamp: " + loadHotPictures.getTimestamp());
		System.out.println("size: " + loadHotPictures.getPictureList().size());
	}
}
