package com.android.lgf.demo.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

/**
 * Created by lgf on 18-1-9.
 */

public class ScrollerMoveView extends View {
    private int lastX;
    private int lastY;
    private Scroller scroller;

    public ScrollerMoveView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        scroller = new Scroller(context);
    }

    public ScrollerMoveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ScrollerMoveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
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
                if (Math.abs(offsetX) >= 100 || Math.abs(offsetY) >= 100) {
                    smoothScrollTo(-x, -y);
                }
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (scroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(scroller.getCurrX(), scroller.getCurrY());
            invalidate();
        }
    }

    public void smoothScrollTo(int destX, int destY) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int deltaX = destX - scrollX;
        int deltaY = destY - scrollY;
        scroller.startScroll(scrollX, scrollY, deltaX, deltaY, 1000);
        invalidate();
    }
}
