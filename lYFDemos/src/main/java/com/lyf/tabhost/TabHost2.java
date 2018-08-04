package com.lyf.tabhost;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;

import com.lyf.lyfdemos.R;

/**
 * <pre>
 * 使用我们自己的tabHost布局，不用继承TabActivity
 * 注意：
 *   TabWidget的id必须定义为：android:id="@android:id/tabs"，
 *   FrameLayout的id必须定义为：android:id="@android:id/tabcontent" 
 *   其它控件没有限制，否则报错。
 * </pre>
 * @author LYF
 */
public class TabHost2  extends Activity {  //不继承TabActivity
    private TabHost tabHost;  
  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.tabhost_tabhost2);  //填充含有TabHost的布局
        try{  
            tabHost = (TabHost) this.findViewById(R.id.TabHost01);  //找到TaHost容器
            tabHost.setup();  
            //添加选项
            tabHost.addTab(tabHost.newTabSpec("tab_1")  //选项详情对象
                    .setContent(R.id.LinearLayout1)  
                    .setIndicator("TAB1",this.getResources().getDrawable(R.drawable.ic_launcher)));  //选项标题和图标
            tabHost.addTab(tabHost.newTabSpec("tab_2")  
                    .setContent(R.id.LinearLayout2).setIndicator("TAB2",this.getResources().getDrawable(R.drawable.ic_launcher)));  
            tabHost.addTab(tabHost.newTabSpec("tab_3")  
                    .setContent(R.id.LinearLayout3).setIndicator("TAB3",  this.getResources().getDrawable(R.drawable.ic_launcher)));  
            tabHost.setCurrentTab(1);   //设置当前的选项
        }catch(Exception ex){  
            ex.printStackTrace();  
            Log.d("EXCEPTION", ex.getMessage());  
        }  
  
    } 
}
