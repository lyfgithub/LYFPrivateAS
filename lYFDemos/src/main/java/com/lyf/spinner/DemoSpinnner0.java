package com.lyf.spinner;

import android.app.Activity;
import android.os.Bundle;

import com.lyf.lyfdemos.R;

/**
 * <pre>
 * 下拉列表  
 *    注意1.android:theme="@style/AppTheme" 需要使用的是系统默认主题，下拉控件右下角显示为斜三角(好看)，
 *    如果程序的主题被修改为android:theme="@android:style/Theme.NoTitleBar"则下拉控件右边显示为倒三角(较丑)
 * </pre>
 * @author LYF
 *
 */
public class DemoSpinnner0 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo_spinnner);
	}


}
