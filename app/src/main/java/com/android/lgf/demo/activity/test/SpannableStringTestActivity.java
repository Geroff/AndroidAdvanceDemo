package com.android.lgf.demo.activity.test;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.widget.TextView;

import com.android.lgf.demo.R;

/**
 * Created by lgf on 18-1-17.
 */

public class SpannableStringTestActivity extends AppCompatActivity {
    private TextView tvSpannableString;
    private TextView tvSpannableString2;
    private TextView tvSpannableString3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spannable_string);
        tvSpannableString = (TextView) findViewById(R.id.tv_spannable_text);
        tvSpannableString2 = (TextView) findViewById(R.id.tv_spannable_text2);
        tvSpannableString3 = (TextView) findViewById(R.id.tv_spannable_text3);
        String text = "Hello World.";
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new RelativeSizeSpan(1.5f), 0, 5, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), 7, 11, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        tvSpannableString.setText(spannableString);

        String text2 = "Hello Alice.";
        SpannableString spannableString1 = new SpannableString(text2);
        spannableString1.setSpan(new RelativeSizeSpan(2.0f), 0, 5, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableString1.setSpan(new ForegroundColorSpan(Color.GREEN), 2, 11, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableString1.setSpan(new BackgroundColorSpan(Color.BLUE), 5, 10, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        tvSpannableString2.setText(spannableString1);

        String url = "http://www.baidu.com";
        String urlText = "Let's go.";
        SpannableString spannableString2 = new SpannableString(urlText);
        URLSpan urlSpan = new URLSpan(url);
        spannableString2.setSpan(urlSpan, 0, urlText.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        tvSpannableString3.setText(spannableString2);
        // 必须设置这个，否则无法跳转
        tvSpannableString3.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
