package com.android.lgf.demo.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lgf on 18-1-9.
 */

public class LayoutParamsMoveView extends View {
    private int lastX;
    private int lastY;

    public LayoutParamsMoveView(Context context) {
        super(context);
    }

    public LayoutParamsMoveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LayoutParamsMoveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                // 由于父控件是LinearLayout,所以这里用的是LinearLayout
//                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
//                 LayoutParams可用ViewGroup.MarginLayoutParams替代
                // 第一步通过getLayoutParams()方法获取LayoutParams
                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
                // 第二步设置margin
                layoutParams.leftMargin += offsetX;
                layoutParams.topMargin += +offsetY;
                // 第三步将改变后的LayoutParams通过setLayoutParams()方法更新视图
                setLayoutParams(layoutParams);
                break;
            default:
                break;
        }
        // 要设置为true,消费触摸事件
        return true;
    }
}
