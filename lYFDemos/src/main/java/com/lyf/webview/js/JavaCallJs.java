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
 * java�������js
 * ���裺
 *   1.�ڳ����е���js���룬ֻ��Ҫ��webview�ؼ���֧��js����������Ϊtrue
 *   2.ʹ��WebView����.loadUrl("javascript:js������()");
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
		// ֧��js
		mWebView.getSettings().setJavaScriptEnabled(true);
		
		// ����js
		mWebView.loadUrl("file:///android_asset/javacalljs.html"); 
		//mWebView.loadData("", "text/html; charset=UTF-8", null); // ����д��������ȷ����

		// �������js�з���
		btn_javaCalljs.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// ִ��js����
				mWebView.loadUrl("javascript:javaCallJs1()");
			}
		});
		
		
		btn_javaCalljs2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// ִ��js����
				mWebView.loadUrl("javascript:javaCallJs2('lyf')");
			}
		});
	}
	
	
	/** WebView���� */
	@SuppressWarnings("deprecation")
	@SuppressLint("SetJavaScriptEnabled") 
	private void myWebViewSet(){
        //WebView����
		mWebView.getSettings().setJavaScriptEnabled(true);  //֧��js
		mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);   //LYF��������ʽ
		mWebView.setHorizontalScrollBarEnabled(false);   //LYF����ˮƽ�������Ƿ����  
//        wrapperContent.setHorizontalScrollbarOverlay(true);   //��ȡˮƽ�������Ƿ��е�����ʽ
		mWebView.setVerticalScrollbarOverlay(true); //ָ���Ĵ�ֱ�������е�����ʽ
//        wrapperContent.setInitialScale(100);  //��ʼ��ʱ������
		
		//WebSettings����
		WebSettings settings = mWebView.getSettings();
		settings.setJavaScriptEnabled(true);//֧��js
		settings.setSupportZoom(true);  //֧������ 
		settings.setBuiltInZoomControls(false); //�����Ƿ���ʾ���Ű�ť
        //����Ӧ��Ļ��С
		settings.setUseWideViewPort(true);  //���ô����ԣ��������������
		settings.setLoadWithOverviewMode(true); // ��������Ļ�Ĵ�С
		//settings.setPluginsEnabled(true);  //֧�ֲ�� 
		settings.setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS); //֧���������²���  
		//settings.supportMultipleWindows();  //�ര�� 
		//settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);  //�ر�webview�л��� 
		//settings.setAllowFileAccess(true);  //���ÿ��Է����ļ� 
		settings.setNeedInitialFocus(false); //��webview����requestFocusʱΪwebview���ýڵ�
		settings.setJavaScriptCanOpenWindowsAutomatically(true); //֧��ͨ��JS���´��� 
		settings.setLoadsImagesAutomatically(true);  //֧���Զ�����ͼƬ
		
        //��ͬ�ֱַ��ʵ������,��Ļ�ܶȲ�һ���������,�Զ�����ҳ��: 
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
