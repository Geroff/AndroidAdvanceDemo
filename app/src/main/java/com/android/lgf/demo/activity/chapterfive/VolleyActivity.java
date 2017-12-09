package com.android.lgf.demo.activity.chapterfive;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.lgf.demo.R;
import com.android.lgf.demo.util.NetworkUtil;
import com.android.volley.toolbox.NetworkImageView;

/**
 * Created by lgf on 17-12-9.
 */

public class VolleyActivity extends Activity implements View.OnClickListener {
    private Button btnRequestToString;
    private Button btnRequestToJSON;
    private Button btnRequestToImage;
    private ImageView ivImage;
    private NetworkImageView networkImageView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        initView();
        setListener();
    }

    private void setListener() {
        btnRequestToString.setOnClickListener(this);
        btnRequestToJSON.setOnClickListener(this);
        btnRequestToImage.setOnClickListener(this);
    }

    private void initView() {
        btnRequestToString = findViewById(R.id.btn_request_to_string);
        btnRequestToJSON = findViewById(R.id.btn_request_to_json);
        btnRequestToImage = findViewById(R.id.btn_request_to_image);
        ivImage = findViewById(R.id.iv_image);
        networkImageView = findViewById(R.id.niv_image);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_request_to_string:
                NetworkUtil.sendRequest2String();
                break;
            case R.id.btn_request_to_json:
                NetworkUtil.sendRequest2JSON();
                break;
            case R.id.btn_request_to_image:
                ivImage.setVisibility(View.GONE);
                NetworkUtil.sendRequestImage(ivImage);
                NetworkUtil.sendRequestImage(networkImageView);
                break;
            default:
                break;
        }
    }
}
