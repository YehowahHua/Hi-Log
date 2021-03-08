package com.yehowah.hiui.refresh;

/**
 * created by cyh
 * on 2021/3/8 20:30
 * Description:
 **/
public interface HiRefresh {
    /**
     * 刷新时是否禁止滚动
     * @param disableRefreshScroll 否禁止滚动
     */
    void setDisableRefreshScroll(boolean disableRefreshScroll);

    /**
     * 刷新完成
     */
    void refreshFinished();

    /**
     * 设置下拉刷新的监听器
     * @param hiRefreshListener 刷新的监听器
     */
    void setRefreshListener(HiRefreshListener hiRefreshListener);

    /**
     * 设置下拉刷新的头部视图
     * @param hiOverView 下拉刷新的视图
     */
    void setRefreshOverView(HiOverView hiOverView);
    /**
     * 下拉监听器
     */
    interface HiRefreshListener{
        void onRefresh();
        boolean enableRefresh();//禁止下拉刷新
    }


}
