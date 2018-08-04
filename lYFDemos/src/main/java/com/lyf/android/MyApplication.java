package com.lyf.android;

import android.app.Application;
import android.graphics.Bitmap;

import com.lyf.android.MyApplication;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * 全局变量类：
 * 注意：
 * 1.这个类要在清单文件中配置，
 * 配置方法： 将 application节点添加name=""
 * 
 * @author LYF
 *
 */
public class MyApplication extends Application{
	@Override
	public void onCreate() {
		super.onCreate(); 
		
		//ImageLoader插件配置
		MyImageLoaderConfiguration();
		
	}
	//==========================================================
	/** ImageLoader插件配置 */
	public void MyImageLoaderConfiguration(){
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
		.threadPoolSize(3)//线程池内加载的数量  
		.diskCacheFileCount(500) //缓存的文件数量 
		.diskCacheFileNameGenerator(new Md5FileNameGenerator()) //将保存的时候的URI名称用MD5 加密 
		.build(); //开始构建  

		//全局初始化此配置  
		ImageLoader.getInstance().init(config);
	}
	//==========================================================
}