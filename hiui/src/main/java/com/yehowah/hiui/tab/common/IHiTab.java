package com.yehowah.hiui.tab.common;

import androidx.annotation.NonNull;
import androidx.annotation.Px;

/**
 * created by cyh
 * on 2021/3/2 22:21
 * Description:
 **/
public interface IHiTab<D> extends IHiTabLayout.OnTabSelectedListener<D> {

    void setHiTabInfo(@NonNull D data);

    /**
     * 动态修改某个Item的大小
     * @param height
     */
    void resetHeight(@Px int height);

}
