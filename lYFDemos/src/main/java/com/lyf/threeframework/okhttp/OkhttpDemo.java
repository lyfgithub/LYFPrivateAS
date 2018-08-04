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
 * okhttp�������
 * �ο���http://blog.csdn.net/lmj623565791/article/details/47911083
 * @author LYF
 *
 */
public class OkhttpDemo extends Activity{
	

	public void MyGet(){
		//����okHttpClient����
		OkHttpClient mOkHttpClient = new OkHttpClient();
		//����һ��Request
		Request request = new Request.Builder()
		                .url("https://www.baidu.com/")
		                .build();
		//new call
		Call call = mOkHttpClient.newCall(request); 
		//����������
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
		    	Toast.makeText(OkhttpDemo.this, "��������С���ˣ�", 0).show();
		    }
		});        
	}
	
	
	public void myPost(){
		//����okHttpClient����
		OkHttpClient mOkHttpClient = new OkHttpClient();
		String url="";
		
//		Request request = buildMultipartFormRequest(
//		        url, 
//		        new File[]{file}, 
//		        new String[]{fileKey}, null);
		
		//������
		FormEncodingBuilder builder = new FormEncodingBuilder();   
		builder.add("username","�ź���");

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
