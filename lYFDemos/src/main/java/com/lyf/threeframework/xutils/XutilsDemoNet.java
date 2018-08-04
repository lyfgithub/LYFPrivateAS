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
 * ������������ܣ�
 * https://github.com/wyouflf/xUtils
 * https://github.com/wyouflf/xUtils3
 * @author LYF
 *
 * ����ģ�飺
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
			Toast.makeText(this, "�û�������Ϊ��!", 0).show();
		}else if(TextUtils.isEmpty(loginPwd)){
			Toast.makeText(this, "���벻��Ϊ��!", 0).show();
		}
		else{
			GET_login(loginName,loginPwd);
			POST_login(loginName,loginPwd);
		}
	}
	
	
	
	//����ģ�飺
	public void GET_login(String name,String pwd){    	
	    	String url = "http://mobile.1niukou.com/api/MemberService.asmx/CheckMember";
	    	RequestParams params=new RequestParams();        //�������
	    	params.addQueryStringParameter("phone", name);   //GET��ʽ�Ĳ�ѯ�ַ�������
	    	params.addQueryStringParameter("password", pwd); //GET��ʽ�Ĳ�ѯ�ַ�������
	    	
	    	HttpUtils http=new HttpUtils();  //http���󹤾�
	    	http.send(HttpMethod.GET, url,params,new RequestCallBack<String>() {
				@Override
				public void onFailure(HttpException error, String msg) {
					Log.v(tag, "checkMember="+error.getExceptionCode()+msg);
					Toast.makeText(getApplicationContext(), "��������С���ˣ�", 0).show();
				}
				@Override
				public void onSuccess(ResponseInfo<String> responseInfo) {
					Log.v(tag, "checkMember="+responseInfo.result);
					Toast.makeText(getApplicationContext(), "get="+responseInfo.result, 0).show();
//					try {
//						Map<String, Object> map= JSONParser.parserLogin(responseInfo.result);
//						String code= (String) map.get("code");
//						if("SUCCESS".equals(code)){
//							Toast.makeText(getApplicationContext(), "��¼�ɹ���", 0).show();
//						}else{
//							Toast.makeText(getApplicationContext(), "�û������������", 0).show();
//						}
//					} catch (JSONException e) {
//						e.printStackTrace();
//						Toast.makeText(getApplicationContext(), "�û������������", 0).show();
//					}
					
				}
			});
	}
	    
	public void POST_login(String name,String pwd){    	
	    	String url = "http://mobile.1niukou.com/api/MemberService.asmx/CheckMember";
	    	RequestParams params=new RequestParams();
	    	params.addBodyParameter("phone", name);  
	    	params.addBodyParameter("password", pwd);
	    	HttpUtils http=new HttpUtils();  //�������
	    	http.send(HttpMethod.POST, url,params,new RequestCallBack<String>() {
				@Override
				public void onFailure(HttpException error, String msg) {
					Log.v(tag, "checkMember="+error.getExceptionCode()+msg);
					Toast.makeText(getApplicationContext(), "��������С���ˣ�", 0).show();
				}
				@Override
				public void onSuccess(ResponseInfo<String> responseInfo) {
					Log.v(tag, "checkMember="+responseInfo.result);
					Toast.makeText(getApplicationContext(), "POST="+responseInfo.result, 0).show();
//					try {
//						Map<String, Object> map= JSONParser.parserLogin(responseInfo.result);
//						String code= (String) map.get("code");
//						if("SUCCESS".equals(code)){
//							Toast.makeText(getApplicationContext(), "��¼�ɹ���", 0).show();
//						}else{
//							Toast.makeText(getApplicationContext(), "�û������������", 0).show();
//						}
//					} catch (JSONException e) {
//						e.printStackTrace();
//						Toast.makeText(getApplicationContext(), "�û������������", 0).show();
//					}
				}
			});
	    }
}
