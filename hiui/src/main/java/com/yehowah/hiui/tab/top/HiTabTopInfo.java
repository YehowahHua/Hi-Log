package com.yehowah.hiui.tab.top;

import android.graphics.Bitmap;

import androidx.fragment.app.Fragment;

/**
 * created by cyh
 * on 2021/3/2 22:25
 * Description:
 **/
public class HiTabTopInfo<Color> {
    public enum TabType {
        BITMAP, TEXT
    }

    public Class<? extends Fragment> fragment;
    public String name;
    public Bitmap defaultBitmap;
    public Bitmap selectedBitmap;
    /**
     * Tips：在Java代码中直接设置iconfont字符串无效，需要定义在string.xml
     */
    public String defaultIconName;
    public String selectedIconName;
    public Color defaultColor;
    public Color tintColor;
    public TabType tabType;

    public HiTabTopInfo(String name, Bitmap defaultBitmap, Bitmap selectedBitmap) {
        this.name = name;
        this.defaultBitmap = defaultBitmap;
        this.selectedBitmap = selectedBitmap;
        this.tabType = TabType.BITMAP;
    }

    public HiTabTopInfo(String name, Color defaultColor, Color tintColor) {
        this.name = name;
        this.defaultColor = defaultColor;
        this.tintColor = tintColor;
        this.tabType = TabType.TEXT;
    }

}
