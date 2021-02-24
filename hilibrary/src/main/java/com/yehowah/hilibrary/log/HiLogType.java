package com.yehowah.hilibrary.log;

import android.util.Log;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * created by cyh
 * on 2020/12/23 9:26
 * Description: 日志类型
 **/
public class HiLogType {
    //使用自定义注解代替enum枚举
    @IntDef({V,D,I,W,E,A})//定义内容，用来描述注解的注解
    @Retention(RetentionPolicy.SOURCE)//范围，保留时期
    public @interface TYPE{}

    //类型
    public final static int V = Log.VERBOSE;
    public final static int D = Log.DEBUG;
    public final static int I = Log.INFO;
    public final static int W = Log.WARN;
    public final static int E = Log.ERROR;
    public final static int A = Log.ASSERT;
}
