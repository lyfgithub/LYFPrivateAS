package com.lyf.tabhost;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

import com.lyf.lyfdemos.R;

/**
 * 继承TabActivity，使用系统的TabHost布局
 * @author LYF
 * 
 */
@SuppressWarnings("deprecation")
public class MyTabActivity extends TabActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 得到选项卡
		TabHost tabHost = this.getTabHost();
		// 向选项卡内容视图中填充布局View
		LayoutInflater.from(this).inflate(R.layout.mytabactivity,tabHost.getTabContentView());
		// 选项卡.添加选项
		// tabHost.addTab(tabHost.newTabSpec("tab标识ID").setIndicator("指示器 显示名字").setContent(显示的ID));
		tabHost.addTab(tabHost.newTabSpec("tag1").setIndicator("首页").setContent(R.id.tv_tabView1));
		tabHost.addTab(tabHost.newTabSpec("tag2").setIndicator("第二页").setContent(R.id.tv_tabView2));
		tabHost.addTab(tabHost.newTabSpec("tag3").setIndicator("我的").setContent(R.id.tv_tabView3));

		//=======================================================
		//设置默认页
		tabHost.setCurrentTab(1);  
		//设置背景色
		tabHost.setBackgroundColor(Color.GRAY);
		//设置tab改变监听
		tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
			public void onTabChanged(String tabId) {
				Dialog dialog = new AlertDialog.Builder(MyTabActivity.this)
						.setTitle("提示")  
						.setMessage("选中了" + tabId + "选项卡")
						.setIcon(R.drawable.ic_launcher)
						.setPositiveButton("确定",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,int which) {  }
								}
						)
						.create();
				dialog.show();
			}
		});
	}
}
