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
 * �̳�TabActivity��ʹ��ϵͳ��TabHost����
 * @author LYF
 * 
 */
@SuppressWarnings("deprecation")
public class MyTabActivity extends TabActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// �õ�ѡ�
		TabHost tabHost = this.getTabHost();
		// ��ѡ�������ͼ����䲼��View
		LayoutInflater.from(this).inflate(R.layout.mytabactivity,tabHost.getTabContentView());
		// ѡ�.���ѡ��
		// tabHost.addTab(tabHost.newTabSpec("tab��ʶID").setIndicator("ָʾ�� ��ʾ����").setContent(��ʾ��ID));
		tabHost.addTab(tabHost.newTabSpec("tag1").setIndicator("��ҳ").setContent(R.id.tv_tabView1));
		tabHost.addTab(tabHost.newTabSpec("tag2").setIndicator("�ڶ�ҳ").setContent(R.id.tv_tabView2));
		tabHost.addTab(tabHost.newTabSpec("tag3").setIndicator("�ҵ�").setContent(R.id.tv_tabView3));

		//=======================================================
		//����Ĭ��ҳ
		tabHost.setCurrentTab(1);  
		//���ñ���ɫ
		tabHost.setBackgroundColor(Color.GRAY);
		//����tab�ı����
		tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
			public void onTabChanged(String tabId) {
				Dialog dialog = new AlertDialog.Builder(MyTabActivity.this)
						.setTitle("��ʾ")  
						.setMessage("ѡ����" + tabId + "ѡ�")
						.setIcon(R.drawable.ic_launcher)
						.setPositiveButton("ȷ��",
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
