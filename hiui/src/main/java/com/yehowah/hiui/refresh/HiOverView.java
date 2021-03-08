package com.yehowah.hiui.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * created by cyh
 * on 2021/3/8 20:38
 * Description: 下拉刷新的Overlay视图，可以重载这个类来定义自己的Overlay
 **/
public abstract class HiOverView extends FrameLayout {
    //状态枚举
    public enum HiRefreshState {
        /**
         * 初始态
         */
        STATE_INIT,
        /**
         * Header展示的状态
         */
        STATE_VISIBLE,
        /**
         * 超出可刷新距离的状态
         */
        STATE_REFRESH,
        /**
         * 超出刷新位置松开手后的状态
         */
        STATE_OVER_RELEASE
    }

    protected HiRefreshState mState = HiRefreshState.STATE_INIT;

    /**
     * 触发下拉刷新需要的最小高度
     */
    public int mPullRefreshHeight;

    /**
     * 最小阻尼
     * 用户下拉距离和视图滚动距离的比例系数
     */
    public float minDamp = 1.6f;
    /**
     * 最大阻尼
     */
    public float maxDamp = 2.2f;


    public HiOverView(@NonNull Context context) {
        super(context);
    }

    public HiOverView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HiOverView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 初始化
     */
    public abstract void init();

    /**
     * 滚动
     * @param scrollY 视图滚动的Y轴
     * @param pullRefreshHeight 下拉的高度
     */
    protected abstract void onScroll(int scrollY, int pullRefreshHeight);

    /**
     * 显示Overlay
     */
    protected abstract void onVisible();


    /**
     * 超过Overlay,释放就会加载
     */
    public abstract void onOver();

    /**
     * 开始刷新
     */
    public abstract void onRefresh();

    /**
     * 加载完成
     */
    public abstract void onFinish();

    /**
     * 设置下拉刷新头部状态
     * @param state
     */
    public void setState(HiRefreshState state) {
        this.mState = state;
    }

    public HiRefreshState getState() {
        return mState;
    }
}
