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
 * ͼƬ���ؿ��
 * ʹ��˵����http://blog.csdn.net/vipzjyno1/article/details/23206387
 * 
 * ʹ�ò��裺
 * 1.����Ȩ��
 * <uses-permission android:name="android.permission.INTERNET" />  
 * <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" /> 
 * 
 * 2.�����Զ���Applicationȫ����
 *   public class MyApplication extends Application {}
 * 3.��Application���б�дImageLoader���������
 *  
 * 4.ʹ��
 * 
 * @author LYF
 *
 */
public class ImageloaderDemo extends Activity{
	//�õ�ͼƬImageLoaderʵ������
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
	 * ��ָ���ؼ�����ʾָ����ͼƬ
	 * @param iv
	 * @param imgPath
	 */
	public void ImageLoaderShow(ImageView iv,String imgPath){
		//===ͼƬ����==================================================================
		DisplayImageOptions option = new DisplayImageOptions.Builder()
		.bitmapConfig(Bitmap.Config.RGB_565)//����ͼƬ�Ľ�������// 
		.showImageForEmptyUri(R.drawable.empty_photo)	// ����ͼƬUriΪ�ջ��Ǵ����ʱ����ʾ��ͼƬ
		.showImageOnFail(R.drawable.empty_photo)       // ����ͼƬ���ػ��������з���������ʾ��ͼƬ	
		.cacheInMemory(true)//�������ص�ͼƬ�Ƿ񻺴����ڴ���
		.cacheOnDisk(true) //�������ص�ͼƬ�Ƿ񻺴���SD����  
		.build();
		mImageLoader.displayImage(imgPath, iv, option);
		//=====================================================================
	}
}
