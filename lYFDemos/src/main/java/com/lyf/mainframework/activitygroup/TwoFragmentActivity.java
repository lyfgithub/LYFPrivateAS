package com.lyf.mainframework.activitygroup;

import com.lyf.lyfdemos.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class TwoFragmentActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.twofragmentactivity);
		
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
