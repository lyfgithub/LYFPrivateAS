package com.lyf.android;

import android.app.Application;
import android.graphics.Bitmap;

import com.lyf.android.MyApplication;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * ȫ�ֱ����ࣺ
 * ע�⣺
 * 1.�����Ҫ���嵥�ļ������ã�
 * ���÷����� �� application�ڵ����name=""
 * 
 * @author LYF
 *
 */
public class MyApplication extends Application{
	@Override
	public void onCreate() {
		super.onCreate(); 
		
		//ImageLoader�������
		MyImageLoaderConfiguration();
		
	}
	//==========================================================
	/** ImageLoader������� */
	public void MyImageLoaderConfiguration(){
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
		.threadPoolSize(3)//�̳߳��ڼ��ص�����  
		.diskCacheFileCount(500) //������ļ����� 
		.diskCacheFileNameGenerator(new Md5FileNameGenerator()) //�������ʱ���URI������MD5 ���� 
		.build(); //��ʼ����  

		//ȫ�ֳ�ʼ��������  
		ImageLoader.getInstance().init(config);
	}
	//==========================================================
}