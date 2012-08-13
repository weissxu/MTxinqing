package com.weiss.xinqing.activity;

import java.io.IOException;
import java.net.URL;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.weiss.xinqing.R;
import com.weiss.xinqing.model.PicturesWithTimestamp;
import com.weiss.xinqing.model.SimplePicture;
import com.weiss.xinqing.util.HttpclientUtil;

public class MainActivity extends Activity implements OnClickListener {
	private PicturesWithTimestamp picsWithTimestamp;

	private GridView gv_hot_content;
	private GridView gv_store_content;
	private GridView gv_keywords;
	private ListView lv_classify_content;
	private LinearLayout ll_search;
	private LinearLayout ll_setting;

	private ImageButton ib_hot;
	private ImageButton ib_classify;
	private ImageButton ib_search;
	private ImageButton ib_store;
	private ImageButton ib_setting;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initWidget();
		initPicturesWithTimestamp();
		gv_hot_content.setAdapter(new PictureAdapter());
	}

	private void initPicturesWithTimestamp() {
		try {
			picsWithTimestamp = HttpclientUtil.loadHotPictures();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initWidget() {
		gv_hot_content = (GridView) findViewById(R.id.gv_hot_content);
		gv_store_content = (GridView) findViewById(R.id.gv_stroe_content);
		gv_keywords = (GridView) findViewById(R.id.gv_keywords);
		lv_classify_content = (ListView) findViewById(R.id.lv_classify_content);
		ll_search = (LinearLayout) findViewById(R.id.ll_search);
		ll_setting = (LinearLayout) findViewById(R.id.ll_setting);

		ib_hot = (ImageButton) findViewById(R.id.ib_hot);
		ib_classify = (ImageButton) findViewById(R.id.ib_classify);
		ib_search = (ImageButton) findViewById(R.id.ib_search);
		ib_store = (ImageButton) findViewById(R.id.ib_store);
		ib_setting = (ImageButton) findViewById(R.id.ib_setting);

		ib_hot.setOnClickListener(this);
		ib_classify.setOnClickListener(this);
		ib_search.setOnClickListener(this);
		ib_store.setOnClickListener(this);
		ib_setting.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		setAllGone();

		int id = v.getId();
		switch (id) {
		case R.id.ib_hot:
			gv_hot_content.setVisibility(View.VISIBLE);
			break;
		case R.id.ib_classify:
			lv_classify_content.setVisibility(View.VISIBLE);
			break;
		case R.id.ib_search:
			ll_search.setVisibility(View.VISIBLE);
			break;
		case R.id.ib_store:
			gv_store_content.setVisibility(View.VISIBLE);
			break;
		case R.id.ib_setting:
			ll_setting.setVisibility(View.VISIBLE);
			break;
		default:
			break;
		}

	}

	private void setAllGone() {
		gv_hot_content.setVisibility(View.GONE);
		gv_store_content.setVisibility(View.GONE);
		lv_classify_content.setVisibility(View.GONE);
		ll_search.setVisibility(View.GONE);
		ll_setting.setVisibility(View.GONE);
	}

	class PictureAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return 50;
		}

		@Override
		public Object getItem(int position) {
			return picsWithTimestamp.getPictureList().get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			SimplePicture picture = picsWithTimestamp.getPictureList().get(position);
			ImageView view = new ImageView(MainActivity.this);
			try {
				view.setImageBitmap(BitmapFactory.decodeStream(new URL(picture.getUrl()).openStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			// view.setLayoutParams(new LayoutParams(150, 150));

			// LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
			// View view = inflater.inflate(R.layout.gv_item_picture, null);
			// ImageView image = (ImageView)
			// view.findViewById(R.id.iv_item_picture);
			// image.setImageURI(Uri.parse(picture.getUrl()));
			return view;
		}

	}
}
