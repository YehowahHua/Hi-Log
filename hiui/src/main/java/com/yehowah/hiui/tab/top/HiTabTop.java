package com.yehowah.hiui.tab.top;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.yehowah.hiui.R;
import com.yehowah.hiui.tab.common.IHiTab;

/**
 * created by cyh
 * on 2021/3/2 22:28
 * Description:
 **/
public class HiTabTop extends RelativeLayout implements IHiTab<HiTabTopInfo<?>> {

    private HiTabTopInfo<?> tabInfo;
    private ImageView tabImageView;
    private TextView tabNameView;
    private View indicator;//指示器

    public HiTabTop(Context context) {
        this(context, null);
    }

    public HiTabTop(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HiTabTop(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    //加载视图
    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.hi_tab_top, this);
        tabImageView = findViewById(R.id.t_iv_image);
        tabNameView = findViewById(R.id.t_tv_name);
        indicator = findViewById(R.id.tab_top_indicator);
    }


    public HiTabTopInfo<?> getHiTabInfo() {
        return tabInfo;
    }

    public ImageView getTabImageView() {
        return tabImageView;
    }

    public TextView getTabNameView() {
        return tabNameView;
    }


    @Override
    public void setHiTabInfo(@NonNull HiTabTopInfo<?> data) {
        this.tabInfo = data;
        inflateInfo(false, true);
    }


    //根据tabInfo初始化视图
    private void inflateInfo(boolean selected, boolean init) {
        if (tabInfo.tabType == HiTabTopInfo.TabType.TEXT) {
            if (init) {
                tabImageView.setVisibility(GONE);
                tabNameView.setVisibility(VISIBLE);
                if (!TextUtils.isEmpty(tabInfo.name)) {
                    tabNameView.setText(tabInfo.name);
                }
            }
            if (selected) {
                indicator.setVisibility(VISIBLE);
                tabNameView.setTextColor(getTextColor(tabInfo.tintColor));

            } else {
                indicator.setVisibility(GONE);
                tabNameView.setTextColor(getTextColor(tabInfo.defaultColor));
            }
        } else if (tabInfo.tabType == HiTabTopInfo.TabType.BITMAP) {
            if (init) {
                tabImageView.setVisibility(VISIBLE);
                tabNameView.setVisibility(GONE);
            }

            if (selected) {
                tabImageView.setImageBitmap(tabInfo.selectedBitmap);
            } else {
                tabImageView.setImageBitmap(tabInfo.defaultBitmap);
            }
        }
    }

    /**
     * 动态修改某个tab的高度
     *
     * @param height
     */
    @Override
    public void resetHeight(int height) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = height;
        setLayoutParams(layoutParams);
        getTabNameView().setVisibility(GONE);
    }

    @Override
    public void onTabSelectedChange(int index, @Nullable HiTabTopInfo<?> prevInfo, @NonNull HiTabTopInfo<?> nextInfo) {
        //排除重复选择自己，或者没有选择到
        if (prevInfo != tabInfo && nextInfo != tabInfo || prevInfo == nextInfo) {
            return;
        }

        //选择
        if (prevInfo == tabInfo) {
            inflateInfo(false, false);
        } else {
            inflateInfo(true, false);
        }
    }

    @ColorInt
    private int getTextColor(Object color) {
        if (color instanceof String) {
            return Color.parseColor((String) color);
        } else {
            return (int) color;
        }

    }
}
