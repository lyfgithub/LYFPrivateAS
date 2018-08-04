package com.lyf.webview.js;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import com.lyf.lyfdemos.R;

/**
 * <pre>
 * js����Java�������裺
 * 1.����WebView֧��JavaScript
 *    webView.getSettings().setJavaScriptEnabled(true);
 * 2.�󶨣��������ͣ�һ��java����webview����ʵ���ǽ�һ��java�������ҳJS��ϵ������
 *    webView.addJavascriptInterface(new JavaScriptObject(), "android");
 * 3.����@JavascriptInterfaceע�⣬��Ҫ����import android.webkit.JavascriptInterface;
 * 4��������3��������ӣ������޷����á������嵥�ļ�(AndroidManifest.xml)��android:targetSdkVersion="16" ������targetSdkVersion�ĳ�16��17����Ӧ�ö����ԣ�δ���ԣ���
 * 
 * �ο���������
 * http://blog.csdn.net/xyz326547445/article/details/46562429
 * </pre>
 */
@SuppressLint({ "SetJavaScriptEnabled", "JavascriptInterface" })
public class JsCallJava extends Activity {
	WebView mWebView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jscalljava);
		
		mWebView =(WebView) findViewById(R.id.WV2);
		mWebView.getSettings().setDefaultTextEncodingName("UTF-8");  
		mWebView.getSettings().setSupportZoom(true); // ֧������
		mWebView.getSettings().setBuiltInZoomControls(true); // ������������װ��
		// ֧��js
		mWebView.getSettings().setJavaScriptEnabled(true);
		//���ñ��ص��ö�����ӿ�  
	    mWebView.addJavascriptInterface(new JavaScriptObject(this), "android"); 
		// ����js
		mWebView.loadUrl("file:///android_asset/jscalljava1.html"); //
		
	}
	/** ����һ���� ����������js�����õķ���  */
	public class JavaScriptObject {  
	    Context mContxt;  
	    public JavaScriptObject(Context mContxt) {  
	        this.mContxt = mContxt;  
	    }  
	  
	    //js����java����1
	    public void jsCallAndroid1() {  
	        Toast.makeText(mContxt, "jsCallAndroid1�ɹ���", Toast.LENGTH_LONG).show();  
	    }  
	    //js����java����2
	    public void jsCallAndroid2(String name) {  
	        Toast.makeText(mContxt, "���óɹ�:" + name, Toast.LENGTH_SHORT).show();  
	    }  
	}  

	

}
