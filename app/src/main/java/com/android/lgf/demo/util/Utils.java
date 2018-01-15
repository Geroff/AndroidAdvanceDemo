package com.android.lgf.demo.util;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

/**
 * Created by lgf on 18-1-11.
 */

public class Utils {
    /**
     * 根据手机的分辨率从的dp的单位转换成px(像素)
     *
     * @param context
     * @param dpValue
     * @return 转换后的像素值
     */
    public static int dip2px(Context context, float dpValue) {
        if (context == null) {
            return 0;
        }
        final float scale = context.getResources().getDisplayMetrics().density;
        Log.d("DisplayTag", "scale-->" + scale);
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从的px的单位转换成dp
     * @param context
     * @param pxValue
     * @return 转换后的dp值
     */
    public static int px2dip(Context context, float pxValue) {
        if (context == null) {
            return 0;
        }
        final float scale = context.getResources().getDisplayMetrics().density;
        Log.d("DisplayTag", "scale-->" + scale);
        return (int) (pxValue / scale + 0.5);
    }

    /**
     * 获取屏幕分辨率
     * @param context
     * @return
     */
    public static Point getScreenSize(Context context) {
        if (context == null) {
            return null;
        }

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        Point size = new Point();
        size.x = dm.widthPixels;
        size.y = dm.heightPixels;
        return size;
    }
}
