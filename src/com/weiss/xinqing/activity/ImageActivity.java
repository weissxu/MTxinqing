package com.weiss.xinqing.activity;

import java.io.IOException;
import java.net.URL;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.weiss.xinqing.R;

public class ImageActivity extends Activity {
	private ImageView iv_large_picture;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.picture);
		iv_large_picture = (ImageView) findViewById(R.id.iv_large_picture);
		try {
			iv_large_picture.setImageBitmap(BitmapFactory.decodeStream(new URL(
					"http://i11.topit.me/l/201004/04/12703348928667.jpg").openStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
