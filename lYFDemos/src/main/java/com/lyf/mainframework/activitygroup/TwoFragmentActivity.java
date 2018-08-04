package com.lyf.mainframework.activitygroup;

import com.lyf.lyfdemos.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class TwoFragmentActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.twofragmentactivity);
		
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
		// TODO Auto-generated method stub
		
	}

	private void mFindViewById() {
		// TODO Auto-generated method stub
		
	}

	private void mInitData() {
		// TODO Auto-generated method stub
		
	}

	private void mSetAdapter() {
		// TODO Auto-generated method stub
		
	}

	private void mListener() {
		// TODO Auto-generated method stub
		
	}
}
