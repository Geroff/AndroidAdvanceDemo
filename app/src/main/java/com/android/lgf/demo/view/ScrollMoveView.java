package com.android.lgf.demo.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by lgf on 18-1-9.
 */

public class ScrollMoveView extends View {
    private int lastX;
    private int lastY;
    public ScrollMoveView(Context context) {
        super(context);
    }

    public ScrollMoveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollMoveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
                // 需要通过父类来执行scrollBy/scrollTo,这两个方法是滚动内容
                // 用getParent()获取父类,且偏移量要用负数
                ((View)getParent()).scrollBy(-offsetX, -offsetY);
                break;
            default:
                break;
        }
        return true;
    }
}
