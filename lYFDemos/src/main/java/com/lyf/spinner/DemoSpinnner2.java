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
 * �����б�  
 *    http://blog.csdn.net/badboy007/article/details/19034609
 *    �޸�Spinner����ʾ��������ʽ���ȿ��Է�ΪSpinner�ؼ�������ǰ�ľ�̬���úͼ��غ�Ķ�̬�������ࡣ
 *    ����ǰ�ľ�̬����Ҳ���Էֳ�����:
 *    һ�֣����ĳ�A������������򵥡���ֱ�ӵ���Layout��xml�ļ�����������ֵ��
 *    ����һ�֣����ĳ�B��������������ƺ�Spinner��Ҫʹ�õ���ʾ��������ʽ��XML�ļ�����������Spinner��Ҫ���ص�Adapter�󣬽�XML�ļ�ָ����Adapterʹ�ã������ָ����Adapter���Զ�ʹ��ϵͳĬ����ʽ����
 *    ��ν���غ�Ķ�̬����Ҳ���Էֳ�����:
 *    һ�֣����ĳ�C���������Լ���дSpinner��Ҫ���ص�Adapter�࣬���Լ���Adapter�෽���ж�̬�޸���ʾ��������ʽ��
 *    ����һ�֣����ĳ�D����������ֱ����Spinner���¼����޸���ʾ��������ʽ��
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
	 * �����Զ���xml��ʾspinner��ʽ���Զ���xml��ʾ��������ʽ
	 * ע�⣺spinner_display_style.xml��spinner_dropdown_style.xml�е�TextView����ʹ����ͬ�����ƣ�����ϵͳ����Ϊ�Ҳ���TextView�ؼ����׳�java.lang.NullPointerException����
	 * </pre> 
	 */
	private void spinner2(){
		Spinner mySpinnerB= (Spinner) findViewById(R.id.mySpinnerB);
		List<String> spinnerList = GetList();
		ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,
				R.layout.spinner_display_style,     //ʹ���Զ����xml��ʾspinner����
				R.id.txtvwSpinner,                  
				spinnerList
		);
		myAdapter.setDropDownViewResource(R.layout.spinner_dropdown_style);  //ʹ���Զ����xml��ʾ ��������
		mySpinnerB.setAdapter(myAdapter);
		
	}
	
	
	/** �������� */
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
