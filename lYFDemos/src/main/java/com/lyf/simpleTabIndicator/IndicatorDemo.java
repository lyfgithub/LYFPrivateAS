package com.lyf.simpleTabIndicator;

import java.util.ArrayList;

//import com.lyf.lyftabindicator.R;


import com.lyf.lyfdemos.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class IndicatorDemo extends Activity implements OnClickListener {
	private Indicator mIndicator;
	private TextView mTabOne;
	private TextView mTabTwo;
	private TextView mTabThree;
	private TextView mTabFour;
	private ViewPager mContainer;
	
	private ArrayList<TextView> mViews = new ArrayList<TextView>(4);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.indicatordemo);
		
		mIndicator = (Indicator) findViewById(R.id.indicator);
		mContainer = (ViewPager) findViewById(R.id.container);
		
		mTabOne = (TextView) findViewById(R.id.tab_one);
		mTabTwo = (TextView) findViewById(R.id.tab_two);
		mTabThree = (TextView) findViewById(R.id.tab_three);
		mTabFour = (TextView) findViewById(R.id.tab_four);
		
		mTabOne.setOnClickListener(this);
		mTabTwo.setOnClickListener(this);
		mTabThree.setOnClickListener(this);
		mTabFour.setOnClickListener(this);
		
		initViews();
		mContainer.setAdapter(new PagerAdapter() {
			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}
			
			@Override
			public int getCount() {
				return mViews.size();
			}
			
			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				View view = mViews.get(position);
				container.addView(view);
				return view;
			}
			
			@Override
			public void destroyItem(ViewGroup container, int position,Object object) {
				container.removeView(mViews.get(position));
			}
		});
		
		mContainer.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
			}
			
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
				mIndicator.scroll(position, positionOffset);
			}
			
			@Override
			public void onPageScrollStateChanged(int position) {
				
			}
		});
	}
	
	private void initViews() {
		for(int i=0;i<4;i++) {
			TextView tv = new TextView(this);
			tv.setText("hello android" + i);
			mViews.add(tv);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tab_one:
			mContainer.setCurrentItem(0);
			break;
		case R.id.tab_two:
			mContainer.setCurrentItem(1);
			break;
		case R.id.tab_three:
			mContainer.setCurrentItem(2);
			break;
		case R.id.tab_four:
			mContainer.setCurrentItem(3);
			break;
		}
	}
}
