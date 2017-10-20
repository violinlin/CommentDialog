package com.example.administrator.commentdialog.share;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.example.administrator.commentdialog.R;

/**
 * Created by wanghuilin on 2017/10/20.
 */

public class ShareDialog extends Dialog {
    public ShareDialog(@NonNull Context context) {
        this(context, R.style.comment_style);
    }

    public ShareDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        setContentView(R.layout.share_dialog_layout);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        window.setGravity(Gravity.BOTTOM);//设置dialog的显示位置
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;//弹窗获取焦点
        attributes.width = context.getResources().getDisplayMetrics().widthPixels;
        window.setAttributes(attributes);
        initView();
    }

    private void initView() {
        TextView qqTV = (TextView) findViewById(R.id.qq);
        TextView weChatTV = (TextView) findViewById(R.id.wechat);
        TextView weChatCircleTV = (TextView) findViewById(R.id.wechat_circle);
        qqTV.startAnimation(getTransAnimation(0));
        weChatTV.startAnimation(getTransAnimation(100));
        weChatCircleTV.startAnimation(getTransAnimation(200));
        final TextView cancelTV = (TextView) findViewById(R.id.cancel);
        cancelTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });

    }

    /**
     * 获取位移动画
     *
     * @param offset 设置动画延迟时间
     * @return
     */
    private Animation getTransAnimation(long offset) {
        Animation animation = new TranslateAnimation(0, 0, 400f, 0);
        animation.setDuration(500);
        animation.setInterpolator(new LinearInterpolator());
        animation.setFillAfter(true);
        animation.setFillBefore(false);
        animation.setStartOffset(offset);
        return animation;
    }
}
