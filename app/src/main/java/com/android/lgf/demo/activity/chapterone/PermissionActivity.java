package com.android.lgf.demo.activity.chapterone;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.android.lgf.demo.R;

/**
 * Created by lgf on 17-12-5.
 */

public class PermissionActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        findViewById(R.id.btn_tel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1.检查权限
                boolean hasCallPhonePermission = ActivityCompat.checkSelfPermission(PermissionActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED;
                if (!hasCallPhonePermission) {
                    // 2.如果没有权限则申请权限
                    requestPermission();
                } else {
                    call();
                }
            }
        });
    }

    /**
     * 没有权限会出异常
     */
    private void call() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:10010"));
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3.实现onRequestPermissionsResult方法,判断用户是否授予权限
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    call();
                } else {
                    // 当点击授予权限对话框的不再询问时会出现
                     if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {
                         AlertDialog.Builder builder = new AlertDialog.Builder(this);
                         builder.setMessage("该功能需要访问电话权限，不开启将无法正常工作!是否去开启?");
                         builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialog, int which) {
                                 gotoAppSetting();
                                 dialog.dismiss();
                             }
                         });
                         builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialog, int which) {
                                 Toast.makeText(PermissionActivity.this, "没有授予权限", Toast.LENGTH_SHORT).show();
                                 dialog.dismiss();
                             }
                         });
                         builder.setCancelable(false);
                         AlertDialog alertDialog = builder.create();
                         alertDialog.show();
                     }
                     return;
                }
                break;
            default:
                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /**
     * 跳转到系统列表中app的设置界面
     */
    private void gotoAppSetting() {
        Uri packageURI = Uri.parse("package:" + getPackageName());
        Intent intent =  new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,packageURI);
        startActivity(intent);
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(PermissionActivity.this, new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CODE);
    }
}
