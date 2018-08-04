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
 * js调用Java方法步骤：
 * 1.设置WebView支持JavaScript
 *    webView.getSettings().setJavaScriptEnabled(true);
 * 2.绑定（这样解释）一个java对象到webview，其实就是将一个java对象和网页JS联系起来。
 *    webView.addJavascriptInterface(new JavaScriptObject(), "android");
 * 3.增加@JavascriptInterface注解，需要导入import android.webkit.JavascriptInterface;
 * 4、若上面3个都已添加，还是无法调用。请检查清单文件(AndroidManifest.xml)中android:targetSdkVersion="16" ，这里targetSdkVersion改成16（17以下应该都可以，未测试）。
 * 
 * 参考问题解决：
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
		mWebView.getSettings().setSupportZoom(true); // 支持缩放
		mWebView.getSettings().setBuiltInZoomControls(true); // 启用内置缩放装置
		// 支持js
		mWebView.getSettings().setJavaScriptEnabled(true);
		//设置本地调用对象及其接口  
	    mWebView.addJavascriptInterface(new JavaScriptObject(this), "android"); 
		// 载入js
		mWebView.loadUrl("file:///android_asset/jscalljava1.html"); //
		
	}
	/** 创建一个类 来包含所有js将调用的方法  */
	public class JavaScriptObject {  
	    Context mContxt;  
	    public JavaScriptObject(Context mContxt) {  
	        this.mContxt = mContxt;  
	    }  
	  
	    //js调用java方法1
	    public void jsCallAndroid1() {  
	        Toast.makeText(mContxt, "jsCallAndroid1成功！", Toast.LENGTH_LONG).show();  
	    }  
	    //js调用java方法2
	    public void jsCallAndroid2(String name) {  
	        Toast.makeText(mContxt, "调用成功:" + name, Toast.LENGTH_SHORT).show();  
	    }  
	}  

	

}
