package com.lyf.tabhost;

import android.app.TabActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TextView;

import com.lyf.lyfdemos.R;

/**
 * 使用选项内容工厂，创建选项内容
 * 
 * @author LYF
 */
@SuppressWarnings("deprecation")
public class MyTabContentFactory extends TabActivity {
	static final String tag = "MyTabContentFactory";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TabHost tabHost = this.getTabHost(); // 得到选项卡对象
		// tabHost.addTab(tabHost.newTabSpec("tab标识ID").setIndicator("指示器 显示名字").setContent(显示的ID));
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("首页",this.getResources().getDrawable(R.drawable.ic_launcher)).setContent(new mTabContentFactory()));
		tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("我的",this.getResources().getDrawable(R.drawable.ic_launcher)).setContent(new mTabContentFactory()));
	}

	// 选项工厂用于创建 选项内容
	class mTabContentFactory implements TabContentFactory {
		@Override
		// 创建选项内容
		public View createTabContent(String tag) {
			Log.d("123", "参数tag===" + tag); // 来源newTabSpec(tag)的参数
			TextView tv = new TextView(MyTabContentFactory.this);
			tv.setText(tag);
			if (tag == "tab1") {
				tv.setText("===" + tag);
			}
			return tv;
		}
	}
}
