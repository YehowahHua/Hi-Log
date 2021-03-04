package com.yehowah.hilibrary.log;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.yehowah.hilibrary.util.HiDisplayUtil;

/**
 * created by cyh
 * on 2021/1/22 10:36
 * Description:对ViewPrinter显示和隐藏
 **/
public class HiViewPrinterProvider {
    private final FrameLayout rootView;//放置recyclerView的容器
    private View floatingView;
    private boolean isOpen;
    private FrameLayout logView;
    private RecyclerView recyclerView;

    private static final String TAG_FLOATING_VIEW = "TAG_FLOATING_VIEW";
    private static final String TAG_LOG_VIEW = "TAG_LOG_VIEW";


    public HiViewPrinterProvider(FrameLayout rootView, RecyclerView recyclerView) {
        this.rootView = rootView;
        this.recyclerView = recyclerView;
    }

    //显示悬浮框
    public void showFloatingView() {
        //如果已经存在悬浮框，防止重复添加
        if (rootView.findViewWithTag(TAG_FLOATING_VIEW) != null) {
            return;
        }

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.BOTTOM | Gravity.END;
        View floatingView = genFloatingView();

        //需要设置Tag 背景 透明度
        floatingView.setTag(TAG_FLOATING_VIEW);
        floatingView.setBackgroundColor(Color.BLACK);
        floatingView.setAlpha(0.8f);
        params.bottomMargin = HiDisplayUtil.dp2px(100, recyclerView.getResources());
        //添加到rootView中
        rootView.addView(genFloatingView(), params);
    }

    /**
     * 展示log 悬浮按钮
     */
    public void closeFloatingView() {
        rootView.removeView(genFloatingView());
    }

    //创建悬浮窗
    private View genFloatingView() {
        if (floatingView != null) {
            return floatingView;
        }
        TextView textView = new TextView(rootView.getContext());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //如果没有展开
                if (!isOpen) {
                    showLogView();
                }
            }
        });
        textView.setText("HiLog");
        return floatingView = textView;
    }

    /**
     * 显示LogView
     */
    private void showLogView() {
        if (rootView.findViewWithTag(TAG_LOG_VIEW) != null) {
            return;
        }
        //宽度是屏幕宽度，高度是 【dp-->px】
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, HiDisplayUtil.dp2px(160, rootView.getResources()));
        params.gravity = Gravity.BOTTOM;
        View logView = genLogView();

        //设置Tag
        logView.setTag(TAG_LOG_VIEW);
        rootView.addView(genLogView(), params);
        isOpen = true;
    }

    private View genLogView() {
        if (logView != null) {
            return logView;
        }

        FrameLayout logView = new FrameLayout(rootView.getContext());
        logView.setBackgroundColor(Color.BLACK);//黑色背景
        logView.addView(recyclerView);
        //设置关闭按钮，位于屏幕右上角
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.END;

        TextView closeView = new TextView(rootView.getContext());
        closeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeLogView();
            }
        });
        closeView.setText("Close");
        logView.addView(closeView, params);

        return this.logView = logView;
    }

    /**
     * 关闭LogView
     */
    private void closeLogView() {
        isOpen = false;
        rootView.removeView(genLogView());
    }

}
