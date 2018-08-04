package com.lyf.tabhost.qiantao;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.lyf.lyfdemos.R;

public class SubTab extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.setContentView(R.layout.qiantao_subtab); //子tab布局
		TabHost tabHost= (TabHost) findViewById(R.id.SubTabHost);  //得到容器TabHost
		tabHost.setup(); 
		tabHost.addTab(tabHost.newTabSpec("sub1").setIndicator("sub1").setContent(R.id.sub1));
		tabHost.addTab(tabHost.newTabSpec("sub2").setIndicator("sub2").setContent(R.id.sub2));
		tabHost.addTab(tabHost.newTabSpec("sub3").setIndicator("sub3").setContent(R.id.sub3));
		tabHost.setCurrentTab(0);
		
		//处理子标题
		TabWidget tabWidget= tabHost.getTabWidget();
		for (int i = 0; i < tabWidget.getChildCount(); i++) {
		    tabWidget.getChildAt(i).getLayoutParams().height=80;
		    TextView textView=	(TextView)(tabWidget.getChildAt(i)).findViewById(android.R.id.title);  //android.R.id.title 系统id
		    textView.setTextColor(this.getResources().getColorStateList(android.R.color.holo_green_dark));
		}
	}
}
