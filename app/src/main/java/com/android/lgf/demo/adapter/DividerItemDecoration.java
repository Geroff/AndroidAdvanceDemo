package com.android.lgf.demo.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by lgf on 17-12-3.
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = new int[]{
            android.R.attr.listDivider
    };

    private Drawable dividerDrawable;
    private int orientation;

    public DividerItemDecoration(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }

        if (!(context instanceof Activity)) {
            throw new IllegalArgumentException("context must be instanced of Activity");
        }

        TypedArray typedArray = context.obtainStyledAttributes(ATTRS);
        dividerDrawable = typedArray.getDrawable(0);
        typedArray.recycle();
        setOrientation(LinearLayoutManager.HORIZONTAL);
    }

    public void setOrientation(int orientation) {
        if (orientation != LinearLayoutManager.HORIZONTAL && orientation != LinearLayoutManager.VERTICAL) {
            throw new IllegalArgumentException("invalid orientation");
        }

        this.orientation = orientation;
    }

    @Override
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        if (orientation == LinearLayoutManager.VERTICAL) {
            drawHorizontal(canvas, recyclerView);
        } else {
            drawVertical(canvas, recyclerView);
        }
    }

    private void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int top = recyclerView.getPaddingTop();
        int bottom = recyclerView.getHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = recyclerView.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childView.getLayoutParams();
            int left = childView.getRight() + layoutParams.rightMargin;
            int right = left + dividerDrawable.getIntrinsicWidth();
            dividerDrawable.setBounds(left, top, right, bottom);
            dividerDrawable.draw(canvas);
        }
    }

    private void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int left = recyclerView.getPaddingLeft();
        int right = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = recyclerView.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) childView.getLayoutParams();
            int top = childView.getBottom() + params.bottomMargin;
            int bottom = top + dividerDrawable.getIntrinsicHeight();
            dividerDrawable.setBounds(left, top, right, bottom);
            dividerDrawable.draw(canvas);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (orientation == LinearLayoutManager.VERTICAL) {
            outRect.set(0, 0, 0, dividerDrawable.getIntrinsicHeight());
        } else {
            outRect.set(0, 0, dividerDrawable.getIntrinsicWidth(), 0);
        }
//        super.getItemOffsets(outRect, view, parent, state);
    }
}
