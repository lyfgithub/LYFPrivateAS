package com.lyf.mainframework.activitygroup;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lyf.lyfdemos.R;

import java.util.ArrayList;
/**
 * <pre>
 * �������ܹ� demo 
 * ================================================================  
 * ��⣺
 * ActivityGroup����Ŷ��Activity(=FragmentActivity)
 * ÿ��Activity�������Fragment 
 * ******************************************************
 * Ӧ�ó�����
 * 1.����ṹ
 * 2.ģ��Ư����Tabhost
 */
@SuppressWarnings("deprecation")
public class MyActivityGroup2 extends ActivityGroup{
	String tag="MyActivityGroup2";
	
	//=============
	private ViewPager vp_main;
	ArrayList<View> arrayList_Views =new ArrayList<View>();
	
	//====tab=========
	private LinearLayout ll_tab1;
	private ImageView iv_tab1;
	private TextView tv_tab1;
	private LinearLayout ll_tab2;
	private ImageView iv_tab2;
	private TextView tv_tab2;
	private LinearLayout ll_tab3;
	private ImageView iv_tab3;
	private TextView tv_tab3;
	//=================
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myactivitygroup2);
		
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
	
	/** �ҿؼ� */
	private void mFindViewById() {
		vp_main = (ViewPager) findViewById(R.id.vp_main);
	    //tab1
		ll_tab1 = (LinearLayout) findViewById(R.id.ll_tab1);
		iv_tab1 = (ImageView) findViewById(R.id.iv_tab1);
		tv_tab1 = (TextView) findViewById(R.id.tv_tab1);
	    //tab2
		ll_tab2 = (LinearLayout) findViewById(R.id.ll_tab2);
		iv_tab2 = (ImageView) findViewById(R.id.iv_tab2);
		tv_tab2 = (TextView) findViewById(R.id.tv_tab2);
	    //tab3		
		ll_tab3 = (LinearLayout) findViewById(R.id.ll_tab3);
		iv_tab3 = (ImageView) findViewById(R.id.iv_tab3);
		tv_tab3 = (TextView) findViewById(R.id.tv_tab3);
	}
	
	private void mInitData() {
		//�õ����ص�Activity�����ߣ�������activity���ڵõ�activity�е���ͼ
		View v1=getLocalActivityManager().startActivity("OneFragmentActivity", new Intent(this,OneFragmentActivity.class)).getDecorView();
		View v2=getLocalActivityManager().startActivity("TwoFragmentActivity", new Intent(this,TwoFragmentActivity.class)).getDecorView();
	    View v3=getLocalActivityManager().startActivity("ThreeFragmentActivity", new Intent(this,ThreeFragmentActivity.class)).getDecorView();
	
	    //����ͼ��ӵ�����
	    arrayList_Views.add(v1);
	    arrayList_Views.add(v2);
	    arrayList_Views.add(v3);
	
	    //Ĭ��ѡ��tab1
	    setSelectStyle(0);
	}
	private void mSetAdapter() {
		vp_main.setAdapter(new MyPagerAdapter());  //����ViewPager�������������Ϳ���ʾ
	}
	private void mListener() {
		//����tab�������
		ll_tab1.setOnClickListener(new MyOnClickListenerTab());
		iv_tab1.setOnClickListener(new MyOnClickListenerTab());
		tv_tab1.setOnClickListener(new MyOnClickListenerTab());
		
		ll_tab2.setOnClickListener(new MyOnClickListenerTab());
		iv_tab2.setOnClickListener(new MyOnClickListenerTab());
		tv_tab2.setOnClickListener(new MyOnClickListenerTab());
		
		ll_tab3.setOnClickListener(new MyOnClickListenerTab());
		iv_tab3.setOnClickListener(new MyOnClickListenerTab());
		tv_tab3.setOnClickListener(new MyOnClickListenerTab());
		
		//����viewpagerҳ��ı����
		vp_main.setOnPageChangeListener(new MyOnPageChangeListener());
	}
	
	/** ViewPager���������� */
	class MyPagerAdapter extends android.support.v4.view.PagerAdapter{
		@Override 
		public int getCount() {
			return arrayList_Views.size();
		}
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0==arg1;
		}

		//����viewʱ�ص�
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			//super.destroyItem(container, position, object);  //��ɾ���쳣java.lang.UnsupportedOperationException: Required method destroyItem was not overridden
			//�����Ƿǳ�����д��ĵط�
			
			//��ϵͳ�������Ƴ�ָ��λ�õ�View
			//((ViewPager)container).removeViewAt(position);   //д�����쳣java.lang.IllegalStateException: The specified child already has a parent. You must call removeView() on the child's parent first.
			((ViewPager)container).removeView(arrayList_Views.get(position));
			
		}

		//ʵ����Viewʱ�ص�
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			View v= arrayList_Views.get(position);//����ϵͳ����λ�ã������ǵ����ݼ������ҳ�һ����ͼ��ϵͳ��ʾ
			((ViewPager)container).addView(v);    //������ָ������View����ϵͳ��������
			return v;
		}
	}
	
	//tab������� 
	class MyOnClickListenerTab implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.ll_tab1:
			case R.id.iv_tab1:
			case R.id.tv_tab1:
				vp_main.setCurrentItem(0);
				setSelectStyle(0);
				break;
			case R.id.ll_tab2:
			case R.id.iv_tab2:
			case R.id.tv_tab2:
				vp_main.setCurrentItem(1);
				setSelectStyle(1);
				break;
			case R.id.ll_tab3:
			case R.id.iv_tab3:
			case R.id.tv_tab3:
				vp_main.setCurrentItem(2);
				setSelectStyle(2);
				break;

			default:
				break;
			}
		}
		
	}
	
	/** ҳ��䶯���� */
	class MyOnPageChangeListener implements OnPageChangeListener{
		@Override
		public void onPageScrollStateChanged(int arg0) {
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			
		}

		//��ҳ��ѡ��֮�����
		@Override
		public void onPageSelected(int position) {
			setSelectStyle(position);
		}
		
	}
	
	/** ����tabѡ��֮�����ʽ */
	private void setSelectStyle(int position){
		//��ԭ��ʼ��ʽ
		ll_tab1.setBackgroundColor(0xFFFFFFFF);
		ll_tab2.setBackgroundColor(0xFFFFFFFF);
		ll_tab3.setBackgroundColor(0xFFFFFFFF);
		//�ı�ָ��tab����ʽ
		switch (position) {
		case 0:
			ll_tab1.setBackgroundColor(0x33000000);
			break;   
		case 1:
			ll_tab2.setBackgroundColor(0x33000000);
			break;
		case 2:
			ll_tab3.setBackgroundColor(0x33000000);
			break;
		default:
			break;
		}
	}
	
	
	
}
