package com.lyf.spinner;

import java.util.ArrayList;
import java.util.List;

import com.lyf.lyfdemos.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * <pre>
 * 下拉列表  
 *    http://blog.csdn.net/badboy007/article/details/19034609
 *    修改Spinner的显示及下拉样式，先可以分为Spinner控件被加载前的静态设置和加载后的动态设置两类。
 *    加载前的静态设置也可以分成两种:
 *    一种（后文称A方法）就是最简单、最直接地在Layout的xml文件中设置属性值；
 *    另外一种（后文称B方法）就是先设计好Spinner将要使用的显示和下拉样式（XML文件），在生成Spinner将要加载的Adapter后，将XML文件指定给Adapter使用（如果不指定，Adapter将自动使用系统默认样式）。
 *    所谓加载后的动态设置也可以分成两种:
 *    一种（后文称C方法）是自己编写Spinner将要加载的Adapter类，在自己的Adapter类方法中动态修改显示和下拉样式；
 *    另外一种（后文称D方法）就是直接在Spinner的事件中修改显示和下拉样式。
 * </pre>
 * @author LYF
 */
public class DemoSpinnner2 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo_spinnner2);
		
		spinner2();  
	}
	
	
	/**
	 * <pre>
	 * 采用自定义xml显示spinner样式和自定义xml显示弹出框样式
	 * 注意：spinner_display_style.xml和spinner_dropdown_style.xml中的TextView必须使用相同的名称，否则，系统会因为找不到TextView控件而抛出java.lang.NullPointerException错误！
	 * </pre> 
	 */
	private void spinner2(){
		Spinner mySpinnerB= (Spinner) findViewById(R.id.mySpinnerB);
		List<String> spinnerList = GetList();
		ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,
				R.layout.spinner_display_style,     //使用自定义的xml显示spinner界面
				R.id.txtvwSpinner,                  
				spinnerList
		);
		myAdapter.setDropDownViewResource(R.layout.spinner_dropdown_style);  //使用自定义的xml显示 弹出界面
		mySpinnerB.setAdapter(myAdapter);
		
	}
	
	
	/** 创建数据 */
	public static List<String> GetList() {
		List<String> list = new ArrayList<String>();
		list.add("0");
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("8");
		list.add("9");
		return list;
	}
	


}
