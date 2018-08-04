package com.lyf.mainframework.activitygroup;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.lyf.lyfdemos.R;

public class OneFragmentActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.onefragmentactivity);
		
		//预先请求数据
		mPreInit();
		//找控件
		mFindViewById();  //doBack();
		//准备数据
		mInitData();
		//设置数据适配器
		mSetAdapter();
		//设置各种监听、页面变动监听 
		mListener();
	}

	private void mPreInit() {
		
	}

	private void mFindViewById() {
		
	}

	private void mInitData() {
		
	}

	private void mSetAdapter() {
		
	}

	private void mListener() {
		
	}
}
