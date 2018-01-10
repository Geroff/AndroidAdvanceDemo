package com.android.lgf.demo.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by lgf on 18-1-9.
 */

public class OffsetMoveView extends View {
    private int lastX;
    private int lastY;

    public OffsetMoveView(Context context) {
        super(context);
    }

    public OffsetMoveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public OffsetMoveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY= y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                offsetLeftAndRight(offsetX);
                offsetTopAndBottom(offsetY);
                break;
            default:
                break;
        }
        return true;
    }
}
