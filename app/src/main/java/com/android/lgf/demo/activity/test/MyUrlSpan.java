package com.android.lgf.demo.activity.test;

import android.content.Context;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.Toast;

/**
 * Created by lgf on 18-1-17.
 */

public class MyUrlSpan extends URLSpan {
    public MyUrlSpan(String url) {
        super(url);
    }

    @Override
    public void onClick(View widget) {
        Context context = widget.getContext();
        Toast.makeText(context, "click", Toast.LENGTH_SHORT).show();
    }

}
