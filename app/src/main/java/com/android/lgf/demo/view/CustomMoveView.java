package com.android.lgf.demo.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * Created by lgf on 17-12-8.
 */

public class CustomMoveView extends View {
    public static final int METHOD_ONE = 0;
    public static final int METHOD_TWO = 1;
    public static final int METHOD_THREE = 2;
    public static final int METHOD_FOUR = 3;
    private int method = METHOD_FOUR;
    private int lastX;
    private int lastY;

    public CustomMoveView(Context context) {
        super(context);
    }

    public CustomMoveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomMoveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;

                if (method == METHOD_ONE) {
                    // 方式一
                    offsetLeftAndRight(offsetX);
                    offsetTopAndBottom(offsetY);
                } else if (method == METHOD_TWO) {
                    // 方式二
                    layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
                } else if (method == METHOD_THREE) {
                    // 方式三
                    // LayoutParams保存了一个View的布局参数
                    // 采用LinearLayout的原因是此例中,CustomMoveView的父布局是LinearLayout,如果是RelativeLayout,则要改为RelativeLayout.LayoutParams
                    // 或者采用ViewGroup.MarginLayoutParams,ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
                    // 步骤1.获取LayoutParams对象
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                    // 步骤2.设置LayoutParams对象的左侧及顶部的偏移
                    layoutParams.leftMargin = getLeft() + offsetX;
                    layoutParams.topMargin = getTop() + offsetY;
                    // 步骤3.将LayoutParams对象传给setLayoutParams方法
                    setLayoutParams(layoutParams);
                } else if (method == METHOD_FOUR) {
                    // scrollBy或scrollTo方法,scrollBy最终也是调用scrollBy方法
                    ((View) getParent()).scrollBy(-offsetX, -offsetY);
                }
                break;
            default:
                break;

        }

        return true;
    }

}