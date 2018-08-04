package com.lyf.threeframework.imageloader;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.lyf.lyfdemos.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * universal-image-loader-1.9.2.jar
 * 图片加载框架
 * 使用说明：http://blog.csdn.net/vipzjyno1/article/details/23206387
 * 
 * 使用步骤：
 * 1.网络权限
 * <uses-permission android:name="android.permission.INTERNET" />  
 * <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" /> 
 * 
 * 2.创建自定义Application全局类
 *   public class MyApplication extends Application {}
 * 3.在Application类中编写ImageLoader插件的配置
 *  
 * 4.使用
 * 
 * @author LYF
 *
 */
public class ImageloaderDemo extends Activity{
	//得到图片ImageLoader实例对象
	private ImageLoader mImageLoader = ImageLoader.getInstance();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imageloaderdemo);
		
		ImageView iv_imageLoader = (ImageView) findViewById(R.id.iv_imageLoader);
		String imgPath="https://www.baidu.com/img/bd_logo1.png";
		ImageLoaderShow(iv_imageLoader,imgPath);
	}
	
	/**
	 * 在指定控件上显示指定的图片
	 * @param iv
	 * @param imgPath
	 */
	public void ImageLoaderShow(ImageView iv,String imgPath){
		//===图片加载==================================================================
		DisplayImageOptions option = new DisplayImageOptions.Builder()
		.bitmapConfig(Bitmap.Config.RGB_565)//设置图片的解码类型// 
		.showImageForEmptyUri(R.drawable.empty_photo)	// 设置图片Uri为空或是错误的时候显示的图片
		.showImageOnFail(R.drawable.empty_photo)       // 设置图片加载或解码过程中发生错误显示的图片	
		.cacheInMemory(true)//设置下载的图片是否缓存在内存中
		.cacheOnDisk(true) //设置下载的图片是否缓存在SD卡中  
		.build();
		mImageLoader.displayImage(imgPath, iv, option);
		//=====================================================================
	}
}
