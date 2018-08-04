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
 * 程序主架构 demo 
 * ================================================================  
 * 理解：
 * ActivityGroup里面放多个Activity(=FragmentActivity)
 * 每个Activity包含多个Fragment 
 * ******************************************************
 * 应用场景：
 * 1.搭建主结构
 * 2.模拟漂亮的Tabhost
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
	
	/** 找控件 */
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
		//得到本地的Activity管理者，并启动activity，在得到activity中的视图
		View v1=getLocalActivityManager().startActivity("OneFragmentActivity", new Intent(this,OneFragmentActivity.class)).getDecorView();
		View v2=getLocalActivityManager().startActivity("TwoFragmentActivity", new Intent(this,TwoFragmentActivity.class)).getDecorView();
	    View v3=getLocalActivityManager().startActivity("ThreeFragmentActivity", new Intent(this,ThreeFragmentActivity.class)).getDecorView();
	
	    //将视图添加到集合
	    arrayList_Views.add(v1);
	    arrayList_Views.add(v2);
	    arrayList_Views.add(v3);
	
	    //默认选中tab1
	    setSelectStyle(0);
	}
	private void mSetAdapter() {
		vp_main.setAdapter(new MyPagerAdapter());  //设置ViewPager数据适配器，就可显示
	}
	private void mListener() {
		//设置tab点击监听
		ll_tab1.setOnClickListener(new MyOnClickListenerTab());
		iv_tab1.setOnClickListener(new MyOnClickListenerTab());
		tv_tab1.setOnClickListener(new MyOnClickListenerTab());
		
		ll_tab2.setOnClickListener(new MyOnClickListenerTab());
		iv_tab2.setOnClickListener(new MyOnClickListenerTab());
		tv_tab2.setOnClickListener(new MyOnClickListenerTab());
		
		ll_tab3.setOnClickListener(new MyOnClickListenerTab());
		iv_tab3.setOnClickListener(new MyOnClickListenerTab());
		tv_tab3.setOnClickListener(new MyOnClickListenerTab());
		
		//设置viewpager页面改变监听
		vp_main.setOnPageChangeListener(new MyOnPageChangeListener());
	}
	
	/** ViewPager数据适配器 */
	class MyPagerAdapter extends android.support.v4.view.PagerAdapter{
		@Override 
		public int getCount() {
			return arrayList_Views.size();
		}
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0==arg1;
		}

		//销毁view时回调
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			//super.destroyItem(container, position, object);  //不删有异常java.lang.UnsupportedOperationException: Required method destroyItem was not overridden
			//这里是非常容易写错的地方
			
			//从系统容器中移除指定位置的View
			//((ViewPager)container).removeViewAt(position);   //写法有异常java.lang.IllegalStateException: The specified child already has a parent. You must call removeView() on the child's parent first.
			((ViewPager)container).removeView(arrayList_Views.get(position));
			
		}

		//实例化View时回调
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			View v= arrayList_Views.get(position);//根据系统给的位置，在我们的数据集合中找出一个视图给系统显示
			((ViewPager)container).addView(v);    //将我们指定的子View交给系统的容器中
			return v;
		}
	}
	
	//tab点击监听 
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
	
	/** 页面变动监听 */
	class MyOnPageChangeListener implements OnPageChangeListener{
		@Override
		public void onPageScrollStateChanged(int arg0) {
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			
		}

		//当页面选中之后调用
		@Override
		public void onPageSelected(int position) {
			setSelectStyle(position);
		}
		
	}
	
	/** 设置tab选中之后的样式 */
	private void setSelectStyle(int position){
		//还原初始样式
		ll_tab1.setBackgroundColor(0xFFFFFFFF);
		ll_tab2.setBackgroundColor(0xFFFFFFFF);
		ll_tab3.setBackgroundColor(0xFFFFFFFF);
		//改变指定tab的样式
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
