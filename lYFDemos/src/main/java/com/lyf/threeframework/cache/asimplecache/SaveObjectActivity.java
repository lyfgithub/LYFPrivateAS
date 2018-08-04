package com.lyf.threeframework.cache.asimplecache;

import org.afinal.simplecache.ACache;

import com.lyf.lyfdemos.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * @ClassName: SaveObjectActivity
 * @Description: 缓存jsonobject
 * @Author Yoson Hao
 * @WebSite www.haoyuexing.cn
 * @Email haoyuexing@gmail.com
 * @Date 2013-8-8 下午2:13:16
 * 
 */
public class SaveObjectActivity extends Activity {

	private TextView mTv_object_original, mTv_object_res;
	private UserBean userBean;

	private ACache mCache;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.asimplecache_activity_save_object);
		// 初始化控�?
		initView();

		mCache = ACache.get(this);
		userBean = new UserBean();
		userBean.setAge("18");
		userBean.setName("HaoYoucai");
		mTv_object_original.setText(userBean.toString());
	}

	/**
	 * 初始化控�?
	 */
	private void initView() {
		mTv_object_original = (TextView) findViewById(R.id.tv_object_original);
		mTv_object_res = (TextView) findViewById(R.id.tv_object_res);
	}

	/**
	 * 点击save事件
	 * 
	 * @param v
	 */
	public void save(View v) {
		mCache.put("testObject", userBean);
	}

	/**
	 * 点击read事件
	 * 
	 * @param v
	 */
	public void read(View v) {
		UserBean testObject = (UserBean) mCache.getAsObject("testObject");
		if (testObject == null) {
			Toast.makeText(this, "Object cache is null ...", Toast.LENGTH_SHORT)
					.show();
			mTv_object_res.setText(null);
			return;
		}
		mTv_object_res.setText(testObject.toString());
	}

	/**
	 * 点击clear事件
	 * 
	 * @param v
	 */
	public void clear(View v) {
		mCache.remove("testObject");
	}
}
