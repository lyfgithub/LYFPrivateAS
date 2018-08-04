package com.lyf.simpleTabIndicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.lyf.lyfdemos.R;

/**
 * 
 * @author LYF
 * http://www.bkjia.com/Androidjc/931270.html
 */
public class Indicator extends LinearLayout {
	private Paint mPaint; // ��ָʾ����paint
	
	private int mTop; // ָʾ����top
	private int mLeft; // ָʾ����left
	private int mWidth; // ָʾ����width
	private int mHeight = 5; // ָʾ���ĸ߶ȣ��̶���
	private int mColor; // ָʾ������ɫ
	private int mChildCount; // ��item�ĸ��������ڼ���ָʾ���Ŀ��
	
	public Indicator(Context context, AttributeSet attrs) {
		super(context, attrs);
		//setBackgroundColor(Color.TRANSPARENT);  // �������ñ���������onDraw��ִ��
		setBackgroundColor(0x55000000);  // �������ñ���������onDraw��ִ��
		
		// ��ȡ�Զ������� ָʾ������ɫ
		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.indicator, 0, 0);
		mColor = ta.getColor(R.styleable.indicator_color, 0X0000FF);
		ta.recycle();
		
		// ��ʼ��paint
		mPaint = new Paint();
		mPaint.setColor(mColor);
		mPaint.setAntiAlias(true);
	}
	
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		mChildCount = getChildCount();  // ��ȡ��item�ĸ���
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);  //�������ǵ����˸����onMeasure��Ŀ�ľ�����������Ĭ�ϵĴ���ȥ����������������ͨ��getMeasuredHeight��ȡ�����ĸ߶�
		mTop = getMeasuredHeight(); // �����ĸ߶ȼ�ָʾ���Ķ���λ��
		int width = getMeasuredWidth(); // ��ȡ�������ܿ��
		//int height = getMeasuredHeight() + mTop + mHeight; // ���¶���һ�²����ĸ߶�
		int height = getMeasuredHeight() + mHeight; // ���¶���һ�²����ĸ߶�
		mWidth = width / mChildCount; // ָʾ���Ŀ��Ϊ�ܿ��/item�ĸ���
		
		setMeasuredDimension(width, height);
	}
	
	/**
	 * ָʾ������
	 * @param position ���ڵ�λ��
	 * @param offset  ƫ���� 0 ~ 1
	 */
	public void scroll(int position, float offset) {
		mLeft = (int) ((position + offset) * mWidth);
		invalidate();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// Ȧ��һ������
		Rect rect = new Rect(mLeft, mTop, mLeft + mWidth, mTop + mHeight);
		canvas.drawRect(rect, mPaint); // ���Ƹþ���
		super.onDraw(canvas);
	}
}
