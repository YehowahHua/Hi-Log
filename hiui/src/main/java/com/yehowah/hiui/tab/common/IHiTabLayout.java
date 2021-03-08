package com.yehowah.hiui.tab.common;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

/**
 * created by cyh
 * on 2021/3/2 21:00
 * Description:
 **/
public interface IHiTabLayout<Tab extends ViewGroup, D> {
    Tab findTab(@NonNull D data);

    void addTabSelectedChangeListener(OnTabSelectedListener<D> listener);

    void defaultSelected(@NonNull D defaultInfo);

    void inflateInfo(@NonNull List<D> infoList);

    interface OnTabSelectedListener<D> {
        void onTabSelectedChange(int index, @Nullable D prevInfo, @NonNull D nextInfo);
    }

}
