package com.lyf.threeframework.okhttp;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * okhttp开发框架
 * 参考：http://blog.csdn.net/lmj623565791/article/details/47911083
 * @author LYF
 *
 */
public class OkhttpDemo extends Activity{
	

	public void MyGet(){
		//创建okHttpClient对象
		OkHttpClient mOkHttpClient = new OkHttpClient();
		//创建一个Request
		Request request = new Request.Builder()
		                .url("https://www.baidu.com/")
		                .build();
		//new call
		Call call = mOkHttpClient.newCall(request); 
		//请求加入调度
		call.enqueue(new Callback() {
		    @Override
		    public void onResponse(final Response response) throws IOException
		    {
		        String htmlStr =  response.body().string();
		    	Toast.makeText(OkhttpDemo.this, htmlStr, 0).show();
		    }
			
		    @Override
		    public void onFailure(Request request, IOException e)
		    {
		    	Toast.makeText(OkhttpDemo.this, "服务器开小差了！", 0).show();
		    }
		});        
	}
	
	
	public void myPost(){
		//创建okHttpClient对象
		OkHttpClient mOkHttpClient = new OkHttpClient();
		String url="";
		
//		Request request = buildMultipartFormRequest(
//		        url, 
//		        new File[]{file}, 
//		        new String[]{fileKey}, null);
		
		//表单数据
		FormEncodingBuilder builder = new FormEncodingBuilder();   
		builder.add("username","张鸿洋");

		Request request2 = new Request.Builder()
		                .url(url)
		                .post(builder.build())
		                .build();
		
		mOkHttpClient.newCall(request2).enqueue(new Callback(){
			@Override
			public void onFailure(Request arg0, IOException arg1) {
				
			}

			@Override
			public void onResponse(Response arg0) throws IOException {
				
			}
		});
	}
}
