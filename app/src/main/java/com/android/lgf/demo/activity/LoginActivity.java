package com.android.lgf.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.lgf.demo.R;

/**
 * Created by lgf on 17-12-6.
 * 主要体验TextInputLayout的应用:<br />
 * TextInputLayout只接受一个子元素,并且只能是EditText<br />
 * 输入框以及输入框上方的hint提示颜色,可通过style中的colorAccent属性进行修改<br />
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private TextInputLayout tlUserName;
    private TextInputLayout tlPassword;
    private EditText etUserName;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        setListener();
    }

    private void setListener() {
        btnLogin.setOnClickListener(this);
        etUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tlUserName.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tlPassword.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void initView() {
        tlUserName = (TextInputLayout) findViewById(R.id.tl_user_name);
        tlPassword = (TextInputLayout) findViewById(R.id.tl_password);
        etUserName = (EditText) findViewById(R.id.et_user_name);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                handleLogin();
                break;
            default:
                break;
        }
    }

    /**
     * TextInputLayout方法用于显示错误信息的两个主要方法:setErrorEnabled和setError
     */
    private void handleLogin() {
        String userName = etUserName.getText().toString();
        String password = etPassword.getText().toString();
        if (TextUtils.isEmpty(userName)) {
            // setErrorEnabled方法用于显示和隐藏错误信息
            tlUserName.setErrorEnabled(true);
            // setError方法用于设置错误信息
            tlUserName.setError("用户名不能为空");
        } else if (TextUtils.isEmpty(password)) {
            tlPassword.setErrorEnabled(true);
            tlPassword.setError("密码不能为空");
        } else {
            tlPassword.setErrorEnabled(false);
            tlUserName.setErrorEnabled(false);
            Toast.makeText(this, "用户名和密码有效", Toast.LENGTH_SHORT).show();
        }
    }
}
