package com.lyf.mainframework.activitygroup;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.lyf.lyfdemos.R;

public class OneFragmentActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.onefragmentactivity);
		
		//Ԥ����������
		mPreInit();
		//�ҿؼ�
		mFindViewById();  //doBack();
		//׼������
		mInitData();
		//��������������
		mSetAdapter();
		//���ø��ּ�����ҳ��䶯���� 
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
