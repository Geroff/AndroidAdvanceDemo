package com.android.lgf.demo.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by lgf on 18-1-8.
 */

public class LayoutMoveView extends View {
    private int lastX;
    private int lastY;

    public LayoutMoveView(Context context) {
        super(context);
    }

    public LayoutMoveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LayoutMoveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 注意不能写成getX(),否则无法移动
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
                System.out.print("offsetX-->" + offsetX + ", offsetY-->" + offsetY);
                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
                break;
            default:
                break;
        }

        return true;
    }
}
