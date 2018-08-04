package com.lyf.webview.js;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebView;
import android.widget.Button;

import com.lyf.lyfdemos.R;

/**
 * <pre>
 * java代码调用js
 * 步骤：
 *   1.在程序中调用js代码，只需要将webview控件的支持js的属性设置为true
 *   2.使用WebView对象.loadUrl("javascript:js方法名()");
 * @author LYF
 * </pre>
 */
public class JavaCallJs extends Activity {
	WebView mWebView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.javacalljs);
		
		javaCallJs1();
	}
	
	@SuppressLint("SetJavaScriptEnabled")
	public void javaCallJs1(){
		mWebView =(WebView) findViewById(R.id.WV1);
		Button btn_javaCalljs = (Button) findViewById(R.id.Btn_javaCalljs);
		Button btn_javaCalljs2 = (Button) findViewById(R.id.Btn_javaCalljs2);
		
		mWebView.getSettings().setDefaultTextEncodingName("UTF-8");    
		// 支持js
		mWebView.getSettings().setJavaScriptEnabled(true);
		
		// 载入js
		mWebView.loadUrl("file:///android_asset/javacalljs.html"); 
		//mWebView.loadData("", "text/html; charset=UTF-8", null); // 这种写法可以正确解码

		// 点击调用js中方法
		btn_javaCalljs.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 执行js方法
				mWebView.loadUrl("javascript:javaCallJs1()");
			}
		});
		
		
		btn_javaCalljs2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 执行js方法
				mWebView.loadUrl("javascript:javaCallJs2('lyf')");
			}
		});
	}
	
	
	/** WebView设置 */
	@SuppressWarnings("deprecation")
	@SuppressLint("SetJavaScriptEnabled") 
	private void myWebViewSet(){
        //WebView设置
		mWebView.getSettings().setJavaScriptEnabled(true);  //支持js
		mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);   //LYF滚动条样式
		mWebView.setHorizontalScrollBarEnabled(false);   //LYF设置水平滚动条是否可用  
//        wrapperContent.setHorizontalScrollbarOverlay(true);   //获取水平滚动条是否有叠加样式
		mWebView.setVerticalScrollbarOverlay(true); //指定的垂直滚动条有叠加样式
//        wrapperContent.setInitialScale(100);  //初始化时的缩放
		
		//WebSettings设置
		WebSettings settings = mWebView.getSettings();
		settings.setJavaScriptEnabled(true);//支持js
		settings.setSupportZoom(true);  //支持缩放 
		settings.setBuiltInZoomControls(false); //设置是否显示缩放按钮
        //自适应屏幕大小
		settings.setUseWideViewPort(true);  //设置此属性，可任意比例缩放
		settings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
		//settings.setPluginsEnabled(true);  //支持插件 
		settings.setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS); //支持内容重新布局  
		//settings.supportMultipleWindows();  //多窗口 
		//settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);  //关闭webview中缓存 
		//settings.setAllowFileAccess(true);  //设置可以访问文件 
		settings.setNeedInitialFocus(false); //当webview调用requestFocus时为webview设置节点
		settings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口 
		settings.setLoadsImagesAutomatically(true);  //支持自动加载图片
		
        //在同种分辨率的情况下,屏幕密度不一样的情况下,自动适配页面: 
        DisplayMetrics dm = getResources().getDisplayMetrics();  
        int scale = dm.densityDpi; 
        if (scale == 120) {  
        	mWebView.getSettings().setDefaultZoom(ZoomDensity.CLOSE);  
        }
        else if (scale == 160) {  
        	mWebView.getSettings().setDefaultZoom(ZoomDensity.MEDIUM);  
        }
        else if (scale == 240) { //   
        	mWebView.getSettings().setDefaultZoom(ZoomDensity.FAR);  
        } 
        else {  
        	mWebView.getSettings().setDefaultZoom(ZoomDensity.FAR); 
        }  
        switch (scale) {
		case DisplayMetrics.DENSITY_LOW:   
			mWebView.getSettings().setDefaultZoom(ZoomDensity.CLOSE); 
			//LogUtil.v(tag, "DisplayMetrics.DENSITY_LOW="+scale);
			break;
		case DisplayMetrics.DENSITY_MEDIUM:
			mWebView.getSettings().setDefaultZoom(ZoomDensity.MEDIUM);
			//LogUtil.v(tag, "DisplayMetrics.DENSITY_MEDIUM="+scale);
			break;
		case DisplayMetrics.DENSITY_HIGH: //240
			mWebView.getSettings().setDefaultZoom(ZoomDensity.FAR); 
			//LogUtil.v(tag, "DisplayMetrics.DENSITY_HIGH="+scale);  
			break;
		case DisplayMetrics.DENSITY_XHIGH:
			mWebView.getSettings().setDefaultZoom(ZoomDensity.FAR); 
			//LogUtil.v(tag, "DisplayMetrics.DENSITY_XHIGH="+scale);
			break;
		case DisplayMetrics.DENSITY_XXHIGH:  //480
			mWebView.getSettings().setDefaultZoom(ZoomDensity.FAR); 
			//LogUtil.v(tag, "DisplayMetrics.DENSITY_XXHIGH="+scale);
			break;
		case DisplayMetrics.DENSITY_XXXHIGH:
			mWebView.getSettings().setDefaultZoom(ZoomDensity.FAR); 
			//LogUtil.v(tag, "DisplayMetrics.DENSITY_XXXHIGH="+scale);
			break;
		default:
			break;
		}
	}
	
	
	
	
}
