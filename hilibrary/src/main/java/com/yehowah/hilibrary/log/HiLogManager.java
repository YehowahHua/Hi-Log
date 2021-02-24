package com.yehowah.hilibrary.log;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by cyh
 * on 2020/12/23 10:16
 * Description:
 **/
public class HiLogManager {
    //实现单例
    private HiLogConfig config;

    private static HiLogManager instance;

    public static HiLogManager getInstance() {
        return instance;
    }


    //数组保存打印器
    private List<HiLogPrinter> printers = new ArrayList<>();


    private HiLogManager(HiLogConfig config, HiLogPrinter[] printers) {
        this.config = config;
        this.printers.addAll(Arrays.asList(printers));
    }


    public static void init(@NonNull HiLogConfig config, HiLogPrinter... printers) {
//        Log.i("TAG", "init: printers--"+printers);
        instance = new HiLogManager(config, printers);
    }

    public HiLogConfig getConfig() {
        return config;
    }
}
