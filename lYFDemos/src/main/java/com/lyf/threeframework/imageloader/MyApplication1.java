package com.lyf.threeframework.imageloader;

import android.app.Application;

/**
 * 全局变量类：
 * 注意：
 * 1.这个类要在清单文件中配置
 * 
 * @author LYF
 *
 */
public class MyApplication1 extends Application{
//	@Override
//	public void onCreate() {
//		super.onCreate(); 
//		
//		MyImageLoaderConfiguration();
//		
//	}
//	//==========================================================
//	/** ImageLoader插件配置 */
//	public void MyImageLoaderConfiguration(){
//		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
//		.diskCacheFileCount(500) //缓存的文件数量 
//		.diskCacheFileNameGenerator(new Md5FileNameGenerator()) //将保存的时候的URI名称用MD5 加密 
//		.build(); //开始构建  
//
//		//全局初始化此配置  
//		ImageLoader.getInstance().init(config);
//	}
//	//==========================================================
}
