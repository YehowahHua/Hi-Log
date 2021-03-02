package com.yehowah.hiui.tab.bottom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.yehowah.hiui.tab.common.IHiTab;
import com.yehowah.hiui.tab.common.IHiTabLayout;

/**
 * created by cyh
 * on 2021/3/2 22:28
 * Description:
 **/
public class HiTabBottom extends RelativeLayout implements IHiTab<HiTabBottomInfo<?>> {
    public HiTabBottom(Context context) {
        super(context);
    }

    public HiTabBottom(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HiTabBottom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setHiTabInfo(@NonNull HiTabBottomInfo<?> data) {

    }

    @Override
    public void resetHeight(int height) {

    }

    @Override
    public void onTabSelectedChange(int index, @Nullable HiTabBottomInfo<?> prevInfo, @NonNull HiTabBottomInfo<?> nextInfo) {

    }
}
