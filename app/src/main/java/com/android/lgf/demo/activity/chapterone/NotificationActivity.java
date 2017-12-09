package com.android.lgf.demo.activity.chapterone;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RemoteViews;

import com.android.lgf.demo.BuildConfig;
import com.android.lgf.demo.R;
import com.android.lgf.demo.util.LogUtil;

import java.lang.ref.SoftReference;

/**
 * Created by lgf on 17-12-4.
 * 目前尚未验证普通Notification/悬挂式Notification/折叠式Notification的区别.魅族和红米没啥区别
 */
public class NotificationActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    public static final int REGULAR_NOTIFICATION_ID = 1000;
    public static final int FOLDING_NOTIFICATION_ID = 1001;
    public static final int HANGING_NOTIFICATION_ID = 1003;
    public static final String HTTP_WWW_BAIDU_COM = "http://www.baidu.com";
    public static final int PUBLIC_MODE = 0;
    public static final int PRIVATE_MODE = 1;
    public static final int SECRET_MODE = 2;
    private int currentMode = PUBLIC_MODE;
    private Button btnSendRegularNotification;
    private Button btnSendFoldingNotification;
    private Button btnSendHangingNotification;

    private RadioGroup rgNotitionModeGroup;
    private NotificationManager notificationManager;
    private ScreenStateReceiver screenStateReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        btnSendRegularNotification = (Button) findViewById(R.id.btn_send_regular_notification);
        btnSendFoldingNotification = (Button) findViewById(R.id.btn_send_folding_notification);
        btnSendHangingNotification = (Button) findViewById(R.id.btn_send_hanging_notification);
        rgNotitionModeGroup = (RadioGroup) findViewById(R.id.rg_notification_mode_group);
        btnSendRegularNotification.setOnClickListener(this);
        btnSendFoldingNotification.setOnClickListener(this);
        btnSendHangingNotification.setOnClickListener(this);
        rgNotitionModeGroup.setOnCheckedChangeListener(this);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        screenStateReceiver = new ScreenStateReceiver(this);
        registerReceiver(screenStateReceiver, intentFilter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        screenStateReceiver = new ScreenStateReceiver(this);
        registerReceiver(screenStateReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(screenStateReceiver);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_send_regular_notification:
                sendRegularNotification();
                break;
            case R.id.btn_send_folding_notification:
                sendFoldingNotification();
                break;
            case R.id.btn_send_hanging_notification:
                sendHangingNotification();
                break;
        }
    }

    private void sendRegularNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(HTTP_WWW_BAIDU_COM));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
        builder.setAutoCancel(true);
        builder.setContentTitle("普通通知");

        // Notification显示等级
        // Notification.VISIBILITY_PUBLIC 任何情况都会显示
        // Notification.VISIBILITY_PRIVATE 只有在没有锁屏时才会显示
        // Notification.VISIBILITY_SECRET 在pin/password等安全锁和没有锁屏的情况下才能显示
        if (Build.VERSION.SDK_INT >= 21) {
            if (currentMode == PRIVATE_MODE) {
                builder.setVisibility(Notification.VISIBILITY_PRIVATE);
                builder.setContentText("private");
            } else if (currentMode == SECRET_MODE) {
                builder.setVisibility(Notification.VISIBILITY_SECRET);
                builder.setContentText("secret");
            } else {
                builder.setVisibility(Notification.VISIBILITY_PUBLIC);
                builder.setContentText("public");
            }
        }
        Notification notification = builder.build();
        notificationManager.notify(REGULAR_NOTIFICATION_ID, notification);
    }

    private void sendFoldingNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(HTTP_WWW_BAIDU_COM));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setContentTitle("折叠式通知");

        // 用RemoteViews来创建自定义Notification视图,以下两句为和普通Notification的差别
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.item_notification);
        builder.setCustomBigContentView(remoteViews);

        Notification notification = builder.build();
        notificationManager.notify(FOLDING_NOTIFICATION_ID, notification);
    }

    /**
     * 悬挂式是5.0引进的
     */
    private void sendHangingNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(HTTP_WWW_BAIDU_COM));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setContentTitle("悬挂式通知");
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.item_notification);
        builder.setCustomBigContentView(remoteViews);
        Intent hangingIntent = new Intent();
        hangingIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        hangingIntent.setClass(this, CardViewActivity.class);
        PendingIntent hangingPendingIntent = PendingIntent.getActivity(this, 0, hangingIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        // 悬挂式与普通Notification的区别
        builder.setFullScreenIntent(hangingPendingIntent, true);

        Notification notification = builder.build();
        notificationManager.notify(HANGING_NOTIFICATION_ID, notification);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb_public:
                currentMode = PUBLIC_MODE;
                break;
            case R.id.rb_private:
                currentMode = PRIVATE_MODE;
                break;
            case R.id.rb_secret:
                currentMode = SECRET_MODE;
                break;
        }
    }

    private static class ScreenStateReceiver extends BroadcastReceiver {
        SoftReference<NotificationActivity> notificationActivitySoftReference;

        public ScreenStateReceiver(NotificationActivity notificationActivity) {
            notificationActivitySoftReference = new SoftReference<NotificationActivity>(notificationActivity);
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                switch (action) {
                    case Intent.ACTION_SCREEN_ON:
                        NotificationActivity notificationActivity = notificationActivitySoftReference.get();
                        if (notificationActivity != null) {
                            notificationActivity.sendRegularNotification();
                        }
                        if (BuildConfig.DEBUG) {
                            LogUtil.info("ScreenStateReceiver.onReceive() ## ACTION_SCREEN_ON");
                        }
                        break;

                    case Intent.ACTION_SCREEN_OFF:
                        if (BuildConfig.DEBUG) {
                            LogUtil.info("ScreenStateReceiver.onReceive() ## ACTION_SCREEN_OFF");
                        }
                        break;
                }
            }
        }
    }
}
