package com.android.lgf.demo.activity.test;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.lgf.demo.R;
import com.android.lgf.demo.manager.ExceptionHandlerManager;
import com.android.lgf.demo.manager.HandlerThreadManager;
import com.android.lgf.demo.util.LogUtils;

/**
 * Created by lgf on 17-12-19.
 * 目的：验证handler调用post方法时Runnable内持有的对象的状态是否是会动态变化（同一个对象）
 * 验证结果为：Runnable内持有的对象的状态会动态变化，Runnable持有的是该引用指向的对象，当要获取该对象的状态时，则以当前最新的状态为准，而不是传递时的状态
 */
public class ThreadTestActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnStart;
    private Button btnStop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_thread);
        initView();
        setListener();
        ExceptionHandlerManager.getInstance().init();
    }

    private void setListener() {
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }

    private void initView() {
        btnStart = (Button) findViewById(R.id.btn_start);
        btnStop = (Button) findViewById(R.id.btn_stop);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                HandlerThreadManager.getInstance().getOrCreateDefaultThread().post(new Runnable() {
                    @Override
                    public void run() {
                        int count = 0;
                        while (count < 10) {
                            Bean bean = new Bean();
                            bean.name = "count" + count;
                            // 传入前,bean对象的name的值为count
                            printLog(bean); // 内部有延时
                            // 传入后,bean对象的name的值为new Count
                            bean.name = "new Count" + count; // 改变name的值，printLog(bean);内打印的name值为此值
                            bean = null; // 并不会影响printLog内的bean，因为对象已经改变
                            count++;
                        }
                    }
                });
                break;
            case R.id.btn_stop:
                HandlerThreadManager.getInstance().release();
                break;
            default:
                break;
        }
    }

    private void printLog(final Bean bean) {
        /**
         * post里面的bean的name值可能和当前传入的不一样，因为post可能被阻塞，当不阻塞时由于外部已经改变了name的值，此时就会不一样
         */
        LogUtils.info("bean before post-->" + bean.name);
        HandlerThreadManager.getInstance().getOrCreateBackgroundThread().post(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(1000);

            }
        });
        HandlerThreadManager.getInstance().getOrCreateBackgroundThread().post(new Runnable() {
            @Override
            public void run() {
                LogUtils.info("bean after post-->" + bean.name);
            }
        });
    }

    class Bean {
        public String name;
    }
}
