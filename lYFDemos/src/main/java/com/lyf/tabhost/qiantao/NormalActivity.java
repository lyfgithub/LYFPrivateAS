package com.lyf.tabhost.qiantao;

import com.lyf.lyfdemos.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NormalActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.qiantao_normalactivity);
	}
	
	
	public View createView(){
		LinearLayout ll=new LinearLayout(this);
		ll.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
		
		TextView tv=new TextView(this);
		tv.setText("NormalActivity");
		
		ll.addView(ll);
		return ll;
	}
}
