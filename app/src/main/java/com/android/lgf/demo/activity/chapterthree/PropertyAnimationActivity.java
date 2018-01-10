package com.android.lgf.demo.activity.chapterthree;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.lgf.demo.R;

/**
 * 属性动画主要类:
 * 1.ObjectAnimater,要操作的属性必须要有get和set方法,否则无法生效.
 * 2.ValueAnimator,不提供任何动画效果,通过AnimatorUpdateListener监听数值变化过程.
 * 3.PropertyValuesHolder类可实现组合动画,但是只能多个动画一起执行,通过ObjectAnimater执行
 */

public class PropertyAnimationActivity extends AppCompatActivity {
    private TextView tvTarget1;
    private Button btnTarget2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        tvTarget1 = (TextView) findViewById(R.id.tv_target1);
        btnTarget2 = (Button) findViewById(R.id.btn_target2);
        tvTarget1.postDelayed(new Runnable() {
            @Override
            public void run() {
//                testObjectAnimator();
//                testValueAnimator();
//                testPropertyValuesHolder();
                testLoadAnimationFromXml();
            }
        }, 1500);
    }

    /**
     * PropertyValuesHolder类,实现组合动画
     */
    private void testPropertyValuesHolder() {
        PropertyValuesHolder valuesHolder1 = PropertyValuesHolder.ofFloat("alpha", 0, 1);
        PropertyValuesHolder valuesHolder2 = PropertyValuesHolder.ofFloat("translationY", 200);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(tvTarget1, valuesHolder1, valuesHolder2);
        objectAnimator.setDuration(1000).start();
    }

    /**
     * 测试从XML中导入动画
     */
    private void testLoadAnimationFromXml() {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.scale);
        animator.setTarget(tvTarget1);
        animator.start();
    }

    /**
     * 测试ObjectAnimator类
     */
    private void testObjectAnimator() {
        ObjectAnimator translationYAnimator = ObjectAnimator.ofFloat(tvTarget1, "translationY", 200);
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(tvTarget1, "alpha", 0, 1);
        // AnimatorSet统一管理动画
        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.playTogether(translationYAnimator, alphaAnimator);
//        animatorSet.play(translationYAnimator).with(alphaAnimator); // 同时执行
//        animatorSet.play(translationYAnimator).after(alphaAnimator); // 先透明度动画再移动
        animatorSet.play(translationYAnimator).before(alphaAnimator); // 先移动再透明度变化
        animatorSet.setDuration(1000);
        animatorSet.start();
        ObjectAnimator.ofInt(tvTarget1, "width", 500).setDuration(500).start();
//                ObjectAnimator.ofInt(btnTarget2, "width", 500).setDuration(500).start();
//                MyView myView = new MyView(tvTarget1);

        // 设置动画的监听,AnimatorListener类可监听start,repeat,end,cancel的过程
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                System.out.println("animation start");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                System.out.println("animation end");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                System.out.println("animation cancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                System.out.println("animation repeat");
            }
        });

        // 用AnimatorListenerAdapter类可只监听需要的事件
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        });
    }

    /**
     * 测试ValueAnimator类
     */
    private void testValueAnimator() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.setTarget(btnTarget2);
        valueAnimator.setDuration(1000).start();
        final int width = btnTarget2.getWidth();
        System.out.println("width-->" + width);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float floatValue = (Float) animation.getAnimatedValue();
                float animatedFraction = animation.getAnimatedFraction();
                float widthValue = animatedFraction * width;
                System.out.println("value-->" + floatValue + ", widthValue-->" + widthValue);
                ViewGroup.LayoutParams layoutParams = btnTarget2.getLayoutParams();
                layoutParams.width = (int) widthValue;
                btnTarget2.setLayoutParams(layoutParams);
            }
        });
    }

    /**
     * 如果某个View的width属性没有set,get方法则可通过如下类来进行包装,使得ObjectAnimator执行width的属性动画有效
     */
    private static class MyView {
        private View target;

        private MyView(View target) {
            this.target = target;
        }

        public int getWidth() {
            return target.getLayoutParams().width;
        }

        public void setWidth(int width) {
            target.getLayoutParams().width = width;
            target.requestLayout();
        }
    }

}
