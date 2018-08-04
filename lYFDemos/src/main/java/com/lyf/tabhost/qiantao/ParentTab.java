package com.lyf.tabhost.qiantao;

import com.lyf.lyfdemos.R;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

/**Ò»¼¶Tab*/
@SuppressWarnings("deprecation")
public class ParentTab extends TabActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    findViewById(R.layout.qiantao_tab_parent);
	    TabHost tabHost=this.getTabHost();
	    
	    tabHost.addTab(tabHost.newTabSpec("p1")
	    		.setIndicator("p1",this.getResources().getDrawable(android.R.drawable.arrow_down_float))
	    		.setContent(new Intent(ParentTab.this, SubTab.class)));
	    tabHost.addTab(tabHost.newTabSpec("p2")
	    		.setIndicator("p2",this.getResources().getDrawable(android.R.drawable.btn_star))
	    		.setContent(new Intent(ParentTab.this,NormalActivity.class)));
	    
	    tabHost.setCurrentTab(0);
	}
}
