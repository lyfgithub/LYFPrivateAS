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
 * ʹ��ѡ�����ݹ���������ѡ������
 * 
 * @author LYF
 */
@SuppressWarnings("deprecation")
public class MyTabContentFactory extends TabActivity {
	static final String tag = "MyTabContentFactory";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TabHost tabHost = this.getTabHost(); // �õ�ѡ�����
		// tabHost.addTab(tabHost.newTabSpec("tab��ʶID").setIndicator("ָʾ�� ��ʾ����").setContent(��ʾ��ID));
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("��ҳ",this.getResources().getDrawable(R.drawable.ic_launcher)).setContent(new mTabContentFactory()));
		tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("�ҵ�",this.getResources().getDrawable(R.drawable.ic_launcher)).setContent(new mTabContentFactory()));
	}

	// ѡ������ڴ��� ѡ������
	class mTabContentFactory implements TabContentFactory {
		@Override
		// ����ѡ������
		public View createTabContent(String tag) {
			Log.d("123", "����tag===" + tag); // ��ԴnewTabSpec(tag)�Ĳ���
			TextView tv = new TextView(MyTabContentFactory.this);
			tv.setText(tag);
			if (tag == "tab1") {
				tv.setText("===" + tag);
			}
			return tv;
		}
	}
}
