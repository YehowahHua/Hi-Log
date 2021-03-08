package com.yehowah.hiui.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * created by cyh
 * on 2021/3/8 21:13
 * Description: 监听手势
 **/
public class HiRefreshLayout extends FrameLayout implements HiRefresh {
    private HiOverView.HiRefreshState mState;
    private GestureDetector mGestureDetector;//监听手势的
    private HiRefresh.HiRefreshListener mHiRefreshListener;
    protected HiOverView mHiOverView;//下拉刷新头部
    private int mLastY;

    //刷新时是否禁止滚动
    private boolean disableRefreshScroll;

    private AutoScroller mAutoScroller;//

    HiOnGestureListener hiOnGestureListener = new HiOnGestureListener() {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return super.onScroll(e1, e2, distanceX, distanceY);
        }
    };

    public HiRefreshLayout(@NonNull Context context) {
        super(context);
        init();
    }

    public HiRefreshLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HiRefreshLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mGestureDetector = new GestureDetector(getContext(), hiOnGestureListener);
        mAutoScroller = new AutoScroller();

    }


    @Override
    public void setDisableRefreshScroll(boolean disableRefreshScroll) {
        this.disableRefreshScroll = disableRefreshScroll;
    }

    @Override
    public void refreshFinished() {

    }

    @Override
    public void setRefreshListener(HiRefreshListener hiRefreshListener) {
        this.mHiRefreshListener = hiRefreshListener;
    }

    @Override
    public void setRefreshOverView(HiOverView hiOverView) {
        this.mHiOverView = hiOverView;
    }

    //手势事件监听
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //获取到head
        View head = getChildAt(0);
        if (ev.getAction() == MotionEvent.ACTION_UP ||
                ev.getAction() == MotionEvent.ACTION_CANCEL ||
                ev.getAction() == MotionEvent.ACTION_POINTER_INDEX_MASK) {
            //松开手
            if (head.getBottom() > 0) {//被拉下来了
                if (mState != HiOverView.HiRefreshState.STATE_REFRESH) {//没有刷新
                    recover(head.getBottom());//恢复原样
                }
            }
        }

        return super.dispatchTouchEvent(ev);
    }



    private void recover(int dis) {
        //头部滚回去
        if (mHiRefreshListener != null && dis > mHiOverView.mPullRefreshHeight) {
            //滚动到指定位置
            //自动滚动器
            mAutoScroller.recover(dis- mHiOverView.mPullRefreshHeight);
            mState = HiOverView.HiRefreshState.STATE_REFRESH;
        }else{
            mAutoScroller.recover(dis);
        }

    }

    //

    /**
     * 借助Scroller实现视图的自动滚动
     * 任务，通过post执行
     */
    private class AutoScroller implements Runnable {
        private Scroller mScroller;
        private int mLastY;
        private boolean mIsFinished;

        public AutoScroller() {
            mScroller = new Scroller(getContext(), new LinearInterpolator());//线性滚动
            mIsFinished = true;
        }

        @Override
        public void run() {
            if (mScroller.computeScrollOffset()) {  //还未完成滚动
                //滚动 距离
                mLastY = mScroller.getCurrY();
                post(this);
            } else {
                removeCallbacks(this);//移除掉任务
                mIsFinished = true;
            }
        }

        //触发滚动
        void recover(int dis) {
            if (dis <= 0) {
                return;
            }
            removeCallbacks(this);
            mLastY = 0;
            mIsFinished = false;
            mScroller.startScroll(0,0,0,dis,300);
            post(this);
        }

        boolean isIsFinished(){
            return mIsFinished;
        }
    }
}
