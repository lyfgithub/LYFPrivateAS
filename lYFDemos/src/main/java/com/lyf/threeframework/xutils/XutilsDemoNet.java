package com.lyf.threeframework.xutils;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.lyf.lyfdemos.R;

/**
 * 第三方开发框架：
 * https://github.com/wyouflf/xUtils
 * https://github.com/wyouflf/xUtils3
 * @author LYF
 *
 * 网络模块：
 */
public class XutilsDemoNet extends Activity{
	String tag="XutilsDemo";
	private EditText eT_LoginName;
	private EditText eT_LoginPwd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xutilsdemonet);
		
		eT_LoginName = (EditText) findViewById(R.id.et_name);
		eT_LoginPwd = (EditText) findViewById(R.id.et_pwd);
		
		findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				login();
			}
		});
	}
	
	public void login(){
		String loginName = eT_LoginName.getText().toString().trim();
		String loginPwd = eT_LoginPwd.getText().toString().trim();
		if(TextUtils.isEmpty(loginName)) {
			Toast.makeText(this, "用户名不能为空!", 0).show();
		}else if(TextUtils.isEmpty(loginPwd)){
			Toast.makeText(this, "密码不能为空!", 0).show();
		}
		else{
			GET_login(loginName,loginPwd);
			POST_login(loginName,loginPwd);
		}
	}
	
	
	
	//网络模块：
	public void GET_login(String name,String pwd){    	
	    	String url = "http://mobile.1niukou.com/api/MemberService.asmx/CheckMember";
	    	RequestParams params=new RequestParams();        //请求参数
	    	params.addQueryStringParameter("phone", name);   //GET方式的查询字符串参数
	    	params.addQueryStringParameter("password", pwd); //GET方式的查询字符串参数
	    	
	    	HttpUtils http=new HttpUtils();  //http请求工具
	    	http.send(HttpMethod.GET, url,params,new RequestCallBack<String>() {
				@Override
				public void onFailure(HttpException error, String msg) {
					Log.v(tag, "checkMember="+error.getExceptionCode()+msg);
					Toast.makeText(getApplicationContext(), "服务器开小差了！", 0).show();
				}
				@Override
				public void onSuccess(ResponseInfo<String> responseInfo) {
					Log.v(tag, "checkMember="+responseInfo.result);
					Toast.makeText(getApplicationContext(), "get="+responseInfo.result, 0).show();
//					try {
//						Map<String, Object> map= JSONParser.parserLogin(responseInfo.result);
//						String code= (String) map.get("code");
//						if("SUCCESS".equals(code)){
//							Toast.makeText(getApplicationContext(), "登录成功！", 0).show();
//						}else{
//							Toast.makeText(getApplicationContext(), "用户名或密码错误！", 0).show();
//						}
//					} catch (JSONException e) {
//						e.printStackTrace();
//						Toast.makeText(getApplicationContext(), "用户名或密码错误！", 0).show();
//					}
					
				}
			});
	}
	    
	public void POST_login(String name,String pwd){    	
	    	String url = "http://mobile.1niukou.com/api/MemberService.asmx/CheckMember";
	    	RequestParams params=new RequestParams();
	    	params.addBodyParameter("phone", name);  
	    	params.addBodyParameter("password", pwd);
	    	HttpUtils http=new HttpUtils();  //请求参数
	    	http.send(HttpMethod.POST, url,params,new RequestCallBack<String>() {
				@Override
				public void onFailure(HttpException error, String msg) {
					Log.v(tag, "checkMember="+error.getExceptionCode()+msg);
					Toast.makeText(getApplicationContext(), "服务器开小差了！", 0).show();
				}
				@Override
				public void onSuccess(ResponseInfo<String> responseInfo) {
					Log.v(tag, "checkMember="+responseInfo.result);
					Toast.makeText(getApplicationContext(), "POST="+responseInfo.result, 0).show();
//					try {
//						Map<String, Object> map= JSONParser.parserLogin(responseInfo.result);
//						String code= (String) map.get("code");
//						if("SUCCESS".equals(code)){
//							Toast.makeText(getApplicationContext(), "登录成功！", 0).show();
//						}else{
//							Toast.makeText(getApplicationContext(), "用户名或密码错误！", 0).show();
//						}
//					} catch (JSONException e) {
//						e.printStackTrace();
//						Toast.makeText(getApplicationContext(), "用户名或密码错误！", 0).show();
//					}
				}
			});
	    }
}
