package com.android.lgf.demo.activity.test;

import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.lgf.demo.R;
import com.android.lgf.demo.util.Utils;

/**
 * Created by lgf on 18-1-11.
 */

public class DisplayTestActivity extends AppCompatActivity {
    private TextView tvDislplay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        tvDislplay = (TextView) findViewById(R.id.tv_display_info);
        tvDislplay.postDelayed(new Runnable() {
            @Override
            public void run() {
                int dpValue = Utils.px2dip(DisplayTestActivity.this, 8);
                int pxValue = Utils.dip2px(DisplayTestActivity.this, 8);
                Log.d("DisplayTag", "8px to dp is " + dpValue + ", 8dp to px is " + pxValue);
                Drawable drawable = getResources().getDrawable(R.drawable.ic_launcher);
                tvDislplay.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
                tvDislplay.setCompoundDrawablePadding(pxValue);
                // 代码中默认为透明，需要用八位表示颜色，xml中默认不是透明
//                tvDislplay.setBackgroundColor(0xFFFF00); // 如果用0xFFFF00，则背景显示为透明
                tvDislplay.setBackgroundColor(0xFFFFFF00);
                Point screenSize = Utils.getScreenSize(DisplayTestActivity.this);
                tvDislplay.setText("[屏幕大小]宽:" + screenSize.x + ",高:" + screenSize.y);
            }
        }, 1000);
    }
}
