package com.lyf.tabhost;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;

import com.lyf.lyfdemos.R;

/**
 * <pre>
 * ʹ�������Լ���tabHost���֣����ü̳�TabActivity
 * ע�⣺
 *   TabWidget��id���붨��Ϊ��android:id="@android:id/tabs"��
 *   FrameLayout��id���붨��Ϊ��android:id="@android:id/tabcontent" 
 *   �����ؼ�û�����ƣ����򱨴�
 * </pre>
 * @author LYF
 */
public class TabHost2  extends Activity {  //���̳�TabActivity
    private TabHost tabHost;  
  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.tabhost_tabhost2);  //��京��TabHost�Ĳ���
        try{  
            tabHost = (TabHost) this.findViewById(R.id.TabHost01);  //�ҵ�TaHost����
            tabHost.setup();  
            //���ѡ��
            tabHost.addTab(tabHost.newTabSpec("tab_1")  //ѡ���������
                    .setContent(R.id.LinearLayout1)  
                    .setIndicator("TAB1",this.getResources().getDrawable(R.drawable.ic_launcher)));  //ѡ������ͼ��
            tabHost.addTab(tabHost.newTabSpec("tab_2")  
                    .setContent(R.id.LinearLayout2).setIndicator("TAB2",this.getResources().getDrawable(R.drawable.ic_launcher)));  
            tabHost.addTab(tabHost.newTabSpec("tab_3")  
                    .setContent(R.id.LinearLayout3).setIndicator("TAB3",  this.getResources().getDrawable(R.drawable.ic_launcher)));  
            tabHost.setCurrentTab(1);   //���õ�ǰ��ѡ��
        }catch(Exception ex){  
            ex.printStackTrace();  
            Log.d("EXCEPTION", ex.getMessage());  
        }  
  
    } 
}
